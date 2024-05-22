package org.example.entity.subscriber.dto;

import lombok.Data;

@Data
public class WebUserDto {
    private String email;
    private String password;
    private Long otpTelegram;
}
