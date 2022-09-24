package com.example.session.post.service.impl;

import com.example.session.post.model.Post;
import com.example.session.post.repository.PostRepository;
import com.example.session.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public List<Post> getPosts(long memberNo) {
        return postRepository.getPosts(memberNo);
    }
}
