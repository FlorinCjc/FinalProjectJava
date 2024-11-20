package com.onlineshop.comonlineshop.services;

import com.onlineshop.comonlineshop.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUserById(int id);
}
