package com.example.stackoverflow.repository;

import com.example.stackoverflow.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{
}
