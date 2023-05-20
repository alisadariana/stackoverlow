package com.example.stackoverflow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "user")
public class User {
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private RoleType role;

  @Column(name = "banned")
  private Boolean banned = false;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Question> questions = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Answer> answers = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Vote> votes = new ArrayList<>();

  public User(String firstName, String lastName, String email, String password, RoleType role) {
    this.firstName = firstName;
    this.lastName = lastName;

    if (email == null)
      this.email = firstName.toLowerCase() + lastName.toLowerCase() + "@gmail.com";
    else
      this.email = email;

    if (password == null)
      this.password = "password";
    else
      this.password = password;

    if (role == null)
      this.role = RoleType.USER;
    else
      this.role = role;
  }

  public Double computeScore() {
    double score = 0;
    score += this.questions
            .stream()
            .map(Question::computeScore)
            .mapToDouble(Double::doubleValue)
            .sum();
    score += this.answers
            .stream()
            .map(Answer::computeScore)
            .mapToDouble(Double::doubleValue)
            .sum();
    score += this.votes
            .stream()
            .filter(vote -> vote.getVoteType() == VoteType.DOWN)
            .mapToDouble(vote -> -1.5F)
            .sum();
    return score;
  }
}