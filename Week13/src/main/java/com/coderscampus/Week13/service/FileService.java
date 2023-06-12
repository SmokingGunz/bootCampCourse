package com.coderscampus.Week13.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // this means that this is no longer a singleton and you'll get a new instance every time you call
// @Service  only need this if you are saying to manage it as a component not using a bean.
public class FileService {
	
	private String filename;
	
	public FileService() {
		// This is just a blank no arg constructor because we also have a 1-arg constructor explicitly defined below
	}
	
	public FileService(String filename) {
		this.filename = filename;
	}

	public List<String> readFiles() throws IOException {

		return Files.readAllLines(Paths.get(filename));
	}

}
