package com.switchfully.oerder.demo.exceptions.items;

public class OrderNotFoundException extends RuntimeException{
    String message;

    public OrderNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Order with id " + message + " was not found in the Oerder shop";
    }
}
