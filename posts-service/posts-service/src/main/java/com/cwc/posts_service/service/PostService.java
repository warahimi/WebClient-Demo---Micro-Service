package com.cwc.posts_service.service;

import com.cwc.posts_service.dao.PostDAO;
import com.cwc.posts_service.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDAO postDAO;
    public Flux<Post> getPosts()
    {
        return postDAO.getPosts();
    }
}
