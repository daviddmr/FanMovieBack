package com.david.model;

import javax.persistence.*;

/**
 * Created by david on 26/04/2017.
 */

@Entity
public class GenreMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_movie")
    private Long idMovie;

    private String category;

    protected GenreMovie() {}

    public GenreMovie(Long idMovie, String category) {
        this.idMovie = idMovie;
        this.category = category;
    }
}
