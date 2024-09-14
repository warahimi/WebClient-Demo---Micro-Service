package com.cwc.user_service.config;

import com.cwc.user_service.dao.UserDAO;
import com.cwc.user_service.model.User;
import com.cwc.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoadToDatabase implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserDAO userDAO;
    @Override
    public void run(String... args) throws Exception {
        //if(userRepository.findAll().size() == 0)
        /*
            Using userRepository.findAll().size() is inefficient because findAll() returns all the records
            in the database, and you're checking the size. This could be very costly if the table grows large.
            A better approach would be to check if the repository is empty using a method like userRepository.count()
             or existsById() if checking for specific records
         */
        if(userRepository.count() == 0)
        {
            // Get the Flux of users from API
            Flux<User> users = userDAO.getUsers();

            //users.subscribe(userRepository::save);

            // Collect the Flux into a List and then save all at once
            Mono<List<User>> listMono = users.collectList();

            listMono.subscribe(usersList -> userRepository.saveAll(usersList));
        }

    }
}


/*
Issues and Improvements
Asynchronous Nature of Flux.subscribe():

The subscribe() method is asynchronous, which means that when you call userRepository::save, it returns immediately and doesn't block. This can lead to a situation where the application finishes execution before all the users are saved to the database.
Additionally, userRepository.save() in this context will not handle backpressure effectively, meaning a large number of users could overwhelm the database with too many save operations at once.
Use of subscribe():

Directly using subscribe() inside a CommandLineRunner is generally discouraged because it doesn't give you control over when the operation is complete. You should rather convert the Flux into blocking operations or manage it with proper operators like collectList() or blockLast() to ensure the database operations complete before the runner finishes.
Size Check with findAll():

Using userRepository.findAll().size() is inefficient because findAll() returns all the records in the database, and you're checking the size. This could be very costly if the table grows large.
A better approach would be to check if the repository is empty using a method like userRepository.count() or existsById() if checking for specific records.
Suggested Changes
Use blockLast() to Wait for Completion: Since you're inside a CommandLineRunner and you want the loading to complete before the application fully starts, you should use blockLast() or collectList() to ensure the process completes.

Check Repository Size Efficiently: Instead of findAll().size(), you should use userRepository.count() to check whether the table is empty.
 */