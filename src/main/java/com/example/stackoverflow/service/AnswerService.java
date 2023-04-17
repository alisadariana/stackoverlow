package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.request.AnswerRequestDTO;
import com.example.stackoverflow.dto.response.AnswerResponseDTO;
import com.example.stackoverflow.entity.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    Answer getAnswer(Integer id);
    AnswerResponseDTO addAnswer(AnswerRequestDTO answerRequestDTO);
    List<AnswerResponseDTO> getAnswers();
    AnswerResponseDTO getAnswerById(Integer id);
    AnswerResponseDTO deleteAnswerById(Integer id);
    AnswerResponseDTO editAnswerById(Integer id, AnswerRequestDTO answerRequestDTO);
}
