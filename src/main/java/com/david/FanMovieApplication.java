package com.david;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.david.model"})
@EnableJpaRepositories(basePackages = {"com.david.repository"})
public class FanMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(FanMovieApplication.class, args);
	}
}
