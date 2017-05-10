package com.david.controller;

import com.david.model.Movie;
import com.david.repository.MovieRepository;
import com.david.utils.MovieJsons;
import com.david.utils.ResultJsonAPI;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        return repository.saveAndFlush(movie);
    }

    @RequestMapping(value = "/remove", produces = "application/json")
    public Movie deleteMovie(@RequestParam("id") Long id) {
        Movie movie = repository.findOne(id);
        repository.delete(id);
        movie.setGenre_ids(null);
        return movie;
    }

    @RequestMapping(value = "/top10", produces = "application/json")
    public List<Movie> topTen() {
        List<Movie> movies =  repository.findAll();

        movies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                if (m1.getVote_average() > m2.getVote_average())
                    return -1;
                if (m1.getVote_average() < m2.getVote_average())
                    return 1;
                return 0;
            }
        });

        return movies.subList(0, 10);
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
