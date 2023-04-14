package com.example.stackoverflow.dto;

import com.example.stackoverflow.dto.response.UserResponseDTO;
import com.example.stackoverflow.entity.User;

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
        return userResponseDTO;
    }

    public static List<UserResponseDTO> usersToResponseDTO(List<User> users) {
        return users.stream().map(Mapper::userToUserResponseDTO).collect(Collectors.toList());
    }
}
