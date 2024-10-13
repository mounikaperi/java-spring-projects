package com.ocp17.java8.lambda;

import com.ocp17.java8.utils.ArithmeticOperation;

public class ArithmeticImplementation {

	public static void main(String[] args) {
		int firstInt = 10, secondInt = 6;
		ArithmeticOperation oldSum = new ArithmeticOperation() {
			@Override
			public int performOperation(int a, int b) {
				return a+b;
			}
		};
		System.out.println("The sum of two input integers with out lambda is: " + oldSum.performOperation(firstInt, secondInt));
		ArithmeticOperation sum = (a, b) -> a + b;
		ArithmeticOperation multi = (a, b) -> a * b;
		ArithmeticOperation sub = (a, b) -> a - b;
		System.out.println("The sum of two input integers is: " + sum.performOperation(firstInt, secondInt));
		System.out.println("The subtraction of two input integers is: " + sub.performOperation(firstInt, secondInt));
		System.out.println("The multiplication of two input integers is: " + multi.performOperation(firstInt, secondInt));
	}

}
