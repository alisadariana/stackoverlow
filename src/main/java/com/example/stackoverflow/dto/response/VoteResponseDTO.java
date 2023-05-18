package com.example.stackoverflow.dto.response;

import com.example.stackoverflow.entity.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteResponseDTO {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private VoteType voteType;
}
