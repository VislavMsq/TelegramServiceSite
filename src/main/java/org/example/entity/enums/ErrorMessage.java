package org.example.entity.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    DATA_NOT_FOUND("даних не знайдено"),
    INVALID_OTP("Невірний код Telegram"),
    EMAIL_ALREADY_EXISTS("ця пошта вже занята");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
