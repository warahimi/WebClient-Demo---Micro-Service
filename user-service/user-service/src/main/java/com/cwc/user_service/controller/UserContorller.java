package com.cwc.user_service.controller;

import com.cwc.user_service.model.User;
import com.cwc.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserContorller {
    private final UserService userService;

    @GetMapping
    public Flux<User> getUsers()
    {
        return userService.getUsers();
    }
    @GetMapping(value = "/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE) // sending the data as event stream rather sending it as entire object at end
    public Flux<User> getUsersEvent() // Asynch and nonblocking
    {
        return userService.getUsers();
    }
    @GetMapping("/if-error")
    public Flux<User> getUsersWithError() {
        return userService.getUsers()
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found")));
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable int id)
    {
        return userService.getUserById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not foud")));
    }
}
