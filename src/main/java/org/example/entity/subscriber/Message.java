package org.example.entity.subscriber;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {
    private String id;
    private String content;
    private LocalDateTime date;
}
