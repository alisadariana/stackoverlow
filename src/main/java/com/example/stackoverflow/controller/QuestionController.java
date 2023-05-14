package com.example.stackoverflow.controller;

import com.example.stackoverflow.dto.request.QuestionRequestDTO;
import com.example.stackoverflow.dto.response.QuestionResponseDTO;
import com.example.stackoverflow.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add")
    @ResponseBody
    public QuestionResponseDTO addQuestion(@RequestBody final QuestionRequestDTO questionRequestDTO) {
        return questionService.addQuestion(questionRequestDTO);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<QuestionResponseDTO> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public QuestionResponseDTO getQuestionById(@PathVariable final Integer id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestionById(@PathVariable final Integer id) {
        questionService.deleteQuestionById(id);
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public QuestionResponseDTO editQuestionById(@RequestBody final QuestionRequestDTO questionRequestDTO,
                                                @PathVariable final Integer id) {
        return questionService.editQuestionById(id, questionRequestDTO);
    }
}
