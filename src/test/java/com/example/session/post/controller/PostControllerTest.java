package com.example.session.post.controller;

import com.example.session.auth.model.User;
import com.example.session.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    private MockMvc mvc;
//    MockHttpSession session;
//    User user;

    @Autowired
    public void setPostControllerTest(MockMvc mvc) {
        this.mvc = mvc;
//        this.session = new MockHttpSession();
//        this.user = new User(5);
    }

//    @BeforeEach
//    public void setUp() throws Exception{
//        session.setAttribute("user", user);
//    }

    @Test
    void getPosts() throws Exception {
        mvc.perform(get("/v1/post/lists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }
}