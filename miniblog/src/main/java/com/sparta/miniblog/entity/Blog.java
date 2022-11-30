package com.sparta.miniblog.entity;


import com.sparta.miniblog.dto.BlogRequestDto;
import com.sparta.miniblog.repository.BlogRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Blog(BlogRequestDto blogRequestDto){
        this.username = blogRequestDto.getUsername();
        this.title = blogRequestDto.getTitle();
        this.content = blogRequestDto.getContent();
        this.password = blogRequestDto.getPassword();
    }

    public void update(BlogRequestDto blogRequestDto) {
        this.title = blogRequestDto.getTitle();
        this.content = blogRequestDto.getContent();
    }
}
