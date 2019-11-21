package com.example.hello.hellodemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sunyuqing on 2019/9/24.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
