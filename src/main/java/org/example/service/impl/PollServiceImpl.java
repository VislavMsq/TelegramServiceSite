package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.ButtonRaw;
import org.example.entity.subscriber.PollRaw;
import org.example.entity.subscriber.dto.PollDto;
import org.example.repository.PollRawRepository;
import org.example.service.PollService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PollServiceImpl implements PollService {
    private final PollRawRepository pollRawRepository;

    @Override
    public void createPoll(PollDto pollDto) {
        PollRaw pollRaw = new PollRaw();
        pollRaw.setText(pollDto.getText());
        pollRaw.setCode(UUID.randomUUID());
        pollRaw.setCreatedAt(LocalDateTime.now());
        pollRawRepository.save(pollRaw);
        List<ButtonRaw> buttons = new ArrayList<>();

        for (String o : pollDto.getButtons()) {
            ButtonRaw buttonRaw = new ButtonRaw();
            buttonRaw.setText(o);
            buttonRaw.setPollRaw(pollRaw);
            buttons.add(buttonRaw);
        }
        pollRaw.setButtons(buttons);
    }
}