package com.coderscampus.lesson8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputApplication {

	public static void main(String[] args) throws IOException {

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("data.txt"));
			writer.write("This is a test string that will be output into a file. \n");
			writer.write("Is this a new line of code?");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			System.out.println(reader.readLine());
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

}
