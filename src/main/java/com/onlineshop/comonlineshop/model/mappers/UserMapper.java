package com.onlineshop.comonlineshop.model.mappers;

import com.onlineshop.comonlineshop.model.User;
import com.onlineshop.comonlineshop.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setRole(userDto.getUserRole());
//        user.setCommandList(userDto.);
        return user;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setUserRole(user.getRole());
        return userDto;
    }

    public UserDto toUserDtoWithoutPassword(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword("");
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setUserRole(user.getRole());
        return userDto;
    }
}
