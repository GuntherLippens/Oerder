package com.switchfully.oerder.demo.exceptions;

import com.switchfully.oerder.demo.exceptions.customers.CustomerAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.customers.CustomerNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    protected void memberAlreadyExistsException(CustomerAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    protected void customerNotFoundException(CustomerNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

}