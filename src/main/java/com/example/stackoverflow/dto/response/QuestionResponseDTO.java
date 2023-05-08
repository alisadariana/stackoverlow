package com.example.stackoverflow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {
    private Integer id;
    private Integer userId;
    private String title;
    private String text;
    private LocalDateTime timestamp;
    private String photo;
    private List<Integer> answerIds;
    private List<String> tagNames;
    private List<Integer> tagIds;
}
