package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.Post;
import com.example.stackoverflow.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post getPost(Integer postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new RuntimeException("Post with id: " + postId + " not found")
        );
    }
}
