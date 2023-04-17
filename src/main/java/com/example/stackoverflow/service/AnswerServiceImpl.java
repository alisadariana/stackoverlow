package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.Mapper;
import com.example.stackoverflow.dto.request.AnswerRequestDTO;
import com.example.stackoverflow.dto.response.AnswerResponseDTO;
import com.example.stackoverflow.entity.Answer;
import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService{

    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final QuestionService questionService;

    @Override
    public Answer getAnswer(Integer id) {
        return answerRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("answer with id: " + id + " could not be found"));
    }

    @Override
    public AnswerResponseDTO addAnswer(AnswerRequestDTO answerRequestDTO) {
        if (answerRequestDTO.getUserId() == null)
            throw new IllegalArgumentException("need user id in order to add answer");
        User user = userService.getUser(answerRequestDTO.getUserId());
        if (user == null)
            throw new IllegalArgumentException("add answer: user id " + answerRequestDTO.getUserId() + " could not be found");

        if (answerRequestDTO.getQuestionId() == null)
            throw new IllegalArgumentException("need question id in order to add answer");
        Question question = questionService.getQuestion(answerRequestDTO.getQuestionId());
        if (question == null)
            throw new IllegalArgumentException("add answer: question id " + answerRequestDTO.getQuestionId() + " could not be found");

        Answer answer = new Answer(user, question);
        answer.setText(answerRequestDTO.getText());
        answer.setPhoto(answerRequestDTO.getPhoto());
        Answer answer1 = answerRepository.save(answer);
        return Mapper.answerToAnswerResponseDTO(answer1);
    }

    @Override
    public List<AnswerResponseDTO> getAnswers() {
        List<Answer> answers = StreamSupport
                .stream(answerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.answersToAnswerResponseDTO(answers);
    }

    @Override
    public AnswerResponseDTO getAnswerById(Integer id) {
        Answer answer = getAnswer(id);
        return Mapper.answerToAnswerResponseDTO(answer);
    }

    @Override
    public AnswerResponseDTO deleteAnswerById(Integer id) {
        Answer answer = getAnswer(id);
        answerRepository.delete(answer);
        return Mapper.answerToAnswerResponseDTO(answer);
    }

    @Override
    public AnswerResponseDTO editAnswerById(Integer id, AnswerRequestDTO answerRequestDTO) {
        Answer answer = getAnswer(id);
        answer.setText(answerRequestDTO.getText());
        answer.setPhoto(answerRequestDTO.getPhoto());
        return Mapper.answerToAnswerResponseDTO(answer);
    }
}
