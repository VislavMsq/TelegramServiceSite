package org.example.service.impl;

import org.example.entity.subscriber.Message;
import org.example.entity.subscriber.Post;
import org.example.entity.subscriber.dto.PostDto;
import org.example.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public List<PostDto> groupMessagesByInterval(List<Post> posts, int intervalMinutes) {
        long count = 0;
        List<PostDto> postDtoList = new ArrayList<>();

        for (Post post : posts) {
            PostDto postDto = new PostDto();
            postDto.setCreationTime(post.getPostTime().truncatedTo(ChronoUnit.MINUTES));
            postDto.setCountMessages(proceedMessages(post, intervalMinutes));
            postDtoList.add(postDto);
        }
        return postDtoList;
    }
    private Long proceedMessages(Post post, int interval) {

        List<LocalDateTime> localDateTimes = post.getMessages().stream()
                .map(Message::getDate)
                .collect(Collectors.toList());
        localDateTimes.add(post.getPostTime());
        return avgDates(localDateTimes,interval);
    }

    private long avgDates(List<LocalDateTime> dates, int interval) {
        dates.sort(LocalDateTime::compareTo);
        int j = 0;
        List<Integer> integers = new ArrayList<>();
        while (j<dates.size()-1) {
            long counter = interval;
            int count = 0;
            for (int i = j; i < dates.size()-1; i++) {

                if (counter < 1) {
                    j++;
                    integers.add(count);
                    break;
                }

                counter -= ChronoUnit.MINUTES.between(dates.get(i), dates.get(i+1));
                count++;
            }
            integers.add(count);
            break;
        }
        int result = integers.stream().mapToInt(Integer::intValue).sum();
        return integers.size() == 0 ? 0 : result/integers.size();
    }
}