package com.coderscampus.lesson1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
	
	String standardFileName = "data.txt";
	
	String readLine (File file) throws FileNotFoundException, IOException;

	void writeLine (File file, String line);

}
