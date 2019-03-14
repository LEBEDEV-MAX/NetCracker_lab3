package com.netCracker3.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception thrown away when customer not found in DB
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(int id){
        super("Customer not found: id= " + id);
    }
}
