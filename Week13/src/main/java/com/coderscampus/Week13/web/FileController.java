package com.coderscampus.Week13.web;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Week13.domain.User;
import com.coderscampus.Week13.service.FileService;

@RestController
public class FileController {

//  Don't do this vvvv 
//	private Integer customerData = 0; // This maintains the State of the data. Meaning that the data can be accessed from multiple places
//  and updated and stored in a single place. 

//  Spring leverages something called the ApplicationContext
//	It instantiates these beans/components and stores them as Singleton objects 
//	meaning one and only one instance of the them is ever created and managed.

//	@Autowired
//	private ApplicationContext applicationContext;

	@Value("${superuser.username}")
	private String superuserUsername;

	@Value("${superuser.password}")
	private String superuserPassword;

	@Value("${superuser.name}")
	private String superuserName;

	@Autowired
	private FileService fileService;

	@Autowired
	@Qualifier("regularUser") // Use this when there are multiple beans for the same class like User. This tells Spring to look for the bean you specify.
	private User user;

	@GetMapping("/cusotmer-report")
	public Integer getCustomerData(Integer customerId) {
		// Always store this type of instance inside the method rather than inside of
		// the controller like private Integer customerId = 1;
		Integer customerData = 0;
		// fetch data based on customerId
		customerData = getCustomerDataById(customerId);
		return customerData;

	}

	private Integer getCustomerDataById(Integer customerId) {
		return new Random().nextInt();
	}

	@GetMapping("/read-lines")
	public List<String> readLines() throws IOException {
//		System.out.println(fileService);
//		FileService bean = applicationContext.getBean(FileService.class);
//		System.out.println(bean);
//		bean = applicationContext.getBean(FileService.class);
//		System.out.println(bean);
//		bean = applicationContext.getBean(FileService.class);
//		System.out.println(bean);
//		bean = applicationContext.getBean(FileService.class);
//		System.out.println(bean);
//		bean = applicationContext.getBean(FileService.class);
//		System.out.println(bean);

		System.out.println(user);

		System.out.println(superuserUsername);
		System.out.println(superuserPassword);
		System.out.println(superuserName);

		return fileService.readFiles();
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@PostMapping("/hello-world")
	public String helloWorldPost() {
		return "Okay cool, you just posted some data!";
	}

}
