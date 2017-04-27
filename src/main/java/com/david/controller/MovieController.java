package com.david.controller;

import com.david.model.Movie;
import com.david.repository.MovieRepository;
import com.david.utils.MovieJsons;
import com.david.utils.ResultJsonAPI;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 26/04/2017.
 */

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository repository;

    @RequestMapping
    public String getMovie(@RequestParam("id") Long id) {
        String result;
        Movie movie = repository.findOne(id);
        result = new Gson().toJson(movie);

        return result;
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

        return "Done!";
    }

}
