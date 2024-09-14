package com.cwc.posts_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}
