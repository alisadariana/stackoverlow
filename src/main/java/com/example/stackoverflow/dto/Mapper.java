package com.example.stackoverflow.dto;

import com.example.stackoverflow.dto.response.QuestionResponseDTO;
import com.example.stackoverflow.dto.response.UserResponseDTO;
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
        questionResponseDTO.setUserId(question.getUserId());
        questionResponseDTO.setTitle(question.getTitle());
        questionResponseDTO.setText(question.getText());
        questionResponseDTO.setTimestamp(question.getTimestamp());
        questionResponseDTO.setPhoto(question.getPhoto());
        questionResponseDTO.setText(question.getTag());
        return questionResponseDTO;
    }

    public static List<QuestionResponseDTO> questionsToQuestionResponseDTO(List<Question> questions) {
        return questions.stream().map(Mapper::questionToQuestionResponseDTO).collect(Collectors.toList());
    }
}
