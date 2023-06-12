package com.coderscampus.lesson5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ReflectionApplication {

	PersonRepository personRepository = new PersonRepository();
	// Used to create one very generic save method that invokes methods for saving. 
	@Test
	public void reflection_test() {

		Person person = new Person();
		person.setName("coder");
		person.setAge(18);
		person.setEyeColor("blue");

		Method[] methods = person.getClass().getMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		save(person, personRepository);

	}

	public <T, R> void save(T obj, R repo) {
		Class<T> c = (Class<T>) obj.getClass();
		
		try {
			Method saveMethod = repo.getClass().getMethod("save", c);
			saveMethod.invoke(repo, obj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("ooops there was an error getting the saved method");
		}
	}

	public void save(Person person) {
		// get a Repository and call the save method on the repo
		PersonRepository repo = new PersonRepository();
		repo.save(person);
	}

	public void save(Cat cat) {
		// get a Repository and call the save method on the repo
		CatRepository repo = new CatRepository();
		repo.save(cat);
	}

	public void save(Car car) {
		// get a Repository and call the save method on the repo
		CarRepository repo = new CarRepository();
		repo.save(car);
	}

}
