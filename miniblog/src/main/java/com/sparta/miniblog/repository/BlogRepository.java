package com.sparta.miniblog.repository;

import com.sparta.miniblog.dto.BlogResponseDto;
import com.sparta.miniblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByModifiedAtDesc();
}
