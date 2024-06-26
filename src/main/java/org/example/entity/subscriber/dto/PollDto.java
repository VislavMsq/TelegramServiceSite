package org.example.entity.subscriber.dto;

import lombok.Data;

import java.util.List;

@Data
public class PollDto {
    private List<ButtonDto> buttons;
    private String text;
}
