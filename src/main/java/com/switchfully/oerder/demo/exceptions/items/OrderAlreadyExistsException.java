package com.switchfully.oerder.demo.exceptions.items;

public class OrderAlreadyExistsException extends RuntimeException{
    String message;

    public OrderAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exists";
    }
}
