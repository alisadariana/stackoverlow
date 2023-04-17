package com.example.stackoverflow.controller;

import com.example.stackoverflow.dto.request.AnswerRequestDTO;
import com.example.stackoverflow.dto.response.AnswerResponseDTO;
import com.example.stackoverflow.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/add")
    @ResponseBody
    public AnswerResponseDTO addAnswer(@RequestBody final AnswerRequestDTO answerRequestDTO) {
        return answerService.addAnswer(answerRequestDTO);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<AnswerResponseDTO> getAnswers() {
        return answerService.getAnswers();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public AnswerResponseDTO getAnswerById(@PathVariable final Integer id) {
        return answerService.getAnswerById(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public AnswerResponseDTO deleteAnswerById(@PathVariable final Integer id) {
        return answerService.deleteAnswerById(id);
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public AnswerResponseDTO editAnswerById(@RequestBody final AnswerRequestDTO answerRequestDTO,
                                                @PathVariable final Integer id) {
        return answerService.editAnswerById(id, answerRequestDTO);
    }

}
