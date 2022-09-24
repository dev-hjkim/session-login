package com.example.session.post.repository;

import com.example.session.post.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {
    List<Post> getPosts(long memberNo);
}
