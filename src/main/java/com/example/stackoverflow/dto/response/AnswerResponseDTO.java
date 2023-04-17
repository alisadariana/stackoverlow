package com.example.stackoverflow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponseDTO {
    private Integer id;
    private Integer userId;
    private Integer questionId;
    private String text;
    private LocalDateTime timestamp;
    private String photo;
}
