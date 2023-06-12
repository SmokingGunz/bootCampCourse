package com.coderscampus.lesson5;

public class Person {

	private String name;
	private Integer age;
	private String eyeColor;

	public Person(String name, Integer age, String eyeColor) {
		this.name = name;
		this.age = age;
		this.eyeColor = eyeColor;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", eyeColor=" + eyeColor + "]";
	}

}
