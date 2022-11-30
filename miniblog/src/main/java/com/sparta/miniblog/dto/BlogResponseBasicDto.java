package com.sparta.miniblog.dto;

import com.sparta.miniblog.entity.Blog;
import lombok.Getter;

@Getter
public class BlogResponseBasicDto extends ResponseDto{
    private BlogResponseDto blog;
    public BlogResponseBasicDto(String msg){
        super(msg, 201);
    }

    public void resultBlog(Blog blog){
        this.blog = new BlogResponseDto(blog);

    }
}
