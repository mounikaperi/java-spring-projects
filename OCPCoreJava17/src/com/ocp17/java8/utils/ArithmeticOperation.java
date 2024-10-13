package com.ocp17.java8.utils;

@FunctionalInterface
public interface ArithmeticOperation {
	public int performOperation(int a, int b);
	public default void performAdd(int a, int b) {
		System.out.println(a+b);
	}
	public static void printInput(int res) {
		System.out.println("The result is: " + res);
	}
}
