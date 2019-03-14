package com.netCracker3.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception thrown away when customer exist in DB
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExistCustomerException extends Exception {
    public ExistCustomerException(int id){
        super("Customer already exist: id= " + id);
    }
}
