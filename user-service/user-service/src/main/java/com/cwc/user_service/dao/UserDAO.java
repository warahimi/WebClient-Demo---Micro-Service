package com.cwc.user_service.dao;

import com.cwc.user_service.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserDAO {
    private final WebClient webClient;

    public UserDAO(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<User> getUsers()
    {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
    }
    public Mono<User> getUserById(int id)
    {
        Flux<User> users = getUsers();
        return users
                .filter(user -> user.getId() == id)
                .next();
    }
}
