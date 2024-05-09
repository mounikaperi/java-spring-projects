package com.ocp17.streamsapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ocp17.collections.Visitor;

public class StreamsAPI {
	public static void main(String[] args) {
		List<Visitor> visitors = new ArrayList<>();
		visitors.add(new Visitor(105, "Vamsy", "abc@gmail.com", 67.00));
		visitors.add(new Visitor(102, "John", "john@gmail.com", 72.00));
		visitors.add(new Visitor(103, "Raju", "raju@gmail.com", 180.00));
		visitors.add(new Visitor(104, "Rani", "rani@gmail.com", 167.00));
		visitors.add(new Visitor(101, "Rakesh", "rakesh@gmail.com", 27.00));
		visitors.add(new Visitor(106, "Ramesh", "ramesh@gmail.com", 897.00));
		visitors.add(new Visitor(107, "Kiran", "kiran@gmail.com", 607.00));
		
		visitors.stream().forEach(v -> v.setFee(v.getFee() + 100));
		visitors.stream().forEach(System.out::println);
		System.out.println(".....................................");
		
		Optional<Visitor> result = visitors.stream().reduce((v1, v2) -> v1.getFee() > v2.getFee() ? v1 : v2);
		System.out.println(result.get());
		
		System.out.println(".....................................");
		visitors.stream().filter(v -> v.getFee() <= 150).forEach(System.out::println);
		
		System.out.println(".....................................");
		List<String> names = visitors.stream().map(v -> v.getFullName()).collect(Collectors.toList());
		System.out.println(names);
		
		System.out.println(".....................................");
	}
}
