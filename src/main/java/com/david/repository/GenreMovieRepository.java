package com.david.repository;

import com.david.model.GenreMovie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david on 26/04/2017.
 */
public interface GenreMovieRepository extends JpaRepository<GenreMovie, Long> {
}
