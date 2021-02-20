package com.example.inventory.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such item")  // 404

public class InvalidQuantityChangeException extends RuntimeException {

    public InvalidQuantityChangeException(int quantity,int amount,long id) {
            super("Invalid quantity change for id:"+id+".Amount is:"+amount +", qunatity change is:"+quantity);
    }
}
