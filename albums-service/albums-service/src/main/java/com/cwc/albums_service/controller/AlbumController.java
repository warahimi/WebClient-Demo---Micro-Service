package com.cwc.albums_service.controller;

import com.cwc.albums_service.model.Album;
import com.cwc.albums_service.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/album")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping
    public Flux<Album> getAlbums()
    {
        return albumService.getAlbums();
    }
}
