package com.david.controller;

import com.david.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 24/04/2017.
 */

@RestController
public class MovieController {

    @RequestMapping(value = "/movies", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getMovies() {
        List<Movie> listOfMovies;
        listOfMovies = createMovieList();
        return listOfMovies;
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Movie getMovieById(@PathVariable int id) {
        List<Movie> listOfMovies;
        listOfMovies = createMovieList();

        for(Movie movie : listOfMovies) {
            if(movie.getId() == id)
                return movie;
        }

        return null;
    }

    private List<Movie> createMovieList() {
        List<Movie> listOfMovies = new ArrayList<>();
        Movie movie = new Movie(1, "Logan");
        listOfMovies.add(movie);
        movie = new Movie(2, "X men");
        listOfMovies.add(movie);
        movie = new Movie(3, "Fast and furious");
        listOfMovies.add(movie);
        movie = new Movie(4, "Megamente");
        listOfMovies.add(movie);

        return listOfMovies;
    }

}
