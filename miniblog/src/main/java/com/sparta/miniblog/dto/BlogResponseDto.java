package com.sparta.miniblog.dto;

import com.sparta.miniblog.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BlogResponseDto{
    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BlogResponseDto(Blog blog, String msg,int statusCode){
        this.id = blog.getId();
        this.username = blog.getUsername();
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.createdAt = blog.getCreatedAt();
        this.modifiedAt = blog.getModifiedAt();
    }

    public BlogResponseDto(Blog blog){
        this.id = blog.getId();
        this.username = blog.getUsername();
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.createdAt = blog.getCreatedAt();
        this.modifiedAt = blog.getModifiedAt();
    }
}
