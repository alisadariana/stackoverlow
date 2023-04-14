package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.Mapper;
import com.example.stackoverflow.dto.request.UserRequestDTO;
import com.example.stackoverflow.dto.response.UserResponseDTO;
import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("user with id: " + id + " could not be found"));
    }

    @Transactional
    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO.getFirstName(), userRequestDTO.getLastName(),
                             userRequestDTO.getEmail(), userRequestDTO.getPassword());
        User user1 = userRepository.save(user);
        return Mapper.userToUserResponseDTO(user1);
    }

    @Override
    public List<UserResponseDTO> getUsers() {
        List<User> users = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.usersToResponseDTO(users);
    }

    @Override
    public UserResponseDTO getUserById(Integer id) {
        User user = getUser(id);
        return Mapper.userToUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO deleteUserById(Integer id) {
        User user = getUser(id);
        userRepository.delete(user);
        return Mapper.userToUserResponseDTO(user);
    }

    @Transactional
    @Override
    public UserResponseDTO editUserById(Integer id, UserRequestDTO userRequestDTO) {
        User user = getUser(id);
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        return Mapper.userToUserResponseDTO(user);
    }
}
