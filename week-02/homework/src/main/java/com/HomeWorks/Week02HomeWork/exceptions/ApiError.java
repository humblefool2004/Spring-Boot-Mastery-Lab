package com.HomeWorks.Week02HomeWork.exceptions;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {
    private int status;          // HTTP status code (404, 400, etc.)
    private String error;        // Short error name (NOT_FOUND, BAD_REQUEST)
    private String message;      // Detailed message
    private String path;         // API path (/departments/1)
    private LocalDateTime timestamp; // Time of error

    private Map<String, String> errors; //handle validation errors

    public ApiError(int status, String error, String message, String path, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }
}
