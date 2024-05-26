package com.ocp17.strings;

public class StringsPracticeClass {

	public static void main(String[] args) {
		String name1 = "Fluffy";
		String name2 = new String("Fluffy");
		String name3 = """
					   Fluffy""";
		
		System.out.println(1+2);      // 3
		System.out.println("a"+"b");  // ab
		System.out.println("a"+"b"+3);// ab3
		System.out.println(1+2+"c");  // 3c
		System.out.println("c"+1+2);  // c12
		System.out.println("c"+ null);// cnull
		
		int three = 3;
		String four = "4";
		System.out.println(1 + 2 + three + four); //64
		
		System.out.println("----------------------------------------------------");
		var name4 = "animals";
		System.out.println(name4.length()); //7
		
		System.out.println("----------------------------------------------------");
		System.out.println(name4.charAt(0));  // a
		System.out.println(name4.charAt(5));  // l
//		System.out.println(name4.charAt(8));  // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Index 8 out of bounds for length 7
		
		System.out.println("----------------------------------------------------");
		System.out.println(name4.indexOf("a")); // 0
		System.out.println(name4.indexOf("al")); //4
		System.out.println(name4.indexOf("a", 4)); // 4
		System.out.println(name4.indexOf("al", 5)); // -1
		
		System.out.println("----------------------------------------------------");
		System.out.println(name4.substring(3)); // mals
		System.out.println(name4.substring(name4.indexOf("m"))); // mals
		System.out.println(name4.substring(3, 4)); // m
		System.out.println(name4.substring(3, 7)); // mals
		System.out.println(name4.substring(3, 3)); // Empty String
//		System.out.println(name4.substring(3, 2)); // Exception
//		System.out.println(name4.substring(3, 8)); // Exception
		
		System.out.println("----------------------------------------------------");
		System.out.println(name4.toUpperCase()); // ANIMALS
		System.out.println("Abc123".toLowerCase()); // abc123
		
		System.out.println("----------------------------------------------------");
		System.out.println("abc".equals("ABC")); // false
		System.out.println("ABC".equals("ABC")); // true
		System.out.println("abc".equalsIgnoreCase("ABC")); // true
		
		
		System.out.println("----------------------------------------------------");
	}

}
