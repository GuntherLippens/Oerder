package com.switchfully.oerder.demo.exceptions;

public class ItemAlreadyExistsException extends RuntimeException{
    String message;

    public ItemAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exists";
    }
}
