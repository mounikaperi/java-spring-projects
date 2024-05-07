package com.ocp17.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class Set {

	public static void main(String[] args) {
		java.util.Set<Visitor> visitors = new HashSet<>();
		visitors.add(new Visitor(105, "Vamsy", "abc@gmail.com", 67.00));
		visitors.add(new Visitor(102, "John", "john@gmail.com", 67.00));
		visitors.add(new Visitor(103, "Raju", "raju@gmail.com", 67.00));
		visitors.add(new Visitor(104, "Rani", "rani@gmail.com", 67.00));
		visitors.add(new Visitor(101, "Rakesh", "rakesh@gmail.com", 67.00));
		visitors.add(new Visitor(106, "Ramesh", "ramesh@gmail.com", 67.00));
		visitors.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		visitors.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		
		System.out.println(visitors.size() + " records are found");
		System.out.println("--------------------------------------------");
		for (Visitor v : visitors) {
			System.out.println(v);
		}
		System.out.println("--------------------------------------------");
		
		java.util.Set<Visitor> visitors1= new LinkedHashSet()<>();
		visitors1.add(new Visitor(105, "Vamsy", "abc@gmail.com", 67.00));
		visitors1.add(new Visitor(102, "John", "john@gmail.com", 67.00));
		visitors1.add(new Visitor(103, "Raju", "raju@gmail.com", 67.00));
		visitors1.add(new Visitor(104, "Rani", "rani@gmail.com", 67.00));
		visitors1.add(new Visitor(101, "Rakesh", "rakesh@gmail.com", 67.00));
		visitors1.add(new Visitor(106, "Ramesh", "ramesh@gmail.com", 67.00));
		visitors1.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		visitors1.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		
		System.out.println(visitors.size() + " records are found");
		System.out.println("--------------------------------------------");
		for (Visitor v : visitors) {
			System.out.println(v);
		}
		System.out.println("--------------------------------------------");
		
		java.util.Set<Visitor> visitors2 = new TreeSet<>();
		visitors2.add(new Visitor(105, "Vamsy", "abc@gmail.com", 67.00));
		visitors2.add(new Visitor(102, "John", "john@gmail.com", 67.00));
		visitors2.add(new Visitor(103, "Raju", "raju@gmail.com", 67.00));
		visitors2.add(new Visitor(104, "Rani", "rani@gmail.com", 67.00));
		visitors2.add(new Visitor(101, "Rakesh", "rakesh@gmail.com", 67.00));
		visitors2.add(new Visitor(106, "Ramesh", "ramesh@gmail.com", 67.00));
		visitors2.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		visitors2.add(new Visitor(107, "Kiran", "kiran@gmail.com", 67.00));
		
		System.out.println(visitors.size() + " records are found");
		System.out.println("--------------------------------------------");
		for (Visitor v : visitors) {
			System.out.println(v);
		}
		System.out.println("--------------------------------------------");
		
		java.util.Set<Visitor> visitors3 = new TreeSet<>((v1, v2) -> ((Double)v1.getFee().compareTo(v2.getFee())));
		
	}

}
