package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.ButtonRaw;
import org.example.entity.subscriber.PollRaw;
import org.example.entity.subscriber.dto.ButtonRawDto;
import org.example.entity.subscriber.dto.PollDto;
import org.example.entity.subscriber.dto.PollRawDto;
import org.example.repository.PollRawRepository;
import org.example.service.PollService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PollServiceImpl implements PollService {
    private final PollRawRepository pollRawRepository;
    private static final SecurityContext securityContext = SecurityContextHolder.getContext();

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
        pollRawRepository.save(pollRaw);
    }

    @Override
    public List<PollRawDto> getAllPolls() {
        securityContext.getAuthentication().getCredentials();
        List<PollRaw> rawPolls = pollRawRepository.findAll();

        return rawPolls.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private PollRawDto mapToDto(PollRaw pollRaw) {
        PollRawDto pollRawDto = new PollRawDto();
        pollRawDto.setId(pollRaw.getCode().toString());
        pollRawDto.setText(pollRaw.getText());
        List<ButtonRawDto> buttonRawDtos = new ArrayList<>();
        for (ButtonRaw buttonRaw : pollRaw.getButtons()) {
            ButtonRawDto buttonRawDto = new ButtonRawDto();
            buttonRawDto.setText(buttonRaw.getText());
            buttonRawDtos.add(buttonRawDto);
        }
        pollRawDto.setButtons(buttonRawDtos);
        return pollRawDto;
    }
}