package com.switchfully.oerder.demo.exceptions;

public class ItemGroupAlreadyExistsException extends RuntimeException{
    String message;

    public ItemGroupAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exists";
    }
}
