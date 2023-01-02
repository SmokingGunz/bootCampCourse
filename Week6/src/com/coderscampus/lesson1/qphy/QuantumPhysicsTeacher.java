package com.coderscampus.lesson1.qphy;

import com.coderscampus.lesson1.physics.PhysicsTeacher;

public class QuantumPhysicsTeacher extends PhysicsTeacher {

	public QuantumPhysicsTeacher () {
		System.out.println("Inside the Quantum Physics Teacher constructor");
		this.setClasses("QPHY 101, QPHY 201");
		this.setLevelOfEducation("PhD");
	}
}
