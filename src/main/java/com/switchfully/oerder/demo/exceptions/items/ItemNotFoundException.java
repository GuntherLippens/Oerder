package com.switchfully.oerder.demo.exceptions.items;

public class ItemNotFoundException extends RuntimeException{
    String message;

    public ItemNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return  message ;
    }
}
