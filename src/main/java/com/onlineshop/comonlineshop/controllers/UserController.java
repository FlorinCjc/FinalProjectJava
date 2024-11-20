package com.onlineshop.comonlineshop.controllers;

import com.onlineshop.comonlineshop.services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
