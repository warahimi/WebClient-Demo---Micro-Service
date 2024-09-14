package com.cwc.albums_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album {
    private int userId;
    private int id;
    private String title;
}
