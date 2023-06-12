package com.coderscampus.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

public class SynchronizedBlocksExample {

	private AtomicInteger j = new AtomicInteger(0);

	@Test
	public void example1() {

		List<CompletableFuture<Integer>> tasks = new ArrayList<>();
		ExecutorService executor = Executors.newCachedThreadPool();
		
//		ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();
//		
//		synchronized (map) {
//			
//			map.put(12, 35);
//		
//		}

		for (int i = 0; i < 10000; i++) {

			CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> incrementJ(), executor);

			tasks.add(task);
		}

		while (tasks.stream().filter(CompletableFuture::isDone).count() < 10000) {

			System.out.println(
					"Number of completed threads: " + tasks.stream().filter(CompletableFuture::isDone).count());

		}
		System.out.println("Number of completed threads: " + tasks.stream().filter(CompletableFuture::isDone).count());

		outputJ();
	}

	private void outputJ() {

		System.out.println(j);
	}

	private Integer incrementJ() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (j) {

			j.set(j.get() + 1);

			return j.get();
		}

	}

}
