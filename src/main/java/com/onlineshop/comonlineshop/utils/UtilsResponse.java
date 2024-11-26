package com.onlineshop.comonlineshop.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UtilsResponse {
    public static ResponseEntity<ApiResponse> success(String message, Object data) {
        ApiResponse response = new ApiResponse.Builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<ApiResponse> error(HttpStatus status, String message) {
        ApiResponse response = new ApiResponse.Builder()
                .status(status.value())
                .message(message)
                .build();

        return ResponseEntity.status(status).body(response);
    }

    public static ResponseEntity<ApiResponse> success(String message) {
        ApiResponse response = new ApiResponse.Builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .build();

        return ResponseEntity.ok(response);
    }
}
