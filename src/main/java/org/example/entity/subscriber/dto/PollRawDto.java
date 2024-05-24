package org.example.entity.subscriber.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PollRawDto {
    private UUID id;
    private String text;
    private List<ButtonRawDto> labels;


}
