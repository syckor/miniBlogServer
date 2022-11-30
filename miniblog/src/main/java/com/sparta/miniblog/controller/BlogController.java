package com.sparta.miniblog.controller;


import com.sparta.miniblog.dto.*;
import com.sparta.miniblog.entity.Blog;
import com.sparta.miniblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }

    //글쓰기
    @PostMapping("/blog")
    public ResponseEntity<BlogResponseBasicDto> write(@RequestBody BlogRequestDto blogRequestDto){
        return blogService.createBlog(blogRequestDto);
    }

    //게시글 하나 조회
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogResponseBasicDto> read(@PathVariable Long id){
        return blogService.getBlog(id);
    }

    //게시글 수정하기
    @PutMapping("/blog/{id}")
    public ResponseEntity<BlogResponseBasicDto> updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogRequestDto){
        return blogService.update(id, blogRequestDto);

    }

    //게시글 삭제하기
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<BlogResponseBasicDto> deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogRequestDto){
        return blogService.deleteBlog(id, blogRequestDto);
    }

    //전체 리스트 조회
    @GetMapping("/blog")
    public ResponseEntity<BlogResponseListDto> getTest(){
        return blogService.getBlogs();
    }

}
