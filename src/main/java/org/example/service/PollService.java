package org.example.service;

import org.example.entity.subscriber.dto.PollDto;
import org.springframework.stereotype.Service;

public interface PollService {
    void createPoll(PollDto pollDto);
}
