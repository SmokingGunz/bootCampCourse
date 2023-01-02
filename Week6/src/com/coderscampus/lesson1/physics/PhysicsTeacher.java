package com.coderscampus.lesson1.physics;

import com.coderscampus.lesson1.Teacher;

public class PhysicsTeacher extends Teacher {

	public PhysicsTeacher() {
		System.out.println("Inside the PhysicsTeacher constructor");
		this.setClasses("PHYS 101, PHYS 201");
		this.setLevelOfEducation("Masters of Science");
	}

	public void teach() {
		System.out.println("Im a Physics teacher and Im now teaching Physics");
	}

	public void teach(String teacherName) {
		System.out.println("Im a Physics teacher called " + teacherName + " and Im now teaching Physics");
	}

}
