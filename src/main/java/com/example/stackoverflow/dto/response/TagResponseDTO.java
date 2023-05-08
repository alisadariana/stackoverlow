package com.example.stackoverflow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagResponseDTO {
    private Integer id;
    private String name;
    private List<Integer> questionIds;
}
