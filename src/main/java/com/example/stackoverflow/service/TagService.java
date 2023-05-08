package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.request.TagRequestDTO;
import com.example.stackoverflow.dto.response.TagResponseDTO;
import com.example.stackoverflow.entity.Tag;

import java.util.List;

public interface TagService {

    Tag getTag(Integer id);
    Tag getTag(String name);
    TagResponseDTO addTag(TagRequestDTO tagRequestDTO);
    List<TagResponseDTO> getTags();
    TagResponseDTO getTagById(Integer id);
}
