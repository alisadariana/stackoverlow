package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.Mapper;
import com.example.stackoverflow.dto.request.QuestionRequestDTO;
import com.example.stackoverflow.dto.response.QuestionResponseDTO;
import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final UserService userService;

    @Override
    public Question getQuestion(Integer id) {
        return questionRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("question with id: " + id + " could not be found"));
    }

    @Transactional
    @Override
    public QuestionResponseDTO addQuestion(QuestionRequestDTO questionRequestDTO) {
        if (questionRequestDTO.getUserId() == null)
            throw new IllegalArgumentException("need user id in order to add question");
        User user = userService.getUser(questionRequestDTO.getUserId());
        if (user == null)
            throw new IllegalArgumentException("add question: user id " + questionRequestDTO.getUserId() + " could not be found");
        Question question = new Question(user);
        question.setTitle(questionRequestDTO.getTitle());
        question.setText(questionRequestDTO.getText());
        question.setTimestamp(LocalDateTime.now());
        question.setPhoto(questionRequestDTO.getPhoto());
        question.setTag(questionRequestDTO.getTag());
        Question question1 = questionRepository.save(question);
        return Mapper.questionToQuestionResponseDTO(question1);
    }

    @Override
    public List<QuestionResponseDTO> getQuestions() {
        List<Question> questions = StreamSupport
                .stream(questionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.questionsToQuestionResponseDTO(questions);
    }

    @Override
    public QuestionResponseDTO getQuestionById(Integer id) {
        Question question = getQuestion(id);
        return Mapper.questionToQuestionResponseDTO(question);
    }


    @Override
    public QuestionResponseDTO deleteQuestionById(Integer id) {
        Question question = getQuestion(id);
        questionRepository.delete(question);
        return Mapper.questionToQuestionResponseDTO(question);
    }

    @Transactional
    @Override
    public QuestionResponseDTO editQuestionById(Integer id, QuestionRequestDTO questionRequestDTO) {
        Question question = getQuestion(id);
        question.setTitle(questionRequestDTO.getTitle());
        question.setText(questionRequestDTO.getText());
        question.setTimestamp(LocalDateTime.now());
        question.setPhoto(questionRequestDTO.getPhoto());
        question.setTag(questionRequestDTO.getTag());
        return Mapper.questionToQuestionResponseDTO(question);
    }
}
