package com.example.stackoverflow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "post")
@Inheritance(strategy = InheritanceType.JOINED)
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}