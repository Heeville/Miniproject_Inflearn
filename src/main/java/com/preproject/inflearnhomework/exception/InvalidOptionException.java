package com.preproject.inflearnhomework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOptionException extends IllegalArgumentException {
    public InvalidOptionException(String message) {
        super(message);
    }
}