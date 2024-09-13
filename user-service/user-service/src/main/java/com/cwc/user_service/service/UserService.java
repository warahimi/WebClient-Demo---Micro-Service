package com.cwc.user_service.service;

import com.cwc.user_service.dao.UserDAO;
import com.cwc.user_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public Flux<User> getUsers()
    {
        return userDAO.getUsers()
               // .delayElements(Duration.ofSeconds(1))
                //.doOnNext(user -> System.out.println("Retrieving user - "+ user.getId()))
        ;
    }
    public Mono<User> getUserById(int id)
    {
        return userDAO.getUserById(id);
    }
}
