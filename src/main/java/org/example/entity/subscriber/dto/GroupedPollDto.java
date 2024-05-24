package org.example.entity.subscriber.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupedPollDto {
    private String title;
    private List<PollDto> polls;
}
