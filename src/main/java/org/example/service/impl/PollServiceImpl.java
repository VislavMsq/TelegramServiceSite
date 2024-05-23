package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.Admin;
import org.example.entity.subscriber.ButtonRaw;
import org.example.entity.subscriber.PollRaw;
import org.example.entity.subscriber.WebUser;
import org.example.entity.subscriber.dto.ButtonRawDto;
import org.example.entity.subscriber.dto.PollDto;
import org.example.entity.subscriber.dto.PollRawDto;
import org.example.repository.AdminRepository;
import org.example.repository.PollRawRepository;
import org.example.service.PollService;
import org.example.service.WebUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PollServiceImpl implements PollService {
    private final PollRawRepository pollRawRepository;
    private final WebUserService webUserService;
    private final AdminRepository adminRepository;

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
    @Transactional
    public List<PollRawDto> getAllPolls() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        WebUser webUser = webUserService.findByEmail(email);
        Admin admin = adminRepository.findFirstByTelegramId(webUser.getTelegramId());
        // todo ...

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
    // todo
    //  метод для отримання дто готових опитування
    //  які по структурі будуть схожі на дто заготовк але будуть згруповані по Channel.title
    //  також зробити ендпоінт в контроллері

    // todo
    //  організувати підрахунок голосів опитувань і передати в кнопки пораховане

    // todo
    //  мене бусить цей фронт сраних джаваскріпт
}