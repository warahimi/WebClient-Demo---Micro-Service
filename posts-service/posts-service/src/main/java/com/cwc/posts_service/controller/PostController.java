package com.cwc.posts_service.controller;


import com.cwc.posts_service.model.Post;
import com.cwc.posts_service.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public Flux<Post> getPosts()
    {
        return postService.getPosts();
    }
}
