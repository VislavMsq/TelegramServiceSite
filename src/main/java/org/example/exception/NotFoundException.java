package org.example.exception;

import org.example.entity.enums.ErrorMessage;

public class NotFoundException extends RuntimeException {
    public NotFoundException(ErrorMessage message) {
        super(message.getMessage());
    }
}
