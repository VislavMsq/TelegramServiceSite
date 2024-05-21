package org.example.exception;

import org.example.entity.enums.ErrorMessage;

public class InvalidOtpException extends RuntimeException {
    public InvalidOtpException(ErrorMessage message) {
        super(message.getMessage());
    }
}
