package com.david;

import com.david.model.Movie;
import com.david.model.User;
import com.david.repository.MovieRepository;
import com.david.repository.UserRepository;
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
	UserRepository userRepository;

	@Autowired
	MovieRepository movieRepository;

	@Transactional
	@Override
	public void run(String... strings) throws Exception {
		MovieJsons movieUtils = new MovieJsons();
		List<String> moviesList = new ArrayList<>();
		moviesList.add(movieUtils.getMoviesPage1());
//		moviesList.add(movieUtils.getMoviesPage2());

		for(String movieItem : moviesList) {

			ResultJsonAPI movieJsonAPI = new Gson().fromJson(movieItem, ResultJsonAPI.class);

			for (Movie movie : movieJsonAPI.getResults()) {
				movieRepository.saveAndFlush(movie);
			}
		}

		User user = new User("David", "daviddmr", "pass");
		User user2 = userRepository.save(user);
		System.out.println("ID = " + user2.getId());
	}
}
