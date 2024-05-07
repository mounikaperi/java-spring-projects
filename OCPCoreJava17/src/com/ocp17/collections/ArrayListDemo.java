package com.ocp17.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Visitor> visitors = new ArrayList<>();
		visitors.add(new Visitor(105, "Vamsy", "abc@gmail.com", 67.00));
		visitors.add(new Visitor(102, "John", "john@gmail.com", 67.00));
		visitors.add(new Visitor(103, "Raju", "raju@gmail.com", 67.00));
		visitors.add(new Visitor(104, "Rani", "rani@gmail.com", 67.00));
		visitors.add(new Visitor(101, "Rakesh", "rakesh@gmail.com", 67.00));
		visitors.add(new Visitor(106, "Ramesh", "ramesh@gmail.com", 67.00));
		visitors.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		
		System.out.println(visitors.size() + " records are found");
		System.out.println("--------------------------------------------");
		for (Visitor v : visitors) {
			System.out.println(v);
		}
		System.out.println("--------------------------------------------");
		Collections.sort(visitors);
		for (Visitor v : visitors) {
			System.out.println(v);
		}
		System.out.println("--------------------------------------------");
		Collections.sort(visitors, (v1, v2) -> v1.getFullName().compareTo(v2.getFullName()));
		for (Visitor v : visitors) {
			System.out.println(v);
		}
	}
}
