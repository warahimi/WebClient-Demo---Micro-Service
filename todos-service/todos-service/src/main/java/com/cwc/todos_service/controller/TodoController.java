package com.cwc.todos_service.controller;

import com.cwc.todos_service.model.Todo;
import com.cwc.todos_service.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public Flux<Todo> getTodos()
    {
        return todoService.getTodos();
    }
}
