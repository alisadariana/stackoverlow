package com.example.stackoverflow.controller;

import com.example.stackoverflow.dto.request.UserRequestDTO;
import com.example.stackoverflow.dto.response.UserResponseDTO;
import com.example.stackoverflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public UserResponseDTO addUser(@RequestBody final UserRequestDTO userRequestDTO) {
        return userService.addUser(userRequestDTO);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public UserResponseDTO getUserById(@PathVariable final Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public UserResponseDTO deleteUserById(@PathVariable final Integer id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public UserResponseDTO editUserById(@RequestBody final UserRequestDTO userRequestDTO,
                                        @PathVariable final Integer id) {
        return userService.editUserById(id, userRequestDTO);
    }

    @GetMapping("/ban/{id}")
    @ResponseBody
    public UserResponseDTO banUserById(@PathVariable final Integer id) {
        return userService.banUserById(id);
    }

    @GetMapping("/unban/{id}")
    @ResponseBody
    public UserResponseDTO unbanUserById(@PathVariable final Integer id) {
        return userService.unbanUserById(id);
    }
}