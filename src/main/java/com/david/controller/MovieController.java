package com.david.controller;

import com.david.model.Movie;
import com.david.repository.MovieRepository;
import com.david.utils.MovieJsons;
import com.david.utils.ResultJsonAPI;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by david on 26/04/2017.
 */

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @RequestMapping(produces = "application/json")
    public Movie getMovie(@RequestParam("id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/list", produces = "application/json")
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Movie insertMovie(@RequestBody Movie movie) {
        repository.saveAndFlush(movie);
        return movie;
    }

    @RequestMapping("/remove")
    public String deleteMovie(@RequestParam("id") Long id) {
        repository.delete(id);

        return "Success";
    }

    @RequestMapping(value = "/fill")
    public String fillMovieTable() {

        MovieJsons movieUtils = new MovieJsons();
        List<String> moviesList = new ArrayList<>();
        moviesList.add(movieUtils.getMoviesPage1());
        moviesList.add(movieUtils.getMoviesPage2());

        for(String movieItem : moviesList) {

            ResultJsonAPI movieJsonAPI = new Gson().fromJson(movieItem, ResultJsonAPI.class);

            for (Movie movie : movieJsonAPI.getResults()) {
                repository.saveAndFlush(movie);
            }
        }

        return "Success!";
    }

}
