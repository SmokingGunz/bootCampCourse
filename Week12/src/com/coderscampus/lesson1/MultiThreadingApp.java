package com.coderscampus.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadingApp {

	public static void main(String[] args) {

		String message = "Starting";
		System.out.println(message);
		System.out.println("Thread- " + Thread.currentThread().getName());

		// how to implement thread multi-threading
		// This starts up as many threads as there are iterations in the for loop.
		// You only want to fire up a ton of threads, if those threads are going to be
		// waiting a lot... i.e. I/O type.
		// Each thread will run a task in its own thread.

//		for (int i = 0; i < 50; i++) {
//			new Thread(new SomeTask()).start();
//		}

		// For a CPU bound operation like we have in our "SomneTask" class,
		// we should make use of an ExecutorService. vvvv

		
		// will open up as many threads as there are iterations in the for loop. 
		// When the threads are not in use for a period of time, they will stop working.
//		ExecutorService service = Executors.newSingleThreadExecutor();
		
		
		// will limit the number of threads to 2.
//		ExecutorService service2 = Executors.newFixedThreadPool(2);
		
//		List<CompletableFuture<Void>> tasks = new ArrayList<>();
		
		ExecutorService cpuBoundTask = Executors.newFixedThreadPool(3);
		ExecutorService ioBoundTask = Executors.newCachedThreadPool();

		for (int i = 0; i < 20; i++) {
			CompletableFuture.supplyAsync(() -> new SomeTask(), ioBoundTask) // create new SomeTask
			                 .thenApplyAsync(someTask -> someTask.doSomeWork(), cpuBoundTask) // then return someTask and execute .call on someTask
			                 .thenApplyAsync(someTask -> someTask.markComplete(), ioBoundTask) // then return someTask and execute.
			                 .thenAcceptAsync(dto -> System.out.println(dto), ioBoundTask); // thenAccept doesn't return anything, just print it.
//			tasks.add(task);
			
			
			// Futures were great prior to Java 8. Now we have something better. 
//			Future<TaskDto> futureTask = service.submit(new SomeTask()); 
//			System.out.println(futureTask.get());
			
		}

		message = "Finished";
		System.out.println(message); 
		
//		while (tasks.stream().filter(CompletableFuture::isDone).count() < 20) {
//			// this just loops and keeps the main thread alive until all threads are done working.
//			
//			
//		}
	}

}
