package com.cwc.photos_service.service;

import com.cwc.photos_service.dao.PhotoDAO;
import com.cwc.photos_service.model.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoDAO photoDAO;

    public Flux<Photo> getPhotos()
    {
        return photoDAO.getPhotos();
    }
}
