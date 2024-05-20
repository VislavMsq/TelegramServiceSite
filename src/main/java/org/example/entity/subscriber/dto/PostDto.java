package org.example.entity.subscriber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
        private Long countMessages;
        private LocalDateTime creationTime;
}
