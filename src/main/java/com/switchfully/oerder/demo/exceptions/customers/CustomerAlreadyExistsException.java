package com.switchfully.oerder.demo.exceptions.customers;

public class CustomerAlreadyExistsException extends RuntimeException{
    String message;

    public CustomerAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exists";
    }
}
