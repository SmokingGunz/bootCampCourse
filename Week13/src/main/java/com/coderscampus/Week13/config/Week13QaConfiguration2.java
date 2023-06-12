package com.coderscampus.Week13.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.coderscampus.Week13.domain.User;
import com.coderscampus.Week13.service.FileService;

@Configuration
@Profile("qa")
public class Week13QaConfiguration2 {

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

	@Value("${superuser.username}")
	private String username;

	@Value("${superuser.password}")
	private String password;

	@Value("${superuser.name}")
	private String name;

	@Bean
	public FileService fileService() {
		return new FileService("text.txt");
	}

	@Bean
	public User user() {
		return new User(username, password, name);
	}

}
