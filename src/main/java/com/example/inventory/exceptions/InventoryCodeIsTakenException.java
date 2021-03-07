package com.example.inventory.exceptions;

public class InventoryCodeIsTakenException extends ApiRuntimeException{
    public InventoryCodeIsTakenException(String message) {
        super(message);
    }
}
