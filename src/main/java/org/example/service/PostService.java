package org.example.service;

import org.example.entity.subscriber.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsFromDataSource();
}
