package com.coderscampus.Week13.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.coderscampus.Week13.domain.User;
import com.coderscampus.Week13.service.FileService;

@Configuration
@Profile("dev")
public class Week13DevConfiguration {
	
	// For illustration purposes only as an example of a real world
	// scenario of connecting to a database.
//	@Bean
//	public Datasource dataSource() {
//		Datasource db = new Datasource();
//		db.setConnectionString("jdbc:mysql://localhost:3306/week13");
//		db.setUsername("root");
//		db.setPassword("root");
//		return db;
//	}
	
	@Bean
	public FileService fileService() {
		return new FileService("text.txt");
	}
	
	@Bean
	public User superUser() {
		return new User("trevor@craftycoder.com", "lakdsjlfkajsd", "Trevor Page");
	}

	@Bean
	public User regularUser() {
		return new User("regular_joe@gmail.com", "joe1234", "Joe Blow");
	}
}
