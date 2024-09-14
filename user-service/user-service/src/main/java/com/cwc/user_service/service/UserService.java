package com.cwc.user_service.service;

import com.cwc.user_service.dao.UserDAO;
import com.cwc.user_service.model.User;
import com.cwc.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final UserRepository userRepository;

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

    public List<User> getUsersFromDb()
    {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getUserByIdFromDb(Long id)
    {
        return userRepository.findById(id);
    }

}
