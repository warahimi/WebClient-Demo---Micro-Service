package com.cwc.photos_service.controller;

import com.cwc.photos_service.model.Photo;
import com.cwc.photos_service.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/photo")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping
    public Flux<Photo> getPhotos()
    {
        return photoService.getPhotos();
    }
}
