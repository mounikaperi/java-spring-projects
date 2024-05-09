package com.ocp17.nioFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("File Name? ");
		String fileName = scan.nextLine();
		Path filePath = Paths.get(fileName);
		try {
			List<String> lines = Files.readAllLines(filePath);
			lines.stream().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scan.close();
	}

}
