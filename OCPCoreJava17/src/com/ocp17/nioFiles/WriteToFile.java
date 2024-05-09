package com.ocp17.nioFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteToFile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("File name: ");
		String fileName = scan.next();
		Path filePath = Paths.get(fileName);
		System.out.println("Enter data (type *** to stop): ");
		List<String> lines = new ArrayList<>();
		String line = "";
		while(!line.equals("***")) {
			line = scan.nextLine();
			if (!line.equals("***")) {
				lines.add(line);
			}
		}
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
