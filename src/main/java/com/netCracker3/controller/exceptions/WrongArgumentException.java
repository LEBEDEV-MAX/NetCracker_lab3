package com.netCracker3.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exceptions thrown away when user wrote invalid argument
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongArgumentException extends Exception {
    public WrongArgumentException(String str){
        super("Wrong Argument: " + str);
    }
}
