package com.cwc.todos_service.dao;

import com.cwc.todos_service.model.Todo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class TodoDAO {
    private WebClient webClient;

    public TodoDAO(WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<Todo> getTodos()
    {
        return webClient
                .get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);
    }
}
