package com.example.inventory.exceptions;

public class ItemExistsException extends ApiRuntimeException {

    public ItemExistsException
            (String s) {
        super(s);

    }
}
