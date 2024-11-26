package com.onlineshop.comonlineshop.model.dto;

import com.onlineshop.comonlineshop.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
//Data transfer object ( dto)
@Data
public class UserDto {
    private int id;
    @NotEmpty(message = "username should contains value")
    @NotBlank(message = "username should contains value")
    @NotNull(message = "username should contains value")
    @Size(min = 3, message = "username length should be at least 3 ")
    private String name;

    @NotEmpty(message = "email should contains value")
    @NotBlank(message = "email should contains value")
    @NotNull(message = "email should contains value")
    private String email;

    @NotEmpty(message = "password should contains value")
    @NotBlank(message = "password should contains value")
    @NotNull(message = "password should contains value")
    private String password;

    @NotEmpty(message = "address should contains value")
    @NotBlank(message = "address should contains value")
    @NotNull(message = "address should contains value")
    private String address;

    @NotEmpty(message = "phone should contains value")
    @NotBlank(message = "phone should contains value")
    @NotNull(message = "phone should contains value")
    private String phone;
    private UserRole userRole;
}
