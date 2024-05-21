package org.example.entity.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    DATA_NOT_FOUND("даних не знайдено");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
