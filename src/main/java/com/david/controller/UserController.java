package com.david.controller;

import com.david.model.User;
import com.david.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david on 28/04/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping(value = "/get")
    public User getUser(Long id) {
        User user = repository.getOne(id);
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/add")
    public String insertUser(User user) {
        repository.save(new User("David"));
        repository.save(new User("David2"));
        repository.save(new User("David3"));
        repository.save(new User("David4"));
        repository.save(new User("David5"));
        return "Done";
    }

    @RequestMapping(value = "/teste")
    public String teste() {
        return "Done!";
    }

}
