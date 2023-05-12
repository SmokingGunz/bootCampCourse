package com.coderscampus.lesson1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileServiceImpl implements FileService, GenericService {

	@Override
	public String readLine(File file) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			return reader.readLine();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	@Override
	public void writeLine(File file, String line) {

	}

	@Override
	public void logStuff() {
		// TODO Auto-generated method stub
		
	}

}
