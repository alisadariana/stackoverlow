package com.example.stackoverflow.controller;

import com.example.stackoverflow.entity.VoteType;
import com.example.stackoverflow.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vote")
public class VoteController {
    private final VoteService voteService;

    @GetMapping("/up/{userId}/{postId}")
    public void upVote(@PathVariable final Integer userId, @PathVariable final Integer postId) {
        voteService.addVote(userId, postId, VoteType.UP);
    }

    @GetMapping("/down/{userId}/{postId}")
    public void downVote(@PathVariable final Integer userId, @PathVariable final Integer postId) {
        voteService.addVote(userId, postId, VoteType.DOWN);
    }
}
