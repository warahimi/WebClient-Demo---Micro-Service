package com.cwc.todos_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}
