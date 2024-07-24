package com.hanna.book.springboot.web;

import com.hanna.book.springboot.service.posts.PostsService;
import com.hanna.book.springboot.web.dto.PostsResponseDto;
import com.hanna.book.springboot.web.dto.PostsSaveRequestDto;
import com.hanna.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.reflect.IReflectionWorld;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    //@Autowired가 아닌 생성자로 주입
    //@RequriedArgsConstructor가 final으로 선언된 필드를 인자값으로 하는 생성자를 생성해줌
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

}
