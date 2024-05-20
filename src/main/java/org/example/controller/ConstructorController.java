package org.example.controller;

import org.example.entity.subscriber.dto.PollDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/constructor")
public class ConstructorController {
    @PostMapping("/poll")
    public void createPoll(@RequestBody PollDto pollDto) {
        System.out.println(pollDto);
    }
}
