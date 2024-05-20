package org.example.service.impl;

import org.example.entity.subscriber.Message;
import org.example.entity.subscriber.Post;
import org.example.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public List<Post> getPostsFromDataSource() {
        // Повертаємо список постів з повідомленнями
        // Цей метод має бути реалізований відповідно до вашого джерела даних
        return List.of(
                new Post("1", List.of(
                        new Message("0", "Message 1", LocalDateTime.now().minusMinutes(80)),
                        new Message("1", "Message 1", LocalDateTime.now().minusMinutes(75)),
                        new Message("2", "Message 1", LocalDateTime.now().minusMinutes(60)),
                        new Message("3", "Message 2", LocalDateTime.now().minusMinutes(20))
                ), LocalDateTime.now().minusMinutes(90)
                ),
                new Post("2", List.of(
                        new Message("4", "Message 3", LocalDateTime.now().minusMinutes(50)),
                        new Message("5", "Message 4", LocalDateTime.now().minusMinutes(45))
                ), LocalDateTime.now().minusMinutes(60)
                ),
                new Post("3", List.of(
                        new Message("6", "Message 3", LocalDateTime.now().minusMinutes(15)),
                        new Message("7", "Message 4", LocalDateTime.now().minusMinutes(20))
                ), LocalDateTime.now().minusMinutes(30)),
                new Post("4", List.of(
                        new Message("8", "Message 3", LocalDateTime.now().minusMinutes(1)),
                        new Message("9", "Message 4", LocalDateTime.now().minusMinutes(2))
                ), LocalDateTime.now())
        );
    }
}