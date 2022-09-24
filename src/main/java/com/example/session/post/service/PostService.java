package com.example.session.post.service;

import com.example.session.post.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts(long memberNo);
}
