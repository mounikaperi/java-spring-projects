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
		System.out.println("abc".startsWith("a")); // true
		System.out.println("abc".startsWith("A")); // false
		
		System.out.println("abc".endsWith("c")); // true
		System.out.println("abc".endsWith("a")); // false
		
		System.out.println("abc".contains("b")); // true
		System.out.println("abc".contains("B")); // false
		
		System.out.println("----------------------------------------------------");
		System.out.println("abcabc".replace("a", "A")); // AbcAbc
		System.out.println("abcabc".replace('a', 'A')); // AbcAbc
		
		System.out.println("----------------------------------------------------");
		System.out.println("abc".strip()); // abc
		System.out.println("\t a b c\n".strip()); // a b c
		
		String text = " abc\t ";
		System.out.println(text.trim().length()); // 3
		System.out.println(text.strip().length()); // 3
		System.out.println(text.stripLeading().length()); // 5
		System.out.println(text.stripTrailing().length()); // 4
		
		System.out.println("----------------------------------------------------");
		
		/**
		 * indent(n) where n > 0 
		 * 		-> Adds n spaces to beginning of each line
		 * 		-> Normalizes existing line breaks (Yes)
		 * 		-> Adds line break at end if missing
		 * 
		 * indent(n) where n == 0
		 * 		-> No change
		 * 		-> Normalizes existing line breaks (Yes)
		 * 		-> Adds line break at end if missing
		 * 
		 * indent(n) where n<0
		 * 		-> Removes upto n spaces from each line where the same number of chanracters is removed from each non-blank line
		 * 		-> Normalizes existing line breaks
		 * 		-> Adds line break at end if missing
		 * 
		 * stripIndent() 
		 * 		-> Removes all leading incidental whitespaces
		 * 		-> Normalizes existing line breaks
		 * 		-> Doesnt add line break at end if missing
		 */
		
		var block = """
				a
				 b
				c""";
		var concat =  " a\n"
					+ "  b\n"
					+ " c";
		
		System.out.println(block.length()); // 6 - 3 characters(a, b, c) one space before b 2 new lines after a and b
		System.out.println(concat.length()); // 9 - 3 characters(a, b, c) 1 space before a, 2 spaces before b and one space before c and 2 newlines after a and b
		System.out.println(block.indent(1).length()); // 10 - 3 characters(a, b, c) one space before b 2 newlines after a and b, one space added before a, b, c and one newline added after c if doesnt exist
		System.out.println(concat.indent(-1).length()); // 7 -> 3 characters(a, b, c) 3 new lines after a b c and one space before b
		System.out.println(concat.indent(-4).length()); // 6 -> 3 characters (a, b , c) 3 new lines after a, b, c 
		System.out.println(concat.stripIndent().length()); // 6 -> 3 characters (a, b, c) 2 new lines one space before b
		
		System.out.println("----------------------------------------------------");
	}

}
