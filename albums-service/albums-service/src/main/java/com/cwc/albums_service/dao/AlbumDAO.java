package com.cwc.albums_service.dao;

import com.cwc.albums_service.model.Album;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class AlbumDAO {

    private WebClient webClient;

    public AlbumDAO(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<Album> getAlbums()
    {
        return webClient.get()
                .uri("/albums")
                .retrieve()
                .bodyToFlux(Album.class);
    }
}
