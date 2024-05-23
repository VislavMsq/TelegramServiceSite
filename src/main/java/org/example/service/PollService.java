package org.example.service;

import org.example.entity.subscriber.PollRaw;
import org.example.entity.subscriber.dto.PollDto;
import org.example.entity.subscriber.dto.PollRawDto;

import java.util.List;

public interface PollService {
    void createPoll(PollDto pollDto);

    List<PollRawDto> getAllPolls();

}
