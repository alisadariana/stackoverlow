package com.example.stackoverflow.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {
    private Integer userId;
    private String title;
    private String text;
    private String photo;
    private List<Integer> tagIds = new ArrayList<>();
}
