package com.example.stackoverflow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "question")
public class Question extends Post {

    static final double UP_VOTE_SCORE = 2.5F;
    static final double DOWN_VOTE_SCORE = -1.5F;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "question_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();

    public Question(User user) {
        super(user);
    }

    public Question() {
        super();
    }

    public Integer getId() {
        return super.getId();
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
