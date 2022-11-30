package com.sparta.miniblog.dto;

import com.sparta.miniblog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BlogResponseListDto extends ResponseDto{

    List<BlogResponseDto> blogList = new ArrayList<BlogResponseDto>();

    public BlogResponseListDto(){
        super("블로그 조회 성공", 201);
    }

    public void addBlogList(BlogResponseDto blogResponseDto) {
        blogList.add(blogResponseDto);
    }
}
