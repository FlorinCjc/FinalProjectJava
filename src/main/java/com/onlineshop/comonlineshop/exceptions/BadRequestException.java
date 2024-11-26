package com.onlineshop.comonlineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) //atunci cand adaugam un email si acel email exista deja in baza de date
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
