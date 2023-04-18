package com.ar.apigroupfamily.family.app.utils;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterUtil {

	public static void createFile(String fileName, String fileContent) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
			fileOutputStream.write(fileContent.getBytes());
		} catch (IOException e) {
			System.err.println("Error creating file: " + e.getMessage());
		}
	}
}
