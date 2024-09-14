package com.cwc.comments_service.config;

import com.cwc.comments_service.dao.CommentsDAO;
import com.cwc.comments_service.model.Comment;
import com.cwc.comments_service.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoadTODatabase implements CommandLineRunner {
    private final CommentRepository commentRepository;
    private final CommentsDAO commentsDAO;
    @Override
    public void run(String... args) throws Exception {
        if(commentRepository.count() == 0)
        {
            Flux<Comment> comments = commentsDAO.getComments();

            Mono<List<Comment>> listMono = comments.collectList();
            listMono.subscribe(commentRepository::saveAll);
        }

    }
}
