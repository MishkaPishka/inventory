package com.example.inventory.exceptions;

public class ApiRuntimeException extends RuntimeException{
    String message;

    public ApiRuntimeException(String message ) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiRuntimeException{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return message;
    }
}
