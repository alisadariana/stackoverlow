package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.request.UserRequestDTO;
import com.example.stackoverflow.dto.response.UserResponseDTO;
import com.example.stackoverflow.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUser(Integer id);
    UserResponseDTO addUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getUsers();
    UserResponseDTO getUserById(Integer id);
    UserResponseDTO deleteUserById(Integer id);
    UserResponseDTO editUserById(Integer id, UserRequestDTO userRequestDTO);

}
