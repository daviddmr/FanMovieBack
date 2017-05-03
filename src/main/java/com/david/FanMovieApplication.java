package com.david;

import com.david.model.Movie;
import com.david.model.Role;
import com.david.repository.MovieRepository;
import com.david.repository.RoleRepository;
import com.david.utils.MovieJsons;
import com.david.utils.ResultJsonAPI;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.david.model"})
@EnableJpaRepositories(basePackages = {"com.david.repository"})
public class FanMovieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FanMovieApplication.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
    private RoleRepository roleRepository;

	@Transactional
	@Override
	public void run(String... strings) throws Exception {
//		MovieJsons movieUtils = new MovieJsons();
//		List<String> moviesList = new ArrayList<>();
//		moviesList.add(movieUtils.getMoviesPage3());
//		moviesList.add(movieUtils.getMoviesPage2());
//		moviesList.add(movieUtils.getMoviesPage1());
//
//        for(String movieItem : moviesList) {
//
//			ResultJsonAPI movieJsonAPI = new Gson().fromJson(movieItem, ResultJsonAPI.class);
//
//			for (Movie movie : movieJsonAPI.getResults()) {
//				movieRepository.saveAndFlush(movie);
//			}
//		}
//
//        roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));
//        roleRepository.saveAndFlush(new Role("ROLE_USER"));
    }
}
