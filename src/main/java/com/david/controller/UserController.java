package com.david.controller;

import com.david.model.Movie;
import com.david.model.User;
import com.david.repository.MovieRepository;
import com.david.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by david on 28/04/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MovieRepository movieRepository;

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

    @RequestMapping("/remove")
    public String deleteUser(@RequestParam("id") Long id) {
        repository.delete(id);

        return "Success";
    }

    @RequestMapping(value = "/add_favorite", method = RequestMethod.POST, produces = "application/json")
    public User addFavorite(@RequestParam("id") Long id, @RequestBody Set<Long> idFavorites) {
        User user = repository.findOne(id);
        idFavorites.addAll(user.getFavorites_movies());
        user.setFavorites_movies(idFavorites);
        return repository.saveAndFlush(user);
    }

    @RequestMapping(value = "/remove_favorite", method = RequestMethod.POST, produces = "application/json")
    public User removeFavorite(@RequestParam("id") Long id, @RequestBody Set<Long> idFavorites) {
        User user = repository.findOne(id);
        Set<Long> currentFavorites = user.getFavorites_movies();
        currentFavorites.removeAll(idFavorites);
        user.setFavorites_movies(currentFavorites);
        return repository.saveAndFlush(user);
    }

    @RequestMapping(value = "/favorites", produces = "application/json")
    public List<Movie> getFavorites(@RequestParam("id") Long id) {
        User user = repository.findOne(id);
        List<Movie> movies = new ArrayList<>();
        user.getFavorites_movies().forEach(
            idMovie -> movies.add(movieRepository.findOne(idMovie))
        );

        return movies;
    }

}
