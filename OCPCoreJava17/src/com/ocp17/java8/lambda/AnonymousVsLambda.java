package com.ocp17.java8.lambda;

import com.ocp17.java8.utils.ArithmeticOperation;

public class AnonymousVsLambda {
	int sum = 0;
	public void sum() {
		ArithmeticOperation sumOperation = (a, b) -> {
			int sum = 0;
			this.sum = a+b;
			System.out.println("The value of sum inside lambda is: " + sum);
			return this.sum;
		};
		System.out.println("The sum of 2 numbers is: " + sumOperation.performOperation(10, 20));
	}
	public static void main(String[] args) {
		AnonymousVsLambda lambda = new AnonymousVsLambda();
		lambda.sum();
	}
}
