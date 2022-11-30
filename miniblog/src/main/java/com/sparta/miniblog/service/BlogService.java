package com.sparta.miniblog.service;

import com.sparta.miniblog.dto.*;
import com.sparta.miniblog.entity.Blog;
import com.sparta.miniblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    //글쓰기
    @Transactional
    public ResponseEntity<BlogResponseBasicDto> createBlog(BlogRequestDto blogRequestDto) {
        Blog blog = new Blog(blogRequestDto);
        blogRepository.save(blog);
        BlogResponseBasicDto res = new BlogResponseBasicDto("글 작성 완료");
        res.resultBlog(blog);
        HttpStatus httpStatus = HttpStatus.valueOf(201);
        return new ResponseEntity<BlogResponseBasicDto>(res,httpStatus);
        //return blogResponseDto;
    }

    //게시글 전체 조회
    @Transactional
    public ResponseEntity<BlogResponseListDto> getBlogs() {
        BlogResponseListDto blogResponseList = new BlogResponseListDto();
        List<Blog> list = blogRepository.findAllByOrderByModifiedAtDesc();

        for (Blog blog : list) {
            blogResponseList.addBlogList(new BlogResponseDto(blog));
        }
        HttpStatus httpStatus = HttpStatus.valueOf(blogResponseList.getStatusCode());
        return new ResponseEntity<BlogResponseListDto>(blogResponseList,httpStatus);
    }

    //게시글 수정하기
    @Transactional
    public ResponseEntity<BlogResponseBasicDto> update(Long id, BlogRequestDto blogRequestDto) {
        /*
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 글이 존재하지 않아요")
        );

         */
        Blog blog = checkBlog(id);
        String msg = "비밀번호 불일치";
        if(blog.getPassword().equals(blogRequestDto.getPassword())){
            blog.update(blogRequestDto);
            msg = "수정 성공";
        }
        BlogResponseBasicDto res = new BlogResponseBasicDto(msg);
        res.resultBlog(blog);
        HttpStatus httpStatus = HttpStatus.valueOf(201);
        return new ResponseEntity<BlogResponseBasicDto>(res,httpStatus);
    }

    //게시글 삭제
    @Transactional
    public ResponseEntity<BlogResponseBasicDto> deleteBlog(Long id, BlogRequestDto blogRequestDto){
        Blog blog = checkBlog(id);
        String msg = "비밀번호 불일치";
        if(blog.getPassword().equals(blogRequestDto.getPassword())){
            blogRepository.deleteById(id);
            msg = "삭제 성공";
        }
        BlogResponseBasicDto res = new BlogResponseBasicDto(msg);
        res.resultBlog(blog);
        HttpStatus httpStatus = HttpStatus.valueOf(201);
        return new ResponseEntity<BlogResponseBasicDto>(res, httpStatus);
    }

    //게시글 하나 조회
    @Transactional
    public ResponseEntity<BlogResponseBasicDto> getBlog(Long id) {
        Blog blog = checkBlog(id);
        BlogResponseBasicDto res = new BlogResponseBasicDto("블로그 조회 완료");
        res.resultBlog(blog);
        HttpStatus httpStatus = HttpStatus.valueOf(201);
        return new ResponseEntity<BlogResponseBasicDto>(res,httpStatus);
    }

    public Blog checkBlog(Long id){
        return blogRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 글이 존재하지 않아요")
        );
    }
}
