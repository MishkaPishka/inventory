package com.example.inventory.exceptions;

//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such item")  // 404
public class ItemNotFoundException extends ApiRuntimeException {

    public ItemNotFoundException(String message) {

        super("Item with id:"+message+ " was not found");
    }


}
