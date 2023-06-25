package com.coderscampus.Week15.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Week15.domain.Person;
import com.coderscampus.Week15.repository.PersonRepository;

@Service
public class PersonService {

	private Integer personId = 1;

	@Autowired
	private PersonRepository personRepo;

	public Person save(Person person) {
		if (person.getId() == null)
			person.setId(personId++);
		return personRepo.save(person);
	}

	public Person findById(Integer personId) {

		return personRepo.findById(personId);
	}

	public List<Person> findAll() {
		
		return personRepo.findAll();

	}

	public void delete(Integer personId) {
		
		personRepo.delete(personId);
	}

}
