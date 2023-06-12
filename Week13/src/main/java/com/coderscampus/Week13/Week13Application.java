package com.coderscampus.Week13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.coderscampus") // to use when your configuration class is not in the same package as your main class. 
public class Week13Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Week13Application.class, args);
		
		Reader in = new FileReader("path/to/file.csv");
		@SuppressWarnings("deprecation")
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
		for (CSVRecord record : records) {
		  record.get(0);
		  record.get(1);
		  record.get(2);
		  record.get(3);
		  
		}
	}

}
