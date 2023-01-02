package com.coderscampus.lesson1;

public class Teacher {

	private String classes;
	private String levelOfEducation;
	protected int totalNumberOfMarkedPapers;
	
	protected void markPapers () {
		System.out.println("I'm a teacher and I'm now marking papers.");
	}

	public void giveARaise() {
		System.out.println("Teacher gets a raise");
	}

	public void teach() {
		System.out.println("Im a teacher and Im now teaching");
	}

	public void teach(String teacherName, int age) {
		System.out.println(
				"Im a " + age + " year old teacher, my name is " + teacherName + ", and Im now teaching Physics");
	}

	public Teacher() {
		System.out.println("Inside the Teacher constructo");
		this.classes = "No classes assigned";
		this.levelOfEducation = "No Education Assigned";
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getLevelOfEducation() {
		return levelOfEducation;
	}

	public void setLevelOfEducation(String levelOfEducation) {
		this.levelOfEducation = levelOfEducation;
	}

}
