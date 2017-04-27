package com.david.repository;

import com.david.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david on 26/04/2017.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
