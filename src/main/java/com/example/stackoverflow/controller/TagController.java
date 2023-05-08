package com.example.stackoverflow.controller;

import com.example.stackoverflow.dto.request.TagRequestDTO;
import com.example.stackoverflow.dto.response.TagResponseDTO;
import com.example.stackoverflow.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping("/add")
    @ResponseBody
    public TagResponseDTO addTag(@RequestBody final TagRequestDTO tagRequestDTO) {
        return tagService.addTag(tagRequestDTO);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<TagResponseDTO> getTags() {
        return tagService.getTags();
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public TagResponseDTO getTagById(@PathVariable final Integer id) {
        return tagService.getTagById(id);
    }
}
