package com.example.stackoverflow.dto;

import com.example.stackoverflow.dto.response.AnswerResponseDTO;
import com.example.stackoverflow.dto.response.QuestionResponseDTO;
import com.example.stackoverflow.dto.response.UserResponseDTO;
import com.example.stackoverflow.entity.Answer;
import com.example.stackoverflow.entity.Question;
import com.example.stackoverflow.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static UserResponseDTO userToUserResponseDTO(User user) {
        if (user == null)
            return null;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setQuestionIds(
                user.getQuestions().stream().map(Question::getId).collect(Collectors.toList())
        );
        return userResponseDTO;
    }

    public static List<UserResponseDTO> usersToResponseDTO(List<User> users) {
        return users.stream().map(Mapper::userToUserResponseDTO).collect(Collectors.toList());
    }

    public static QuestionResponseDTO questionToQuestionResponseDTO(Question question) {
        if (question == null)
            return null;
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(question.getId());
        questionResponseDTO.setUserId(question.getUser().getId());
        questionResponseDTO.setTitle(question.getTitle());
        questionResponseDTO.setText(question.getText());
        questionResponseDTO.setTimestamp(question.getTimestamp());
        questionResponseDTO.setPhoto(question.getPhoto());
        questionResponseDTO.setTag(question.getTag());
        return questionResponseDTO;
    }

    public static List<QuestionResponseDTO> questionsToQuestionResponseDTO(List<Question> questions) {
        return questions.stream().map(Mapper::questionToQuestionResponseDTO).collect(Collectors.toList());
    }

    public static AnswerResponseDTO answerToAnswerResponseDTO(Answer answer) {
        if (answer == null)
            return null;
        AnswerResponseDTO answerResponseDTO = new AnswerResponseDTO();
        answerResponseDTO.setId(answer.getId());
        answerResponseDTO.setUserId(answer.getUser().getId());
        answerResponseDTO.setQuestionId(answer.getQuestion().getId());
        answerResponseDTO.setText(answer.getText());
        answerResponseDTO.setTimestamp(answer.getTimestamp());
        answerResponseDTO.setPhoto(answer.getPhoto());
        return answerResponseDTO;
    }

    public static List<AnswerResponseDTO> answersToAnswerResponseDTO(List<Answer> answers) {
        return answers.stream().map(Mapper::answerToAnswerResponseDTO).collect(Collectors.toList());
    }
}
