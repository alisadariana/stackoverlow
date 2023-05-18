package com.example.stackoverflow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "answer")
public class Answer extends Post {

    static final double UP_VOTE_SCORE = 5F;
    static final double DOWN_VOTE_SCORE = -2.5F;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(User user, Question question) {
        super(user);
        this.question = question;
    }

    public Answer() {
        super();
    }

    public Double computeScore() {
        double score = 0;
        for (Vote vote : getVotes()) {
            if (vote.getVoteType() == VoteType.UP) {
                score += UP_VOTE_SCORE;
            } else {
                score += DOWN_VOTE_SCORE;
            }
        }
        return score;
    }
}