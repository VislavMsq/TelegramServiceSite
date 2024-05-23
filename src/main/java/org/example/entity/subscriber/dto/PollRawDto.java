package org.example.entity.subscriber.dto;

import lombok.Data;

import java.util.List;

@Data
public class PollRawDto {
    String id;
    String text;
    List<ButtonRawDto> buttons;


}
