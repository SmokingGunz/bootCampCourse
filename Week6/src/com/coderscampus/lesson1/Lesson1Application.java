package com.coderscampus.lesson1;

import com.coderscampus.lesson1.compsci.CompSciTeacher;
import com.coderscampus.lesson1.physics.PhysicsTeacher;
import com.coderscampus.lesson1.qphy.QuantumPhysicsTeacher;

public class Lesson1Application {

	
	// Access modifiers in Java are: public, protected, package, and private
	public static void main(String[] args) {

		PackageAccessModifierExample example = new PackageAccessModifierExample();
		System.out.println(example.someInt);
		System.out.println("----------");
		
		Teacher physicsTeacher = new PhysicsTeacher();
//		This is an alternate way of casting, but it is more verbose
//		PhysicsTeacher casteedPhyTeacher = (PhysicsTeacher)physicsTeacher;
//		casteedPhyTeacher.teach("Eric Owens");  -- this works with the above instantiated cast 
		
		System.out.println(physicsTeacher.getClasses());
		System.out.println(physicsTeacher.getLevelOfEducation());
		
		((PhysicsTeacher)physicsTeacher).teach("Eric Owens");
		((PhysicsTeacher)physicsTeacher).markPapers();
		System.out.println("---------");

		CompSciTeacher compSciTeacher = new CompSciTeacher();
		System.out.println(compSciTeacher.getClasses());
		System.out.println(compSciTeacher.getLevelOfEducation());
		compSciTeacher.teach("Eric Owens", 36);
		System.out.println("---------");

		QuantumPhysicsTeacher quantumPhysicsTeacher = new QuantumPhysicsTeacher();
		System.out.println(quantumPhysicsTeacher.getClasses());
		System.out.println(quantumPhysicsTeacher.getLevelOfEducation());
		quantumPhysicsTeacher.teach();
		System.out.println("---------");
	}

}
