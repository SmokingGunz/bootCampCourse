package com.coderscampus.lesson1.compsci;

import com.coderscampus.lesson1.Teacher;

public class CompSciTeacher extends Teacher {

	public CompSciTeacher () {
		System.out.println("Inside the CompSciTeacher constructor");
		this.setClasses("COMP 101, COMP 201");
		this.setLevelOfEducation("Bachelor of Science");
	}
	public void teach () {
		System.out.println("Im a CompSci teacher and Im now teaching CompSci");
	}
	
}
