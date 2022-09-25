package com.example.session.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Post {
    private long postNo;
    private long membeNo;
    private long boardNo;

    private String title;
    private String content;

    private Date regDt;
    private Date updDt;
}
