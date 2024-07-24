package com.hanna.book.springboot.service.posts;

import com.hanna.book.springboot.domain.posts.Posts;
import com.hanna.book.springboot.domain.posts.PostsRepository;
import com.hanna.book.springboot.web.dto.PostsResponseDto;
import com.hanna.book.springboot.web.dto.PostsSaveRequestDto;
import com.hanna.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id)
        );

        // cf. JPA의 영속성 컨텍스트, 더티 체킹
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );
        
        return new PostsResponseDto(entity);
    }
}
