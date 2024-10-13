package com.ocp17.java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionalLambdas {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> isEven = (a,b) -> (a+b) % 2 == 0;
		System.out.println("Is the sum of given numbers even? " + isEven.test(4, 9));
		
		BiFunction<Integer, Integer, Double> power = (a, b) -> Math.pow(a, b);
		System.out.println("The power of given number is: " + power.apply(5, 2));
		
		BiConsumer<String, String> appendAndConvert = (word1, word2) -> System.out.println("Converted Value is: " + (word1 + word2).toUpperCase());
		appendAndConvert.accept("Hello", "World");
	}

}
