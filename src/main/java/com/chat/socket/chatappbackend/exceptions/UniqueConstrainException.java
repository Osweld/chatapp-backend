package com.chat.socket.chatappbackend.exceptions;

public class UniqueConstrainException extends RuntimeException{

    public UniqueConstrainException(String message) {
        super(message);
    }

    public UniqueConstrainException(String message, Throwable cause) {
        super(message, cause);
    }
}
