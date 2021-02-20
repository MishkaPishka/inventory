package com.example.inventory.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Can't create item")  // 404
public class InvalidCreatingException extends RuntimeException {

    public InvalidCreatingException(String name,int quantity) {
            super("Cannot add item with negative quantity. Name:"+name+", Quantity:"+quantity);
    }
}
