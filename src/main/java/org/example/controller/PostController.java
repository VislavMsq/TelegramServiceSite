package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.subscriber.Post;
import org.example.entity.subscriber.dto.GroupedPollDto;
import org.example.entity.subscriber.dto.PollRawDto;
import org.example.entity.subscriber.dto.PostDto;
import org.example.service.MessageService;
import org.example.service.PollService;
import org.example.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final MessageService messageService;
    private final PollService pollService;

    @GetMapping("/raw")
    public List<PollRawDto> getRawPoll() {
        return pollService.getAllPolls();

    }
    @GetMapping
    public List<PostDto> getPosts(@RequestParam("interval") Integer interval) {
        List<Post> posts = postService.getPostsFromDataSource();
        List<Integer> intervals = Arrays.asList(5, 10, 15, 30, 60);

        return messageService.groupMessagesByInterval(posts, interval);

//        return posts.stream()
//                .map(post -> {
//                    Map<String, Map<String, Long>> groupedMessages = intervals.stream()
//                            .collect(Collectors.toMap(
//                                    Object::toString,
//                                    interval -> messageService.groupMessagesByInterval(post.getMessages(), interval)
//                            ));
//                    return new PostDto(post.getId(), post.getPostTime(), groupedMessages);
//                })
//                .collect(Collectors.toList());

    }

    @GetMapping("/grouped")
    public List<GroupedPollDto> groupPolls() {
        return pollService.getGroupedPolls();
    }
}
