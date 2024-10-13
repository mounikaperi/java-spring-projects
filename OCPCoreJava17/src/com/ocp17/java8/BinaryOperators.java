package com.ocp17.java8;

import java.util.function.BinaryOperator;

public class BinaryOperators {

	public static void main(String[] args) {
		BinaryOperator<String> appendAndConvert = (word1, word2) -> (word1+word2).toUpperCase();
		System.out.println("The updated value after appending and converting: " + appendAndConvert.apply("Hello", "World"));
		
		BinaryOperator<Integer> maxOperation = BinaryOperator.maxBy((a, b) -> (a > b) ? 1: ((a == b) ? 0 : -1));
		System.out.println("The largest number is: " + maxOperation.apply(16, 30));
		
		BinaryOperator<Integer> minOperation = BinaryOperator.minBy((a, b) -> (a > b) ? 1: ((a == b) ? 0 : -1));
		System.out.println("The smallest number is: " + minOperation.apply(16, 30));
	}

}
