package com.turtlesoup.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TurtlesoupApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurtlesoupApplication.class, args);
	}

}
