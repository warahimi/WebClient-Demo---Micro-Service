package com.cwc.albums_service.service;

import com.cwc.albums_service.dao.AlbumDAO;
import com.cwc.albums_service.model.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumDAO albumDAO;
    public Flux<Album> getAlbums()
    {
        return albumDAO.getAlbums();
    }
}
