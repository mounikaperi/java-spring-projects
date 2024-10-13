package com.ocp17.java8;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		Function<String, String> convertStr = input -> input.toUpperCase();
		System.out.println("The uppercase value of the string is: " + convertStr.apply("hello"));
		//--------------------------------------------------------------------------------------
		Function<String, String> sameValue = Function.identity();
		System.out.println("The value for the given input is: " + sameValue.apply("hello"));
		//--------------------------------------------------------------------------------------
		Function<Integer, Integer> multiplyOperation = a -> {
			System.out.println("Double Operation");
			return a*2;
		};
		multiplyOperation = multiplyOperation.andThen(a -> {
			System.out.println("Triple Operation");
			return 3*a;
		});
		System.out.println(multiplyOperation.apply(5));
		//--------------------------------------------------------------------------------------
		Function<Integer, Integer> divOperation = a -> {
			System.out.println("Division by 2 operation");
			return a/2;
		};
		divOperation = divOperation.compose(a -> {
			System.out.println("Division by 3 operation");
			return a/3;
		});
		System.out.println(divOperation.apply(30));
	}

}
