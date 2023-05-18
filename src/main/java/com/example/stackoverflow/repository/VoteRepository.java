package com.example.stackoverflow.repository;

import com.example.stackoverflow.entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {
    Optional<Vote> findByPostIdAndUserId(Integer postId, Integer userId);
}
