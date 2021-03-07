package com.example.inventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Invalid Quantity Change")  // 404
public class InvalidQuantityChangeException extends ApiRuntimeException {

    int quantity;
    int amount;
    long id;
    public InvalidQuantityChangeException(int quantity,int amount,long id) {
            super("Invalid quantity change for id:"+id+".Amount is:"+amount +", qunatity change is:"+quantity);
            this.quantity = quantity;
            this.amount = amount;
            this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
