package com.example.stackoverflow.repository;

import com.example.stackoverflow.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
