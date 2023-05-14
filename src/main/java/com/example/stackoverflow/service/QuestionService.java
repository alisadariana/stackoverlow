package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.request.QuestionRequestDTO;
import com.example.stackoverflow.dto.response.QuestionResponseDTO;
import com.example.stackoverflow.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    Question getQuestion(Integer id);
    QuestionResponseDTO addQuestion(QuestionRequestDTO questionRequestDTO);
    List<QuestionResponseDTO> getQuestions();
    QuestionResponseDTO getQuestionById(Integer id);
    void deleteQuestionById(Integer id);
    QuestionResponseDTO editQuestionById(Integer id, QuestionRequestDTO questionRequestDTO);
}
