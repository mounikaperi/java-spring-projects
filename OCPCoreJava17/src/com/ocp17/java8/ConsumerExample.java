package com.ocp17.java8;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> convertAndDisplay = (input) -> System.out.println("Converted value is: " + input.toUpperCase());
		convertAndDisplay.accept("hello");
		
		Consumer<String> appendInput = input -> System.out.println("New value after appending is: " + "HELLO" + input);
		appendInput.accept("world");
		appendInput.andThen(convertAndDisplay).accept("Java8");
	}

}
