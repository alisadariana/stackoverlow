package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.Vote;
import com.example.stackoverflow.entity.VoteType;
import com.example.stackoverflow.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public void addVote(Integer userId, Integer postId, VoteType voteType) {
        Optional<Vote> voteOptional = voteRepository.findByPostIdAndUserId(postId, userId);
        if (voteOptional.isPresent()) {
            Vote vote = voteOptional.get();
            voteRepository.delete(vote);
            if (!vote.getVoteType().equals(voteType)) {
                vote.setVoteType(voteType);
                voteRepository.save(vote);
            }
        } else {
            Vote vote = new Vote();
            vote.setUser(userService.getUser(userId));
            vote.setPost(postService.getPost(postId));
            vote.setVoteType(voteType);
            voteRepository.save(vote);
        }
    }
}
