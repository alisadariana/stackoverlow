package com.example.stackoverflow.service;

import com.example.stackoverflow.dto.Mapper;
import com.example.stackoverflow.dto.request.TagRequestDTO;
import com.example.stackoverflow.dto.response.TagResponseDTO;
import com.example.stackoverflow.entity.Tag;
import com.example.stackoverflow.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public Tag getTag(Integer id) {
        return tagRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("tag with id: " + id + " could not be found"));
    }

    @Override
    public Tag getTag(String name) {
        return StreamSupport
                .stream(tagRepository.findAll().spliterator(), false)
                .filter(thisTag -> thisTag.getName().equals(name))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("tag with name: " + name + " could not be found")
                );
    }

    @Override
    public TagResponseDTO addTag(TagRequestDTO tagRequestDTO) {
        Tag tag = new Tag(tagRequestDTO.getName());
        Tag tag1 = tagRepository.save(tag);
        return Mapper.tagToTagResponseDTO(tag1);
    }

    @Override
    public List<TagResponseDTO> getTags() {
        List<Tag> tags = StreamSupport
                .stream(tagRepository.findAll().spliterator(), false)
                .toList();
        return Mapper.tagsToTagResponseDTO(tags);
    }

    @Override
    public TagResponseDTO getTagById(Integer id) {
        Tag tag = getTag(id);
        return Mapper.tagToTagResponseDTO(tag);
    }
}
