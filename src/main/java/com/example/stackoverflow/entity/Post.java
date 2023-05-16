package com.example.stackoverflow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post")
@Inheritance(strategy = InheritanceType.JOINED)
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "text")
    private String text;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "photo")
    private String photo;

    public Post(User user) {
        this.timestamp = LocalDateTime.now();
        this.user = user;
    }

    public Post() {
        this.timestamp = LocalDateTime.now();
    }
}