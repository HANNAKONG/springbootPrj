package com.hanna.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // 기본적인 CRUD 메소드가 자동으로 생성됨
}
