package com.capbank.CapBank;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


@SpringBootApplication
public class CapBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapBankApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			String email = "test4@test";
			User user = new User(
					email,
					"1234",
					"test3"
			);

//			usingMongoTemplateAndQuery(repository, mongoTemplate, email, user);

			repository.findUserByEmail(email)
					.ifPresentOrElse(u -> {
						System.out.println(user + " already exists");
					}, ()-> {
						System.out.println("inserting user " + user);
						repository.insert(user);
					});
		};
	}

	private void usingMongoTemplateAndQuery(UserRepository repository, MongoTemplate mongoTemplate, String email, User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<User> users = mongoTemplate.find(query, User.class);

		if(users.size() > 1) {
			throw new IllegalStateException("found many users with email " + email);
		}
		if(users.isEmpty()){
			System.out.println("inserting user " + user);
			repository.insert(user);
		} else {
			System.out.println(user + " already exists");
		}
	}
}
