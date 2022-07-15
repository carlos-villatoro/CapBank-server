package com.capbank.CapBank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CapBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapBankApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepo repository){
		return args -> {
			User user = new User("testdude", "test@dude", "1234");

			repository.insert(user);
		};
	}
}
