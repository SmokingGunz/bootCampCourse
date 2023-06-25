package com.coderscampus.Week15.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.Week15.domain.Person;
import com.coderscampus.Week15.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	
	// getting all persons from the database
	@GetMapping("/persons")
	public String getRootWebpage(ModelMap model) {

		// how to hard code information into the model to use inside the template
		// this is not working 

//		String firstName = "John";
//		String lastName = "Doe";
//		model.put("firstName", firstName);
//		model.put("lastName", lastName);
		
		List<Person> people = personService.findAll();

		Person person = new Person();

		model.put("person", person);
		
		model.put("people", people);
		

		// This is what gets returned / resolved when we return a string inside of a
		// regular Controller GetMapping method
		// /src/main/resources/templates/{filename}.html - this is where this controller
		// will look for the template

		return "people";
	}

	// getting a specific person from the database
	@GetMapping("/persons/{personId}")
	public String getPerson(@PathVariable Integer personId, ModelMap model) {

		Person person = personService.findById(personId);
		model.put("person", person);

		return "people";

	}

	
	// adding a new person to the database
	@PostMapping("/persons")
	public String postRootWebpage(Person person) {

		Person savedPerson = personService.save(person);

		System.out.println(savedPerson);

//		System.out.println(person);
		// return "welcome"; was the previous line of code
		return "redirect:/persons"; // this with redirect to the root page GetMapping

	}

	
	// updating a person in the database
	@PostMapping("/persons/{personId}")
	public String postPerson(Person person) {

		Person savedPerson = personService.save(person);
		System.out.println();

		return "redirect:/persons/" + savedPerson.getId();
	}
	
	
	// deleting a person from the database
	@PostMapping("/persons/{personId}/delete")
	public String deletePerson (@PathVariable Integer personId) {
		
		personService.delete(personId);
		
		return "redirect:/persons";
		
	}
}
