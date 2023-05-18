package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Post getPost(Integer postId);
}
