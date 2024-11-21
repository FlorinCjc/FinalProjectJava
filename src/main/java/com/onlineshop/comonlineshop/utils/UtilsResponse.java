package com.onlineshop.comonlineshop.utils;

import org.springframework.http.HttpStatus;

public class UtilsResponse {
    public static ApiResponse succes(String message , Object data) {
        return new ApiResponse.Builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();
    }
    public static ApiResponse error(int status, String message) {
    return new ApiResponse.Builder()
            .status(status)
            .message(message)
            .build();
    }
    public static ApiResponse succes(String message ) {
        return new ApiResponse.Builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .build();
    }
}
