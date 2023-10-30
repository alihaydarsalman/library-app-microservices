package com.hzyazilimci.libraryservice.util.exception;

import com.hzyazilimci.libraryservice.client.ExceptionMessage;
import lombok.Data;

@Data
public class BookNotFoundException extends RuntimeException {

    private ExceptionMessage exceptionMessage;
    public BookNotFoundException(String s) {
        super(s);
    }

    public BookNotFoundException(ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public BookNotFoundException(String s, ExceptionMessage exceptionMessage) {
        super(s);
        this.exceptionMessage = exceptionMessage;
    }
}
