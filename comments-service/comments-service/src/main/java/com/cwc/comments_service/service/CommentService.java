package com.cwc.comments_service.service;

import com.cwc.comments_service.dao.CommentsDAO;
import com.cwc.comments_service.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentsDAO commentsDAO;

    public Flux<Comment> getComments()
    {
        return commentsDAO.getComments();
    }

}
