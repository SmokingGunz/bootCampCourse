package com.coderscampus.Week14;

import org.junit.jupiter.api.Test;

import com.coderscampus.Week14.dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
	
	/**
	 * JSON 
	 * JavaScript Object Notation
	 * A Simple String based way to notate data
	 * 	- Key : Value pairs
	 *  - Key : Value pairs are separated by commas
	 *  - Objects are sperated by { }
	 *  - Arrays are sperated by [ ]
	 *  
	 *  Important note: JSON is NOT tied to JavaScript... it is language agnostic (*meaning it'll work in any language)
	 *  
	 *  Person: name, age, gender
	 *  
	 *  {
	 *  	"name": "John",
	 *  	"age": 30,
	 *  	"gender": "Male"
	 *  }
	 *  
	 *  List<Person> people = 
	 *  [
	 *  	{
	 *  		"name": "John",
	 *  		"age": 30,
	 *  		"gender": "Male"
	 *  },
	 *      {
	 *     	 	"name": "Jane Doe",
	 *  		"age": 29,
	 *  		"gender": "Female"
	 *      },
	 *  
	 *  ]
	 *  
	 *  XML 
	 *  
	 *  	<people>
	 *  		<person>
	 *  	    	<name>John</name>
	 *  	    	<age>30</age>
	 *  	    	<gender>Male</gender>
	 *  		</person>
	 *  		<person>
	 *  	   		<name>Jane Doe</name>
	 *  	    	<age>29</age>
	 *  	    	<gender>Female</gender>
	 *  		</person>
	 *  	</people>
	 *  
	 *  
	 *  
	 *  
	 */
	
	@Test
	public void convertJsonStringToJavaObject() {
		
		String jsonString = "{\"name\": \"John\", \"age\": 30, \"gender\": \"Male\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Person person = mapper.readValue(jsonString, Person.class); // how to convert JSON string to Java object
			System.out.println(person);
			System.out.println(person.getName());
			System.out.println(person.getAge());
			System.out.println(person.getGender());
			celebrateBirthday(person);
			
			System.out.println(mapper.writeValueAsString(person)); // how to convert Java object to JSON string
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void celebrateBirthday(Person person) {
		person.setAge(person.getAge() + 1);
	}
	
	// convert Java object to JSON string
	@Test
    public void convertJavaObjectToJsonString() {
		Person person = new Person();
		person.setName("John");
		person.setAge(30);
		person.setGender("Male");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			System.out.println(mapper.writeValueAsString(person));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
