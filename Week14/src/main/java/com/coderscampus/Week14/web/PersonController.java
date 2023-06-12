package com.coderscampus.Week14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Week14.dto.Person;
import com.coderscampus.Week14.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepo;

	@PostMapping("/persons")
	public Person createPerson(@RequestParam String name, @RequestParam Integer age, @RequestParam(required = false) String gender, @RequestParam Long id) {

		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setGender(gender);
		person.setId(id);
		personRepo.save(person);

		return person;
	}
	
	@PostMapping("/people") // Same as above but without @RequestParam. Down side to this is you cannot specify whether a parameter is required.
	public Person createPeople(String name, Integer age, String gender, Long id) {

		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setGender(gender);
		person.setId(id);
		personRepo.save(person);

		return person;
	}
	
	// fetches the person with id 1
	// http://localhost:8080/persons/1
	
	@GetMapping("/persons/{personId}") // pathvariable is the id of the person being passed in the url
	public Person getPerson(@PathVariable Long personId) {
		
		System.out.println("Person ID is: " + personId);
		return personRepo.findById(personId);
		
		
	}
}
