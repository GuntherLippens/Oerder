package com.switchfully.oerder.demo.exceptions.items;

public class ItemGroupNotFoundException extends RuntimeException{
    String message;

    public ItemGroupNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return  message ;
    }
}
