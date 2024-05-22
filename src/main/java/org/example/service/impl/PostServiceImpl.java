package org.example.service.impl;

import org.example.entity.subscriber.Message;
import org.example.entity.subscriber.Post;
import org.example.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public List<Post> getPostsFromDataSource() {
        // Повертаємо список постів з повідомленнями
        // Цей метод має бути реалізований відповідно до вашого джерела даних
        Message message1 = new Message();
        message1.setText("Message 1");
        message1.setMessageTime(LocalDateTime.now().minusMinutes(80));
        Message message2 = new Message();
        message2.setText("Message 2");
        message2.setMessageTime(LocalDateTime.now().minusMinutes(75));
        Message message3 = new Message();
        message3.setText("Message 3");
        message3.setMessageTime(LocalDateTime.now().minusMinutes(60));
        Message message4 = new Message();
        message4.setText("Message 4");
        message4.setMessageTime(LocalDateTime.now().minusMinutes(20));
        Message message5 = new Message();
        message5.setText("Message 5");
        message5.setMessageTime(LocalDateTime.now().minusMinutes(50));
        Message message6 = new Message();
        message6.setText("Message 6");
        message6.setMessageTime(LocalDateTime.now().minusMinutes(45));
        Message message7 = new Message();
        message7.setText("Message 7");
        message7.setMessageTime(LocalDateTime.now().minusMinutes(15));
        Message message8 = new Message();
        message8.setText("Message 8");
        message8.setMessageTime(LocalDateTime.now().minusMinutes(20));
        Message message9 = new Message();
        message9.setText("Message 9");
        message9.setMessageTime(LocalDateTime.now().minusMinutes(1));
        Message message10 = new Message();
        message10.setText("Message 10");
        message10.setMessageTime(LocalDateTime.now().minusMinutes(2));

        Post post1 = new Post();
        post1.setMessages(Set.of(
                message1,
                message2,
                message3,
                message4
        ));
        post1.setPostTime(LocalDateTime.now().minusMinutes(90));

        Post post2 = new Post();
        post2.setMessages(Set.of(
                message5,
                message6
        ));
        post2.setPostTime(LocalDateTime.now().minusMinutes(60));

        Post post3 = new Post();
        post3.setMessages(Set.of(
                message7,
                message8
        ));
        post3.setPostTime(LocalDateTime.now().minusMinutes(30));

        Post post4 = new Post();
        post4.setMessages(Set.of(
                message9,
                message10
        ));
        post4.setPostTime(LocalDateTime.now());

        return List.of(
                post1,
                post2,
                post3,
                post4

        );
    }
}