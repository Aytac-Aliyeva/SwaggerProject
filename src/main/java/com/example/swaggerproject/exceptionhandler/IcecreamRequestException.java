package com.example.swaggerproject.exceptionhandler;

public class IcecreamRequestException extends RuntimeException {

    public IcecreamRequestException() {
        super();
    }

    public IcecreamRequestException(String message) {
        super(message);
    }

    public IcecreamRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
