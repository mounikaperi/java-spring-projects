package com.ocp17.java8.lambda;

public class LambdaExamples {

	public static void main(String[] args) {
		voidMethodWithNoParams();
		voidMethodWithOneParam();
		voidMethodWithTwoParams();
		returnMethodWithTwoParams();
	}
	
	private static void voidMethodWithNoParams() {
		VoidMethodWithNoParams method = () -> {
			System.out.println("Method with no return and no input params");
		};
		VoidMethodWithNoParams method1 = () -> System.out.println("Ignoring {} since we have only one line");
		method.printHello();
		method1.printHello();
	}

	private static void voidMethodWithOneParam() {
		VoidMethodWithOneParam method1 = (input) -> {
			System.out.println(input);
		};
		VoidMethodWithOneParam method2 = (input) -> System.out.println(input);
		VoidMethodWithOneParam method3 = input -> System.out.println(input);
		method1.printInput("Method1: Hello World");
		method2.printInput("Method2: Hello World");
		method3.printInput("Method3: Hello World");
	}

	private static void voidMethodWithTwoParams() {
		VoidMethodWithTwoParams addition = (a, b) -> {
			System.out.println(a+b);
		};
		VoidMethodWithTwoParams multiplication = (a, b) -> System.out.println(a*b);
		addition.calculatePrint(5, 2);
		multiplication.calculatePrint(5, 2);
	}
	
	private static void returnMethodWithTwoParams() {
		ReturnMethodWithTwoParams addition = (a, b) -> {
			return a+b;
		};
		ReturnMethodWithTwoParams multiplication = (a, b) ->  a*b;
		ReturnMethodWithTwoParams division = (a, b) -> a/b;
		System.out.println("Addition of numbers: " + addition.calculate(5, 2));
		System.out.println("Multiplication of numbers: " + multiplication.calculate(5, 2));
		System.out.println("Division of numbers: " + division.calculate(10, 2));
	}
}
