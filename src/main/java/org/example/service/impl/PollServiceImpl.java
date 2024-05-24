package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.*;
import org.example.entity.subscriber.dto.*;
import org.example.repository.AdminRepository;
import org.example.repository.ButtonUserLinkRepository;
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
    private final ButtonUserLinkRepository buttonUserLinkRepository;

    @Override
    @Transactional
    public void createPoll(PollPostDto pollDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        WebUser webUser = webUserService.findByEmail(email);

        PollRaw pollRaw = new PollRaw();
        pollRaw.setText(pollDto.getTitle());
        pollRaw.setCreatedAt(LocalDateTime.now());
        pollRaw.setWebUser(webUser);
        pollRawRepository.save(pollRaw);
        List<ButtonRaw> buttons = new ArrayList<>();

        for (String text : pollDto.getButtons()) {
            ButtonRaw buttonRaw = new ButtonRaw();
            buttonRaw.setText(text);
            buttonRaw.setPollRaw(pollRaw);
            buttons.add(buttonRaw);
        }
        pollRaw.setButtons(buttons);
    }

    @Override
    @Transactional
    public List<PollRawDto> getAllPolls() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        WebUser webUser = webUserService.findByEmail(email);
        List<PollRaw> pollRawList = webUser.getPollRawList();

        return pollRawList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<GroupedPollDto> getGroupedPolls() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = webUserService.findByEmail(email);
        List<Admin> adminList = adminRepository.findAllByTelegramId(webUser.getTelegramId());
        List<Channel> channelList = adminList.stream()
                .map(Admin::getChannel)
                .collect(Collectors.toList());

        List<GroupedPollDto> groupedPollDtoList = new ArrayList<>();
        for (Channel channel : channelList) {
            GroupedPollDto groupedPollDto = new GroupedPollDto();
            groupedPollDto.setTitle(channel.getTitle());
            groupedPollDto.setPolls(convertToPollDtos(channel));
            groupedPollDtoList.add(groupedPollDto);
        }
        return groupedPollDtoList;
    }

    @Transactional
    public List<PollDto> convertToPollDtos(Channel channel) {
        List<Poll> polls = channel.getPolls();

        List<PollDto> pollDtos = new ArrayList<>();
        for (Poll poll : polls) {
            PollDto pollDto = new PollDto();

            pollDto.setText(poll.getText());
            List<ButtonDto> buttons = new ArrayList<>();
            for (Button button : poll.getButtons()) {
                ButtonDto buttonDto = new ButtonDto();
                buttonDto.setText(button.getText());
                buttonDto.setVotes((long) buttonUserLinkRepository.findAllByButton(button).size());
                buttons.add(buttonDto);
            }
            pollDto.setButtons(buttons);
            pollDtos.add(pollDto);
        }
        return pollDtos;
    }

    private PollRawDto mapToDto(PollRaw pollRaw) {
        PollRawDto pollRawDto = new PollRawDto();
        List<ButtonRawDto> buttonRawDtos = new ArrayList<>();
        for (ButtonRaw buttonRaw : pollRaw.getButtons()) {
            ButtonRawDto buttonRawDto = new ButtonRawDto();
            buttonRawDto.setText(buttonRaw.getText());
            buttonRawDtos.add(buttonRawDto);
        }
        pollRawDto.setId(pollRaw.getId());
        pollRawDto.setLabels(buttonRawDtos);
        pollRawDto.setText(pollRaw.getText());
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