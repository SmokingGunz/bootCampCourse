package com.coderscampus.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApplication {

	public static void main(String[] args) {
		
		
	

//		example4();
		
//		example2();
//		example1();
	

	}



	public static void example4() {
		List<List<Integer>> listOfNumbersList = new ArrayList<>();
		
		listOfNumbersList.add(Arrays.asList(1,2,3)); 
		listOfNumbersList.add(Arrays.asList(2,3,4));
		listOfNumbersList.add(Arrays.asList(3,4,5));
		listOfNumbersList.add(Arrays.asList(4,5,6));
		
		IntSummaryStatistics sumStats = listOfNumbersList.stream()
														 .flatMap(x -> x.stream())
//														 .mapToInt(Integer::intValue)
											 // this ^^^^ is the same as below. Just another way to write it
														 .mapToInt(x -> x.intValue())
														 .summaryStatistics();
		
		
		System.out.println("Average: " + sumStats.getAverage());
		System.out.println("Max: " + sumStats.getMax());
		System.out.println("Min: " + sumStats.getMin());
		System.out.println("Count: " + sumStats.getCount());
		
//		System.out.println(sum);
	}
	
	public static void example3() {

		List<Car> cars = new ArrayList<>();
		
		cars.add(new Car("Tesla", "Model S", 2019));
		cars.add(new Car("Tesla", "Model S", 2018));
		cars.add(new Car("Tesla", "Model X", 2016));
		cars.add(new Car("Tesla", "Model 3", 2019));
		cars.add(new Car("Ford", "F150", 2017));
		cars.add(new Car("Toyota", "Corolla", 1997));
		cars.add(new Car("Toyota", "Celica", 2002));
		
		// Tesla -> ["Model S 2019", Model S 2018", "Model X 2016", "Model 3 2019"]
		// Ford -> ["F150 2017"]
		// Toyota -> ["Corolla 1997", "Cellica 2002"]
	
		
		Map<String, List<Car>> groupedByBrand = cars.stream()
													.collect(Collectors.groupingBy((car) -> car.getBrand()));
		
		// ^^^ Cmnd 2, L at the beginning of line to assign to local variable ^^^
		
		System.out.println(groupedByBrand);
		
		Set<Entry<String, List<Car>>> entrySet = groupedByBrand.entrySet();
		
		System.out.println(entrySet);
		
		entrySet.stream()
				.forEach((entry) -> {
					System.out.println(entry.getKey() + " -> " + entry.getValue());
					});
		
	}

	public static void example2() {
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Car("Tesla", "Model S", 2019));
		cars.add(new Car("Tesla", "Model S", 2018));
		cars.add(new Car("Tesla", "Model X", 2016));
		cars.add(new Car("Tesla", "Model 3", 2019));
		cars.add(new Car("Ford", "F150", 2017));
		cars.add(new Car("Toyota", "Corolla", 1997));
		cars.add(new Car("Toyota", "Celica", 2002));
		
		List<String> models = cars.stream()
								  .map(car -> car.getModel())
								  .collect(Collectors.toList());
		
		
		Set<String> brands =  cars.stream()
								  .map(car -> car.getBrand())
								  .collect(Collectors.toSet());
		
		String brand1 =  cars.stream()
							 .map(car -> car.getBrand())
							 .distinct()
							 .filter(brand -> brand.startsWith("T"))
							 .collect(Collectors.joining(", "));
		
		// Here would be the long way to do it without streams
		// DON'T DO THIS!!! Its better to use Java 8 Streams!!!
		
		Set<String> carBrands = new LinkedHashSet<>();
		for (Car car : cars) {
			String brand= car.getBrand();
			if (brand.startsWith("T")) {
				carBrands.add(brand);
			}
		}
		String output = "";
		for (String carBrand : carBrands) {
			// the equivalent to this commented out code is below 
//			output = output + carBrand + ", ";
			
			output += carBrand + ", ";
		}
		output = output.substring(0, output.length()-2);
		
		// map is an intermediary operation meaning it is never the final operation of a stream.
		// collect is a final operation meaning it is the last operation of a stream. 
		
		
		models.stream()
			  .forEach(model -> System.out.println(model));
		
		System.out.println("-----------");
		
		brands.stream()
			  .forEach(brand -> System.out.println(brand));
		
		System.out.println("-----------");

		
		System.out.println(brand1);
		
		
		System.out.println("-----------");

		
		System.out.println(output);
	}

	public static void example1() {
		List<String> names = new ArrayList<>();

		populateNames(names);

//		for (String name : names) {
//			System.out.println(name);
//		}
		
		
		System.out.println("Verbose stream example: " + "\n");
		
		// verbose stream example
		
		names.stream()
			 .forEach((String name) -> {
				 System.out.println(name);
			 });
		
		
		System.out.println("");
		System.out.println("Condensed stream example: " + "\n");
		
		// condensed stream example
		
		names.stream()
		     .forEach(name -> System.out.println(name));
		
		System.out.println("");
		System.out.println("Mulithreaded stream example: " + "\n");
		
		// Multi-threaded stream example
		
		names.parallelStream()
		     .forEach(name -> System.out.println(name));
	}

	private static void populateNames(List<String> names) {

		names.add("Nahla Kirkland");
		names.add("Charly Gay");
		names.add("Jamie-Lee Swan");
		names.add("George McKeown");
		names.add("Deen Markham");
		names.add("Misha Ali");
		names.add("Tanya James");
		names.add("Taybah Wilkinson");
		names.add("Zac Holman");
		names.add("Kacie Dunlap");

	}

}
