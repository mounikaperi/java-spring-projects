package com.ocp17.lambdasandfuntionalinterfaces;

import java.time.LocalDateTime;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionaIInterface {

	public static void main(String[] args) {
		Consumer<String> c1 = str -> {
			for (int i=1; i<10; i++) {
				System.out.println(str);
			}
		};
		c1.accept("RAMA");
		Consumer<String> c2 = System.out::println;
		c2.accept("Krishna");
		
		Predicate<Integer> isEven = x -> x%2==0;
		System.out.println("25 is even ? " + isEven.test(25));
		System.out.println("29 is even ? " + isEven.test(29));
		
		Supplier<String> orgTitle = () -> "Cognizant";
		c2.accept(orgTitle.get());
		
		Supplier<String> today = () -> LocalDateTime.now().toString();
		c2.accept(today.get());
		
		BinaryOperator<Integer> sum = (n1, n2) -> n1 + n2;
		BinaryOperator<Integer> max = (n1, n2) -> n1 >= n2 ? n1 : n2;
		
		Consumer<Integer> c3 = System.out::println;
		c3.accept(sum.apply(25, 75));
		c3.accept(max.apply(25, 75));
	}
}
