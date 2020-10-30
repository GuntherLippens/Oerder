package com.switchfully.oerder.demo.exceptions;

import com.switchfully.oerder.demo.exceptions.customers.CustomerAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.customers.CustomerNotFoundException;
import com.switchfully.oerder.demo.exceptions.items.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    protected void customerAlreadyExistsException(CustomerAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    protected void customerNotFoundException(CustomerNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        System.out.println();
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    protected void ItemAlreadyExistsException(ItemAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ItemGroupNotFoundException.class)
    protected void itemGroupNotFoundException(ItemGroupNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    protected void itemNotFoundException(ItemNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ItemGroupAlreadyExistsException.class)
    protected void ItemGroupAlreadyExistsException(ItemAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(OrderAlreadyExistsException.class)
    protected void orderAlreadyExistsException(OrderAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    protected void orderNotFoundException(OrderNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }


}