package com.cwc.comments_service.controller;

import com.cwc.comments_service.model.Comment;
import com.cwc.comments_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public Flux<Comment> getComments()
    {
        return commentService.getComments();
    }
}
