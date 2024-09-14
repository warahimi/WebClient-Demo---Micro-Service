package com.cwc.comments_service.controller;

import com.cwc.comments_service.model.Comment;
import com.cwc.comments_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/db")
    public ResponseEntity<List<Comment>> getCommentsFromDB()
    {
        List<Comment> comments = commentService.getCommentsFromDB();
        if(!comments.isEmpty())
        {
            return ResponseEntity
                    .ok(comments);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/db/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Long id) {
        Optional<Comment> commentById = commentService.getCommentByIdFromDb(id);

        if (commentById.isPresent()) {
            return ResponseEntity.ok(commentById.get());
        } else {
            // Returning a custom error message
            String errorMessage = String.format("Comment with ID %d not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorMessage);
        }
    }


}
