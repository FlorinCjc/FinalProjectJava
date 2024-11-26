package com.onlineshop.comonlineshop.services.impl;

import com.onlineshop.comonlineshop.exceptions.BadRequestException;
import com.onlineshop.comonlineshop.exceptions.ResourceNotFoundException;
import com.onlineshop.comonlineshop.model.User;
import com.onlineshop.comonlineshop.model.dto.UserDto;
import com.onlineshop.comonlineshop.model.mappers.UserMapper;
import com.onlineshop.comonlineshop.repositories.UserRepository;
import com.onlineshop.comonlineshop.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map((user) -> this.userMapper.toUserDtoWithoutPassword(user))
                .toList();
    }

    @Override
    public UserDto getUserById(int id) {
        if (id < 1) {
            throw new BadRequestException("Invalid user id");
        }
        User user =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return this.userMapper.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto body) {
        boolean emailExists = userRepository.existsUserByEmail(body.getEmail());

        if (emailExists) {
            throw new BadRequestException("User already exists");
        }
        String password = BCrypt.hashpw(body.getPassword(), BCrypt.gensalt());
        body.setPassword(password);


        User user = userMapper.toUser(body);

        return this.userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UserDto body) {
        UserDto userDb = this.getUserById(body.getId());
//        if(!userRepository.existsById(user.getId())){
//            throw new ResourceNotFoundException("User not found");
//        }
        //Daca utilizatorul a schimbat adresa de email prin metoda de update
        //verificam daca noua adresa exista sau nu in baza de date
        if (!userDb.getEmail().equals(body.getEmail())) {
            boolean emailExists = userRepository.existsUserByEmail(body.getEmail());

            if (emailExists) {
                throw new BadRequestException("User email already exists");
            }
        }
        String password = BCrypt.hashpw(body.getPassword(), BCrypt.gensalt());//metoda pentru a cripta password-ul
        body.setPassword(password);
        User user = userMapper.toUser(body);

        return this.userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUserById(int id) {
        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
