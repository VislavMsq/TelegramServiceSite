package org.example.exception;

import org.example.entity.enums.ErrorMessage;

public class InternalTechnicalErrorException extends RuntimeException {
    public InternalTechnicalErrorException(ErrorMessage message) {
        super(message.getMessage());
    }
}
