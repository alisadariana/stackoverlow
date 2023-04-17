package com.example.stackoverflow.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequestDTO {
    private Integer userId;
    private Integer questionId;
    private String text;
    private String photo;
}
