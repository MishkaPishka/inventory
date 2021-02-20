package com.example.inventory.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such item")  // 404
public class ItemNotFoundException extends RuntimeException {
    private Long id;
    public ItemNotFoundException(Long id) {
        super("blabla");

    }
}
