package com.example.session.post.controller;

import com.example.session.aop.LoginCheck;
import com.example.session.aop.UserParam;
import com.example.session.auth.model.User;
import com.example.session.post.model.Post;
import com.example.session.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @LoginCheck
    @GetMapping("/lists")
    public List<Post> getPosts(@UserParam User user) {
        return postService.getPosts(user.getMemberNo());
    }
}
