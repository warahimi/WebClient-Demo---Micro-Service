package com.cwc.photos_service.dao;

import com.cwc.photos_service.model.Photo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PhotoDAO {
    private WebClient webClient;

    public PhotoDAO(WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<Photo> getPhotos()
    {
        return webClient
                .get()
                .uri("/photos")
                .retrieve()
                .bodyToFlux(Photo.class);
    }
}
