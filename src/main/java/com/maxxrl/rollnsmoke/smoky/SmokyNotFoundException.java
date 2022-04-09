package com.maxxrl.rollnsmoke.smoky;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SmokyNotFoundException extends RuntimeException{
    public SmokyNotFoundException(String message) {
        super(message);
    }

    public SmokyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
