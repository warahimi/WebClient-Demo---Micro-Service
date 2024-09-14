package com.cwc.comments_service.dao;

import com.cwc.comments_service.model.Comment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class CommentsDAO {
    private WebClient webClient;
    public CommentsDAO(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<Comment> getComments()
    {
        return webClient.get()
                .uri("/comments")
                .retrieve()
                .bodyToFlux(Comment.class);
    }
}
