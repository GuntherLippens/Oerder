package com.switchfully.oerder.demo.exceptions.customers;

public class CustomerNotFoundException extends RuntimeException{
    private String message;

    public CustomerNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "A customer with id " + message + " is not registered in the Oerder shop";
    }
}
