package com.david.controller;

import com.david.model.Movie;
import com.david.model.User;
import com.david.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by david on 28/04/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(produces = "application/json")
    public User getUser(@RequestParam("id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/list", produces = "application/json")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public User insertUser(@RequestBody User user) {
        repository.saveAndFlush(user);
        return user;
    }

    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST, produces = "application/json")
    public User addFavorite(@RequestParam("id") Long id, @RequestBody List<Movie> movies) {
        User user = repository.findOne(id);
        user.setMovies(movies);
        return repository.saveAndFlush(user);
    }

    @RequestMapping("/remove")
    public String deleteUser(@RequestParam("id") Long id) {
        repository.delete(id);

        return "Success";
    }

}
