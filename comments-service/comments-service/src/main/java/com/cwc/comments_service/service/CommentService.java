package com.cwc.comments_service.service;

import com.cwc.comments_service.dao.CommentsDAO;
import com.cwc.comments_service.model.Comment;
import com.cwc.comments_service.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentsDAO commentsDAO;
    private final CommentRepository commentRepository;

    public Flux<Comment> getComments()
    {
        return commentsDAO.getComments();
    }

    public List<Comment> getCommentsFromDB()
    {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentByIdFromDb(Long id)
    {
        return commentRepository.findById(id);
    }



}
