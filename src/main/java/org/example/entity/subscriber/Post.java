package org.example.entity.subscriber;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private String id;
    private List<Message> messages;
    private LocalDateTime postTime;
}

