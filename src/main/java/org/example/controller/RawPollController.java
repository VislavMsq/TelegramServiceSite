package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.PollRaw;
import org.example.entity.subscriber.dto.PollRawDto;
import org.example.service.PollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class RawPollController {
    private final PollService pollService;

    @GetMapping
    public List<PollRawDto> getRawPoll() {
        return pollService.getAllPolls();

    }

}
// метод мажє повертати список PollRawDto
// {
//  id: ...
//  text: ...,
//  buttons:
//          [
//              {text: ...},
//              {...},
//              ...
//          ]
// }