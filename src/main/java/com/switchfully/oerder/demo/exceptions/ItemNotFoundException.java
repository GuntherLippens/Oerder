package com.switchfully.oerder.demo.exceptions;

public class ItemNotFoundException extends RuntimeException{
    String message;

    public ItemNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Item with id " + message + " was not found in the Oerder shop";
    }
}
