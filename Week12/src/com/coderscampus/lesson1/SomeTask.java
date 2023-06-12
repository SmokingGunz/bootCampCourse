package com.coderscampus.lesson1;

import java.util.Random;
import java.util.concurrent.Callable;

class SomeTask {

	private static int taskId = 0;
	private TaskDto taskDto;

	// this is a runnable task that runs in a separate thread
	// it can also be used to run a task in the main thread

//	@Override
//	public void run() {
//		for (int i = 0; i < 100000; i++) {
//			Integer int1 = new Random().nextInt();
//			Integer int2 = new Random().nextInt();
//			Double something = (int1 + int2) * 1.65;
//		}
//		taskId++;
//		System.out.println("Hey look at me, I'm a task-id: " + taskId + "! I'm running on thread "
//				+ Thread.currentThread().getName());
//
//	}

	
	public SomeTask doSomeWork() {
		
		taskDto = new TaskDto();
		
		for (int i = 0; i < 1000000; i++) {
			Integer int1 = new Random().nextInt();
			Integer int2 = new Random().nextInt();
			Double something = (int1 + int2) * 1.65;
			taskDto.setValue(something);
		}
		taskId++;
		System.out.println("Hey look at me, I'm a task-id: " + taskId + "! I'm running on thread "
				+ Thread.currentThread().getName());

//		taskDto.setFinished(true);
		
		return this;
	}
	
	public TaskDto markComplete() {
		taskDto.setFinished(true);
		
		return taskDto;
		
	}

}