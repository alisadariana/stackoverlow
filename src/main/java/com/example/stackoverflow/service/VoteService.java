package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.VoteType;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    void addVote(Integer userId, Integer postId, VoteType voteType);
}
