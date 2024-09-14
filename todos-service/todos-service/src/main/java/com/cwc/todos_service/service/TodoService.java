package com.cwc.todos_service.service;

import com.cwc.todos_service.dao.TodoDAO;
import com.cwc.todos_service.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoDAO todoDAO;

    public Flux<Todo> getTodos()
    {
        return todoDAO.getTodos();
    }
}
