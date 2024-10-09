package com.ocp17.java7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.ocp17.java7.utils.CustomResource;

public class TryWithResources {
	public static void main(String[] args) throws Exception {
		beforeJava7();
		withJava7();
		withCustomResInJava7();
	}

	public static void beforeJava7() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:/eazybytes.txt"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} finally {
			br.close();
		}
	}
	
	public static void withJava7() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:/eazybytes.txt"));) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		}
	}
	
	/**
	 * Sample implementation from Java 7 
	 * @throws Exception 
	 */
	public static void withCustomResInJava7() throws Exception {
		try(CustomResource cr = new CustomResource();) {
			cr.readFromResource();
		}
	}

}