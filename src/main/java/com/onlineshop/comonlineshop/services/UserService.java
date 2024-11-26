package com.onlineshop.comonlineshop.services;

import com.onlineshop.comonlineshop.model.User;
import com.onlineshop.comonlineshop.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto createUser(UserDto body);

    UserDto updateUser(UserDto body);

    void deleteUserById(int id);
}
