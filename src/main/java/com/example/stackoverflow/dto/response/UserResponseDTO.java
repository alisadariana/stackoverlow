package com.example.stackoverflow.dto.response;

import com.example.stackoverflow.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Integer> questionIds;
    private Double score;
    private RoleType role;
    private Boolean banned;
}
