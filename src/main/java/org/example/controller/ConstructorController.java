package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.dto.PollDto;
import org.example.entity.subscriber.dto.PollPostDto;
import org.example.service.PollService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/constructor")
public class ConstructorController {
    private final PollService pollService;

    @PostMapping("/poll")
    public void createPoll(@RequestBody PollPostDto pollDto) {
        pollService.createPoll(pollDto);

    }
}

