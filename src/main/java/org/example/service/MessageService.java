package org.example.service;

import org.example.entity.subscriber.Post;
import org.example.entity.subscriber.dto.PostDto;

import java.util.List;

public interface MessageService {
    List<PostDto> groupMessagesByInterval(List<Post> posts, int intervalMinutes);
}
