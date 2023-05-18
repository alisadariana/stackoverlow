package com.example.stackoverflow.dto;

import com.example.stackoverflow.dto.response.*;
import com.example.stackoverflow.entity.*;

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
        userResponseDTO.setPassword(user.getPassword());
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
        questionResponseDTO.setAnswerIds(
                question.getAnswers().stream().map(Answer::getId).collect(Collectors.toList())
        );
        questionResponseDTO.setTagNames(
                question.getTags()
                        .stream()
                        .map(Tag::getName)
                        .collect(Collectors.toList())
        );
        questionResponseDTO.setTagIds(
                question.getTags()
                        .stream()
                        .map(Tag::getId)
                        .collect(Collectors.toList())
        );
        questionResponseDTO.setVotes(
                question.getVotes()
                        .stream()
                        .map(Mapper::voteToVoteResponseDTO)
                        .collect(Collectors.toList())
        );
        int count = 0;
        for (Vote vote : question.getVotes()) {
            if (vote.getVoteType() == VoteType.UP)
                count++;
            else
                count--;
        }
        questionResponseDTO.setVoteCount(count);
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
        answerResponseDTO.setVotes(
                answer.getVotes()
                        .stream()
                        .map(Mapper::voteToVoteResponseDTO)
                        .collect(Collectors.toList())
        );
        int count = 0;
        for (Vote vote : answer.getVotes()) {
            if (vote.getVoteType() == VoteType.UP)
                count++;
            else
                count--;
        }
        answerResponseDTO.setVoteCount(count);
        return answerResponseDTO;
    }

    public static List<AnswerResponseDTO> answersToAnswerResponseDTO(List<Answer> answers) {
        return answers.stream().map(Mapper::answerToAnswerResponseDTO).collect(Collectors.toList());
    }

    public static TagResponseDTO tagToTagResponseDTO(Tag tag) {
        TagResponseDTO tagResponseDTO = new TagResponseDTO();
        tagResponseDTO.setId(tag.getId());
        tagResponseDTO.setName(tag.getName());
        tagResponseDTO.setQuestionIds(
                tag.getQuestions().stream().map(Question::getId).collect(Collectors.toList())
        );
        return tagResponseDTO;
    }

    public static List<TagResponseDTO> tagsToTagResponseDTO(List<Tag> tags) {
        return  tags.stream().map(Mapper::tagToTagResponseDTO).collect(Collectors.toList());
    }

    public static VoteResponseDTO voteToVoteResponseDTO(Vote vote) {
        VoteResponseDTO voteResponseDTO = new VoteResponseDTO();
        voteResponseDTO.setId(vote.getId());
        voteResponseDTO.setUserId(vote.getUser().getId());
        voteResponseDTO.setPostId(vote.getPost().getId());
        voteResponseDTO.setVoteType(vote.getVoteType());
        return voteResponseDTO;
    }
}
