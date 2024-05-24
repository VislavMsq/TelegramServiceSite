package org.example.service;

import org.example.entity.subscriber.dto.GroupedPollDto;
import org.example.entity.subscriber.dto.PollDto;
import org.example.entity.subscriber.dto.PollPostDto;
import org.example.entity.subscriber.dto.PollRawDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PollService {
    void createPoll(PollPostDto pollDto);

    List<PollRawDto> getAllPolls();

    List<GroupedPollDto> getGroupedPolls();
}
