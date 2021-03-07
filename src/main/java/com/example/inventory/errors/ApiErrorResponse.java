package com.example.inventory.errors;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ApiErrorResponse {
    private HttpStatus code;
    private String message;
    private Instant timestamp;

    public ApiErrorResponse(HttpStatus code, String message, Instant timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
