
      1. Enhanced For Loop (JDK 5)
      2. Generics (JDK 5)
      3. Interfaces, Lambda Expressions (JDK 8)
      4. Streams API (JDK 8)
      5. Concurrency (JDK 8)
      6. NIO (JDK 8)
      7. DateTime API (JDK 8)
      8. RegEx (JDK 8)
      9. Open JDK (JDK 11)
      10. New String Methods - lines(), strip(), isBlank() - (JDK 11)
      11. New File Methods - (JDK-11)
      12. Collection::ToArray (JDK - 11)
      13. Predicate::not - (JDK- 11)
      14. var keyword - (JDK -11)
      15. HttpClient - (JDK -11)

Exception Handling:

      java.lang.Throwable
            -> Error
            -> Exception
                -> All subclasses are called checked exceptions (Compiler will check if these are handled or not)
                -> RuntimeExceptions
                    -> All subclasses are called Unchecked exceptions (Compiler will not check if they are handled)

      try..catch
      throw
      throws

      Why Compiler has two kinds of exceptions? Why checked and unchecked? why compiler doesn't check unchecked exceptions?

      1. Unchecked Exceptions must be avoided through defensive programming but they are not expected to be handled.
      2. Checked Exceptions cannot be avoided, hence it is mandate to handle them.

        Examples:

          public String getValue(int index) {
            return index>=0 && index<myArray.length ? this.myArray[index] : null; // Avoided ArrayIndexOutOfBoundsException
          }
          public void getSalary(Employee emp, double percent) {
             if (emp != null) {
               emp.setSalary(emp.getSalary() + emp.getSalary() * percent); // Avoided Null Pointer Exception
              }
          }

        Checked Exceptions:
          1. IOException
          2. FileNotFoundException
          3. SQLException

Regular try-catch

        try {
            // statment that may raise an exception
        } catch (ExceptionType1 e1) {
            // logic
        } catch (ExceptionType2 e2) {
            // logic
        } catch (ExceptionType3 e3) {
            // logic
        } catch (ExceptionType4 e4) {
            // logic
        }

try-with-multi-catch

      try {
            // statment that may raise an exception
      } catch (ExceptionType1 e1 | ExceptionType2 e2 | ExceptionType3 e3) {
            // logic
      } finally {
        // used to close the resources to avoid resource Leakage
      }

try-with-resources

    try (declare closeable objects like steams files or connections) {
            // statment that may raise an exception
    } catch (ExceptionType1 e1 | ExceptionType2 e2 | ExceptionType3 e3) {
            // logic
    }
    // finally block is not needed here
    
        
Interfaces (From JDK 8)

      1. Interfaces can accomodate method with implementation but those methods must be marked as 'default'
            interface Shape() {
                  void area();
                  void perimeter();
                  public default double estimatePaintCost(double paintRate) {
                        return this.area() * paintRate;
                  }
            }
      2. Functional Interfaces: 
            Interfaces that have only one abstract method. To ensure that a interface remains so. @FunctionalInterface compiler check annotation is used.
            Functional Interfaces are introduced to facilitate a new programming paradigm called functional programming.
            Functional Programming is passing a function as a parameter to another function.
            Functional Interfaces can be implemented using Lambda Expressions without having to create a subclass.

            @FunctionalInterface
            interface Give {
                  String doGive();
            }
            public class MyApplication {
                  public static void main(String[] args) {
                        Give orgName = () => "Cognizant";
                        System.out.println(orgName.doGive());
                        
                        Give greet = () => "Hello"; // Lambda Expression
                        System.out.println(greet.doGive());

                        Give greetByTime = () => {
                              String greeting = "";
                              int h = LocalTime.now().getHour();
                              if (h >=3 && h<=11) 
                                    greeting = "Good Morning";
                              else if (h >= 12 && h<=15) 
                                    greeting = "Good Noon";
                              else
                                    greeting = "Good Evening";
                              return greeting;
                        };
                        System.out.println(greetbyTime.doGive());
                  }
            }
      3. Types of Functional Interfaces:
            - Consumer
            - Supplier
            - Predicate
            - Operator

            Consumer: 
                  Functional Interfaces whose abstract method that accepts a param but doesnt return any value is called a Consumer
            Supplier:
                  Functional Interfaces whose abstract method doesn't accepts any param but returns a value is called Supplier
            Predicate:
                  Functional Interface whose abstract method always returns a boolean value. It doesnt matter whether it accepts a param or not, return value is always 
                  boolean.
            Operator:
                  Functional Interface whose absract method accepts param and also returns a value.

      4. java.util.function package offers a lot of pre-created functional interfaces
      5. A functional interface can refer to a method, as long as the signature of the method being referred matched with the signature of the functional interface.
      6. Scope resolution operator :: means referred -> System.out::println

Generics

      1. Generics are used to create Abstract Data Types (ADT's)
      2. ADTs are used to house algorithms that are independent of the data types
      3. For Example: Sorting, Searching, Comparisions, swapping etc are logics that wont change with data type of the data
      4. Generics do not support primitive data types and we have to use Wrapper classes in such cases.

Collections

      1 Java approach for data structures
      2. java.util.* has
                  1-> Collection (I) -> represents a collection of data
                                    -> Methods:
                                          -> add(element)
                                          -> remove(element)
                                          -> contains(element)
                                          -> size()
                                          -> stream()
                        1.a-> List (I) -> represents a linear data structure
                                    -> Allows index on elements and hence support index based operations like 
                                          -> add (element, index)
                                          -> remove(element, index)
                                          -> get(element, index) ...
                                    -> Allows duplicate elements to be added and more than one null elements
                                    -> classes that implement List Interface are:
                                          -> ArrayList -> Growable array
                                          -> Vector    -> Synchronized Growable array
                                          -> LinkedList -> Doubly linked list
                        1.b-> Set (I)  -> represents a non linear data structure and no duplicates are allowed. Index based operations are not possible
                                       -> Classes implementing Set interface are:
                                             -> HashSet -> pure set implementation. It follows no order of retrieval.
                                             -> LinkedHashSet -> It follows entry order for retrieval
                              1.b.a -> SortedSet (I)
                                             -> Classes implementing SortedSet interface are:
                                             -> TreeSet -> It follows sorted order for retrieval
                              
                  2-> Map (I)  -> represents a collection of key:value pairs, duplicate keys are not allowed.
                               -> Methods 
                                     -> put(key, value)
                                     -> keySet(),
                                     -> Values(),
                                     -> containsKey(),
                                     -> size(),
                                     -> set (key, value)
                              -> Classes implementing Map interface are:
                                    -> HashMap -> . It follows no order of retrieval.
                                    -> LinkedHashSet -> It follows entry order for retrieval
                        -> SortedMap (I)
                              -> Classes implementing SortedMap interface are:
                                    -> TreeMap -> It follows sorted order for retrieval, sorted based on keys
                  3-> Collections (C) -> Collections class offers a lot of utility methods for a variety of collection related operations.
                  4-> Comparator (I) 
                        -> is a functional interface having "int compare(T a, T b)" as the method.
                        -> It is to be implemented to dictate on how to compare our custom types like Employee, Consumer etc
                        -> The expectation is:
                              -> compare(a, b) -> shall return 0 if a is equal to b
                              -> compare(a, b) -> shall return a negative int if a is less than b
                              -> compare(a, b) -> shall return a positive int if a is greater than b
                        -> java.lang.Comparable interface with method "int compareTo(x)" is also a similar interface
                        -> Comparable is expected to be implemented by the class whose objects must be compared. 
                        -> In that case, the current object is compared within the incoming object
                              a.compareTo(b) -> shall return 0 if a is equal to b
                              a.compareTo(b) -> shall return a negative int if a is less than b
                              a.compareTo(b) -> shall return a positive int if a is greater than b

                        -> Comparable is used as a default comparision logic
                        -> Comparator is used as customized comparision logic

DateTime API

      java.time
            Static Methods:
            LocalDate       .now(), of(year, month, date),                       parse(ISOFormatString), parse(String, DateTimeFormatter)
            LocalTime       .now(), of(year, month, date),                       parse(ISOFormatString), parse(string, DateTimeFormatter)
            LocalDateTime   .now(), of(year, month, date, hour, minute, second), parse(ISOFormatString), parse(String, DateTimeFormatter)
            ZonedDateTime    now(zoneId), of(year, month, date, hour, minute, second, zoneId)

            Instance Methods
            plusYears()
            plusDays()
            plusMonths()
            plusHours()
            plusMinutes()
            minusYears()
            minusDays()
            minusMonths()
            isAfter()
            isBefore()
            compareTo()

            DateTimeFormatter
                  static methods
                        ofPattern("format")
                  instance methods
                        format(dateObject)

            Period
                  between (startDate, endDate)
            Duration
                  between (startTime, endTime)


Streams API

      A stream is a flow of data
      Source <----------------stream------------------> Destination
      Source and destination can be an array or any other collection (lists, sets etc)
      We can operate on the data before the data flows into the destination
      Source 
            <--------------stream---------------------->
                  OPERATION
                        <--------------------stream --------------------------->
                              DESTINATION
      java.util.stream.Stream class represents the stream
      A stream can be created by using 
            Stream s1 = Stream.of(anArray);
            Stream s2 = list.stream();
            Stream s3 = list.stream();
      Instance methods of Stream are:
            forEach   -> takes a consumer as a param and executes the consumer on each element of the stream and returns nothing 
                        as it doesn't return anything we cannot chain other operations and hence called as TERMINAL
            reduce    -> reduce takes a binaryOperator and executes the binaryOperator on each pair of values and returns a single value wrapped in java.util.Optional class
                         int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
                         Optional<Integer> result = Stream.of(arr).reduce((x, y) -> x+y);
                         result.get() will give 10
                         Optional is to avoid nullpointerexceptions

                     -> takes a identity value and a binaryOperator and execute the binaryOperator on each pair of values and returns a single value
                        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
                        Integer result = Stream.of(arr).reduce(0, (x,y) -> x + y); // result is 10
                        Integer result2 = Stream.of(arr).reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x : y); // result is 4
                        As it doesn't return a stream, we cannot chain other operations and hence is called a TERMINAL
            collect  -> accepts a Collector object and returns a collection. 
                        Collectors.toList()
                        Collectors.toSet() are the prebuilt objects of the Collector
                        int[] arr = new int[] {1, 2, 3, 4};
                        List<Integer> list = Stream.of(arr).collect(Collectors.toList());
                        As it doesn't return a stream, we cannot chain other operations and hence is called a TERMINAL
            filter   -> takes a predicate and returns a new stream containing values that satisfy the predicate. 
                        As it returns new stream, operations can be chained and hence called INTERMEDIATE.
                        int[] arr = new int[]{1, 2, 3, 4};
                        Stream.of(arr).filter(x -> x%2 == 0).reduce(0, (x,y) -> x + y); // returns result as 6
            map      -> takes a mapper and returns a new stream containing all mapped values from old stream.
                        int[] arr = new int[]{1, 2, 3, 4};
                        Stream.of(arr).map(n -> n*n).forEach(System.out::println); // prints [1, 4, 9, 16]
            

# CORE JAVA 17

Methods:

      public final void nap(int minutes) throws InterruptedException {}

      - This is called method declaration. Two parts - method name and parameter list are called the method signature

Access Modifiers:

      - An access modifier determines what classes a method can be accessed from. 
      - Access modifiers help to enforce when these components are allowed to talk to each other
            - private: method can be called only from within the same class
            - package: method can be called only from class in same package. also called as package-private/default access
            - protected: method can be called only from a class in the same package or a subclass
            - public: method can be called anywhere
      - Optional specifiers for methods:
            - static: Indicates that method is a member of the shared class object
            - abstract: Used in an abstract class or interface when the method body is excluded.
            - final: Specifies that the method may not be overriden in a subclass.
            - default: Used in an interface to provide default imlementation of method for classes that implement interface
            - synchronized: Used with multithreaded code
            - native: Used with interacting with code written in another language such as C++
            - strictfp: Used for making floating-point calculations portable

      - The same class
            - private: YES
            - package: YES
            - protected: YES
            - public: YES
      - another class in the same package
            - private: NO
            - package: YES
            - protected: YES
            - public: YES
      - a subclass in a different package
            - private: NO
            - package: NO
            - protected: YES
            - public: YES
      - an unrelated class in a different package
            - private: NO
            - package: NO
            - protected: NO
            - public: YES

Effectively final variables:

      - An effectively final local variable is one that is not modified after it is assigned. 
      - This means that the value of a variable doesnt change after it is et regardless of whether it is explicitly marked as final.

Working with Varargs:

      - Rules for creating a method with Varargs:
      - A method can have atmost one varargs parameter
      - If a method contains a varargs parameter, it must be the last parameter in the list

Understating static methods:

      - For utility or helper methods that don't require any object state. 
      - Since there is no need to access instance variables, having static methods eliminates the need for the caller to instantiate an object just to call the method.
      - For state that is shared by all instances of the class, like a counter. All instances must share the same state. 
      - Methods that merely use the state should be static as well.
      - A static member cannot call an instance member without referencing an instance of the class. 
      - A static or instance method can call a static method because static methods dont require an object to use.
      - Only an instance method can call another instance method on the same class without using a reference variable because instance methods do require an object.
      

Understanding Inheritance:

      1. Inheritance is a process by which subclass automatically includes certain members of the class, including primitives, objects or methods defined in parent class.
      2. When one class inherits from a parent class, all public and protected members are automatically available as part of child class. Private members are restricted to the class they are defined and are never available via inheritance.

Class Modifiers:

      final: The class may not be extended
      abstract: The class is abstract may contain abstract methods and requires a concrete subclass to instantiate
      sealed: The class may only be extended by a specific list of classes
      non-sealed: A subclass of a sealed class permits potentially unnamed subclasses.
      static: Used for static nested classes defined within a class.

Single vs Multiple Inheritance:

      1. Java supports single inheritance, by which a class may inherit from only one direct parent class. 
      2. Java also supports multiple levels of inheritance, by which one class can extend another class which in turn extends another class.
      3. Multiple Inheritance, by which a class may have multiple direct parents. By design, Java doesn't support multiple inheritance.
      4. Multiple Inheritance can lead to complex, often difficult-to-maintain data models. 
      5. Part of what makes multiple inheritance complicated is determining which parent to inherit values from in case of a conflict.

Inheriting Object:

      1. In Java, all classes inherit from a single class: java.lang.Object. Object is the only class that doesn't have a parent class.
      2. The compiler has been automatically inserting code into any class you write that doesn't extend a specific class. 
      3. The result is that every class gains access to any accessible methods in the Object class.  For Eg: toString() and equals()
      4. Primitive types such as int and boolean do not inherit from Object, since they are not classes. 
      5. Through autoboxing they can be assigned or passed as an instance of an associated wrapper class which does inherit Object.

Accessing the "this" Reference:

      1. When a method parameter has the same name as an existing instance variable, Java uses the most granular scope so when method parameter name and instance variabe name are same it thinks you are assigning the method parameter value to itself.
      2. The assignment completes successfullly within the method, but the value of the instance variable is never modifies. 
      3. The fix when you have a local variable with the same name as an instance variable is to use the this reference or keyword.
      4. The this reference refers to the current instance of the class and can be used to access any member of the class, including inherited members.
      5. It cannot be used where there is no implicit instance of te class, such as static method or static initializer block.

Calling the "super" reference:

      1. In Java, a method or variable can be defined in both a parent class and child class. 
      2. This means the object instance actually holds two copies of the same variable with the same underlying name. 
      3. To reference the version in parent class instead of current subclass we use super keyword.
      4. Declaring a variable with the same name as an inherited variable is referred to as hiding a variable.

Declaring Constructors:

      1. A constructor is a special method that matches the name of the class and has no return type.
      2. It is called when a new instance of the class is created.
      3. A class can have multiple constructors, as long as each constructor has a unique constructor signature. In this case, the parameters must be distinct.
      4. Like methods with the same name but different signatures, declaring multiple constructors with different signatures is referred to as constructor overloading.
      5. Constructors are used when creating a new object. This process is called instantiation because it creates a new instance of te class.
      6. A constructor is called when we write new followed by the name of the class we want to instantiate.
      7. When Java sees a new keyword, it allocates memory for thew new object. It then looks for constructor with a matching signature and calls it.

The Default Constructor:

      1. Every class in Java has a constructor whether you code one or not.
      2. If you don't include any constructors in the class, Java will create one for you without any parameters.
      3. The Java-created constructor is called the default constructor and is added any time a class is declared without any constructors. 
      4. The default constructor as an empty parameter list and an empty body. The constructor is generated at compile time step.
      5. The constructor wouldn't be present in .java extension file but would be present in the .class extension file
      6. Having only private constructors in a class tells the compiler not to provide a default no-argument constructor.
      7. It also prevents other classes from instantiating te class. 
      8. This is useful when a class has only static methods or the developer wants to have full control of all the calls to create new instances of the class.

Calling overloaded constructors with this():

      1. Since a class can contain multiple overloaded constructors, these constructors can actually call one another. 
      2. Constructors can be called only by writing new before the name of the constructor.
            public Hamster(int weight, String color) {
                  this.weight = weight;
                  this.color = color;
            }
            public Hamster(int weight) {
                  new Hamster(weight, "brown"); // Compiles but creates new object
            }
      3. This attempt does compile. When this constructor is called, it creates a new object with default weight and color. 
      4. It then constructs a different object with the desires weight and color. In this manner, we end up with two objects, one of which is discarded after it is created.
      5. Java provides a solution: this() - the same keyword we used to refer to instance members with parentheses.
      6. When this() is used wit parentheses, Java calls another constructor on the same instance of the class.
            public Hamster(int weight) {
                  this(weight, "brown");
            }
      7. Now, Java calls the constructor that takes two parameters with weight and color as expected.

this vs this()

      1. Despite using the same keyword, this and this() are very different. 
      2. The first this, refers to an instance of the class while the second this() refers to the constructor call within the class.
      3. Calling this() has one special rule, if you choose to call this(), it must be te first statement in the constructor. 
      4. There can be only one this() call in any constructor.
      5. Constructors calling each other can end up in infinte loop and Java detects this and throws a compile time error.
            public class Gopher {
                  public Gopher() {
                        this(5); // Doesn't compile
                  }
                  public Gopher(int dugHoles) {
                        this(); // Doesn't compile
                  }

Summary of Rules:

      1. A class can contain many overloaded constructors, provided the signature for each is distinct.
      2. The compiler inserts a default no-argument constructor if no constructors are declared.
      3. If a constructor calls this(), then it must be the first line of the constructor. 
      4. Java doesn't allow cyclic constructor calls.

Calling Parent constructors with super():

      1. The first statement of every constructor is a call to a parent constructor using super() or another constructor in the class using this().
      2. Like this and this(), super and super() are unrelated in Java. 
      3. The first super, is used to reference members of the parent class, while the second super() calls a parent constructor. 
      4. super() can be called only once and should be the first statement in the constructor.
      5. Java automatically inserts a call to the no-argument constructor super() if you donot explicitly call this() or super() as the first line of a constructor.
            public class Donkey() {}
            public class Donkey() { 
                  public Donkey() {}
            }
            is converted equivalent to:
            public class Donkey() {
                  public Donkey() {
                        super();
                  }
            }

Default constructor Tips and Tricks:

      1. Let's say we have a class that doesn't include a no-argument constructor. 
      2. What happens if we define a subclass with no constructor or a subclass with a constructor that dosnt include a super() reference?
            public class Mammal {
                  public Mammal(int age) {}
            }
            public class Seal extends Mammal {} // Doesn't compile
            public class Elephant extends Mammal {
                  public Elephant() {} // Doesnt compile
            } 
      3. The answer is that neither subclass compiles. Since Mammal defines a constructor, the compiler does not insert a no-argument constructor. 
      4. The compiler will insert a default no-argument constructor in Seal class but it will call a nonexistent parent default constructor.
            public class Seal extends Mammal {
                  public Seal() {
                        super();
                  }
            }
      5. Likewise, Elephant will not compile for similar reason, The compiler doesn't see a call to super() or this() as the first line of the constructor so it inserts a call to non-existent no-argument super() automatically.
      6. In these cases, the compiler will not help, you must create atleast one constructor in your child class that explicitly calls a parent constructor via super().
            public class Seal extends Mammal {
                  public Seal() {
                        super(6);
                  }
            }
            public class Elephant extends Mammal {
                  public Elephant() {
                        super(4); 
                  }
            }

Summary of Constructor calls:

      1. The first lne of every constructor is a call to a parent constructor using super() or an overloaded constructor using this().
      2. If the constructor does not contain a this() or super() reference, then compiler automatically inserts super() with no arguments at the first line of constructor.
      3. If a constructor calls super(), ten it must be the first line of the constructor.

Initializing Objects:

      1. Order of initialization refers to how members of a class are assigned values. 
      2. They can be given default values like 0 for an int or require explicit values such as for final variables. 
      3. First, we initialize the class, which involves invoking all static members in the class hierarchy, starting eith the highest superclass and working downward.
      4. This is sometimes referred to as loading the class. The Java Virtual Machine controls when the class is initialized.
      5. The class may be initialized when the program first starts, when a static member of the class is referenced, or shortly before an instance of the class is created.
      6. One of the most important rues with class initialization is that it happens atmost once for each class. 
      7. The class may also never be loaded if it is not used in the program.

Initialize class:

      1. If there is a superclass Y of X, then initialize class Y first.
      2. Process all static variable declarations in the order in which they appear in the class.
      3. Process all static initializers in the order in which they appear in the class. 

Initializing final fields:

      1. For instance and class variables they are assigned a default value based on their type of no value is specified. 
      2. For example: a double is initialized with 0.0 while an object reference is initialized to null. A default value is only appled to a non-final field though.
      3. final static variables must be explicitly assigned a value exactly once. 
      4. Fields marked final can be assigned values in the line in which they are declared or in an instance initializer
            public class MouseHouse {
                  private final int volume;
                  private final String name = "The Mouse House";
                  {
                        volume = 10; // Instance initializer assignment
                  }
            }
      5. Unlike static class members, though, final instance fields can also be set in a constructor.
      6. The constructor is part of the initialization process, so it is allowed to assign final instance variables.
      7. By the time the constructor completes, all final instance variables must be assigned a value exactly once.
      8. Unlike local final variables, which are not required to have a value unless they are actually used, final instance variables must be assigned a value. 
      9. If they are not assigned a value when they are declared or in an instance initializer, then they must be assigned a value in the constructor declaration 
      10. Failure to do so will result in a compile error on the line that declares the constructor.
      11. In the case of final instance variables when a constructor calls another constructor in the same class, you have to follow the flow carefully, making sure wvwey final instance variable is assigned a value exactly once. 

Initialing Instances:

      1. First, start at the lowest-level constructor where the new keyword is used. 
      2. Remember, the first line of every constructor is a call to this() or super() and if omitted, the compiler will automatically insert a call to this() or super(). 
      3. Then, progress upward and note the order of constructors. F
      4. Finally, initialize each class starting with the superclass, processing each instance initializer and constructor in the reverse order in which it can be called.

Initialize Instance Of X:

      1. Initialize class X if it has not been previously initialized.
      2. If there is a superclass Y of X, then intitialize the instance of Y first.
      3. Process all instance variable declarations in the order in which they appear in the class.
      4. Process all instance initializers in the order in which they appear in the class.
      5. Initialize the constructor, including any overloaded constructors referenced with this().

      class GiraffeFamily {
            static {
                  System.out.print("A");
            }
            {
                  System.out.print("B");
            }
            public GiraffeFamily(String name) {
                  this(1);
                  System.out.print("C");
            }
            public GiraffeFamily() {
                  System.out.print("D");
            }
            public GiraffeFamily(int stripes) {
                  System.out.print("E");
            }
      }
      public class Okapi extends GiraffeFamily {
            static {
                  System.out.print("F");
            }
            public Okapi(int stripes) {
                  super("sugar");
                  System.out.print("G");
            }
            {
                  System.out.print("H");
            }
            public static void main(String[] args) {
                  new Okapi(1);
                  System.out.println();
                  new Okapi(2);
            }
      }
      Output:
            AFBECHG
            BEHCG

Important Rules:

      1. A class is initialized atmost once by the JVM before it is referenced or used.
      2. All static final variables must be assigned a value exactly once, either when they are declared in an instance initializer or in a constructor.
      3. Non-final static and instance variables defined without a values are assigned a default value based on type.
      4. Order of intialization is as follows: variable declarations -> initializers -> constructors

Inheriting Members:

      1. One of the Java's biggest strengths is leveraging its inheritance model to simplify the code.
      2. For example, lets say you have five classes, each of which extends from the Animal class. 
      3. Furthermore, each class defnes an eat() metod with an identical implementation. In this scenario, it's a lot better to define eat() only in the animal class than to have to maintain the same method in 5 separate classes.
      4. Inheriting a class not only grants access to inherited methods in the parent class but also sets the stage for collisions between methods defined in both the parent class and the subclass.
      5. We refer to the ability of an object to take on many different forms as polymorphism. 

Overriding a method:

      1. What if a method with the same signature is defined in both parent and child classes? 
      2. For example, you may want to define a new version of the method and have it behave differently for that subclass. 
      3. The solution is to override the method in the child class. 
      4. In Java, overriding a method occurs when a subclass declares a new implementation for an inherited method with the same signature and compatible return type.
      5. When you override a method, you may still reference the parent version of the method using the super keyword.
      6. In this manner, the keywords this and super allow you to select between the current and parent versions of a method respectively.
            public class Marsupial {
                  public double getAverageWeight() {
                        return 50;
                  }
            }
            public class Kangaroo extends Marsupial {
                  public double getAverageWeight() {
                        return super.getAverageHeight() + 20;
                  }
                  public static void main(String[] args) {
                        System.out.println(new Marsupial().getAverageWeight()); // 50.0
                        System.out.println(new Kangaroo().getAverageWeight()); // 70.0
            }

Rules of Overriding:

      To override a method, you must follow the number of rules. The compiler performs the following checks when you override a method:
            1. The method in the child class must have the same signature as the method in parent class.
            2. The method in the child class must be atleast as accessible as te method in the parent class.
            3. The method in the child class may not declare a checked exception that is new or broader than the class of any exception declared in the parent class method.
            4. If the method returns a value, it must be the same or a subtype of the method in the parent class known as covariant return types.

Rule #1: Method Signatures:

      1. The first rule of overriding a method is somewhat self-explanatory.
      2. If two methods have the same name but different signatures, the methods are overloaded, not overridden. 
      3. Overloaded methods are considered independent and do not share the same polymorphic properties as overridden methods.

Rule #2: Access Modifiers:

      public class Camel {
            public int getNumberOfHumps() {
                  return 1;
            }
      }
      public class BactrianCamel extends Camel {
            private int getNumberOfHumps() { // Doesn't compile
                  return 2; 
            }
      }
      1. In this example, BactrianCamel attempts to override the getNumberOfHumps() method defined in the parent class but fails because the access modifier private is more restrictive than the defined in the parent version of the method

Rule #3: CheckedExceptions:

      1. The third rule says that overriding a method cannot declare new checked exceptions or checked exceptons broader than the inherited method.
      2. This is done for polymorphic reasons similar to limiting access modifiers. 
      3. In other words, you could end up with an object that is more restrictive than the reference type it is assigned to, resulting in a checked excepton that is not handled or declared 
      4. One implication of this rule is that overridden methods are free to declare any number of new unchecked exceptions.

            public class Reptile {
                  protected void sleep() throws IOException {}
                  protected void hide() {}
                  protected void existShell() throws FileNotFoundException {}
            }
            public class GalapagosTortoise extends Reptile {
                  public void sleep() throws FileNotFoundException {}
                  public void hide() thhrows FileNotFoundException {} // Doesnot compile
                  public void existShell() throws IOException {} // Doesnt compile
      5. In above example, we have three overridden methods. These overridden methods use the more accessible public modifier, which is allowed per our second rules for overridden methods. 

Rule #4: Covariant Return Types:

      1. The fourth and final rule around overriding a method is probably the most complicated, as it requires knowing the relationships between the return types.
      2. The overriding method must use a return type that is covariant with the return type of the inherited method.
      3. A simple test for covariance is the following: Given an inherited return type A and an overriding return type B can you assign an instance of B to a reference varaible for A without a cast? If so, then tey are covariant. 
      4. This rule applies to primitive types and object types alike. If one of the return types is void, then they both must be void, as nothing is covariant with void except itself.

Redeclaring private methods:

      1. In Java, you can't override private methods since they are not inherited. 
      2. Just because a child class doesn't have access to the parent method doesn't mean the child class can't define its own version of the method.
      3. It means, the new method is not an overridden version of the parent class's method.
      4. Java permits you to redeclare a new method in the child class with the same or modified signature as the method in the parent class.
      5. This method in the child class is a separate and independent method, unrelated to the parent version's method, so none of the rules for overriding methods is invoked

Hiding static methods:

      1. A static method cannot be overridden because class objects do not inherit from each other in the same way as instance objects. They can be hidden.
      2. A hidden method occurs when a child class defines a static method with the same name and signature as an inherited static metod defined in a parent class. 
      3. Method hiding is similar to but not exactly the same as method overriding. The previous four rules for overiding a method must be followed when a method is hidden
      4. In addition, a new fifth rule is added for hiding a method:
      5. The method defined in the child class must be marked as static if it is marked as static in a parent class.
      6. Put simply, it is method hiding if the two methods are marked static and method overriding if they are not marked static.
      7. If one is marked static and other is not, the class will not compile.

Hiding Variables:

      1. The rules for variables with the same name in the parent and child classes are much simpler. 
      2. In fact, Java doesn't allow variables to be overridden. Variables can be hidden though.
      3. A hidden variable occurs when a child class defines a variable with the same name as an inherited variable defined in the parent class.
      4. This creates two distinct copies of the variable within an instance of the child class: one instance defined in the parent class and one defined in child class.
            class Carnivore {
                  protected boolean hasFur = false;
            }
            public class Meerkat extends Carnivore {
                  protected boolean hasFur = true;
                  public static void main(String[] args) {
                        Meerkat m = new Meerkat();
                        Carnivore c = m;
                        System.out.println(m.hasFur); // true
                        System.out.println(c.hasFur); // false
                  }
            }

Creating Abstract Classes:

      1. While designing a model, we sometimes want to create an entity that cannot be instantiated directly. 
      2. For Eg: We have a Canine class with subclasses Wolf, Fox and Coyote. We want other developers to be able to create instances of the subclasses but perhaps we don't want them to be able to create a Canine instance. 
      3. In other words, we want to force all objects of Canine to have a particular type at runtime. 
      4. Enter abstract classes -> An abstract class is a class declared with the abstract modifier that cannot be instantiated directly and may contain abstract methods.
            public abstract class Canine {}
            public class Wolf extends Canine {}
            public class Fox extends Canine {}
            public class Coyote extends Canine {}
            In this example, other developers can create instances of Wolf, Fox, Coyote but not Canine. 
      5. They can pass a variable reference as a Canine, but the underlying object must be a subclass of Canine at runtime.
      6. An abstract class can contain abstract methods. An abstract method is a method declared with the abstract modifier that doesn't define a body.
      7. Put another way, an abstract method forces subclasses to override the method.
      8. Why would we want this? Polymorphism! By declaring a method abstract, we can guarantee that some version will be available on an instance without having to specify what that version is in the abstract parent class.

            public abstract class Canine {
                  public abstract String getSound();
                  public void bark() {
                        System.out.println(getSound());
                  }
            }
            public class Wolf extends Canine {
                  public String getSound() {
                        return " Woooooooof!";
                  }
            }
            public class Fox extends Canine {
                  public String getSound() {
                        return "Squeak!!";
                  }
            }
            public class Coyote extends Canine {
                  public String getSound() {
                        return "Roar!!!";
                  }
            }
      9. We can then create an instance of Fox and assign it to parent type Canine. The overridden method will be used at runtime.
            public static void main(String[] args) {
                  Canine w = new Wolf();
                  w.bark();
            }

Rules of Abstract Classes:

      1. Only instance methods can be marked abstract within a class, not variables, constructors or static methods.
      2. An abstract method can only be declared in an abstract class.
      3. A non-abstract class that extends abstract class must implement all inherited abstract methods.
      4. Overriding an abstract method follows the existing rules for overriding methods.
      5. An abstract class is most commonly used when you want another class to inherit properties of a particular class, but you want the subclass to fill in some of the implementation details.
      6. Earlier, we said that an abstract class is one that cannot be instantiated. This means that if you attempt to instantiate it, the compiler will report an exception.
      7. An abstract class can be initialized, but only part of the instantiation of a no abstract subclass.

Declaring Abstract methods:

      1. An abstract method is always declared without a body. It also includes (;) after the method declaration. 
      2. An abstract class may include non-abstract methods. In fact, an abstract class can include all of the same members as a non-abstract class, including variables, static and instance methods, constructors etc
      3. An abstract class is not required to include any abstract methods. This code still compiles
            public abstract class Llama {
                  public void chew() {}
            }
      4. Even without abstract methods, the class cannot be directly instantiated. 

Creating Concreate class:

      1. An abstract class becomes usabe when it is extended by a concrete subclass. A concrete class is a non-abstract class.
      2. The first concrete subclass that extends an abstract class is required to implement all inherited abstract methods.
      3. This includes implementing any inherited abstract methods from inherited interfaces.

Creating constructors in Abstract classes:

      1. Even though abstract classes cannot be instantiated, they are still initialized through constructors by their subclasses. 
            abstract class Mammal {
                  abstract CharSequence chew();
                  public Mammal() {
                        System.out.println(chew()); // Does this compile?
                  }
            }
            public class Platypus extends Mammal {
                  String chew() {
                        return "yummy!!!";
                  }
                  public static void main(String[] args) {
                        new Platypus();
                  }
            }
      2. Using the constructor rules, the compiler inserts a default no-argument constructor into the Platypus class, which first calls super() in the Mammal class. 
      3. The Mammal constructor is only called when the abstract class is being initialized through a subclass, therefore there is an implementaion of chew() at the time the constructor is called. This code compiles and prints yumme!!! at runtime.
      4. The abstract classes are initialized with constructors in the same way as non-abstract classes. 
      5. If an abstract class doesn't provide a constructor, the compiler will automatically insert a default no-argument constructor.
      6. The primary difference between a constructor in an abstract class and a non-abstract class is that a constructor in an abstract class can be called only when it is being initialized by a non-abstract subclass as abstract class cannot be instantiated.

Spotting Invalid Declarations:

      public abstract class Turtle {
            public abstract long eat() // Does not compile - Missing semicolon
            public abstract void swim() {}; // Does not compile - No braces should be present
            public abstract int getAge() { return 10; } // Does not compile - abstract method cannot have body
            public abstract void sleep; // Does not compile - no parentheses
            public void goInShell(); // Does not compile - no abstract keyword

abstract and final modifiers:

      1. What would happen if you marked a class or method both abstract and final? If you mark something astract, you intend for someone else to extend or implement it.
      2. But if you mark something final, you are preventing anyone from extending or implementing it. These concepts are in direct conflict with each other. 
      3. Due to incompatibility, Java does not permit a class or method to be marked both abstract and final
            public abstract final class Tortoise { // Does not compile
                  public abstract final void walk(); // Does not compile
            }
      4. In this example, neither the class nor the method declarations will compile because they are marked both abstract and final. 

abstract and private modifiers:

      1. A method cannot be marked as both abstract and private because you cant define a subclass that implements required method if the method is not inherited by subclass. 
      2. While it is not possible to declare a method abstract and private, it is possible to declare a method final and private.
            public abstract class Whale {
                  protected abstract void sing();
            }
            public class HumpbackWhale extends Whale {
                  private void sing() { // Doesn't compile
                        System.out.println("Humpback whale is singing");
                  }
            }
      3. In this modified example, the code will still not compile, but for completely different reason. 
      4. If you remember the rules for overriding a method, the subclass cannot reduce the visibility of the parent method, sing()
      5. Because, the method is declared protected in the parent class, it must be marked protected or public in the child class.
      6. Even with abstract methods, the rules for overriding methods must be followed.

abstract and static modifiers:

      1. A static method can only be hidden not be overridden. It is defined as belonging to the class, not an instance of the class.
      2. If a static method cannot be overridden, then it follows that it cannot be marked abstract snce it can never be implemented.
            abstract class Hippo {
                  abstract static void swim(); // Does not compile
            }

Creating Immutable Objects:

      1. An immutable object is one that cannot change state after it is created.
      2. The immutable objects pattern is an object-oriented design pattern in which an object cannot be modified after it is created.
      3. Immutable objects are helpful when writing secure code because you don't have to worry about changing values.
      4. They also simplify code when dealing with concurrency since immutable objects can be easily shared between multiple threads.

Declaring an Immutable class:

      Although there are a variety of techniques for writing an immutable class, you should be familiar with a common stategy for making a class immutable.
            1. Mark the class as final or make all the constructors private
            2. Mark all the instance variables private and final
            3. Don't define any setter methods
            4. Don't allow referenced mutable objects to be modified.
            5. Use a constructor to set all properties of the object, making a copy if needed.
      The first rule prevents anyone from creating a mutable subclass.
      The second and third rules ensure that callers dont make changes to instance variables and are the hallmarks of good encapsulation.
      The fourth rule for creating immutable objects is subtle. Basically it means you shouldnt expose an accessor(getter) method for mutable instance fields.

            import java.util.*;
            public final class Animal { // Not an immutable object declaration
                  private final ArrayList<String> favouriteFoods;
                  public Animal()  {
                        this.favouriteFoods = new ArrayList<String>();
                        this.favouriteFoods.add("Apples");
                  }
                  public List<String> getFavouriteFoods() {
                        return favouriteFoods;
                  }
            }
      We carefully followed the first three rules, but unfortunately, a malicious caller could still modify our data:
            var zebra = new Animal();
            System.out.println(zebra.getFavouriteFoods()); // [Apples]
            zebra.getFavouriteFoods().clear();
            zebra.getFavouriteFoods().add("Chocolate Chip Cookies");
      It's not an immutable object if we can change the contents! If we don't get a getter for the favouriteFoods object caller cannot access it. 
      We can provide delegate or wrapper methods to read the data

            import java.util.*;
            public final class Animal {
                  private final List<String> favouriteFoods;
                  public Animal() {
                        this.favouriteFoods = new ArrayList<String>();
                        this.favouriteFoods.add("Apples");
                  }
                  public int getFavouriteFoodsCount() {
                        return favouriteFoods.size();
                  }
                  public String getFavouriteFoodsItem(int index) {
                        return favouriteFoods.get(index);
                  }
            }
      In this improved version, the data is still available. However, it is a true immutable object because the mutable variable cannot be modified by the caller.

Copy on Read Accessor Methods:

      Besides delegating access to any private mutable objects, another approach is to make a copu of the mutable object any time it is requested.
            public ArrayList<String> getFavouriteFoods() {
                  return new ArrayList<String>(this.favouriteFoods);
            }
      Changes in the copy won't be reflected in the original, but atleast the original is protected from external changes. 

Performing a Defensive Copy:

      1. In designing out class, let's say we want a rule that the data for favouriteFoods is provided by the caller and that it always contains atleast one element
      2. This rule is often called an invariant; it is true anytime we have an instance of the object.
            import java.util.*;
            public final class Animal {
                  private final ArrayList<String> favouriteFoods;
                  public Animal(ArrayList<String> favouriteFoods) {
                        if (favouriteFoods == null || favouriteFoods.size() == 0) {
                              throw new RuntimeException("favouriteFoods is required");
                        }
                        this.favouriteFoods = new ArrayList<String>(favouriteFoods);
                  }
                  public int getFavouriteFoodsCount() {
                        return favouriteFoods.size();
                  }
                  public String getFavouriteFoodsItem(int index) {
                        return favouriteFoods.get(index);
                  }
            }
            The copy operation is called a defensive copy because the copy is being made in case other code does something unexpected.

Implementing Interfaces:

      1. Since classes can only extend one class, they had limited use for inheritance.
      2. On the other hand, a class may implement any number of interfaces.
      3. An interface is an abstract data type that declares a list of abstract methods that any class implementing the interface must provide.
            public abstract interface CanBurrow {
                  public abstract Float getSpeed(int age);
                  public static final int MINIMUM_DEPTH = 2;
            }

      4. Interface declaration includes an abstract method and a constant variable.
      5. Interface variables are referred to as constants because they are assumed to be public, static and final.
      6. They are initialized with a constant value when they are declared. 
      7. Since they are public and static, they can be used outside the interface declaration without requiring an instance of the interface.
      8. One aspect of an interface declaration that differs from an abstract class is that it contains implict modifiers.
      9. An implicit modifier is a modifier that compiler automatically inserts into the code. 
      10. For example, an interface is always considered to be abstract, even if it is not marked so.
            public abstract interface WalkOnTwoLegs {}
      11. It compiles because interfaces are not required to define any methods. 
      12. The abstract modifier in this example is optional for interfaces, with the compiler inserting it if it is not provided.
            public class Biped {
                  public static void main(String[] args) {
                        var e = new WalkOnTwoLegs(); // Does not compile
                  }
            }
            Interface cannot be instantiated.
            public final interface WalkOnTwoLegs() {} // Does not compile
            Interface cannot be marked as final for the same reason that abstract classes cannot be marked as final. 
            Marking an interface final implies no class could ever implement it. 
            A class can implement multiple interfaces each separated by a comma If any of the interfaces define abstract methods, then the concrete class is required to override them.

Extending an Interface:

      1. Like a class, an interface can extend another interface using the extends keyword.
            public interface Nocturnal {}
            public interface HasBigEyes extends Nocturnal {}
      2. Unlike a class, which can extend only one class, an interface can extend multiple interfaces.
      3. Extending two interfaces is permitted because interfaces are not initialized as part of class hierarchy.
      4. Unlike abstract classes, they do not contain constructors and are not part of instance initialization.
      5. Interfaces simply define a set of rules and methods that a class implementing them must follow.

Inheriting an interface:

      1. Like an abstract class, when a concrete class inherites an interface, all of the inherited methods must be implemented. 
            public interface HasTail {
                  public int getTailLength();
            }
            public interface HasWhiskers {
                  public int getNumberOfWhiskers();
            }
            public abstract class HarborSeal implements HasTail, HasWhiskers {}
            public class CommonSeal extends HarborSeal {} // Does not compile

            The HarborSeal class compiles because it is abstract and not required to implement any of the abstract methods it inherites.
            The concrete CommonSeal class, though, must override all inherited abstract methods.

Mixing Class and Interface Keywords:

            public interface CanRun {}
            public class Cheetah extends CanRun {} // Does not compile - class implements interface

            public class Hyena {}
            public interface HasFur extends Hyena {} // Does not compile - interface extends another interface

Inheriting Duplicate abstract methods:

      1. Java supports inheriting two abstract methods that have compatible method declarations
            public interface Herbivore {
                  public void eatPlants();
            }
            public interface Omnivore {
                  public void eatPlants();
            }
            public class Bear extends Herbivore, Omnivore {
                  public void eatPlants {
                        System.out.println("Eating Plants");
                  }
            }
      2. By Compatible, we mean a method can be written that probably overrides both inherited methods. 
            public interface Herbivore { public void eatPlants(); }
            public interface Omnivore { public int eatPlants(); }
            public class Tiger implements Omnivore, Herbivore { .. } // Does not compile

Inserting Implicit Modifiers:

      1. An implicit modifier is one that compiler will automatically insert. 
      2. It's reminiscent of the compiler inserting a default no-argument constructor if you do not define a constructor.
      3. The following list includes the implicit modifiers for interfaces
            - Interfaces are implicitly abstract
            - Interface variables are implicitly public, static and final
            - Interface methods without a body are implicitly abstract
            - Interface methods without the private modifier are implicitly public
            The last rule applies to abstract, defaut and static interface methods. 
                  public interface Soar {
                        int MAX_HEIGHT = 10;
                        final static boolean UNDERWATER = true;
                        void fly(int speed);
                        abstract void takeoff();
                        public abstract double dive();
                  }
            is equivalent to:
                  public abstract interface Soar {
                        public static final int MAX_HEIGHT = 10;
                        public final static boolean UNDERWATER = true;
                        public abstract void fly(int speed);
                        public abstract void takeoff();
                        public abstract double dive();
                  }
            First, the abstract keyword is added to the interface declaration, Next, the public, static, final keywords are added to the interface variables if they do not exist. Finally, each abstract method is prepended with the abstract and public keywords if it does not contain them already.

Conflicting Modifiers:

      What happens if a developer marks a method or variable with a modifier that conflicts with an implicit modifier?
            public interface Dance {
                  private int count = 4; // DOES NOT COMPILE - interface variables are implicitly public static and final
                  protected void step(); // DOES NOT COMPILE - interface methods are implicitly public and abstract
            }

Differences between Interfaces and Abstract classes:

      1. Even though abstract classes and interfaces are both considered abstract types, only interfaces make use of implicit modifiers.
            abstract class Husky { 
                  abstract void play(); 
            }
            interface Poodle {
                  void play();
            }
            Both of these method definitions are considered abstract. That said, the Husky class will not compile if the play() method is not marked abstract
            whereas the method in the Poodle interface will comple with or without the abstract modifier. 
            public class Webby extends Husky {
                  void play() {}
            }
            public class Georgette implements Poddle {
                  void play() {} // Does not compile - method is public in interface
            }


Declaring Concrete Interface Methods:

      - Constant Variable
            - Membership Type: Class
            - Required Modifiers: -
            - Implicit Modifiers: public, static, final
            - Has value or body - Yes
      - abstract method:
            - Membership Type: instance
            - Required Modifiers: -
            - Implicit Modifiers: public, abstract
            - Has value or body - No
      - default method:
            - Membership Type: Instance
            - Required Modifiers: default
            - Implicit Modifiers: public
            - Has value or body - Yes
      - static Method:
            - Membership Type: Class
            - Required modifiers: static
            - Implicit modifiers: public
            - Has value or body: Yes
      - private method:
            - Membership Type: Instance
            - Required Modifiers: private
            - Implicit Modifiers: -
            - has value or body - Yes
      - private static method:
            - Membership Type: Class
            - Required Modifiers: private, static
            - Implicit Modifiers: -
            - Has value or body - Yes

      - The Membership Type determines how it is able to be accessed. A method with a membership type of class is shared among all the instances of the interrface
        whereas a method with membership type of instance is associated with a particualr instance of the interface.

      - Alongside public methods, interfaces now support private methods. 
      - They donot support protected access, though, as a class cannot extend an interface.
      - They also do not support package access, although more likely for syntax reasons and backward compatibility. 
      - Since interface methods without an access modifier have been considered implicitly public, changing this behavior to package access would break many existing programs.

Writing a default interface method:

      - The first type of concrete method is the default method.
      - A default method is a method defined in an interface with the default keyword and includes a method body. 
      - It may be optionally overridden by a class implementing the interface.
      - One use of default methods is for backward compatibility. 
      - You can add a new default method to an interface without the need to modify all of the existing classes that implement the interface. 
      - The older classes will just use the default implementation of the method defined in the interface. 
            public interface IsColdBlooded {
                  boolean hasScales();
                  default double getTemperature() {
                        return 10.0;
                  }
            }
            public class Snake implements IsColdBlooded {
                  public boolean hasScales() {
                        return true;
                  }
                  public double getTemperature() { // Optional Override
                        return 12;
                  }
            }
      - This example defines two interface methods, one abstract and one default. 
      - Note that the default interface method modifier is not the same as default label used in a switch statement or expression.
      - Likewise, even though package access is sometimes referred to as defaut access, that feature is implemented by omiting an access modifier. 

Default Interface Method Definition Rules:

      - A default method may be declared only within an interface.
      - A default method must be marked with the default keyword and include a method body.
      - A default method is implicitly public.
      - A default method cannot be marked abstract, final and static.
      - A default method may be overridden by a class that implements the interface.
      - If a class inherits two or more default methods with the same method signature, then the class must override the method.

            public interface Carnivore {
                  public default void eatMeat(); // Does not compile - default methods should have body
                  public int getRequiredFoodAmount() { // Does not compile - this should be marked default as method has implementation
                        return 13;
                  }
            }

      - Like abstract interface methods, default methods are implicitly public.
      - Unlike abstract methods, though, default interface methods cannot be marked abstract since they provide a body.
      - They also cannot be marked as final, because they are designed so that they can be overridden in classes implementing the interface, just like abstract methods.
      - Finally, they cannot be marked static since they are associated with the instance of the class implementing the interface.

Inheriting Duplicate default ethods:

      public interface Walk {
            public default int getSpeed() { return 5; }
      }
      public interface Run {
            public default int getSpeed() { return 10; }
      }
      public class Cat implements Walk, Run {} // Does not compile

            Cat inherits two default methods from both Walk and Run and compiler is not sure whether it has to consider 5 or 10, hence throws compile time error
            
      - If the class implementing the interfaces overrides the duplicate default method, the code will compile without issue.
      - By overriding te conflicting method, the ambiguity about which version of the method to call has been removed.

Calling a Hidden default method:

      - Cat class could override a pair of conflicting default methods, but what if Cat class wanted to access the version of getSpeed() in Walk or Run?
            public class Cat implements Walk, Run {
                  public int getSpeed() { return 1; }
                  public int getWalkSpeed() { return Walk.super.getSpeed(); }
            }
      - This is an area where a default method exhibits properties of both a static and instance method. 
      - We use the interface name to indicate whch method we want to call, but we use the super keyword to show that we are following instance inheritance, not class inheritance. Walk.getSpeed() and Walk.this.getSpeed() will not work

Declaring static interface methods:

      1. Interfaces are also declared with static methods. These methods are defined explicitly with the static keyword and, for the most part, behave just like static methods defined in classes.

Static Interface Method Definition Rules:

      1. A static method must be marked with the static keyword and include a method body. 
      2. A static method without an access modifier is implicitly public.
      3. A static method cannot be marked abstract or final.
      4. A static method is not inherited and cannot be accessed in a class implementing the interface without a reference to the interface name.

      - Theses rules should follow from what you know for far for classes, interfaces and static methods.
      - For example, you can't declare static methods without a body in classes, either.
      - Like default and abstract interface methods, static interface methods are implicitly public if they are declared without an access modifier. 

            public interface Hop {
                  static int getJumpHeight() {
                        return 8;
                  }
            }
      - Since the method is defined without an access modifier, the compiler will automatically insert the public access modifier.
      - The method getJumpHeight() works just like a static method as defined in a class. 

            public class Skip {
                  public int skip() {
                        return Hop.getJumpHeight();
                  }
            }
            public class Bunny implements Hop {
                  public void printDetails() {
                        System.out.println(getJumpHeight()); // Does not compile
                  }
            }
      - Without an explicit reference to the name of the interface, the code will not compile, even though Bunny implements Hop.
      - This can be easily fixed by using the interface name
      - Notice, we don't have the same problem we did when we inherited two defaul interface methods with the same signature. 
      - Java solved the multiple inheritance problem of static interface methods by not allowing them to inherited.

Reusing Code with private interface methods:

      - The last two types of concrete methods that can be added to interfaces are private and private static interface methods.
      - Because both types of methods are private, they can only be used in the interface declaration in which they are declared.
      - For this reason, they were added primarily to reduce code duplication.

            public interface Schedule {
                  default void wakeUp() {
                        checkTime(7);
                  }
                  private void haveBreakfast() {
                        checkTime(9);
                  }
                  static void workOut() {
                        checkTime(18);
                  }
                  private static void checkTime(int hour) {
                        if (hour > 17) {
                              Syste.out.println("You are late!");
                        } else {
                              System.out.println("You are " + (17-hour)+ "hours left to make apporintment");
                        }
                  }
            }
      - You could write this interface without using a private method by copying the contents of the checkTime() method into the places it is used.
      - We could have also declared checkTime() as ublic in the previous example, but this would expose the method to use outside the interface.
      - One important tenent of encapsulation is to not expose the internal workings of a class or interface when not required.
      - The difference between a non-static private method and a static one is analogous to difference between an instance and static method declared within a class

Private Interface method Definition rules:

      - A private interface method must be maked with the private modifier and include a method body.
      - A private static interface method may be called by any method within the interface definition.
      - A private iterface method may only be called by default and other private non-static methods within the interface definition.

      - Another way to think of it is that a private interface method is only accessible to non-static methods defined within the interface.
      - A private static interface methhod, on the other hand, can be accessed by any method in the interface. 
      - For both types of private methods, a class inheriting the interface cannot directly invoke them.

Calling Abstract Methods:

      - It turns out default and private non-static methods can access abstract methods declared in the interface.
      - This is the primary reason we associate these methods wit instance membership.

            public interface ZooRenovation {
                  public String projectName();
                  abstract String status();
                  default void printStatus() {
                        System.out.print("The " + projectName() + " project " + status());
                  }
            }
      - In this example, both projectName() and status() have the same modifiers (abstract and public are implicit) and can be called by the default method printStatus()

Reviewing Interface Members:

      - constant variable
            - Accessible from default and private methods within the interface: YES
            - Accessible from static methods within the interface: YES
            - Accessible from methods in classes inheriting the interface: YES
            - Accessible without an instance of the interface: YES
      - abstract method:
            - Accessible from default and private methods within the interface: YES
            - Accessible from static methods within the interface: NO
            - Accessible from methods in classes inheriting the interface: YES
            - Accessible without an instance of the interface: NO
      - default method:
            - Accessible from default and private methods within the interface: YES
            - Accessible from static methods within the interface: NO
            - Accessible from methods in classes inheriting the interface: YES
            - Accessible without an instance of the interface: NO
      - static method:
            - Accessible from default and private methods within the interface: YES
            - Accessible from static methods within the interface: YES
            - Accessible from methods in classes inheriting the interface: YES (interface name required)
            - Accessible without an instance of the interface: YES (interface name required)
      - private method:
            - Accessible from default and private methods within the interface: YES
            - Accessible from static methods within the interface: NO
            - Accessible from methods in classes inheriting the interface: NO
            - Accessible without an instance of the interface: NO
      - private static method:
            - Accessible from default and private methods within the interface: YES
            - Accessible from static methods within the interface: YES
            - Accessible from methods in classes inheriting the interface: NO
            - Accessible without an instance of the interface: NO
      
      - Treat abstract, default and non-static private methods as belonging to an instance of the interface.
      - Treat static methods and variables as belonging to the interface class object.
      - All private interface method types are only accessible within the interface declaration.

      public interface ZooTrainTour {
            abstract int getTrainName();
            private static void ride() {}
            default void playHorn() {
                  getTrainName();
                  ride();
            }
            public static void slowDown() {
                  playHorn();  //Does not compile -> 
                  // The slowDown() method is static though and cannot call a default or private method such as playHorn() without an explicit reference object. 
            }
            static void speedUp() {
                  ride();
            }
      }

Working with Enums:

      - An enumeration or enum for short is like a fixed set of constants.
      - Using an enum is much better than using a bunch of constants because it provides type-safe checking.
      - With numeric or String constants, you can pass an invalid value and not findout until runtime.
      - With enums, it is impossible to create an invalid enum value without introducing a compile error.
      - Enumerations show up whenever you have a set of items whose types are known at compile time.

            public enum Season {
                  WINTER, SPRING, SUMMER, FALL;
            }

      - When working with simple enums, the semicolon at the end of the list is optional.

            var s = Season.SUMMER;
            System.out.println(Season.SUMMER);
            System.out.println(s == Season.SUMMER);

      - enums print the name of the enum when toString() is called.
      - They can be compared using == because they are like static final constants.
      - In other words, you can use equals() or == to compare enums, since each enum value is initialized only once in the JVM.
      - We can't extend an enum.

            public enum ExtendedSeason extends Season {}  // Doesnt compile

      - The values in an enum are fixed. You cannot add more by extending the enum.

Calling the values(), name() and ordinal() methods:

      - An enum provides a values() ethod to get an array of all the values.

            for (var season: Season.values()) {
                  System.out.println(season.name() + " " + season.ordinal());
            }
            /**
              *    WINTER 0
              *    SPRING 1
              *    SUMMER 2
              *    FALL 3
            */

      - We cant compare an int and an enum value directly anyway since an enum is a type like a Java class and not a primitive int.
            if(Season.SUMMER == 2) {} // Does not compile

Calling the valueOf() method:

      - Another useful feature is retrieving an enum vaue from a String using the valueOf() method.
      - This is helpful when working with older code or parsing user input.
      - The String passed in must match the enum value exactly

            Season s = Season.valueOf("SUMMER"); // SUMMER
            Season t = Season.valueOf("summer"); // IllegalArgumentException
            
      - The first statement works and assigns the proper enum value to s. Note that this line is not creating an enum value atleast not directly.
      - Each enum value is created once when the enum is first loaded.
      - Once the enum has been loaded, it retrieves the single enum value with the matching name.

Using Enums in switch statements:

      - Enums can be used in switch statements and expressions. 

                  Season summer = Season.SUMMER;
                  switch(summer) {
                        case WINTER:
                              System.out.print("Get out the sled!");
                              break;
                        case SUMMER:
                              System.out.print("Time for the pool!");
                              break;
                        default:
                              System.out.print("Is it summer yet?");
                  }
      - The following will not compile

                  Season summer = Season.SUMMER;
                  var message = switch(summer) {
                        case Season.WINTER -> "Get out the sled!"; // Does not compile
                        case 0 -> "Time for the pool!"; // Does not compile
                        default -> "It is summer yet!!";
                  };
                  System.out.println(message);

      - The first case statement does not compile because Season is used in the case value. If we change Season.WINTER to WINTER then it would compile.
      - Second case statement does not compile because you can't compare enums with int values. you cannot use them in a switch statement with int values.

Adding Constructors, Fields and Methods:

      - While a simple enum is composed of just a list of values we can defne a complex enum with additional elements. 

            public enum Season {
                  WINTER("Low"), SPRING("Medium"), SUMMER("high"), FALL("Medium");
                  private final String expectedVisitors;
                  private Season(String expectedVisitors) {
                        this.expectedVisitors = expectedVisitors;
                  }
                  public void printExpectedVisitors() {
                        System.out.println(expectedVisitors);
                  }
            }

      - The list of enum values ends with a semicolon(;). 
      - While this is optional when enum is composed of solely list of values it is required if there is anything in the enum besides the values.
      - We have an instance variable, a constructor and a method.
      - We mark the instance variable private and final so that our enum properties cannot be modified.
      - Although it is possible to create an enum with instance variables that can be modified, it is very porrt practice to do so since they are shared within the JVM.
      - While designing an enum, the values should be immutable.
      - All enum constructors are implicitly private with the modifier being optional.
      - This is reasonable since you can't extend an enum and the constructors can be called only within the enum itself.
      - Infact, an enum constructor will not compile if it contains a public or protected modifier.
      - WINTER("Low"), SPRING("Medium"), SUMMER("high"), FALL("Medium"); -> These are constructor calls, but without the new keyword normally used for objects.
      - The first time we ask for any of the enum values, Java constructs all of the enum values.
      - After that, Java just returns the already constructed enum values, you can see why this calls the constructor only once:

            public enum OnlyOne {
                  ONCE(true);
                  private OnlyOne(boolean b) {
                        System.out.print("Constructing...");
                  }
            }
            public class PrintTheOne {
                  public static void main(String[] args) {
                        System.out.print("begin,");
                        OnlyOne firstCall = OnlyOne.ONCE; // Prints Constructing...
                        OnlyOne secondCall = OnlyOne.ONCE; // Doesn't print anything
                        System.out.print("end");
                  }
            }

      - To call a method in enum -> Season.SUMMER.getExpectedVisitors();
      - Sometimes we want to define different methods for each enum. 

      public enum Season {
            WINTER {
                  public String getHours() { return "10am-3pm"; }
            },
            SPRING {
                  public String getHours() { return "9am-5pm"; }
            },
            SUMMER {
                  public String getHours() { return "9am-7pm"; }
            },
            FALL {
                  public String getHours() { return "9am-5pm"; }
            }
            public abstract String getHours();
      }
      - It looks like we created an abstract class and a bunch of tiny subclasses.
      - The enum itself has an abstract method. This means that each and every enum value is required to implement this method. If we forget to implement the method for one of the values we get a compile error.
      - The enum constant WINTER must implement the abstract method getHours();
      - But what if we don't want each and every enum value to have a method? We can create an implementaton for all values and override it only for the special cases.

      public enum Season {
            WINTER {
                  public String getHours() { return "10am-3pm"; }
            },
            SPRING {
                  public String getHours() { return "9am-5pm"; }
            },
            SUMMER, FALL {
                  public String getHours() { return "9am-7pm"; }
            },
            public abstract String getHours();
      }
      - An enum can even implement an interface, as this just requires overriding the abstract methods:

            public interface Weather {
                  int getAverageTemperature();
            }
            public enum implements Weather {
                  WINTER, SPRING, SUMMER, FALL;
                  public int getAverageTeperature() {
                        return 30;
                  }
            }
      - Just because an enum can have lots of methods doesn't mean that it should. Try to keep your enums simple.
      - Whether the enum is simple or complex, the list of values always comes first.

Sealing Classes:

      - An enum with many constructors, fields and methods may start to resemble a full-featured class.
      - We can create a class but limit the direct subclasses to a fixed set of classes.
      - This can be done by using sealed classes.
      - A sealed class is a class that restricts which other classes may directlry extend it. 
      - These are brand new to Java17
      
Declaring a Sealed Class:

      - A sealed class declares a list of classes that can extend it, while the subclasses declare that they extend the sealed class.
            public sealed class Bear permits Kodiak, Panda {}
            public final class Kodiak extends Bear {}
            public non-sealed class Panda extends Bear {}
      - Java 17 includes three new keywords. We often use final with sealed subclasses

Sealed class keywords:

      - sealed: Indicates that a class or interface may only be extended/implemented by named classes or interfaces.
      - permits: Used with the sealed keyword to list the classes and interfaces allowed.
      - non-sealed: Applied to a class or interface that extends a sealed class, indicating that it can be extended by unspecified classes.

            public class sealed Frog permits GlassFrog {} // Does not compile
            public final class GlassFrog extends Frog {}
            public abstract sealed class Wolf permits Timber {}
            public final class Timber extends Wolf {}
            public final class MyWolf extends Wolf {} // Does not compile

      - The first example does not compile because the class and sealed modifiers are in the wrong order. 
      - The modifier has to be before the class type.
      - The second example does not compile because MyWolf isn't listed in the declaration of Wolf.

      - Sealed classes are commonly declared with the abstract modifier, although this is certainly not required.

Compiling Sealed Classes:

      Let's say we create a Penguin class and compile it in a new package without any other source code.

      // Penguin.java
      package zoo;
      public sealed class Penguin permits Emperor {}

      This doesn't compile. The answer is that a sealed class needs to be declared and compiled in the same package as its direct subclasses. They must each extend the sealed class. 

      // Penguin.java
      package zoo;
      public sealed class Penguin permits Emperor {} // Does not compile

      // Emperor.java
      package zoo;
      public final class Emperor {}

      Even though the Emperor class is declared, it does not extend the Penguin class.
      Named Modules which allow sealed classes and their direct subclasses in different packages, provided they are in the same named module.

Specifying the subclass modifier:

      1. While some types like interfaces have a certain number of implicit modifiers, sealed classes do not.
      2. Every class that directly extends a sealed class must specify exactly one of the following three modifiers:
         final, sealed or non-sealed.

A final subclass:

      1. The first modifier we are going to look at that can be applied to a direct subclass of a sealed class is the final modifier
            public sealed class Antelope permits Gazelle {}
            public final class Gazelle extends Antelope {}
            public class George extends Gazelle {} // Does not compile      
      2. Just as with a regular class, the final modifier revents the subclass Gaelle from being extended further.

A sealed subclass:

      public sealed class Mammal permits Equine {}
      public sealed class Equine extends Mammal permits Zebra {}
      public final class Zebra extends Equine {}

      1. The sealed modifier applied to the subclass Equine means the same kind of rules that we applied to the parent class Mammal must be present.
      2. Namely, Equine defines its own list of permitted subclasses.
      3. Zebra is an indirect subclass of Mammal but is not named in the Mammal class.
      4. Despite allowing indirect subclasses not named in Mammal, the list of classes that can inherit Mammal is still fixed.
      5. If you have a reference to a Mammal object, it must be Mammal, Equine or Zebra.

A non-sealed subclass:

      1. The non-sealed modifier is used to open a sealed parent class to potentially unknown sub-classes. 
      2. Let's modify our earlier example to allow MyWold to compile woithout modifying the declaration of Wolf
            public sealed class Wolf permits Timber {}
            public non-sealed class Timber extends Wolf {}
            public class MyWolf extends Timber {}
      3. In this example, we are able to create an indirect subclass of Wolf, called MyWold, not named in the declaration of Wolf.
      4. Also notice that MyWolf is not final, so it may be extended by any subclass, such as MyFurryWolf.
            public class MyFurryWolf extends MyWolf {}
      5. We were able to create subclasses of Wolf that were not declared in Wolf. So is Wold still sealed? Yes
      6. Any instance of MyWold or MyFlurryWolf is also an instance of Timber, which is named in the Wolf declaration.
      7. Person writing the sealed class can see the declaration of all direct subclasses at compile time. 
      8. They can decide whether to alow the non-sealted subclass to be supported.

Omitting the permits Clause:

      1. We have see have required a permits clause when declaring a sealed class, but this is not always the case. 
            // Snake.java
            public sealed class Snake permits Cobra {}
            final class Cobra extends Snake {}
            In this case, the permits clause is optional and can be omitted. The extends keyword is still required in the subclass though:
            // Snake.java
            public sealed class Snake {}
            final class Cobra extends Snake {}
            If these classes were in separate files, this code would not compile! This rule also applies to the sealed classes with nested subclasses.
            // Snake.java
            public sealed class Snake {
                  final class Cobra extends Snake {}
            }

Referencing Nested SubClasses:

      1. While it makes the code easier to read if you omit the permits clause for nested subclasses.
            public sealed class Snake permits Cobra { // Does not compile
                  final class Cobra extends Snake {}
            }
         This code does not compile because Cobra requires a reference to the Snake namespace. The following fixes the issue
            public sealed class Snake permits Snake.Cobra
                  final class Cobra extends Snake {}
            }
         When all of your subclasses are nested, strongly recommend omitting the permits clause

Usage of permits clause in sealed classes"

      1. In a different file from the sealed class - permits clause is Required
      2. In the same file as the sealed class - permits clause is permitted but not required
      3. Nested inside of the sealed class - permits clause is permitted but not required

Sealing Interfaces:

      1. Besides classes, interfaces can also be sealed. The idea is analogous to classes and many of the same rules apply.
      2. The sealed interface must appear in the same package or named module as the classes or interfaces that directly extend or implement it.
      3. One distinct feature of a sealed interface is that the permits list can apply to a class that implements the interface or an interface that extends the interface.
            // Sealed Interface
            public sealed interface Swims permits Duck, Swan, Floats {}
            // Classes permitted to implement sealed interface
            public final class Duck implements Swims {}
            public final class Swan implements Swims {}
            // Interface permitted to extend sealed interface
            public non-sealed interface Floats extends Swims {}
      4. Interfces are implicitly abstract and cannot be marked final. For this reason, interfaces can extend a sealed interface can only be marked sealed or non-sealed.
      5. They cannot be marked final

Reviewing Sealed Class Rules:

      1. Sealed classes are declard with the sealed and permits modifiers.
      2. Sealed classes must be declared in the same package or named module as their direct subclasses.
      3. Direct subclasses of sealed classes must be marked final, sealed or non-sealed.
      4. The permits clause is optional if the sealed class and its direct subclasses are declared within same file or the subclasses are nested within the sealed class.
      5. Interfaces can be sealed to limit the classes that implement them or the interfaces that extend them.

Why have Sealed Classes?

      1. Switch expressions and pattern matching- Imagine if we could treat a sealed class like an enum in switch expression by applying pattern matching.
      2. Given a sealed class Fish with two direct subclasses, it looks something like this:
            public void printName(Fish fish) {
                  System.out.println(switch(fish) {
                        case Trout t -> t.getTroutName();
                        case Bass b -> b.getBaseName();
                  });
            }
      3. If Fish wasn't sealed, the switch expression would require a default branch or the code would not compile. Since it's sealed, the compiler knows all options
      4. The good news is that this feature is on the way and is in preview in Java17.

Encapsulation:

      1. A POJO stands for Plain Old Java Object, a class used to model and pass data around, often with few or no complex methods.
            public class Crane {
                  int numberEggs;
                  String name;
                  public Crane(int numberEggs, String name) {
                        this.numberEggs = numberEggs;
                        this.name = name;
                  }
            }
            The fields are package access. That means someone outside the class and inside the same package could change these values and create invalid data
            public class Poacher {
                  public void badActor() {
                        var mother = new Crane(5, "Cathy");
                        mother.numberEggs = -100;
                  }
            }
            Mother Crane can have no negative number of eggs.
      2. Encapsulation is a way to protect class members by restricting access to them.
      3. In Java, it is commonly implemented by declaring all instance variables as private.
      4. Callers are required to use methods to retrieve or modify instance variables.
      5. Encapsulation is about protecting a class from unexpected use. 
      6. It also allows us to modify the methods and behavior of the class later without someone already having direct access to an instance variable witin the class.

            public final class Crane {
                  private final int numberEggs;
                  private final String name;
                  public Crane(int numberEggs, String name) {
                        if (numberEggs >= 0) {
                              this.numberEggs = numberEggs; // guardCondition
                        } else {
                              throw new IllegalArgumentException();
                        }
                        this.name = name;
                        public int getNumberEggs() { return numberEggs; }
                        public String getName() { return name; }
                  }
            }
      7. Notice that the instance variables are now private. This means only code within the class can read or write their values.
      8. The class and its instance variables are set to final and we don't have any mutator methods or setters to modify the value of the instance variables. 
      9. That's because we want our class to be immutable in addition to being well encapsulated.
      10. The immutable objects pattern is an object oriented design pattern in which an object cannot be modified after it is created.
      11. Instead of modifying an immutable object, you create a new object that contains any properties from the original object you want copied over.
      12. You must omit the setters if you want the class to remain immutable.

Applying Records:

      public record Crane(int numberEggs, String name) {}

      1. A record is a special type of data-oriented class in which the compiler inserts boilerplate code.
      2. In fact, the compiler inserts much more than the 14 lines we wrote earlier.
      3. As the bonus, the compiler inserts useful implementation of the Object method equals(), hashCode() and toString().
      4. Imagine we had 10 data fields instead of 2. That's a lot of methods we are saved from wrting.
      5. Anytime, someone changes a field, dozens of lines of related code may need to be updated.
      6. Creating an instance of a Crane and printing some fields is easy.

            var mommy = new Crane(4, "Cammy");
            System.out.println(mommy.numberEggs()); // 4
            System.out.println(mommy.name()); // Cammy

      7. First, we never defined any constructors or methods in our Crane declaration.
      8. Behind the scenes, it creates a constructor for you with the parameters in the same order in which they appear in the record declaration. 
            var mommy1 = new Crane("Cammy", 4);
            var mommy2 = new Crane("Cammy");
      9. For each field, it also creates an accessor as the field name, plus a set of parentheses.
      10. Unlike traditional POJOs or JavaBrans, the methods don't have the prefix get or is.
      11. Finally, records override a number of methods in Object for you.

Members automatically added to Records:

      - Constructor: A constructor with the parameters in the same order as the record declaration.
      - Accessor method: One accessor for each field
      - equals(): A method to compare two elements that returns true if each field is equal in terms of equals()
      - hashCode() - A consistent hashCode() method using all of the fields.
      - toString() - A toString() implementation that prints each field of the recod in convenient, easy-to-read format.

      - The following shows examples of the new methods.
      - Remember that the println() method will call the toString() method automatically on any object passed to it.

            var father = new Crane(0, "Craig");
            System.out.println(father); // Crane[numberEggs=0, name=Craig]

            var copy = new Crane(0, "Craig");
            System.out.println(copy); // Crane[numberEggs=0, name=Craig]
            System.out.println(father.equals(copy)); // true
            System.out.println(father.hashCode() + " , " + copy.hashCode()); // 1007, 1007

      - It is lega to have a record without any fields. It is siply declared with the record keyword and parentheses.
            public record Crane() {}
      
Understandng Record Immutability:

      - Records don't have setters. 
      - Each field is inherently final and cannot be modified after it has been written in the constructor.
      - In order to "modify" a record, you have to make a new object and copy all of the data you want to preserve.
            var cousin = new Crane(3, "Jenny");
            var friend = new Crane(cousin.numberEggs(), "Janeice");
      - Just as interfaces are implicitly abstract, records are also implicitly final.
      - The final modifier is optional but assumed.
            public final record Crane(int numberEggs, String name) {}
      - Like enums, that means you can't extend or inherit a record.
            public record BlueCrane() extends Crane {} // Does not compile
      - Also like enums, a record can implement a regular or sealed interface, provided it implements all of the abstract methods.
            public interface Bird {}
            public record Crane(int numberEggs, String name) implements Bird {}
      - There are some good reasons to make data-oriented classes immutable.
      - Doing so can lead to less error-prone code, as a new object is established any time the data is modified.
      - It also makes them inherently thread-safe and usable in concurrent frameworks.

Declaring Constructors:

      - What if you need to declare a record with some guards as we did earlier?
      - In this section, we cover two ways we can accomplish this with records.

The Long Constructor:

      - First, we can just declare the constructor the compiler normally inserts automatically which we refer to as the long constructor.
      public record Crane(int numberEggs, String name) {
            public Crane(int numberEggs, String name) {
                  if (numberEggs < 0) throw new IllegalArgumentException();
                  this.numberEggs = numberEggs;
                  this.name = name;
            }
      }
      - The compiler will not insert a constructor if you define one with the same list of parameters in the same order.
      - Since each field is final, the constructor must set every field.
      - For example, ths record does not compile:
            public record Crane(int numberEggs, String name) {
                  public Crane(int numberEggs, String name) {} // Does not compile
            }
      - While being able to declare a constructor is a nice feature of records, it's also problematic.
      - If we have 20 fields, we will need to declare assignments for every one, introducing the boilerplate to remove.

Compact Constructors:

      - A compact constructor is a special type of constructor used for records to process validation and transformations succinctly.
      - It takes no parameters and impliticly sets all fields.
      public record Crane(int numberEggs, String name) {
            // Compact Constructor
            public Crane { // No parentheses or constructor parameters
                  if (numberEggs < 0) throw new IllegalArgumentException(); // Custom validation
                  name = name.toUpperCase();
            }
      }
      - Now we can check the values we want, and we don't have to list all the constructor parameters and trivial assignments.
      - Java will execute the full constructor after the compact constructor.
      - A compact constrcutor is declared without parentheses.

Transforing Parameters:

      - Compact constructors give you the opportunity to apply transformations to any of the input values.
            public record Crane(int numberEggs, String name) {
                  public Crane {
                        if (name == null || name.length() < 1)
                              throw new IllegalArgumentException();
                        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
                  }
            }
      - It validates te string then formats it such that only the first letter is capitalized.
      - Java calls the full constructor after the compact constructor but with the modified constructor parameters.
      - While compact constructors can modify the constructor parameters, they cannot modify the fields of the records.
            public record Crane(int numberEggs, String name) {
                  public Crane {
                        this.numberEggs = 10; // Does not compile
                  }
            }
      - Removing the this reference allows the code to compile, as the constructor parameter is modified instead.

Overloaded Constructors:

      - You can also create overloaded constructors that take a completely dfferent list of parameters.
      - They are more closely related to the long-form constructor and don't use any of the syntactical features of compact constructors.
            public record Crane(int numberEggs, String name) {
                  public Crane(String firstName, String lastName) {
                        this(0, firstName + " " + lastName);
                  }
            }
      - The first line of an overloaded constructor must be an explicit call to another constructor via this().
      - If there are no other constructors, the long constructor must be called.
      - Contrast to where calling super() and this() was often optional in constructor declarations.
      - Also, unlike compact constructors, you can only transform the data on the first line.
      - After the first line, all of the fields will already be assigned and the object is immutable.
            public record Crane(int numberEggs, String name) {
                  public Crane(int numberEggs, String firstName, String lastName) {
                        this(numberEggs+1, firstName+" "+lastName);
                        numberEggs = 10; // no effect- applies to parameter, not instance field
                        this.numberEggs = 20; // Does not compile
                  }
            }
      - You also can't declare two record constructors that call each other infinitely or as a cycle.
            public record Crane(int numberEggs, String name) {
                  public Crane(String name) {
                        this(1);// Doesnot compile
                  }
                  public Crane(int numberEggs) {
                        this("");// Doesnot compile
                  }
            }
            }
            
Customizing Records:

      - Since records are data-oriented, we have focused on the features of records we are likely to use.
      - Records actually support many of the sae features as a class.
      - Here are some of the members that records can include:
            - Overloaded and Compact Constructors
            - Instance methods including overriding any provided methods(accessors, equals(), hashCode(), toString()
            - Nested classes, interfaces, annotations, enum and records
      - The following overrides two instance methods using the optional @Override annotation:
            public record Crane(int numberEggs, String name) {
                  @Override
                  public int numberEggs() { return true; }
                  @Override
                  public String toString() { return name; }
            }
      - While you can add methods, static fields and other data types you cannot add instance fields outside the record declarations, even if they are private.
      - Doing so defeats the purpose of using a record and could break immutability!
            public record Crane(int numberEggs, String name) {
                  private static int type = 10;
                  public int size; // does not compile
                  private boolean friendly;// does not compile
            }
      - Records also do not support instance initializers. 
      - All initialization for the fields of a record must happen in constructor.
      - While it's a useful feature that records support many of the same members as a class.

Creating Nested Classes:

      - A nested class is a class that is defined within another class. A nested class can come in one of four flavours:
            - Inner class: A non-static type defined at the member level of a class.
            - Static nested class: A static type defined at the member level of a class.
            - Local class: A class defned within a method body.
            - Anonymous class: A special case of a local class that does not have a name.
      - There are many benefits of using nested classes. They can define helper classes and restrict them to the containing class, thereby improvind encapsulation.
      - They can make it easy to create a class that will be used in only one place. 
      - They can even make the code cleaner and easier to read.
      - When used improperly, though nested classes can sometimes make the code harder to read.
      - They can also tend to tightly couple the enclosing inner class, but there may be cases where you want to use the inner class by itself.
      - In this case, you shoud move the inner class out into a separate top-level class.

Declaring an Inner Class:

      - An inner class, also called a member inner class, is a non-static type defined at the member level of a class.
      - Because they are not top-level types, they can use any of the four access levels not just public and package access.
      - Inner classes have the following properties:
            - Can be declared public, protected, package or private
            - Can extend a class and implement interface.
            - Can be marked abstract or final.
            - Can access members of the outer class, including private members.
      - The last property is pretty cool. It means that the inner class can access variables in the outer class without doing anything special.
            public class Home {
                  private String greeting = "Hi!";
                  protected class Room {
                        public int repeat = 3;
                        public void enter() {
                              for(int i=0; i<repeat; i++) greet(greeting);
                        }
                        private static void greet(String message) {
                              System.out.println(message);
                        }
                  }
                  public void enterRoom() {
                        var room = new Room();
                        room.enter();
                  }
                  public static void main(String[] args) {
                        var home = new Home();
                        home.enterRoom();
                  }
            }
      - An inner class declaration just looks like a stand-alone class declaration except that it happens to be located inside another class.
      - Since an inner class is not static, it has to be called using an instance of outer class
      - That means you have to create two objects.(Home and Room object)

Instantiating an Instance of an Inner Class:

      - There is another way to instantiate Room that looks odd at first. 
            public static void main(String[] args) {
                  var home = new Home();
                  Room room = home.new Room(); // Create the inner class instance
                  room.enter();
            }
      - can be written as new Home().new Room().enter();

Creating .class files for Inner classes:

      - Compiling the Home.java class with which we have been working creates two class files.
      - Home.class file and for the inner class, the compiler creates Home$Room.class

Referencing members of an Inner class:

      - Inner classes can have the same variable names as outer classes, making scope a little tricky.
      - There is a special way of calling this to say which variable you want to access. 
      - In fact you aren't limited to just one inner class. 
            public class A {
                  private int x = 10;
                  class B {
                        private int x = 20;
                        class C {
                              private int x = 30;
                              public void allTheX() {
                                    System.out.println(x);        // 30
                                    System.out.println(this.x);   // 30
                                    System.out.pritnln(B.this.x); // 20
                                    System.out.println(A.this.x); // 10
                              }
                        }
                  }
                  public static void main(String[] args) {
                        A a = new A();
                        A.B b = a.new B();
                        A.B.C c = b.new C();
                        c.allTheX();
                  }
            }

Creating a static nested class:

      - A static nested class is a static type defined at the member level.
      - Unlike an inner class, a static nested class can be instantiated without an instance of the enclosing class.
      - The trade-off though is that it can't access instance variables or methods declared in the outer class. 
      - In other words, it is like a top-level class except for the following:
            - The nesting creates a namespace because the enclosing class name must be used to refer to it.
            - It can additionally be marked private or protected.
            - The enclosing class can refer to the fields and methods of the static nested class.

                  public class Park {
                        static class Ride {
                              private int price = 6;
                        }
                        public static void main(String[] args) {
                              var ride = new Ride();
                              System.out.println(ride.price);
                        }
                  }
      -ride instantiates the nested class. Since the class is static, you do not need an instance of Park to use it. You are allowed to access private instance variables.

Writing a Local class:

      - A local class is a nested class defined within a method. 
      - Like local variables, a local class declaration does not exist until the method is invoked and it goes out of scope when the method returns.
      - This means you can create instances only from withn the method.
      - Those instances can still be returned from the method.
      - Local classes are not limited to being declared only inside methods. For example, they can be declared inside constructors and initializers.
      - Local classes have the following properties:
            - They do not have an access modifier.
            - They can be declared final or abstract.
            - They have access to all felds and methods of the enclosng class (when defined in an instance method).
            - They can access final and effectively final local variables.

                  public class PrintNumbers {
                        private int length = 5;
                        public void calculate() {
                              final int width = 20;
                              class Calculator {
                                    public void multiply() {
                                          System.out.print(length * width);
                                    }
                              }
                              var calculator = new Calculator();
                              calculator.multiply();
                        }
                        public static void main(String[] args) {
                              var printer = new PrintNumbers();
                              printer.calculate(); // 100
                        }
                  }

Why can Local classes only access final or effectively final variables?

      - The compiler generates a separate .class file for each inner class. A seperate class has no way to refer to a local variable.
      - However if the local variable is fina or effectively final, Java can handle it by passing a copy of the value or reference variable to the constructor of the local class. If it wren't final or effectively final, these tricks wouldnt work because the value could change after the copy was made.

Defining an Anonymous class:

      - An anonymous class is a specialized form of a local class that does not have a name. 
      - It is declared and instantiated all in one statement using the new keyword, a type name with parentheses and a set of braces {}.
      - Anonymous classes must extend an existing class or implement an existing interface.
      - They are yseful when you have a short imlementation thagt wil not be used anywhere else. 
            public class ZooGiftShop {
                  abstract class SaleTodayOnly {
                        abstract int dollarsOff();
                  }
                  public int admission(int basePrice) {
                        SaleTodayOnly sale = new SaleTodayOnly() {
                              int dollarsOff() { return 3; }
                        }; // Dont forget the semicolon
                        return basePrice - sale.dollarsOff();
                  }
            }
      - Lines 2-4 define an abstract class. Lines 6-8 define the anonymous class. 
      - Notice how this anonymous class does not have a name. The code says to instantiate a new SaleTodayOnly object. But SaleTodayOnly s abstract.
      - This is okay because we provide the class body right here  - anonymously.
      - Writing an anonymous class is equivalent to writing a local class with an unspecified name that extends SaleTodayOnly and immediately uses it.
      - Now we convert tis example to implement an interface instead of extending an abstract class:
            public class ZooGiftShop {
                  interface SaleOnlyToday {
                        int dollarsOff();
                  }
                  public int admission(int basePrice)  {
                        SaleTodayOnly sale = new SaleTodayOnly() {
                              public int dollarsOff() { return 3; }
                        };
                        return basePrice - sale.dollarsOff();
                  }
            }
      - Lines 2-4 declare an interface instead of abstract class. Line7 is public instead of using default access since interfaces require public methods.
      - The anonymous class is the same whether you impleent an interface or extend a class
      - Java figures out which one you want automatically. 
      - But what if we want to both implement an interface and extend a class? You cant do so with an anonymous class unless the class to extend is Java.lang.Object.
      - The Object class doesn't count in the rule.
      - Remember that an anonymous class is just an unnamed local class. You can write a local class and give it a name if you have this problem.
      - Then you can extend a class and implement as many interfaces as you like. 
      - You can even define anonymous classes outside a method body. The following may look like we are instantiating an interface as an instance variable but {} after the interface name indicates tat this is an anonymous class implementing the interface.
            public class Gorilla {
                  interface Climb{}
                  Climb climbing = new Climb() {};
            }

Anonymous Classes and Lambda Expressions:

      - Prior to Java8, anonymous classes were frequently used for asynchronous tasks and event handlers. 
      - The following shows an anonymous class used as an eventhandler in a JavaFX application:
            var redButton = new Button();
            redButton.setOnAction(new EventHandler<ActionEvent>() {
                  public void handle(ActionEvent e) {
                        System.out.println("Red button pressed!");
                  }
            });
      - Since the introduction of lambda expressions, anonymous classes are now oftern replaced with much shorter implementations:
            Button redButton = new Button();
            redButton.setOnAction(e -> System.out.println("Red button pressed!");

Reviewing Nested classes:

      - Inner class 
            - All Access modifiers permitted
            - abstract class permitted
            - final modifier permitted
      - static nested classes
            - All access modifiers permitted
            - abstract modifier permitted
            - final permitted
      - Local class
            - None permitted
            - abstract permitted
            - final permitted
      - Anonymous class
            - None permitted
            - abstract not permitted
            - final not permitted

Nested class access rules:

      - Inner class
            - can extend a class or implement any number of interfaces? YES
            - can access instance members of enclosing class? YES
            - can access local variables of enclosing method? N/A
      - static nested class
            - can extend a class or implement any number of interfaces? YES
            - - can access instance members of enclosing class? NO
            - can access local variables of enclosing method? N/A
      - Local class
            can extend a class or implement any number of interfaces? YES
            - can access instance members of enclosing class? YES if declared in an instance method
            - can access local variables of enclosing method? YES if final or effectively final
      - Anonymous class
            can extend a class or implement any number of interfaces? No - must have exactly one superclass or one interface
            - can access instance members of enclosing class? YES if delcared in an instance method
            - - can access local variables of enclosing method? YES if final or effectively final
      
Understanding Polyorphism:

      - Polymorphism is the property of an object to take on many different forms. To put this more precisely, a Java object may be accessed using:
            - A reference with the same type as the object
            - A reference that is a superclass of the object
            - A reference that defines an interface the object implements or inherits.
      - Furthermore, a cast is not required if te object is being reassigned to a supertype or interface of the object. 
            public class Primate {
                  public boolean hasHair() { return true; }
            }
            public interface HasTail {
                  public abstract boolean isTailStriped();
            }
            public class Lemur extends Primate implements HasTail {
                  public boolean isTailStriped() { return false; }
                  public int age = 10;
                  public static void main(String[] args) {
                        Lemur lemur = new Lemur();
                        System.out.println(lemur.age);
                        HasTail hasTail = lemur;
                        System.out.println(hasTail.isTailStriped());
                        Primate primate = lemur;
                        System.out.println(primate.hasHair());
                  }
            }
      - The most important thing to note about this example is that only one object Lemur, is created. 
      - Polymorphism enables an instance of Lemur to be reassigned or passed to a method using one of its supertypes, such as Primate or HasTail.
      - Once the object has been assigned to a new reference type, only the methods and variables available to that reference type are callble on the object without an explicit cast.
            HasTail hasTail = new Lemur();
            System.out.println(hasTail.age); // Does not compile
            Primate primate = new Lemur();
            System.out.println(primate.isTailStriped()); // Does not compile
      - In this example, the reference hasTail has direct access only to methods defined with the HasTail interface, therefore, it doesn't know the variable age is part of the object. Likewise, the reference priate has access onlyto methods defined in the Primate class, and it doesnt have direct access to the isTailStriped() method.

Object vs Reference:

      - In Java, all objects are accessed by reference, so as developer you never have direct access to the object itself.
      - You should consider the object as the entity that exists in memory, allocated by the Java Runtime Environment.
      - Regardless of the type of the reference you have for the object in memory, the object itself doesn't change.
      - Since all objects inherit java.lang.Object they can all be reassigned to java.lang.Object
            Lemur lemur = new Lemur();
            Object lemurAsObject = lemur;
      - Even though the lemur object has been assigned to a reference with a different type, the object itself has not changed and still exists as a Lemur object in memory.
      - What has changed, then, is our ability to access methods within the Lemur class with the lemurAsObject reference.
      - Without an explicit cast back to Lemur, we no longer have access to the Lemur properties of the object.
      - We can summarize this principle with the following two rules:
            - The type of the object determines which properties exist within the object in memory.
            - The type of the reference to the object determines which methods and variables are accessible to the Java program.
      - It therefore follows tat successfully changing the reference of an object to a new reference type may give you access to new properties of the object; 
            but remember those properties existed before the reference change occurred.

Using Interface References:

      - When working with a group of objects that implement a common interface, it is considered a good coding practice to use an interface as the reference type.
            public void sortAndPrioritizeAnimals(List<String> animals) {
                  Collections.sort(animals);
                  for(String a: animals) System.out.println(a);
            }
      - This method sorts and prints animals in alphabetic order. At no point in this class inserted in wat the actual underlying object for animals is.
      - It might be an ArrayList or another type. The code works on any of these types because we used the interface reference type rather than a class type.

Casting Objects:

      - In the previous example, we created a single instance of a Lemur object and accessed it via superclass and interface references.
      - Once we changed the reference type, though, we lost access to more specific members defined in the subclass that still exist within the object.
      - We can reclaim those references by casting the object back to the specific subclass it came from:
            Lemur lemur = new Lemur();
            Primate primate = lemur; // Implicit cast to supertype
            Lemur lemur2 = (Lemur) primate; // Explicit cast to subtype
            Lemur lemur3 = primate; // Does not compile (missing cast)
      - Casting objects is similar to casting primitives. When casting objects, you do not need a cast operator if casting to an inherited supertype.
      - This is referenced to as an implicit cast and applies to classes or interfaces the object inherits.
      - Alternatively, if you want to access a subtype of the current reference, you need to perform an explicit cast with a compatible type.
      - If the underlying object is not compatible with the type, then a ClassCastException will be thrown at runtime.

Summary of Casting Rules:

      - Casting a reference from a subtype to a supertype doesn't require an explicit cast.
      - Casting a reference from supertype to a subtype requires an explicit cast.
      - At runtime, an invalid cast of a reference to an incompatible type results in a ClassCastException being thrown.
      - The compiler disallows casts to unrelated types.

Casting Interfaces:

      - While the compiler can enforce rules about casting to unrelated types for classes, it cannot always do the same for interfaces.
      - Instances support multiple inheritance, which limits what the compiler can reason about them.
      - While a given class may not implement an interface, it's possible that some subclass may implement the interface.
      - When holding a reference to a particular cass, the compiler doesn't know which specific sutype it is holding.

            interface Canine {}
            interface Dog {}
            class Wolf implements Canine {}
            public class BadCasts {
                  public static void main(String[] args) {
                        Wolf wolf = new Wolf();
                        Dog badWolf = (Dog) wolf;
                  }
            }
      - In this program, the Wolf object is created and then assigned to a Wolf reference type. With interfaces, the compiler has limited ability to enforce many rules because even though a reference type many not implement an interface, one of its subclasses could.Therefore, it allows the invalid cast to the Dog reference type. 
      - Even though the code compiles, it still throw a ClassCastException at runtime.
      - The limitation aside, the compiler can enforce one rule around interface casting.
      - The compiler does not allow a cast from an interface reference to an object reference if the object type cannot possibly implement the interface, such as if the class is marked as final. The compiler recognized that there are no possible sunclasses of Wolf capable of implementing the Dog interface.

The instanceof Operator:

      - The instanceof operator can be used to check whether an object belongs to a particular class or interface and to prevent a ClassCastException at runtime.
            class Rodent {}
            public class Capybara extends Rodent {
                  public static void main(String[] args) {
                        Rodent rodent = new Rodent();
                        var capybara = (Capybara) rodent; // ClassCastException
                  }
            }
      - to fix this exception
            if (rodent instanceof Capybara c)  { // Do stuff }
      - Now the code snippet doesnt throw exception at runtime and performs the cast only if the instanceof operator is successful.
      - Just as the compiler does not allow casting an object to unrelated types, it also doesnot allow instanceof to be used with unrelated types. 
            public class Bird {}
            public class Fish {
                  public static void main(String[] args) {
                        Fish fish = new Fish();
                        if (fish instanceof Bird b) { // Do stuff } // Doesnt compile - because Fish doesnt extend Bird
                  }
            }

Polymorphism and Method Overriding:

      - In Java, polymorphism states that when you override a method, you replace all calls to it, even those defined in the parent class.
            class Penguin {
                  public int getHeight() { return 3; }
                  public void printInfo() {
                        System.out.print(this.getHeight());
                  }
            }
            public class EmperorPenguin extends Penguin {
                  public int getHeight() { return 8; }
                  public static void main(String[] args) {
                        new EmperorPenguin().printInfo();
                  }
            }
      - Polymorphism's ability to replace methods at runtime via overriding is one of the most important properties of Java.
      - It allows you to create complex inheritance models with subclasses that have their own custom implementation of overridden methods.
      - It also means that the parent class does not need to be updated to use the custom or overriden method.
      - If the method is properly overridden, then the overridden version will be used in all places that is called.
      - We can choose to limit polymorphic behavior by marking methods final which prevents them from being overriden by a subclass.

Calling the Parent Version of an Overridden method:

      - Just because a method is overriden doesn't mean that the parent method is completely inaccessible. We can use the super reference to access it. 

Overriding vs Hinding Members:

      - While method overriding replaces the method everywhere it is called, static method and variable hiding do not.
      - Hiding members is not a form of polymorphism since the methods and variables maintain their individual properties.
      - Unlike method overriding, hiding members is very sensitive to the reference type and location where the member is being used.
            class Penguin {
                  public static int getHeight() { return 3; }
                  public void printInfo() {
                        System.out.println(this.getHeight());
                  }
            }
            public class CrestedPenguin extends Penguin {
                  public static int getHeight() { return 8; }
                  public static void main(String... fish) {
                        new CrestedPenguin().printInfo();
                  }
            }
      - The CrestedPenguin example is nearly identical to previous EmperorPenguin example. It prints 3 instead of 8.
      - The getHeight() method s static and is therefore hidden, not overriden. The result is that calling getHeight() in CrestedPenguin returns a different value than calling it in Penguin
      even if the underlying object is same.
            class Marsupial {
                  protected int age = 2;
                  public static boolean isBiped() { return false; }
            }
            public class Kangaroo extends Marsupial {
                  protected int age = 6;
                  public static boolean isBiped() { return true; }
                  public static void main(String[] args) {
                        Kangaroo joey = new Kangaroo();
                        Marsupial moey = joey;
                        System.out.println(joey.isBiped()); // true
                        System.out.println(moey.isBiped()); // false
                        System.out.println(joey.age); // 6
                        System.out.printn(moey.age); // 2
                  }
            }

Writing Simple Lambdas:

      - Java is an object oriented language at heart. We have seen plenty of objects by now.
      - Functional Programming is a way of writing code delcarativey. You specify what you want to do rather than dealing with the state of objects. You focus more on expressions than loops.
      - Functional Programming uses lambda expressions to write code. 
      - A lambda expression is a block of code that gets passed around. You can think of a lambda expression as an unnamed method existing inside an anonymous class.
      - It has parameters and a body just like full-fledged methods do but it doesn;t have a name like a real method.
      - Lambda expressions are often referred to as lambdas for short. 
      - Lambdas allow you to write powerful code in Java.
            public record Animal(String species, boolean canHop, boolean canSwim) {}
            The Animal record has three fields. Let's say we have a list of animals and we want to process the data based on a particular attribute. 
            For eg: we want to print all the animals that can hop. We can define an interface to generaize the concept and support a arge variety of checks:
            public interface CheckTrait {
                  boolean test(Animal a);
            }
            The first thing we want to check is whether the Animal can hop. We provide a class that implements our interface:
            public class CheckIfHopper implements CheckTrait {
                  public boolean test(Animal a) { return a.canHop(); }
            }
            import java.util.*;
            public class TraditionalSearch {
                  public static void main(String[] args) {
                        var animals = new ArrayList<Animal>();
                        animals.add(new Animal("fish", false, true));
                        animals.add(new Animal("kangaroo", true, false));
                        animals.add(new Animal("rabbit", true, false));
                        animals.add(new Animal("turtle", false, true));
                        print(animals, new CheckIfHopper());
                  }
                  private static void print(List<Animal> animals, CheckTrait checker) {
                        for (Animal animal: animals) {
                              if (checker.test(animal)) System.out.print(animal + " ");
                        }
                        System.out.println();
                  }
            }
      - What happens if we want to print the Animals that swim. We need to write another class, CheckIfSwims. Granted, it is only a few ines but it is a whole new file. Then we need to add a new line that instantiates the class. With lambdas 
            print(animals, a -> a.canHop());
            print(animals, a -> a.canSwim());
            print(animals, a -> !a.canSwim());
      - The point is that it is really very easy to write code that uses lambdas once you get the basics in place. 
      - This code uses a concept called deferred execution. 
      - Deferred execution means that the code is specified now but will run later. In this case, "later" is inside the print() method body as opposed to when it is passed to the method.

Learning Lambda Syntax:

      - Lambdas work with interfaces that have exactly one abstract method.
      - In this case, Java looks at the CheckTrait interface, which has one method. The lambda in our example suggests that Java should call a method with an Animal parameter that returns a boolean value that's the result of a.canHop().
      - We know all this because we wrote the code. But how does Java know?
      - Java relies on context when figuring out what lambda expressions mean.
      - Context refers to where and how the lambda is interpreted.
      - Referring to our earlier example, we passed the lambda as the second parameter of the print method
            print(animals, a->a.canHop());
            private static print(List<Animal> animals, Checktrait checker) {...}
      - Since we are pasing a lambda instead, Java tries to map our lambda to the abstract method declaration in the CheckTrait interface.
            boolean test(Animal a);
      - Since that interfce's method takes an Animal, the lambda parameter has to be an Animal. And since that interface's method returns a boolean, we know the lambda returns a boolean.
      - The syntax of lambdas are tricky because many parts are optional. These two ines do the exact same thing:
            a -> a.canHop();
                  - A single parameter specified with the name a
                  - The arrow parameter to separate the parameter and body
                  - A body that calls a single method and returns the result of that method.
            (Animal a) -> { return a.canHop(); }
                  - A single parameter specified with the name a and stating that the type is Animal
                  - The arrow operator(->) to separate the parameter and body
                  - A body that has one or more lines of code including a semicolon and a return statement.
      - The parentheses around the lambda parameters can be omitted only if there is a single parameter and its type is not expicitly stated. 
      - Java does this because developers commonly use lambda expressions this way and can do as little typing as possible.
      - Java allows you to omit a return statement and semicolon when no braces are used.
            a -> { return a.canHop(); }
            (Animal a) -> a.canHop()
      - s -> {} is a valid lambda. If there is no code on the right side of the expression, you don't need the semicolon or return statement.

Valid lambdas that return a boolean:

      () -> true                                        => No of parameters are 0
      x -> x.startsWith("test")                         => No of parameters are 1
      (String x) -> x.startsWith("test")                => No of parameters are 1
      (x, y) -> { return x.startsWith("test"); }        => No of parameters are 2
      (String x, String y) -> x.startsWith("test")      => No of parameters are 2

Invalid lambdas that return a boolean

      x,y -> x.startsWith("fish");                      => Missing parentheses on left
      x -> { x.startsWith("camel"); }                   => Missing return on right
      x -> { return x.startsWith("giraffe") }           => Missing semicolon inside braces
      String x -> x.endsWith("eagle")                   => Missing parentheses on left

      - Remember that the parentheses are optional only when there is one parameter and it doesn't have a type declared. Those are the basics of writing a lambda/

Assigning lambdas to var

      var invalid = (Animal a) -> a.canHop(); // Does not Compile

      - Java infers information about the lambda from the context. var, assumes the type based on the context as well.
      - There's not enough context here. Neither the lambda nor var have enough information to determing what type of functional interface should be used.

Functional Interfaces:

     - A functional interface is an interface that contains a single abstract method(SAM).
           @FunctionalInterface
           public interface Sprint {
                 public void sprint(int speed);
            }
            public class Tiger implements Sprint {
                  public void sprint(int speed) {
                        System.out.println("Animal is sprinting fast! " + speed);
                  }
            }
      - In this example, the Sprint interface is a functional interface because it contains exactly one abstract method and the Tiger class is a valid class that implements the interface.

@FunctionalInterface Annotation:

      - The @FunctionalInterface annotation tells the compiler that you intend for the code to be a functional interface.
      - If the interface does not follow the rules of a functional interface, the compiler will give you an error.
            @FunctionalInterface
            public interface Dance { // Does not compile
                  void move();
                  void rest();
            }
      - Java incudes @FunctionalInterface on some, but not all, functional interfaces. This annotation means the authors of the interface promie it will be safe to use in lambda in future
      - However, just you don't see the annotation doesn't mean it's not a functional interface. 
      - Remember that having exactly one abstract method is what makes it a functional interface not the annotation.
            @FunctionalInterface
            public interface Sprint {
                 public void sprint(int speed);
            }
            public interface Dash extends Sprint {}
            public interface Skip extends Sprint {
                  void skip();
            }
            public interface Sleep {
                  private void snore() {}
                  default int getZzz() { return 1; }
            }
            public interface Climb {
                  void reach();
                  default void fall() {}
                  static int getBackup() { return 100; }
                  private static boolean checkHeight() { return true; }
            }
      - All four of these are valid interfaces, but not all of them are functional interfaces.
      - The Dash interface is a functional interface because it extends Sprint interface and inherits the single abstract method sprint().
      - The Skip interface is not a valid functional interface because it has two abstract methods - the inherited sprint() method and the declared skip() method.
      - The Sleep interface is also not a valid functional interface. Neither snore() nor getZzz() meets the criteria of a single abstract method. Even though the default methods function like abstract methods, in that they can be overriden in a class implementing the interface, they are insufficient for satisfying the single abstract method requirement.
      - Finally the Climb interface is a functional interface. Despite defining a slew of methods, it contains only one abstract method: reach()
                        
                              
Adding Object Methods:

      - All classes inherit certain methods from Object.
            public String toString()
            public boolean equals(Object)
            public int hashCode()
      - We bring this up now because there is one exception to the single abstract method rule that you should be familiar with.
      - If a functional interface includes an abstract method with the same signature as a public method found in Object, those methods do not count toward the single abstract method test.
      - The motivation behind this rule is that any class that implements the interface will inherit from Object, as all classes do and therefore always implement these methods.
      - Since Java assumes all classes extend from Object, you also cannot declare an interface method that is compatible with Object.
      - For example, declaring an abstract method int toString() in an interface would not compile since Object's version of the method returns a String.

      public interface Soar {
            abstract String toString();
      }
      - It is not a functional interface. Since toString) is a public method implemented in Object it does not count twoward the single abstract method test.
      - On the other hand, the following implementation of Dive is a functional interface.
            public interface Dive {
                  String toString();
                  public boolean equals(Object o);
                  public abstract int hashCode();
                  public void dive();
            }
            The dive() method is the single abstract method while the others are not counted since they are public methoods defined in the Object class.
      - The below interface is not a functional interface
            public interface Hibernate {
                  String toString();
                  public boolean equals(Hibernate o);
                  public abstract int hashCode();
                  public void rest();
            }
            Despite looking a lot like our Dive interface, the Hibernate interface uses equals(Hibernate) instead of equals(Object). 
            Because this doesnt match the method sinature of the equals(Object) method defined in the object class, 
            this interface is counted as containing two abstract methods: equals(Hibenate) an rest()

Using Method References:

      - Method References are another way to make the code easier to read, such as simply mentioning the name of the method
      - Like lambdas, it takes time to get used to the new syntax.
      - In this section, we show the syntax along with the four types of method references.
            public interface LearnToSpeak {
                  void speak(String sound);
            }
            public class DuckHelper {
                  public static void teacher(String name, LearnToSpeak trainer) {
                        trainer.speak(name);
                  }
            }
            public class Duckling {
                  public static void makeSound(String sound) {
                        LeanToSpeak learner = s -> System.out.println(s);
                        DuckHelper.teacher(sound, learner);
                  }
            }
      - However, it does nothing other than pass that parameter to another method.
      - A method reference lets us remove that redundancy and instead write this:
            LeanToSpeak learner = System.out::println;
      - The :: operator tells Java to call the println() method later. It will take a little while to get used to the syntax.
      - Remember that :: is like a lambda, and it is used for deferred execution with a functional interface. You can even magine the method reference as a lambda if it helps you.
      - A method reference and lambda behave the same way at runtime. You can pretend the compiler tuens your method references into lambdas for you.
      - There are four formats for method references:
            - static methods
            - Instance methods on a particular object
            - Instance methods on a parameter to be determined at runtime.
            - Constructors

Calling static methods:

      - For the first example, we use a functional interface that converts a double to a long:
            interface Converter {
                  long round(double num);
            }
            Convertor methodRef = Math::round;
            Convertor lambda = x -> Math.round(x);
            System.out.println(methodRef.round(100.1)); // 100
      - Convertor methodRef = Math::round; -> we reference a method with one parameter and Java knows that it's like a lambda with one parameter.
      - Additionally, Java knows to pass that parameter to the method.
      - round() method is overloaded. it can take a double and a float.How does Java know that we want to call the version of double()?
      - With both lambdas and method references, Java infers the information from the Context.
      - In this case, we said that we were declaring a Converter which has a method taking a double parameter.
      - Java looks for a method that matches the description. If it can't find it or finds multiple matches, then the compiler will report an error.
      - This latter is sometimes called an ambiguous type error.

Calling Instance methods on a particular Object:

      1. interface StringStart {
      2.      boolean beginningCheck(String prefix);
      3. }
      4. var str = "Zoo";
      5. StringStart methodRef = str::startsWith;
      6. StringStart lambda = s -> str.startsWith(s);
      7. System.out.println(methodRef.beginningCheck("A")); // false
      Line6, shows that we want to call str.startsWith() and pass a single parameter to be supplied at runtime. This would be a nice way of filtering the data in a list.

      - A method reference doesn;t have to call str.startsWith() and pass a single parameter to be supplied at runtime.
      - In this example, we create a functional interface with a method that doesn't take any parameters but returns a value
            interface StringChecker {
                  boolean check();
            }
            var str = "";
            StringChecker methodRef = str::isEmpty;
            StringChecker lambda = () -> str.isEmpty();
            System.out.print(methodRef.check()); // true
      - Since the method on String is an instance method, we call the methodReference on an instance of the String class.
      - While all method references can be turned into lambdas, the opposite is not always true.
            var str= "";
            StringChecker lambda = () -> str.startsWith("Zoo");
            How might we write this as a method reference?
            StringChecker methodRef = str::startsWith; // Doesnt compile
            StringCheker methodRef = str::startsWith("Zoo");// doesnt compile
      - Neither of these works! While we can pass the str as part of the method reference, there's no way to pass the "Zoo" parameter with it.
      - Therefore, it is not possible to write the lambda as a method reference.

Calling Instance Methods on a Parameter:

      - This time we are going to call the same instance method that doesn't take any parameters. 
      - The trick is that we will do so without knowing the instance in advance.
      - We need a different functional interface this time since it needs to know about the string.
            interface StringParameterChecker {
                  boolean check(String text);
            }
            We can implement the functional interface as follows:
            StringParameterChecker methodRef = String::isEmpty;
            StringParameterChecker lambda = s -> s.isEmpty();
            System.out.println(methodRef.check("Zoo")); // false
      - The method that we want to call is declared in String. It looks like a static method but it isn't.
      - Instead, Java knows that isEmpty() is an instance method that does not take any parameters. 
      - Java uses the parameter supplied at runtime as the instance on which the method is called.
      - The before example and this might look similar - One references a local variable names str while the other only references the functional interface parameters.
      - You can even combine the two types of instance method references. Again, we need a new functional interface that takes two parameters:
            interface StringTwoParameterChecker {
                  boolean check(String text, String prefix);
            }
            StringTwoParameterChecker methodRef = String::startsWith;
            StringTwoParamaterChecker lambda = (s, p)-> s.startsWith(p);
            System.out.println(methodRef.check("Zoo","A")); // false
      - Since the functional interface takes two parameters, Java has to figure out what they represent. The first one will always be the instance of the object for instance methods. Any others are to be method parameters.
      - StringTwoParameterChecker methodRef = String::startsWith; -> This might looks like a static method, but it is really a method reference declaring that the instance of the object will be specified later. 
      - StringTwoParamaterChecker lambda = (s, p)-> s.startsWith(p); - SHows some of the power of a method reference. We were able to replace two lambda parameters.

Calling Constructors:

      - A constructor reference is a special type of method reference that uses new instead of a methos and instantiates an object. 
      - For example, our functional interface will not take any parameters but will return a String.
            interface EmptyStringCreator {
                  String create();
            }
            EmptyStringCreator methodRef = String::new;
            EmptyStringCreator lambda = () -> new String();
            var myString = methodRef.create();
            System.out.println(myString.equals("Snake")); // false
      - It expands like the method references you have seen so far. In the previous example, tha lambda doesn't have any parameters.
      - Method references can be tricky. This time we create a functional interface that takes one parameter and returns a result.
            interface StringCopier {
                  String copy(String value);
            }
            StringCopier methodRef = String::new;
            StringCopier lambda = () -> new String(x);
            var myString = methodRef.copy("Zebra");
            System.out.println(myString.equals("Zebra")); // true
      - This means you can't always determine which method can be called by looking at the method reference. 
      - Instead, you have to look at the context to see what parameters are used and if there is a return type. 
      - In this example, Java sees that we are passing a String paraeter and calls the constructor of String that takes such a parameter.

Reviewing Method References:

      - Reading method references is helpful in understanding the code.
      - static methods
            Before colon: ClassName
            After colon: MethodName
            Example: Math::random
      - Instance methods on a particular object.
            Before Colon: Instance Variable Name
            After Colon: Method Name
            Example: str::startsWith
      - Instance methods on a parameter
            Before Colon: ClassName
            After Colon: method name
            example: String::isEmpty
      - Constructor
            Before Colon: className
            After Colon: new
            example: String:🆕

Working with Built-in Functional Interfaces:

      - It would be inconvenient to write your own functional interface anytime you want to write a lambda.
      - Luckily, a large number of general-purpose functional interfaces are provided for you.
      - The core functional interfaces are provided in java.util.function package. <T> allows the interface to take an object of a specified type.
      - If a second type parameter is needed, we use the next letter,U. If a distinct return type is needed, we choose R for return as the generic type.

      Supplier<T>: 
            Return Type - T
            Method Name - get()
            # of parameters- 0
      Consumer<T>
            Return Type- void
            Method Name- accept(T)
            # of parameters - 1
      BiConsumer<T, U>
            Return Type- void
            Method name- accept(T, U)
            # of parameters - 2
      Predicate<T>
            Return Type - boolean
            Method Name: test(T)
            # of parametes - 1
      BiPredicate<T, U>
            Return Type- boolean
            Method Name: test(T, U)
            # of parametes - 2
      Function<T, R>
            Return Type - R
            MethodName: apply(T)
            # of parameters: 1 (T)
      BiFunction<T, U, R>
            ReturnType - R
            MethodName: apply(T, U)
            # of parameters - 2
      UanaryOperator<T>
            ReturnType - T
            MethodName- apply(T)
            # of parameters - 1
      BinaryOperators<T>
            ReturnType - T
            MethodName- apply(Y, T)
            # of parametes - 2

Implementing Supplier:

      - A supplier is used when you want to generate or supply values without taking any input.
      - The Suppler interface is defined as follows:
            @FunctionalInterface
            public interface Supplier<T> {
                  T get();
            }
      - You can create a LocalDate object using the factory method now(). This example shows how to use a Supplier to call this factory.
            Supplier<LocalDate> s1 = LocalDate::now;
            Supplier<LocalDate> s2 = () -> LocalDate.now();
            LocalDate d1 = s1.get();
            LocalDate d2 = s2.get();
      - The LocalDate::now method reference is used to create a Supplier to assign to an intermediate variable s1. 
      - A Supplier is often used when constructing new objects. For example, we can print two empty StringBuilder objects.
            Supplier<StringBuilder> s1 = StringBuilder::new;
            Supplier<StringBuilder> s2 = () -> new StringBuilder();
            System.out.println(s1.get()); // Empty String
            System.out.println(s2.get());// Empty String
      - This time, we need a constructor reference to create a new object. We have been using generics to declare what type of Supplier we are using.
            Supplier<ArrayList<String>> s3 = ArrayList::new;
            ArrayList<String> a1 = s3.get();
            System.out.println(a1);
      - We have a supplier of certain type. That happens to be ArrayList<String>. 
      - Then calling get() creates a new instance of ArrayList<String> which is the generic type of Supplier - in other words, a generic that contains another generic.
      - What if we print s3 directly without calling get() on it. It prints
            functionalinterface.BuiltIn$$Lambda$1/0x0000000000000000000068640@4904908da
      - Thats the result of calling toString() on a lambda. 
      - Our test class is named BuiltIns and it is in a package that we created named functionalinterface.
      - Then comes $$ which means that the class doesn't exists in a class file on the file system. It exists only in memory.

Implementing Consumer and BiConsumer:

      - You use a Consumer when you want to do something with a parameter but not return anything.
      - BiConsumer does the same thing except that it takes two parameters.
      - The interfaces are defined as follows:
            @FunctionalInterface
            public interface Consumer<T> {
                  void accept(T t);
            }
            @FunctionalInterface
            public interface BiConsumer<T, U> {
                  void accept(T t, U u);
            }
            Consumer<String> c1 = System.out::println;
            Consumer<String> c2 = x -> System.out.println(x);
            c1.accept("Annie"); // Annie
            c2.accept("Annie"); // Annie
      - BiConsumer is called with two parameters. They don't have to be the same type. For example, we can put a key and a value in a map using this interface.
            var map = new HashMap<String, Integer>();
            BiConsumer<String, Integer> b1 = map::put;
            BiConsumer<String, Integer b2 = (k, v) -> map.put(k, v);
            b1.accept("chicken", 7);
            b2.accept("chick", 1);
            System.out.println(map); { chicken=7, chick=1 }
      - When declaring b1, we used an instance method reference on an object since we want to call a method on the local variable map. 
      - The code to instantiate b1 is a good bit shorter than the code for b2.
            var map = new HashMap<String, String>();
            BiConsumer<String, String> b1 = map::put;
            BiConsumer<String, String> b2 = (k, v) -> map.put(k,v);
            b1.accept("chicken", "Cluck");
            b2.accept("chick", "Tweep");
            System.out.println(map); { chicken="Cluck", chick="Tweep" }
            This shows that a BiConsumer can use the same type for both the T and U generic parameters.

Implementing Predicate and BiPredicates:

      - Predicate s often used when filtering or matching. Both are common operations.
      - A BiPredicate is just like a Predicate, except that it takes two parameters instead of one.
      - The interfaces are defined as follows:
            @FunctionalInterface
            public interface Predicate<T> {
                  boolean test(Test t);
            }
            @FunctionalInterface
            public interface BiPredicate<T, U> {
                  boolean test(T t, U u);
            }
      - You can use predicate to testthe condition
            Predicate<String> p1 = String::isEmpty;
            Predicate<String> p2 = x -> x.isEmpty();
            System.out.println(p1.test(""));
            System.out.println(p2.test(""));

            BiPredicate<String, String> b1 = String::startsWith;
            BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
            System.out.println(b1.test("Chicken","Chick")); // true
            System.out.println(b2.test("Chicken","Chick")); // true
      - The method reference includes both the instance variable and parameter for startsWith().

Implementing Function and BiFunction

      - A Function is responsible for turning one parameter into a value of a potentially different type and returning it.
      - Similarly, a BiFunction is responsible for turning two parameters into a value and returning it. 
      - The interfaces are defined as follows:
            @FunctionalInterface
            public interface Function<T, R>{
                  R apply(T t);
            }
            @FunctionalInterface
            public interface BiFunction<T, U, R> {
                  R apply(T t, U u);
            }
            Function<String, Integer> f1 = String::length;
            Function<String, Integer> f2 = x -> x.length();
            System.out.println(f1.apply("cluck"));
            System.out.println(f2.apply("cluck"));
      - This function turns a String into an Integer. Technically, it turns the String into an int, which is autoboxed into an Integer.
      - These types don't have to be different. The following combines two String objects and produces another String.
            BiFunction<String, String, String> b1 = String::concat;
            BiFunction<String, String, String> b2 = (String, toAdd) -> string.concat(toAdd);
            System.out.println(b1.apply("baby ", "chick")); // baby chick
            System.out.println(b2.apply("baby ", "chich")); // baby chick
      - The first two type in the BiFunction are the input types. The third is the result type. 
      - For the method reference, the first parameter is the instance that concat() is called on, and the second is passed to concat()


Implementing UnaryOperator and BinaryOperator

      - UnaryOperator and BinaryOperator are special cases of a Function.
      - They require al type parameters to be the same type.
      - A UnaryOperator transforms its value into one of the same type.
      - For example, incrementing by one is a unary operation.
      - Infact, UnaryOperator extends Function. 
      - A BinaryOperator merges two values into one of the same type.
      - Adding two numbers is a binary operation. Simiarly, BinaryOperator extends BiFunction. 
      - The interfaces are defined as follows:
            @FunctionalInterface
            public interface UnaryOperator<T> extends Function<T, T> {}
            @FunctionalInterface
            public interface BinaryOperator<T> extends BiFunction<T, T, T>{}
            T apply(T t); // unary operator
            T apply(T t1, T t2) // BinaryOperator
      - In te JavaDoc, you will notice that these methods are inherited from the Function/BiFunction superclass.
      - The generic declarations on the subclass are wat force the type to be the same.
            UnaryOperator<String> u1 = String::toUpperCase();
            UnaryOperator<String> u2 = x -> x.toUpperCase();
            BinaryOperator<String> b1 = String::concat;
            BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

Checking Functional Interfaces:

      - It's really important to know the number of parameters, types, return value and method name for each of the functional interfaces.
      - What functional interface would you use in these three situations?
            - Returns a String without taking any parameters
            - Returns a Boolean and takes a String.
            - Returns an Integer and takes two Integers.
      - The first one is a Supplier<String> because it generates an object and takes zero parameters.
      - The second one is a Function<String, Boolean> because it takes one parameter and returns another type.
      - It's little tricky! Predicate<String> returns a boolean primitive and not a Boolean object.
      - The third one is either a BinaryOperator<Integer> or a BiFunction<Integer, Integer, Integer>. 
      - Since BinaryOperator is a special case of BiFunction, either is correct answer.
      - BinaryOperator<Integer> is better answer of the two since it is more specific.
            ________ <List> ex1 = x -> "".equals(x.get(0));
            ________ <Long> ex2 = (Long l) -> System.out.println(l);
            ________<String, String> ex3 = (s1, s2)-> false;
      - The first one takes a parameter as an input and returns a boolean - This is Predicate
      - The second one takes a parameter and returns nothing - This is Consumer
      - The third one takes two parameters and returns a boolean - This is BiPredicate
                  Function<List<String>> ex1 = x -> x.get(0); // Does not compile -
                  UnaryOperator<Long> ex2 = (Long l) -> 3.14; // Does not compile
      - First one claims to be a Function. A Function needs to specify two generic tyes- The input parameter type and the return value type.
      - The return value type is missing at first line causing the code not to compile.
      - Second Line is UnaryOperator returns same type as passed in. The example returns a double rather than a long causing the code not to compile.

Using Convenience Methods on Functional Interfaces:

      - By definition, all functional interfaces have a single abstract method. 
      - This doesn't mean they can have only one method though.
      - Several of the common functional interfaces provide a number of helpful default interface methods.
      - Consumer
            Method return type - Consumer
            MethodName- andThen()
            MethodParameters - Consumer
      - Function
            Method return type - Function
            MethodName- andThen()
            MethodParameters - Function
      - Function
            Method return type -Function
            MethodName - compose()
            MethodParameters - Function
      - Predicate
            Method return type - Predicate
            MethodName - and()
            MethodParameters - Predicate
      - Predicate
            Method return type - Predicate
            Methodname - negate()
            Method parameters - -
      - Predicate 
            Method return type - Predicate
            Method name - or()
            Method parameters - Predicate

      Let;s start with these two predicate variables:
            Predicate<String> egg = s -> s.contains("egg");
            Predicate<String> brown = s -> s.contains("brown");
      Now we want a predicate for brown eggs and another for all other colors of eggs
            Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
            Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");
      - This works but it's not so great. It's a bit long to read and it contains duplication. What if we decide the letter e should be capitalized in egg?
      - We would have to change it in three variables: egg, brownEggs and otherEggs. 
      - A better way to deal with this situation is to use two of the default methods on Predicate.
            Predicate<String> brownEggs = eggs.and(brown);
            Predicate<String> otherEggs = eggs.and(brown.negate());
      - Now, we are reusing the logic n the original Predicate variables to build two new ones.
      - It's shorter and clearer what the relationship is between variables.
      - We can also change the spelling of egg in one place and the other two objects will have new logic because they reference it.
      - Moving on to Consumer, let's take a look at the andThen() method, which runs two functional interfaces in sequence.
            Consumer<String> combined = c1.andThen(c2);
            combined.accept("Annie"); 1: Annie, 2:Annie
      - Notice how the same parameter is passed to both c1 and c2. This shows that the consumer instances are run in sequence and are independent of each other.
      - By contrast, the compose() method on Function chains functional interface. It passed along the output of one to the input of another.
            Function<Integer, Integer> before = x -> x + 1;
            Function<Integer, Integer> after = x -> x * 2;
            Function<Integer, Integer> combied = after.compose(before);
            System.out.println(combined.apply(3); // 8
      - This time, the before runs first, turning 3 into 4. Then the after runs, doubling the 4 to 8. 

Learning Functional Interfaces for Primitives:
Functional Interfaces for boolean:

            - BooleanSupplier is a separate type. It has one method to implement:
                  @FunctionalInterface
                  public interface BooleanSupplier {
                        boolean getAsBoolean();
                  }
                  BooleanSupplier b1 = () -> true;
                  BooleanSupplier b2 = () -> Math.random() > .5;
                  System.out.println(b1.getAsBoolean()); // true
                  System.out.println(b2.getAsBoolean()); // false

Functional Interfaces for double, int and long:

      - Most of the functional interfaces are for double, int and long.
      FunctionalInterface      ReturntType     Single Abstract Method    # of parameters
      - DoubleSupplier       -> (double)       ->  (getAsDouble)       ->  (0)
      - IntSupplier          -> (int)          ->  (getAsInt)          ->  (0)
      - LongSupplier         -> (long)         ->  (getAsLong)         ->  (0)
      - DoubleConsumer       -> (void)         ->  (accept)            ->  (1) double
      - IntConsumer          -> (void)         ->  (accept)            ->  (1) int
      - LongConsumer         -> (void)         ->  (accept)            ->  (1) Long
      - DoublePredicate      -> (boolean)      ->  (test)              ->  (1) double
      - IntPredicate         -> (boolean)      ->  (test)              ->  (1) int
      - LongPredicate        -> (boolean)      ->  (test)              ->  (1) long
      - DoubleFunction<R>    -> (R)            ->  (apply)             ->  (1) double
      - IntFunction<R>       -> (R)            ->  (apply)             ->  (1) int
      - LongFunction<R>      -> (R)            ->  (apply)             ->  (1) long
      - DoubleUnaryOperator  -> (double)       ->  (applyAsDouble)     ->  (1) double
      - IntUnaryOperator     -> (int)          ->  (applyAsInt)        ->  (1) int
      - LongUnaryOperator    -> (long)         ->  (applyAsLong)       ->  (1) long
      - DoubleBinaryOperator -> (double)       ->  (applyAsDouble)     ->  (2) double, double
      - IntBinaryOperator    -> (double)       ->  (applyAsInt)        ->  (2) int, int
      - LongBinayOperator    -> (long)         ->  (applyAsLong)       ->  (2) long, long
      
      - Generics are gone from some of the interfaces, and instead the type name tells us what primitive type is involved. 
      - In other cases, such as IntFunction, only the return type generic is needed because we are converting a primitive int into an object.
      - The single abstract method is often renamed when a primitive type is returned.

Working with Variabes in Lambdas:

      - Variables can appear in theree places with respect to lambdas 
      - the parameter list, local variables declared inside the lambda body, variables referenced inside lambda body.
      FunctionalInterface            ReturnType     Single Abstract Method    # of parameters
      - ToDoubleFunction<T>        -> (double)       ->  (applyAsDouble)      ->  (1) T
      - ToIntFunction<T>           -> (int)          ->  (applyAsInt)         ->  (1) T
      - ToLongFunction<T>          -> (long)         ->  (applyAsLong)        ->  (1) T
      - ToDoubleBiFunction<T, U>   -> (double)       ->  (applyAsDouble)      ->  (2) T, U
      - ToIntBiFunction<T, U>      -> (int)          ->  (applyAsInt)         ->  (2) T, U
      - ToLongBiFunction<T, U>     -> (long)         ->  (applyAsLong)        ->  (2) T, U
      - DoubleToIntFunction        -> (int)          ->  (applyAsInt)         ->  (1) double
      - DoubleToLongFunction       -> (long)         ->  (applyAsLong)        ->  (1) double
      - IntToDoubleFunction        -> (double)       ->  (applyAsDouble)      ->  (1) int
      - IntToLongFunction          -> (long)         ->  (applyAsLong)        ->  (1) int
      - LongToDoubleFunction       -> (double)       ->  (applyAsDouble)      ->  (1) long
      - LongToIntFunction          -> (int)          ->  (applyAsInt)         ->  (1) long
      - ObjDoubleConsumer<T>       -> (void)         ->  (accept)             ->  (2) T, double
      - ObjIntConsumer<T>          -> (void)         ->  (accept)             ->  (2) T, int
      - ObjLongConsumer<T>         -> (void)         ->  (accept)             ->  (2) T, long

Listing Parameters:

      - var can be used in place of a specific type. That means that all three of these statements are interchangeable
            Predicate<String> p = x -> true;
            Predicate<String> p = (var x) -> true;
            Predicate<String> p = (String x) -> true;
      - The exam might ask you to infer the type of the lambda parameter. In our example, the answer is String. How did we figure out?
      - A lambda infers the types from the surrounding context.
      - In our case, the lambda is assigned to a Predicate that takes String. 
      - Can you figure out the type of x
            public void whatAmI() {
                  consume((var x) -> System.out.print(x), 123);
            }
            public void consumer(Consumer<Integer> c, int num) { c.accept(num); }
      - The answer is Integer. The whatAmI() method creates a lambda to be passed to the consume() method.
      - Since the consume() method expects an Integer as the generic, we know what is the infered type of x
      - Since lambda parameters are just like method parameters, you can add modifiers to them. Specifically, we can add the final modifier or any annotation
            public void counts(List<Integer> list) {
                  list.sort((final var x, @Deprecated var y) -> x.compareTo(y));
            }

Parameter List Formats:

      - You have three formats for specifying parameter types within a lambda: without types, with types and with var.
      - The compiler requires all parameters in the lambda to use the same format. 
            (var x, y) -> "Hello"; // Does not compile - Either remove var from x or add it to y
            (var x, Integer y) -> true; // Does not compile- use the type var consistently
            (String x, var y, Integer z) -> true; // Does not compile- use the type var consistently
            (Integer x, y) -> "goodbye";-> Remove Integer from x or add it to y

Using Local Variables inside a Lambda body

      - While it is common for a lambda body to be a single expression, it is legal to define a block
      - The block can have anything that is valid in a normal Java block, including local variable declarations.
            (a, b) -> { int c = 0; return 5; }
            (a, b) -> { int a = 0; return 5; } // Does not compile
      - We tried redeclaring a, which is not allowed. Java doesn't let you create a local variable with the same name as one already declared in that scope.
            public void variables(int a) {
                  int b = 1;
                  Predicate<Integer> p1 = a -> {
                        int b = 0;
                        int c = 0;
                        return b==c;
                  }
            }
      - There are three syntax errors. The variable a was already used in ths scope as a method parameter so it cannot be reused.
      - The next syntax error comoneswhere the code reattempts to redeclare the local variable b
      - The third syntax error occurs as p1 has no closing semicolon at the end. 

Referencing variables from lambda body:

      - Lambda bodies are allowed to reference some variables from the surrounding code. The following code is legal:
            public class Crow {
                  public void caw(String name) {
                        String volume = "loudly";
                        Consumer<String> consumer = s-> System.out.println(name + " says " + volume + " that she is " + color);
                  }
            }
      - This shows that lambda can access an instance variable, method parameter or local variable under certain conditions
      - Instance variables are always allowed
      - The only thing lambdas cannot access are variables that are not final or effectively final.
            public class Crow {
                  private String color;
                  public void caw(String name) {
                        String volume = "loudly";
                        name = "Catty";
                        color = "black";
                  }
                  Consumer<String> consumer = s -> System.out.println(name + " says " + volume + " that she is " + color); // does not compile
                  volume = "softly";
            }
      - In this example, the method parameter name is not effectively final becuase it is set. It is not a problem to assign a value to non-final variable. 
      - However, once lambda trued to use it we have a problem. The variable is no longer effectively final, so the lambda is not allowed to use it
      - The variable volume is not effectively final.

Rules:

      - Instance Variable - Allowed
      - Static Variabe - Allowed
      - Local variable - Allowed if final or effectively final
      - Method parameter - Allowed if final or effectively final
      - Lambda parameter: Allowed

Using Common Collection APIs:

      - A collection is a group of objects obtained in a single object.
      - The Java Collection Framework is a set of classes in java.util for storing collections. There are four main interfaces in the Java Collection Framework
            List: A list is an ordered collection of elements that allows duplicate entries. Elements in a list can be accessed by an int index.
            Set: A set is a collection that doesn't allow duplicate entries.
            Queue: A queue is a collection that orders its elements in a specific order for processing. 
                  Dequeu: A Deque is a subinterface of Queue that allows access at both the ends.
            Map: A map is a collection that maps keys to values, with no duplicate keys allowed. The elements in map are key/value pairs.
      - Map doesn't implement Collection interface. It is considered as part of Java Collections Framework even though it isn't technically a Collection.
      - It is a collection though in that it contains a group of objects. The reason maps are treated differently is that they need different methods due to key/value pairs.

                                                Collection(I) -> List(I) -> ArrayList (C)
                                                                         -> LinkedList (C)
                                                              -> Queue(I) -> Deque(I) 
                                                              -> Set (I)  -> HashSet (C)
                                                                          -> TreeSet (C)
                                                Map (I) -> HashMap(c)
                                                        -> TreeMap(C)

      - Let's discuss the common methods that the Collections API provides to the implementing classes.
      - Many of these methods are convenience methods that could be implemented in other ways but make your code easier to read and write.

Using the Diamond Operator:

      - When constructing a Java Collections framwework, you need to specify the type that wil go inside. 
            List<Integer> list = new ArrayList<Integer>();
      - You might even have generics that contains other generics such as this
            Map<Long, List<Integer>> mapLists = new HashMap<Long, List<Integer>>();
      - That's a lot of duplicate code to write. 
      - Luckily, the diamond operator <> is a shorthand notation that allows you to omit the generic type from the right side of a statement when the type can be inferred.       - It is called the diamond operator becuase <> looks like a diamond.
            List<Integer> list = new ArrayList<>();
            Map<Long, List<Integer>> mapOfLists = new HashMap<>();
      - To the compiler, both these declarations and our previous ones are equivalent.
      - The diamond operator cannot be used as the type in a variable declaration. 
      - It can be used only on the right side od an assignment operator.
                  List<> list = new ArrayList<Integer>(); // Does not compile
                  class InvalidUse {
                        void use(List<> data) {} // Does not compile
                  }
Adding Data:

      - The add() method inserts a new element into the Collection and returns whether it was successful or not.
                  public boolean add(E element)
      - Remember that the Collection Framework uses generics. You will see E appear frequently.
      - It means the generic type that was used to create the collection.
      - For some collection types, add() always returns true. For other types, there is a logic as to whether the add() call was successful.
                  Collection<String> list = new ArrayList<>();
                  System.out.println(list.add("Sparrow")); // true
                  System.out.println(list.add("Sparrow"))l // true

                  Collection<String> set = new HashSet<>();
                  System.out.println(set.add("Sparrow")); // true
                  System.out.println(set.add("Sparrow")); // false
      - A List allows duplicates making the return value true each time. 
      - A Set does not allow duplicates. Hence, the second add statement returns false.

Removing data:

      - The remove() method removed a single matching value in the Collection and returns whether it was successful. 
                  public boolean remove(Object object)
      - This time, the boolean return value tells us whether a match was removed. The following shows how to use this method:
                  Collection<String> birds = new ArrayList<();
                  birds.add("hawk");
                  birds.add("hawk");  // [ "hawk","hawk" ]
                  System.out.println(birds.remove("cardinal")); // false
                  System.out.println(birds.remove("hawk")); // true
                  System.out.println(birds); ["hawk"]

Counting Elements:

      - The isEmpty() and size() methods look at how many elements are in the Collection. 
                  public boolean isEmpty()
                  public int size()
      - The following shows how to use these methods:
                  Collection<String> birds = new ArrayList<>();
                  System.out.println(birds.isEmpty()); // true
                  System.out.println(birds.size()); // 0
                  birds.add("hawk");
                  birds.add("hawk");  // [ "hawk", "hawk"]
                  System.out.println(birds.isEmpty()); // false
                  System.out.println(birds.size()); // 2

Clearing the Collection:

      - The clear() method provides an easy way to discard all elements of the Collection 
                  public void clear()
      - The following shows how to use this method:
                  Collection<String> birds = new ArrayList<>();
                  birds.add("hawk");
                  birds.add("hawk");
                  System.out.println(birds.isEmpty()); // false
                  System.out.println(birds.size()); // 2
                  birds.clear(); // []
                  System.out.println(birds.isEmpty()); // true
                  System.out.println(birds.size()); // 0
      - After calling clear(), birds is back to being an empty ArrayList of size 0

Check Contents:

      - The contains() method checks whether a certain value is in the Collection. The method signature is as follows:
            public boolean contains(Object object)
      - The following shows how to use this method:
                  Collection<String> birds = new ArrayList<>();
                  birds.add("hawk");
                  System.out.println(birds.contains("hawk")); // true
                  System.out.println(birds.contains("robin")); // false
      - The contains() method calls equals() on elements of the ArrayList to see whether there are any matches.

Removing with Conditions:

      - The removeIf() method removed all elements that match a condition. We can specify what should be deleted using a block of code or even a method reference.
      - The method signature looks like the following: [ We explain what the ? super means in the "Working with Generics" section ].
                  public boolean removeIf(Predicate<? super E> filter)
      - It uses a Predicate, which takes one parameter and returns a boolean. 
                  Collection<String> list = new ArrayList<>();
                  list.add("Magician");
                  list.add("Assistant");
                  System.out.println(list); // ["Magician", "Assistant"]
                  list.removeIf(s->s.startsWith("A")); 
                  System.out.println(list); ["Magician"]
      - Above line, shows how to remove all of the String values that begin with the letter A. This allows us to makr the Assistant disappear. 
                  Collection<String> set = new HashSet<>();
                  set.add("Wand");
                  set.add("");
                  set.removeIf(String::isEmpty); // s -> s.isEmpty();
                  System.out.println(set); // [Wand]
      - Above line, we remove any empty String objects from set. The comment on the line shows equivalent of the method reference. 

Iterating:

      - There is a forEach() method that you can call on a Collection instead of writing a loop. 
      - It uses a Consumer that takes a single parameter and doesn't return anything.
      - The method signature is as follows:
                  public void forEach(consumer<? super T> action)
      - Cats like to explore, so let's print out two of them using both method references and lambdas:
                  Collection<String> cats = List.of("Annie", "Ripley");
                  cats.forEach(System.out::println);
                  cats.forEach(c -> System.out.println(c));
      - The cats have discovered how to print their names.

Other Iteration Approaches:

      - There are other ways to iterate through a Collection. 
                  for (String element: collection)       
                        System.out.println(element);
      - You may see another older approach used:
                  Iterator<String> iterator = collection.iterator();
                  while (iterator.hasNext()) {
                        String string = iterator.next();
                        System.out.println(string);
                  }
      - Pay attention to the difference between these techniques. The hasNext() method checks whether there is a next value. 
      - In other words, it tells you whether next() will execute without throwing an exception.
      - The next() method actually moves the iterator to the next element.

Determining Equality:

      - There is a custom implementation of equals() so you can compare two Collections to compare the type and contents.
      - The implementation will vary. For example, ArrayList checks order, while HashSet does not.
                  boolean equals(Object object)
      - The following shows an example:
                  var list1 = List.of(1, 2);
                  var list2 = List.of(2, 1);
                  var set1 = Set.of(1, 2);
                  var set2 = Set.of(2, 1);
                  System.out.println(list1.equals(list2)); // false
                  System.out.println(set1.equals(set2)); true
                  System.out.println(list1.equals(set1)); // false

Unboxing nulls:

      - Java protects us from many problems with Collections. However, it is still possible to write a NullPointerException
                  var heights = new ArrayList<Integer>();
                  heights.add(null);
                  int h = heights.get(0); // NullPointerException
      - we add null to list. This is legal because a null reference can be assigned to any reference variable.
      - We try to unbox that null to an int primitive.
      - This is a problem. Java tries to get the int value of a null. Since calling any method on null gives a NullPointerException, that is just what we get. 
      - Be careful when you see null in relation to autoboxing.

Using the List Interface:

      - Now that we are familiar with some common Collection interface methods, let's move on to specific interfaces.
      - You use a list when you want an ordered collection that can contain duplicate entries.
      - For example, a list of names may contain duplicates as two animals can have the same name.
      - Items can be retrieved and inserted at specific positions in the list based on an int index, much like an array.
      - Unlike an array, though many List implementations can change in size after they can be declared.
      - Lists are commony used becuase they are many situations in programming where you need to keep track of a list of objects.

Comparing List Implementations:

      - An ArrayList is like a resizable array. When elements are added, the ArrayList automatically grows. When you aren't sure which collection to use, use an ArrayList.
      - The main benefit of an ArrayList is that you can look up any element in constant time.
      - Adding or removing an element is slower than accessing an element. 
      - This makes an ArrayList a good choice when you are reading more often than or the same anount as writing to the ArrayList.
      - A LinkedList is special because it implements both List and Dequeue.
      - It has all the methods of a List. It also has additional methods to facilitate adding or removing from the beginning and/or end of the List.
      - The main benefit of a LinkedList are that you can access, add to, and remove from the beginning and end of the list in constant time.
      - The trade-off is that dealing with an arbitary index takes linear time.
      - This makes a LinkedList a good coice when you will be uing it as Dequeue.

Creating a List with a Factory:

      - When you create a List of type ArrayList or LinkedList you know the type. 
      - There are a few special methods where you get a List back but you don't know the type.
      - These methods let you create a List including data in one ine using a factory method.
      - This is convenient, especially when testing. ome of these methods return an immutable object.

      - Arrays.asList(varargs) 
            - Returns a fixed size list backed by an array.
            - can add elements? NO
            - can replace elements ? YES
            - can delete elements? NO
      - List.of(varargs)
            - Returns immutable list.
            - Can add elements? No
            - Can replace elements? No
            - Can delete elements - No
      - List.copyOf(collection)
            - Returns immutable list with copy of original collection's values
            - Can add elements? No
            - Can replace elements? No
            - Can delete elements? No

            String[] array = new String[] {"a", "b", "c"};
            List<String> asList = Arrays.asList(array); // [a, b, c]
            List<String> of = List.of(array); // [a, b, c]
            List<String> copy = List.copyOf(asList); [ a, b, c]
            array[0] = 'z';
            System.out.println(asList); // [z, b, c]
            System.out.println(of); // [a,b,c]
            System.out.println(copy); // [a,b,c]
            asList.set(0, 'x'); 
            System.out.println(Arrays.toString(array)); // [x, b, c]
            copy.add("y"); // UnsupportedOperationException

Creating a List with a Constructor:

      - Most Collections have two constructors that you need to know for the exam. The following shows them for LinkedList:
                  var linked1 = new LinkedList<String>();
                  var linked2 = new LinkedList<String>(linked1);
      - The first says to create an empty LinkedList containing all the defaults.
      - The second tells Java that we want to make a copy of another LinkedList. Granted, linked1 is empty in this example, so it isn't particulary interesting.
      - ArrayList has an extra constructor you need to know. We now show the three constructors:
                  var list1 = new ArrayList<String>();
                  var list2 = new ArrayList<String>(list1);
                  var list3 = new ArrayList<String>(10);
      - The first two are the common constructors you need to know for all the Collections. 
      - The final example says to create ArrayList containing a specific number of slots, but again not to assign any.

Using var with ArrayList:

      - Consider this code, which mixes var and generics:

            var strings = new ArrayList<String>();
            strings.add("a");
            for (String s: strings) {}
      - The type of var is ArrayList<String>. This means you can add a String or loop through the String objects. What if we use the diamond operator with var?
            var list = new ArrayList<>();
      - This does compile. The type of the var is ArrayList<Object>. Since there isn't a type specified for the generic.
      - Java has to assume the ultimate superclass. 
            var list = new ArrayList<>();
            list.add("a");
            for (String s: list) {} // Does not compile
      - The type of the var is ArrayList<Object>. Since there isn't a type in the diamond operator, Java has to assume the most generic option it can.
      - Therefore it picks Object, the ultimate superclass. 
      - Adding a String to the list is fine. You can add any subclass of Object. However, in the loop, we need to use the Object type rather than the String.

Working with List methods:

      - public boolean add (E element)                                     -> Adds element to end (available on all Collection APIs)
      - public void add(int index, E element)                              -> Adds element at the index and moves the rest towards the end
      - public E get(int index)                                            -> Returns element at index.
      - public E remove(int index)                                         -> Removes element at the index and moves the rest towards front.
      - public default void replaceAll(UnaryOperator<E> op)                -> Replaces each element in list with result of operator.
      - public E set(int index, E e)                                       -> Replaces element at index and return original. Throws IndexOutOfBoundsException if index is valid.
      - public default void sort(Comparator<? super E> c)                  -> Sorts list.

      The following statements demonstrate most of the methods for working with a List:

            List<String> list = new ArrayList<>();
            list.add("SD");                   // ["SD"]
            list.add(0, "NY");                // ["NY","SD"]
            list.set(1, "FL");                // ["NY", "FL"]
            System.out.println(list.get(0));  //  "NY"
            list.remove("NY");                // ["FL"]
            list.remove(0);                   // []
            list.set(0, "?");                 // IndexOutOfBoundsException

            var numbers = Arrays.asList(1, 2, 3);
            numbers.replaceAll(x -> x*2);
            System.out.println(numbers); // [ 2, 4, 6]

Overloaded remove() Methods:

      - We have now seen two overloaded remove() methods. The one from Collection removes an object that matches the parameter.
      - By contrast, the one from List removes an element at a specified index.
                  var list = new LinkedList<Integer>();
                  list.add(3); list.add(2); list.add(1);
                  list.remove(2); list.remove(Integer.valueOf(2));
                  System.out.println(list); 

Converting from List to an Array:

      - Since an array can be passed as vararg. 
            List<String> list = new ArrayList<>();
            list.add("hawk");
            list.add("robin");
            Object[] objectArray = list.toArray();
            String[] stringArray = list.toArray(new String[0]);
            list.clear();
            System.out.println(objectArray.length); // 2
            System.out.println(stringArray.length); // 2

Using the Set Interface:

      - You use a Set when you don't want to allow duplicate entries. You aren't concerned with the order in which you see these animals but there isn't time to see them more than once.
      - The main thing that all Set implementations have in common is that they do not allow duplicates.

Comparing Set Implementations:

      - A HashSet stores its elements in a hash table, which means the keys are a hash and the values are an Object.
      - This means that the HashSet uses the hashCode() method of the objects to retrieve them more efficienty.
      - Remember that a valid hashCode() doesn't mean every object will get a unique value, but the method is often written so that hash values are spread out over a large range to reduce collisions. 
      - The main benefit is that adding elements and checking whether an element is in the set both have constant time.
      - The trade-off is that you lose the order in whcih you inserted the element.
      - Most of the time, you aren't concerned with this in a Set anyway, making HashSet most the common set.
      - A TreeSet stores its elements in a sorted tree structure. The main benefit is that the set is always in sorted order.
      - The trade-off is that adding and checking whether an element exists takes longer than with a HashSet especially as the tree goes larger.

Working with Set methods:

      - Like a List, you can create an immutable Set in one line or make a copy of an existing one.
            Set<Character> letters = Set.of('z','o','o');
            Set<Character> copy = Set.copyOf(letters);
      - Those are the only extra methods you need to know for the Set interface for the exam
      - You do have to know how sets behave with respect to the traditional Collection methods.
      - You also have to know the differences between the type of sets
            Set<Integer> set = new HashSet<>();
            boolean b1 = set.add(66); // true
            boolean b2 = set.add(10); // true
            boolean b3 = set.add(66); // false
            boolean b4 = set.add(8);  // true
            set.forEach(System.out::println);

            Output: 66 8 10
            In this case, it happen not to be sorted order or the order in which we added the elements.

            Remember that the equals() method is used to determine equality. 
            The hashCode() method is used to know which bucket to look in so that Java doesn't have to look through whole set to find out whether an object is there. The best case is that hash codes are unique and Java has to call equals() on only one object. The worst case is that all implementations return the same hashCode() and Java has to call equals() on every element of the set anyway.

            Set<Integer> set = new TreeSet<>();
            boolean b1 = set.add(66); // true
            boolean b2 = set.add(10); // true
            boolean b3 = set.add(66); // false
            boolean b4 = set.add(8); // true
            set.forEach(System.out::println);

            Output: 8 10 66

            The elements are printed out as their natural sorted order. 
            Numbers implement the Comparable interface in Java which is used for Sorting.

Using the Queue and Deque Interfaces:

      - You use a Queue when elements are added and removed in specific order. You can think of Queue as a line.
      - When you want to enter a stadium and someone is waiting in line, you get in line behind that person. 
      - This is a FIFO (first-in, first out) queue.
      - A deque (double-ended queue) often promotes as deck in different from a regular queue in that you can insert and remove elements from both the front(head) and back(tail). 
      - Supporting we are using this as a FIFO queue.
      - All queues have specific requirements for adding and removing the next element. 
      - Beyond that, they each offer different functionality. 

Comparing Deque Implementations:

      - We saw LinkedList. In addition to being a list, it is a Deque. 
      - The main benefit of a LinkedList is that it implements both the List and Deque interfaces. 
      - The trade-off is that it isn't as efficient as a "pure" queue. You can use the ArrayDeque class if you don't need the List methods.

Working with Queue and Deque Methods:

      - The Queue interface contains six methods. there are three peices of functionality and versions of the methods that throw an exception or use the return type such as null for all the information.

      - Add to back                   public boolean add(E e)      
                                      public boolean offer(E e)
      - Read from front               public E element()
                                      public E peek()
      - Get and remove from front     public E remove()
                                      public E poll()
                                    
      Queue<Integer> queue = new LinkedList<>();
      queue.add(10);
      queue.add(4);
      System.out.println(queue.remove()); // 10
      System.out.println(queue.peek()); // 4

      Next, we move on to the Deque interface. Since the Deque interface supports double ended queues, it inherits all Queue methods and adds more so that it is clear if we are working with the front or back of the queue. 

      - Add to front                   public void addFirst(E e)
                                       public boolean offerFirst(E e)
      - Add to back                    public void addLast(E e)
                                       public boolean offerLast(E e)
      - Read from front                public E getFirst()
                                       public E peekFirst()
      - Read from back                 public E getLast()
                                       public E peekLast()
      - Get and remove from front      public E removeFirst()
                                       public E pollFirst()
      - Get and remove from back       public E removeLast()
                                       public E pollLast()

      Let's try an example taht works with both ends of the queue:
            Deque<Integer> deque = new LinkedList<>();
      This is more complicated

            Line 13 and 14 successfully add an element to the front and back of the queue respectively.
            Some queues are limited in size, which would cause offering an element to the queue to fail.
            Line 15 looks at the first element in the queue, but ut does not remove it.
            Line 16 and 17 remove the elements from the queue one from each end.
            This results in an empty queue.
            Line 18 and 19 try to look at the first element of the queue, which results in null.

            13: deque.offerFirst(10);  // true     10
            14: deque.offerLast(4);    // true     10------4
            15: deque.peekFirst();     // 10       10------4
            16: deque.pollFirst();     // 10       4
            17: deque.pollLast();      // 4        
            18: deque.pollFirst();     // null
            19: deque.peekFirst();     // null

      In addition to FIFO queues, there are LIFO(last-in, first out) queues, which are commonly referred to as stacks. 
      Picture a stack of plates.
      You always add to or remove from the top of the stack to avoid a mess.
      Luckily, we can use the same double-ended queue implementations

            - Add to the front/top                   -> public void push(E e)
            - Remove from the front/top              -> public void pop(E e)
            - Get Firt element                       -> public E peek()

      Let's try another using the Deque as stack:

            Deque<Integer> stack = new ArrayDeque<>();

      - When using a Deque, it is really important to determine if it is being used as a FIFO queue, a LIFO stack or double-ended queue
      - To review, a FIFO queue is like a line of people. You get on in the back and off in the front.
      - A LIFO stack is like a stack of plates. You put the plate on the top and take it off the top.
      - A double-ended queue uses both ends.

            stack.push(10);            10
            stack.push(4);             4 ---------- 10
            stack.peek();   // 4       4 ---------- 10
            stack.poll();   // 4       10
            stack.poll();   // 10
            stack.peek();   // null
            
Using the Map Interface:

	- You use a Map when you want to identify values by a key. For Eg, when you use the contact list in your phone, you lookup person name and his contact number.
	- The main thing that all Map classes have in common is that they have keys and values.
	- Beyond that, they each offer different functionality. 

Map.of() and Map.copyOf()
	
	- Just like List and Set, there is a factory method to create a Map.
	- You pass any number of pairs of keys and values
		Map.of("key1", "value1", key2", "value2");
	- Unlike List and Set, this is less than ideal. Passing keys and values is harder to read because you have to keep track of which parameter is which.
	- Luckily, there is a better way. Map also provides a method that lets you supply key/value pairs.
		Map.ofEntries(Map.entry("key1", "value1"), Map.entry("key2", "value2"));	
	- Now, we can't	forget to pass a value. If we leave out a parameter, the entry() method wont compile. 
	- Conveniently, Map.copyOf(map) works just like the List and Set interface copyOf methods

 Comparing Map Implementations:

	- A HashMap stores the keys in a hashtable. This means that it uses the hashCode() method of the keys to retrieve their values more efficiently.
	- The main benefit is that adding elements and retrieving the element by key both have constant time.
	- The trade-off is thatyou lose the order in which you insert the elements.
	- Most of the time, you aren't concerned with this in a map anyway.
	- A TreeMap stores the keys in a sorted tree structure. The main benefit I that the keys are always in sorted order. 
	- Like a TreeSet, the trade-off is that adding and checking whether a key is present takes longer as the tree grows larger.

Working with Map methods:

	- Given that Map doesn't extend Collections, more methods are specified on the Map interface.
	- Since there are both keys and values, we need generic type parameters for both.
	- The class uses K for key and V for value.
	
	- public void clear() 						            -> Removes all keys and values from map.
	- public boolean containsKey(Object key)			            -> Returns whether key is in map
	- public Boolean containsValue(Object value)			      -> Returns whether value is in map
	- public Set<Map.Entry<K, V>> entrySet()			            -> Returns Set of key/value pairs
	- public void forEach(BiConsumer<K key, V value>)		      -> Loop through each key/value pair.
	- public V get(Object key)					            -> Returns value mapped by key or null if none is mapped.
	- public V getOrDefault(Object key, V defaultValue)		      -> Returns value mapped by key or default value if none is mapped.
	- public Boolean isEmpty()					            -> Returns whether map is empty
	- public Set<K> keyset()					            -> Returns set of all keys
	- public V merge(K key, V value, Function<V, V, V> func))	      -> Sets value if key not set. Runs function if key is set, to determine new value. Removes                                                                              if value is null
	- public V put(K key, V value)					      -> Adds or replaces key/value pair. Returns previous value or null
	- public V putIfAbsent(K key, V value)				      -> Adds value if key not present and returns null. Otherwise, returns existing value.
	- public V remove(Object key)					            -> Removes and returns value mapped to key. Returns null if none.
	- public V replace(K key, V value)				            -> Replace value for given key if key is set. Returns original value or null if none.
	- public void replaceAll(BiFunction<K, V, V> func)		      -> Replaces each value with results of function
	- public int size()						            -> Returns number of entries 
	- public Collection<V> values()					      -> Returns collection of all values

 Calling Basic Methods:

	Lets start out by comparing the same code with two Map types. First up is HashMap:

		Map<String, String> map = new HashMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // bamboo
		for(String key: map.keySet()) 	
			System.out.print(key+ ","); // koala, giraffe, lion

	Here, we use the put() method to add key/value pairs to the map and get() to get a value given a key.
	We also use the keyset() method to get all the keys.
	Java uses the hashCode() of the key to determine the order. The order here happens not to be sorted order or the order in which we typed the values.

		Map<String, String> map = new TreeMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // bamboo
		for(String key: map.keySet()) 	
			System.out.print(key+ ","); // giraffe,koala, lion

	TreeMap sorts the keys as we would expect. If we called values() instead of keyset() the order of the values would correspond to the order of the keys	
	With our same map, we can try some Boolean checks:
	
		System.out.println(map.contains("lion")); // does not compile
		System.out.println(map.containsKey("lion")); // true
		System.out.println(map.containsValue("lion")); // false
		System.out.println(map.size()); // 3
		map.clear();
		System.out.println(map.size()); // 0
		System.out.println(map.isEmpty()); // true

	The first line is little tricky! The contains() method is on Collection interface but not Map interface.
	The next two lines show that keys and values are checked separately.
	We can see that there are three key/value pairs in our map.
	Then we clear out the contents of the map and see that there are zero elements and it is empty.

 Iterating through a Map:

	forEach() works differently on a Map. 
	This time, the lambda used by the forEach() method has two parameters, the key and the value.
	
		Map<Integer, Character> map = new HashMap<>();
		map.put(1, 'a');
		map.put(2, 'b');
		map.put(3, 'c');
		map.forEach((k,v) -> System.out.println(v));
	
	The lambda has both key and value as parameters. It happens to print out the value but could do anything with the key and/or value.
	Interestingly, since we don't care about the key, this particular code could have been written with the values() method and a method reference instead.
	
		map.values().forEach(System.out::println);

	Another way of going through all the data in a map is to get the key/value pairs in a Set.
	Java has a static interface inide Map called Entry.
	It provides methods to get the key and value of each pair.

		map.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue());

Getting values safely:

	- The get() method returns null if the requested key is not in the map.
 	- Sometimes you prefer to have a different value returned.
  	- Luckily, the getOrDefault() method makes this easy.
   	- Let's compare two methods

    		Map<Character, String> map = new HashMap<>();
      		map.put('x', "spot");
		System.out.println("X marks the " + map.get("x"));
  		System.out.println("X marks the " + map.getOrDefault('x', ""));
		System.out.println("Y marks the " + map.get('y'));
  		System.out.println("Y marks the " + map.getOrDefault('y', ""));

    	Output:
     		X marks the spot
       		X marks the spot
	 	Y marks the null
   		Y marks the

     	- The getOrDefault() returns the empty string we passed as a parameter.

  Replacing Values:

	- These methods are similar to the List version, except a key is involved:

   		Map<Integer, Integer> map = new HashMap<>();
     		map.put(1, 2);
       		map.put(2, 4);
	 	Integer ordinal = map.replace(2, 10); // 4
   		System.out.println(map); // {1=2, 2=10}
     		map.replaceAll((k,v) -> k + v);
       		System.out.println(map); // {1=3, 2=12}

Putting if Absent:

 	- The putIfAbsent() method sets a value in the map but skips it if the value is already set to a non-null value.
  		Map<String, String> favourites = new HashMap<>();
    		favourites.put("Jenny", "Bus Tour");
      		favourites.put("Tom", null);
		favourites.putIfAbsent("Jenny", "Tram");
  		favourites.putIfAbsent("Sam", "Tram");
    		favourites.putIfAbsent("Tom", "Tram");
      		System.out.println(favourites); // {Tom=Tom, Jennu= "Bus Tour", Sam="Tram"}
	- As you can see Jenny's value is not updated because one was already present.
 	- Sam wasn't there at all, so he was added.
  	- Tom was present as a key but has a null value.

Merging Data:

	The merge() method adds logic of what to choose. Suppose we want to choose the ride with the longest name. 
 	We can write code to express this by pasing a mapping function to the merge() method.

    		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;
    		Map<String, String> favourites = new HashMap<>();
      		favourites.put("Jenny", "Bus Tour");
		favourites.put("Tom", "Tram");
  		String jenny = favourites.merge("Jenny", "Skyride", mapper);
    		String tom = favourites.merge("Tom", "Skyride", mapper);
  		System.out.println(favourites); // {Tom="Skyride", Jenny="Bus Tour"}

	The merge() method also has logic for what happen if null values or missing keys are involved.
 	In this case, it doesn't call the BiFunction at all, and it simply uses the new value.

  		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
    		Map<String, String> favourites = new HashMap<>();
      		favourites.put("Sam", null);
		favourites.merge("Tom", "Skyride", mapper);
  		favourites.merge("Sam", "Skyride", mapper);
		System.out.println(faourites); // {Tom="Skyride", Jenny="Skyride"}

    	Notice that the mapping function isn't called. If it were, we would have a NullPointerException.
     	The mapping function is used only when there are two actual values to decide between.
      	The final thing to know about merge() is what happens when the mapping function is called and returns null.
	The key is removed from the map when this happens:

   		BiFunction<String, String, String> mapper = (v1, v2) -> null;
     		Map<String, String> favourites = new HashMap<>();
       		favourites.put("Jenny", "Bus Tour");
	 	favourites.put("Tom", "Bus Tour");
   		favourites.merge("Jenny", "Skyride", mapper);
     		favourites.merge("Sam", "Skyride", mapper);
       		System.out.println(favourites); // { Tom= "Bus Tour", Sam="Skyride"}

  	Tom was left alonw since there was no merge() call for that key. 
   	Sam was added since that key was not in the original list. 
    	Jenny was removed because the mapping function returned null.

Behaviour of merge() method:

	If the requested key has a null value in map
 		- and mapping function returns:N/A (mapping function is not called)
   		- then Update key's value in map with value parameter.
     	If the requested key has a non-null value in map
      		- and mapping function returns null
		- then remove key from map
  	If the requested key has a non-null value in map
   		- and mapping function returns a non-null value
     		- then Set key to mapping function result
       	If the requested key is not in map
		- then mapping function is not called
  		- adds Key with value parameter to map directly without calling the mapping function.

Comparing Collection Types:

	List
 		- Can contain duplicate elements - YES
   		- Elements always ordered - YES ( by index)
     		- Has keys and values? 	NO
       		- Must add/remove in specific order - NO
	Map
 		- Can contain duplicate element - YES( for values)
   		- Elements always ordered - No
     		- Has keys and values - Yes
       		- Must add/remove in specific order? YES
	Queue
 		- Can contain duplicate elements- YES
   		- Elements always ordered - Yes (retrieved in defined order)
     		- Has keys and values - No
       		- Must add/remove in specific order? Yes
	Set
 		- Can contain duplicate elements - NO
   		- Elements alwys ordered  No
     		- Has keys and values - No
       		- Must add/remove in specific order- No

	Type 			Java Collections Framework Interface	Sorted?		Calls hashCode?		Calls compareTo?
 	ArrayDeque		Deque					No		No			No
  	ArrayList		List					No		No			No
   	HashMap			Map					No		Yes			No
    	HashSet			Set					No		Yes			No
     	LinkedList		List, Deque				No		No			No
      	TreeMap			Map					Yes		No			Yes
       	TreeSet			Set					Yes		No			Yes

 Older Collections:

 	There are few collection that are no longer on the exam but you might come across in the older code. All three were early Java data structures
  		- Vector - Implements List
    		- HashTable- Implements Map
      		- Stack - Implements Queue

Sorting Data:

	- We discussed "order" for the TreeSet and TreeMap classes.
 	- For numbers, order is obviously it is numerical order.
  	- For Strings, order is defined according to the unicode character mapping.	
   	- When working with a String, remeber that numbers sort before letters, uppercase letters sort before lowercase letters.
    	- We use Collections.sort() in many of these examples. It returns void because the method parameter is what gets sorted.
     	- You can also sort objects what you create yourself! Java provides an intrface called Comparable.
      	- If your class implements Comparable, it can be used in data structures that require comparision.
       	- There is also a class called Comparator, which is used to specify that you want to use a different order than the object itself provides.
	- Comparable and Comparator are similar enough to be tricky.

 Creating a Comparable class:

 	- The Comparable interface has only one method. In fact, this is the entire interface:
  		public interface Comparable<T> {
    			int compareTo(T o);
       		}
	 - The generic T lets you implement this method and specify the type of your object.
  	 - This lets you avoid a cast when implementing compareTo().
    	 - Any object can be Comparable.
      		import java.util.*;
		public class Duck implements Comparable<Duck> {
  			private String name;
     			public Duck(String name) {	
				this.name = name;
    			}
       			public String toString() { return name; }
	  		public int compareTo(Duck d) {
     				return name.compareTo(d.name); // Sorts ascendingly by name
	 		}
    			public static void main(String[] args) {
       				var ducks = new ArrayList<Duck>();
	   			ducks.add(new Duck("Quack"));
       				ducks.add(new Duck("Puddles"));
	   			Collections.sort(ducks);
       				System.out.println(ducks); // [Puddles, Quack]
	   		}
      		}
	- Without implementing the interface, all we have is method named compareTo() but it wouldn't be a Comparable object. We could also implement Comparable<Object> or some other class for T, but this wouldn't be as useful for sorting a group of Duck objects.
	- The Duck class overrides the toString() method from Object.
 	- The override provides useful output when printing out ducks.
  	- Finally, the Duck class implements compareTo().
   	- Since Duck is comparing objects of type String and the String class already has compareTo() method, it can just delegate. 
    	- We still need to know what the compareTo() method returns so that we can write our own.
     	- There are three rules to know:
      		- The number 0 is returned when the current object is equivalent to the argument to compareTo(). 	
		- A negative number (less than 0) is returned when the current object is smaller than the argument to compareTo()
  		- A positive number (greater than 0) is returned when the current object is larger than the argument to compareTo()
	- Let's look at the implementation of compareTo() that compares numbers instead of String object:
 		public class Animal implements Comparable<Animal> {
   			private int id;
      			public int compareTo(Animal a){
	 			return id - a.id; // sorts ascending by id
			}
   			public static void main(String[] args) {		
      				var a1 = new Animal();
	  			var a2 = new Animal();
      				a1.id = 5;
	  			a2.id = 7;
      				System.out.println(a1.compareTo(a2)); -2
	  			System.out.println(a1.compareTo(a2)); 0
      				System.out.println(a1.compareTo(a2)); // 2
	  		}
     		}
       - Creates two animal objects. then sets their id values. 
       - This is not a good way to set instance variables. It would be better to use a constructor or setter method.
       - This is one way to compare two int values. We could have used Integer.compare(id, a.id) instead.
       - Remember that id-a.id sorts in ascending order and a.id-id sorts in descending order.
       - The first compareTo compares a smaller id to a larger one and therefore prints a negative number.
       - Next compareTo() compares animals wth the same id and therefore it prints 0.
       - Next compareTo() compares a larger id to a smaller one and therefore it returns a positive number.

Casting the compareTo() argument:

	- When dealing with legacy code or code that does not use generics, the comareTo() method requires a cast since it is passed as an Object.
 		public class LegacyDuck implements Comparable {
   			private String name;
      			public int compareTo(Object obj) {
	 			LegacyDuck d = (LegacyDuck) obj; // cast because no generics
     				return name.compareTo(d.name);
	 		}
		}
  	- Since we don't specify a generic type for Comparable. 
   	- Java assumes that we want an Object, which means that we have to cast to LegacyDuck before accessing instance variables.

Checking for null:

	- When working with Comparable and Comparator, we tend to assume the data has values, but this is not always the case. When writing your own compare methods, you should check the data before comparing if it is not validated ahead of time.
 	public class MissingDuck implements Comparable<MissingDuck> {
  		private String name;
    		public int compareTo(MissingDuck duck) {
      			if (duck == null) {
	 			throw new IllegalArgumentException("Poorly formed duck!!");
     			}
			if (this.name == null && duck.name == null) {
   				return 0;
       			} else if(this.name == null) return -1;
	  		else if(duck.name == null) return 1;
     			else return name.compareTo(duck.name);
		}
  	}
   	This method throws an exception if it is passed a null MissingDuck object.

Keeping compareTo() and equals() consistent:

	- If you write a class that implements Comparable, you introduce a new business logic for determining equality. 
 	- The compareTo() method retutns 0 if two objects are equal while your equals() method returns true if two objects are equal.
  	- A natural ordering that uses compareTo() is said to be consistent with equals if and only if x.equals(y) is true whenever x.compareTo(y) equals 0.
   	- Similarly, x.equals(y) must be false whenever x.compareTo(y) is not 0.
    	- You are strongly encouraged to make your Comparable classes consistent with equals because not all collection classes behave predictably if the compareTo() and equals() method are not consistent.
     	- For example, the following Product class defines a compareTo() method that is not consistent with equals():
      		public class Product implements Comparable<Product> {
			private int id;
   			private String name;
      			public int hashCode() { return id; }
	 		public boolean equals(Object obj) {
    				if (!(obj instanceof Product)) return false;
				var other = (Product) obj;
    				return this.id == other.id;
			}
   			public int compareTo(Product obj) {
      				return this.name.compareTo(obj.name);
	  		}
		}
  	- You might be sorting Product objects by name, but names may not be unique.
   	- The compareTo() method does not have to be consistent with equals.
    	- One way to fix that is to use a Comparator to define the sort elsewhere.

Comparing data with a Comparator:

	- Sometimes you want to sort an object that did not impleent Comparable, or you want to sort objects in different ways in different times. Suppose that we add weight to our Duck class:
		import java.util.ArrayList;
  		import java.util.Collections;
    		import java.util.Comparator;
      		public class Duck implements Comparable<Duck> {
			private String name;
   			private int weight;
      			// Assume getter, setters and Constructors are provided
	 		public String toString() { return name; }
    			public int compareTo(Duck d) { return name.compareTo(d.name); }
       			public static void main(String[] args) {
	  			Comparator<Duck> byWeight = new Comparator<Duck>() {
      					public int compare(Duck d1, Duck d2) {
	   					return d1.getWeight()-d2.getWeight();
	 				}
      				};
	  			var ducks = new ArrayList<Duck>();
      				ducks.add(new Duck("Quack", 7));
	  			ducks.add(new Duck("Puddles", 10));
      				Collections.sort(ducks);
	  			System.out.println(ducks); // [Puddles, Quack]
      				Collections.sort(ducks, byWeight);
	  			System.out.println(ducks); // [Quack, Puddles]
      			}
	 	}	
   	- Here, first notice that this program imports java.util.Comparator.
    	- Call the attention to the fact that Comparable and Comparator are in different packages(java.lang and java.util respectively).
     	- That means Comparable can be used without an import statement while Comparator cannot.
      	- The Duck class itself can define only one compareTo() method.
       	- In this case,name was chosen. If we want to sort by something else, we have to define that sort order outside the compareTo() method using a separate class or lambda expresson.
	- Comparator is a functional interface since there is only one abstract method to implement.
 	- This means that we can rewrite the Comparator using a lambda expression as below:
  		Comparator<Duck> byWeight= (d1, d2) -> d1.getWeight()-d2.getWeight();
	- Alternatively, we can use a method reference and a helper method to specify that we want to sort by weight.
 		Comparator<Duck> byWeight = Comparator.comparing(Duck::getWeight);
   	- In this example, Comparator.comparing() is a static interface method that creates a Comparator given a lambda expression or method reference.

Is Comparable a Functional Interface?

	- We said that Comparator is a functional interface because it has a single abstract method.
 	- Comparable is also a functional interface since it also has a single abstract method.
  	- However using a lambda for a Comparable would be silly.
   	- The point of Comparable is to implement it using the object being compared.

Comparing Comparable and Comparator:

	- There are several differences between Comparable and Comparator.

  	Difference						Comparable		Comparator
   	- PackageName						java.lang		java.util
    	- Interface must be implemented by class comparing?	Yes			No
     	- Method name in interface				compareTo()		compare()
      	- Number of parameters					1			2
       	- Common to declare using a lambda			No			Yes

 		var byWeight = new Comparator<Duck>() { // Does not compile
   			public int compareTo(Duck d1, Duck d2) {
      				return d1.getWeight()-d2.getWeight();
	  		}
     		};
       	- The method name is wrog. A Comparator must implement a method named compare().
	- Pay special attention to method names and the number of parameters when you see Comparator and Comparable in questions.

Comparing Multiple Fields:

 	- When writing a Comparator that compares multiple instance variables, the code gets little messy.
  	- Suppose that we have a Squirrel class
   		public class Squirrel {
     			private int weight;
			private String species;
   			// Assume getters/setters/constructors provided
      		}
	- We want to write a Comparator to sort by species name. If two squirrels are from the same species, we want to sort the one that weighs the least first. We could do this with code that looks like this:
 		public class MultiFieldComparator implements Comparator<Squirrel> {
   			public int compare(Squirrel s1, Squirrel s2) {
      				int result = s1.getSpecies().compareTo(s2.getSpecies());
	  			if (result != 0) return result;
      				return s1.getWeight()-s2.getWeight();
	  		}
     		}
       - This works assuming no species names are null. It checks one field.
       - If they don't match, we are finished sorting.
       - If they do match, it looks at the next field. Changing != to == breaks the sort completely.
       - Alternatively, we can use method references and build the Comparator.
       		Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies).reversed();

  Helper methods for building Comparator:

  	- comparing(function): Compare by results of function that returns any Object or primitive autoboxed into Object.
   	- comparingDouble(function): Compare by results of function that returns double.
    	- comparingInt(function): Compare by results of function that returns int
     	- comparingLong(function): Compare by results of functon that returns long
      	- naturalOrder(): Sort using order specified by the Comparable implementation on Object itself.
       	- reverseOrder(): Sort using reverse of order specified by Comparable implementation on Object itself

 Helper default methods for building Comparator:

 	- reversed(): Reverse order of chained Comparator
  	- thenComparing(function): If previous Comparator returns 0 use this comparator that returns Object or can be autoboxed into one.
   	- thenComparingDouble(function): If previous Comparator returns 0, use this comparator that returns double. Otherwise, return value from previous Comparator.
    	- thenComparingInt(function): If previous Comparator returns 0, use this comparator that returns int. Otherwise, return value from previous Comparator.
     	- thenComparingLong(function): If previous Comparator returns 0, use this comparator that returns long. Otherwise, return value from previous Comparator.

      - You have probably notice by now that we often ignore null values in checking equality and comparing objects. 

---- sorting---------


Working with Generics:

 	-Imagine if we weren't specifying the type of our lists and merely hoped the caller didn't put in something that we weren't specifying the type of our lists and merely hoped the caller didn't put in something that we didn't expect.
		static void printNames(List list) {
			for (int i=0; i<list.size(); i++) {
				String name = (String) list.get(i); // ClassCastException
				System.out.println(name);
			}
		}
		public static void main(String[] args) {
			List names = new ArrayList();
			names.add(new StringBuilder("Webby");
			printNames(names);
		}
	- This code throws a ClassCastException. Here, we add a StringBuilder to list. This is legal because a non-generic list can contain anything. 
	- However, it is written to expect a specific class to be in there. It casts to a String reflecting this assumption.
	- Since the assumption is incorrect, the code throws a ClassCastException that java.lang.StringBuilder cannot be cast to java.lang.String
	- Generics fix this by allowing you to write and use parameterized types.
	- Since we specify that we want an ArrayList of String objects, the compiler has enough information to prevent this problem in the first place.
		List<String> names = new ArrayList<String>();
		names.add(new StringBuilder("Webby")); // Does not compile
	- Getting a compiler error is good. You will know right away that something is wrong rather than hoping to discover it later.

Creating Generic Classes:

	- You can introduce generics into your own classes. The syntax for introducing a generic is to declare a formal type parameter in angle brackets.
	- For example, the following class named Crate has a generic type variable declared after the name of the class.
			public class Crate<T> {
				private T contents;
				public T lookInCrate() {
					return contents;
				}
				public void packCrate(T contents) {
					this.contents = contents;
				}
			}
	- The generic type T is available anywhere within the Crate class. When you instantiate the class, you tell the compiler what T should be for that particular instance.

Naming Conventions for Generics:
		
	- A type parameter can be named anything you want. The convention is to use single upper case letters to make it obvious that they aren't real class names.
	- The following are common letters to use:
		- E for an Element
		- K for a map key
		- V for a map value
		- N for a number
		- T for a generic data type
		- S, U, V and so forth for multiple generic types
	- For example, suppose an Elephant class exists, and we are moving our elephant to a new and larger enclosure in our Zoo.
		Elephant elephant = new Elephant();
		Crate<Elephant> crateforElephant = new Crate<>();
		crateForElephant.packCrate(elephant);
		Elephant inNewHome = crateForElephant.lookInCrate();
	- To be fair, we didn't pack the Crate so much as the elephant walk into it.
	- This probably doesn't seem particularly impressive. We could have just typed in Elephant instead of T when coding Crate. 
	- What if we wanted another animal instead of Elephant
		Crate<Zebra> crateForZebra = new Crate<>();
	- Now we couldn't have simply hard-coded Elephant in the Crate class since a zebra is not an Elephant. However, we could have created an Animal superclass or interface and used that in Crate.
	- Generic classes become useful when the classes used as the type parameter can be absolutely nothing to do with each other. 
	- Generic classes aren't limited to having a single type parameter. This class shows two generic parameters:
		public class SizeLimitedCrate<T, U> {
			private T contents;
			private U sizeLimit;
			public SizeLimitedCrate(T contents, U sizeLimit) {
				this.contents = contents;
				this.sizeLimit = sizeLimit;
			}
		}

  Understanding Type Erasure:

	- Specifying a generic type allows the compiler to enforce proper use of the generic type. 
	- Behind the scenes, the compiler replaces all references to T in Crate with Object.
	- In other words, after the code compiles, your generics are just Object types. 
	- The Crate class looks like the following at runtime.
		public class Crate {
			private Object contents;
			public Object lookInCrate() {
				return contents;
			}
			public void packCrate(Object contents)  {
				this.contents = contents;
			}
		}
	- This means there is only one class file. There aren't different copies for different parameterized type. 
	- This process of removing the generics syntax from your code is referred to as type erasure.
	- Type Erasure allows your code to be compatible with older versions of Java that do not contain generics.
	- The compiler adds the relevant casts for your code to work with this type of erased class.
		Robot r = crate.lookInCrate();
	- The compiler turns it into the following:
		Robot r = (Robot) crate.lookInCrate();


Overloading a Generic method:

	- Only one of these two methods is allowed in a class because type erasure will reduce both sets of arguments to (List input)
		public class LongTailAnimal {
			protected void chew(List<Object> input) {}
			protected void chew(List<Double> input) {} // Does not compile
		}
	- For the same reason, you also can't overload a generic method from a parent class
		public class LongTailAnimal {
			protected void chew(List<Object> input) {}
		}
		public class Anteater extends LongTailAnimal {
			protected void chew(List<Double> input) {} // does not compile
		}
	- Both of these examples fail to compile because of Type Erasure. In the compiled form, the generic type is dropped, and it appears as a invalid overloaded method.
		public class Anteater extends LongTailAnimal {
			protected void chew(List<Object> input) {}
			protected void chew(ArrayList<Double> input) {}
		}
	- The first chew() method compiles because it uses the same generic type in the overridden method as the one defined in the parent class. 
	- The second method compiles as well. However, it is an overloaded method because one of the method arguments i a List and the other is an ArrayList.
	- When working with generic methods, it's important to consider the underlying type.

Return Generic types:

	- When you are working with overridden methods that return generics, the return values must be covariant. 
	- In terms of generics, this means that the return type of the class or Interface declared in the overriding method must be a subtype of the class defined in the parent class.
	- The generic parameter type must match its parent's type exactly.
	- Given the following declaration for the Mammal class, which of the two subclasses Monkey and Goat compile?
		public class Mammal {
			public List<CharSequence> play() {...}
			public CharSequence sleep() {...}
		}
		public class Monkey extends Mammal {
			public ArrayList<CharSequence> play() {...}
		}
		public class Goat extends Mammal {
			public List<String> play() {...} // Does not compile
			public String sleep() {...}
		}
	- The Monkey class compiles because ArrayList is a subtype of List. 
	- The play() method in the Goat class does not compile, though. 
	- For the return types to be covariant, the generic type parameter must match.
	- Even though String is a subtype of CharSequence, it does not match the generic type defined in the Mammal class. Therefore, this is considered an invalid override.
	- Notice that the sleep() method in the Goat class does compile since String is a subtype of CharSequence. This example shows that covariance applies to the return type, just not the generic parameter type.
	- Once you have determined which methods are overridden and which are being overloaded, work backward, making sure the generic types match for overridden methods.
	- And remember, generic methods cannot be overloaded by changing the generic parameter type only.


----------------------------------------------------------------------------------------------------------------------------------------------------

Returning an Optional:

	- An Optional is created using a factory.
 	- You can either request an empty Optional or pass a value for the Optional to wrap. 

Creating an Optional:

 	public static Optional<Double> average(int... scores) {
  		if (scores.length == 0) return Optional.empty();
    		int sum = 0;
      		for (int score: scores) sum += score;
		return Optional.of((double) sum / scores.length);
  	}
   	- Line 2 returns an empty Optional when we can't calculate an average.
    	- Line 3 and Line 4 add up the scores.
     	Calling the method shows what is in our two boxes:
      		System.out.println(avergae(90, 100)); // Optional[95.0]
		System.out.println(average()); // Optiona.empty
  	- You can see that one Optional contains a value and the other is empty.
   	- Normally, we want to check whether a value is there and/or get it out of the box.
    		Optional<Double> opt = average(90, 100);
      		if (opt.isPresent()) 
			System.out.println(opt.get());
   	- First, we check whether the Optional contains a value. 
    		Optional<Double> opt = average();
      		System.out.println(opt.get()); // NoSuchElementException
	- We would get an exception since there is no value inside the Optional.
 		java.util.NoSuchElementException: No Value present
   	- When creating an Optional, it is common to want to use empty() when the value is null.
    	- You can do this with an if statement or ternary operator.
     		Optional o = (value == null) ? Optional.empty(): Optional.of(value);
       - If value is null, o is assigned the empty Optional. Otherwise, we wrap the value. 
       - Since this si such a comon pattern, Java provides a factory method to do the same thing
       		Optional o = Optional.ofNullable(value);

Common Optional instance methods:

	Method				When Optional is empty				When Optional contains value
 	get()				Throws exception				Returns value
  	ifPresent(Consumer c)		Does nothing					Calls Consumer with Value
   	ifPresent()			Returns false					Returns true
    	orElse(T other)			Returns other parameter				Returns value
     	orElseGet(Supplier s)		Returns result of calling Supplier		Returns value
      	orElseThrow()			Throws NoSuchElementException			Returns value
       	orElseThrow(Supplier s)		Throws Exception created by calling Supplier	Returns value

	- The other methods allow you to write code that uses an Optional in one line without having to use the ternary operator. 
 	- This makes the code easier to read. Instead of using an if statement, which we used when checking the average earlier, we can specify a Consumer to be run when there is a value inside the Optional.
  	- When there isn't, the method simply skips running the Consumer.
   		Optional<Double> opt = average(90, 100);
     		opt.ifPresent(System.out::println);
       - Using ifPresent() better expresses our intent.

Dealing with an Empty Optional:

	- The remaining methods allow you to specify what to do if a value isn't present.
 	- There are a few choices. The first two allow you to specify a return value either directly or using a Supplier.
  		Optional<Double> opt = average();
    		System.out.println(opt.orElse(Double.NaN));
      		System.out.println(opt.orElseGet(() -> Math.random()));
	- Line2 shows that you can return a specific value or variable.
 	- In our case, we print the "not a number" value
  	- Line3 shows using a Supplier to generate a value at runtime to return instead.
   	- ALternatively, we can have the code throw an exception if the Optional is empty.
    		Optional<Double> opt = average();
      		System.out.println(opt.orElseThrow());
	- Without specifying a Supplier for the exception, Java will throw a NoSuchElementException.
 	- ALternatively, we can have the code throw a custom exception if the Optional is empty.
  	- Remember that the stacktrace looks weird because the lambdas are generated rather than the named classes.
   		Optional<Double> opt = average();
     		System.out.println(opt.orElseThrow(() -> new IllegalStateException));
       	- Line 2 shows using a Supplier to create an exception that should be thrown.
	- Notice that we do not write throw new IllegalStateException(). The orElseThrow() ethod takes care of actually throwing the exception when we run it. 
 		System.out.println(opt.orElseGet(() -> new IllegalStateException()); // Does not compile
   	- The opt variable is an Optional<Double>. This means that the Supplier must return a Double.
    	- Since this Supplier returns an exception, the type does not match.
     		Optional<Double> opt = average(90, 100);
       		System.out.println(opt.orElse(Double.NaN)); // 95.0
	 	System.out.println(opt.orElseGet(() -> Math.random())); // 95.0
   		System.out.println(opt.orElseThrow()); //95.0

Is Optional the same as null?

 	- An alternative to Optional is to return null.
  	- There are a few shortcomings with this approach.
   	- One is that there isn't a clear way to express that null might be a special value.
    	- On Contrast, returning an Optional is a clear statement in the API that there might not be a value
     	- Another advantage of Optional s that you can use a functional programming style with ifPresent() and the other methods rather than needing an if statement.
      	
Using Streams:

	- An stream in Java is a sequence of data.
 	- A stream pipeline consists of the operations that run on a stream to produce a result.
  	- With streams, the data isn't generated upfront. It is created when needed. 
   	- This is an example of lazy evalutation, which delays execution until necessary.
    	- In functional programming, these are called stream operations. Just like with the assembly line, operations occur in a pipeline. 
     	- Someone has to start and end the work, and there can be any number of stations in between.
      	- There are three parts to a stream pipeline
       		Source: Where the stream comes from
	 	Intermediate Operations: Transforms the stream into another one. There can be as few or as many intermediate operations as you would like. Since streams use lazy evaluation, the intermediate operations do not run unril the terminal operation runs.
   		Terminal Operation: Produces a result. Since streams can be used only once, the stream is no longer valid after a terminal operation completes.

Intermediate vs Terminal Operations:

	Scenario				Intermediate Operation		Terminal Operation
 	Required part of useful pipeline?	No				Yes
  	Can exist multiple times in pipeline?	yes				No
   	Return type is stream type?		yes				No	
    	Executed upon method call?		no				yes
     	Stream valid after call?		yes				no

	- A factory typically has a foreperson who oversees the work.
 	- Java serves as the foreperson when working with stream pipeline.
  	- This is really important role, especially when dealing with lazy evaluatioon and infinte streams.
   	- Think of declaring the stream as giving instructions to the foreperson.
    	- As the foreperson finds out what needs to be done, they set up the stations and tell workers what their duties will be. However, thw workers do not start until the foreperson tells them to begin.
     	- The foreperson waits untill they see the terminal operation to kickoff.

Creating Stream sources:

	- In Java, the streams we have been talking about are represented by the Stream<T> interface defined in the java.util.stream package.

 Creating Finite Streams:

 	- For simplicity, we start with finite streams. There are few ways to create them.
  		Stream<String> empty = Stream.empty();
    		Stream<Integer> singleElement = Stream.of(1);
      		Stream<Integer> fromArray = Stream.of(1, 2, 3);
	- Line 1 shows how to create an empty stream.
 	- Line 2 shows how to create a stream with a single element.
  	- Line 3 shows how to create a stream from varargs.
   	- Java also provides a convenient way of converting a Collection to a Stream.
    		var list = List.of('a','b','c');
      		Stream<String> fromList = list.stream();
	- Line 2 shows that it is a simple method call to create a stream from list. This is helpful since such conversions are common.

Creating a Parallel Stream:

	var list = List.of('a','b','c');
 	Stream<String> fromListParallel = list.parallelStream();
  	- This is a great feature because you can write code that uses concurrency before even learning what a thread is. 	
   	- Using parallel streams is like setting up multiple tables of workers who can do the same task.

Creating Infinite Streams:

	- We can't create an infinite list though, which makes streams more powerful.
 		Stream<Double> random = Stream.generate(Math::random);
   		Stream<Integer> oddNumbers = Stream.iterate(1, n->n+2);
     	- Line 1 generates a stream of random numbers. How many random numbers? Until you kill it. 
      	- Line 2 gives you more control. The iterate() method takes a seed or starting value as the first parameter. This is the first element that will be part of the stream.
       	- The other parameter is a lambda expression that is passed the previous value and generates next value. 

 Printing a Stream Reference:

 	- If you try to call System.out.print(stream) you wil get something like the following:
  		java.util.stream.ReferencePipeline$3@4517d9a3
    	- This is different from a Collection where you see the contents. 
     	- What if you wanted just odd numbers less than 100. There is an overloaded version of iterate() that helps:
      		Stream<Integer> oddNumbersUnder100 = Stream.iterate(1, n->n<100, n->n+2);
	- This method takes three parameters. Notice how they are seperated by commas, just like in all other methods.

Reviewing Stream Collection Methods:
							
 	- Stream.empty()					
  		Creates a Finite Stream with zero elements
  	- Stream.of(varargs)				
   		Creates a Finite Stream with elements listed
   	coll.stream():
    		Creates a Finite Stream from collection
    	coll.parallelStream():
     		Creates a Finite Strea from collection where stream can run in parallel
     	Stream.generate(supplier):			
      		Creates an Infinite stream by calling Suppler for each element upon request
      	Stream.iterate(seed, unaryOperator):
       		Creates an Infinte stream by using seed for first element and then calling UnaryOperator for each subsequent element upon request
       	Stream.iterate(seed, predicate, unaryOperator):
		Creates Finite/Infinte stream by using seed for first element and then calling UnaryIperator for each subsequent element upon request. Stops if predicate returns false.

Using Common Terminal Operations:

	- You can perform a terminal operation without any intermediate operations but not the other way around. This is why we talk about terminal operations first. 
 	- Reductions are a special type of terminal operation where all of the contents of the stream are combined into a single primitive or Object.

 	Method		What happens for Infinte streams	Return Value	Reduction
	- count()	Does not terminate			long		Yes
 	- min()		Does not terminate			Optional<T>	Yes
  	- max()
 	- findAny()	Terminates				Optional<T>	No
  	- findFirst()	
   	- allMatch()	Sometimes terminates			boolean		No
    	- anyMatch()
     	- noneMatch()
      	- forEach()	Does not terminate			void		No	
       	- reduce()	Does not terminate			varies		yes
	- collect() 	Does not terminate			varies		yes

 Counting

 	- The count() method determines the number of elements in a finite stream. 
  	- For an infinite stream, it never terminates.
   	- The count() method is a reduction because it looks at each element in the stream and returns a single value. 
    		public long count()
      	- This example shows calling count() on a finite stream.
       		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
	 	System.out.println(s.count());

   Finding the minimum and maximum:

   	- The min() and max() methods allows you to pass a custom comparator and find the smallest or largest value in finite stream according to that sort order.
    	- Like the count() method, the min() and max() hand on an infinite stream because they cannot be sure that a smaller or larger vlaue isn't coming later in stream
     	- Both methods are reductions becuase they return a single value after looking at the entire stream.
      		public Optional<T> min(Comparator<? super T> comparator)
		public Optional<T> max(Comparator<? super T> comparator)
  	- This examoke finds the animal with the fewest letters in its name:
   		Stream<String> s = Stream.of("monkey","ape","bonobo");
     		Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
       		min.ifPresent(System.out::println);
	 - Notice that the code returns an Optional rather than the value. This allows the method to specify that no minimum or maximum was found.
  	 - We use the Optional method ifPresent() and a method reference to print out the minimum only if one is found.
    	 - As an examle of where there isn't a minimum. Let's look at an empty stream
      		Optional<?> minEmpty = Stream.empty().min((S1, s2) -> 0);
		System.out.println(minEmpty.isPresent()); // false
  	 - Since the stream is empty, the comparator is never called, and no value s present in the Optional.

Finding a Value:

    	- The findAny() and findFirst() methods return an element of the stream unless the stream is empty.
     	- If the stream is empty, then return an empty Optional.
      	- This is the method that can terminate with an infinite stream,
        - Since Java generates only the amount of stream you need, the infinite stream needs to generate only one element.
	- As the name implies, the findAny() method can return any element of the stream.
 	- These methods are termina operations but not reductions. The reason is that they sometimes return without processing all of the elements.
  	- This means that they return a value based on the stream but do not reduce the entire stream into one value.
		public Optional<T> findAny()
  		public Optional<T> findFirst()
    	- Stream<String> s = Stream.of("monkey", "gorilla","bonobo");
     	  Stream<String> infinite - Stream.generate(() -> "Chimp");
	  s.findAny().ifPresent(System.out::println);
   	  infinite.findAny().ifPresent(System.out::println)l
      	- Finding any one match is more useful. Sometimes we just want to sample the results and get a representative element but we don't need to waste the processing generating them all.


Matching:

	- The allMatch(), anyMatch() and noneMatch() methods search a stream and return information about how the stream pertains to the predicate.
 	- These may or may not terminate for infinite strams.
  	- It deends on the data.
   	- Like the find methods, they are not reductions because they donot necessarily look at all of the elements.
    		The method signatures are as follows:
      		public boolean anyMatch(Predicate <? super T> predicate)
		public boolean allMatch(Predicate <? super T> predicate)
  		public boolean noneMatch(Predicate <? super T> predicate)
    	- var list = List.of("monkey", "2", "chimp");
     	  Stream<String> infinite = Stream.generate(() -> "chimp");
	  Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
   	  System.out.println(list.stream().anyMatch(pred)); // true
          System.out.println(list.stream().allMatch(pred)); // false
	  System.out.println(list.stream().noneMatch(pred)); // false
   	  System.out.println(infinite.anyMatch(pred));// true
      	- This shows tat we can reuse the same predicate, but we need a different stream each time.
       	- The anyMatch() method returns true because two of the three elements match.
	- The allMatch() method returns false becuase one doesn't match.
 	- The noneMatch() method also returns false becuase at least one matches.
  	- On the infinte stream, one match is found, so the call terminates. If we called allMatch() run unril we killed the program.
   	- The allMatch(), anyMatch() and noneMatch() return a boolean. By contrast, the find methods return an Optiona because they return an element of the stream.


Iterating:

	- As in the Java Collections Framework, it is common to iterate over the elements of a stream.
 	- As expected, calling forEach() on an infinite stream does not terminate. 
  	- Since there is no return value, it is not a reduction. 
   	- Before you use it, consider if another approach would be better. 
    		public void forEach(Consumer<? super T> action)
      	- Notice that this is the only terminal operation with a return type of void. 
       		Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
	 	s.forEach(System.out.print);

   Reducing:

    	- The reduce() method combines a stream into a single object. It is a reduction, which means it processes all the elements. 
     	- The three method signatures are these:
      		public T reduce(T identity, BinaryOperator<T> accumulator)
		public Optional<T> reduce(BinaryOperator<T> accumulator)
  		public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
    	- Let's take them one at a time. The most common way of ding a reduction is to start with an initial value and keep merging it with the next value.
     	- Think about how you would concatenate an array of String objects into a single String without functional programming. 
      		var array = new String[] {"w", "o", "l", "f"};
		var result = "";
  		for (var s: array) result = result + s;
    		System.out.println(result);
	- The identity is the initia value of the reduction, in the case an empty String.
 	- The accumulator combines the current result with the current value in the stream. 
  	- With lambdas, we can do the same thing with a stream and reduction.
   		Stream<String> stream = Stream.of("w", "o", "l", "f");
     		String word = stream.reduce("", (s, c) -> s + c);
       		System.out.println(word);

  		Stream<Integer> stream = Stream.of(3, 5, 6);
    		System.out.println(stream.reduce(1, (a, b) -> a+b));

	- We set the identity to 1 and the accumulator to multiplication. When you don't specify an identity, an Optional is returned because there might not be any data. There are three choices for what is in the Optional.
 		- If the stream is empty, an empty Optional is returned
   		- If the stream has one element, it is returned
     		- If the stream has multiple elements, the accumulator is applied to combine them.
       	- The following illustrates each of these scenarios:
		BinaryOperator<Integer> op = (a, b) -> a + b;
  		Stream<Integer> empty = Stream.empty();
    		Stream<Integer> oneELement = Stream.of(3);
      		Stream<Integer> threeElements = Stream.of(3, 5, 6);
		empty.reduce(op).ifPresent(System.out::println); // no output
  		oneElement.reduce(op).ifPresent(System.out::println); // 3
    		threeElements.reduce(op).ifPresent(System.out::println) // 90
      - Why are there two similar methods? Why not just always require the identity? Java could have done that. 
      - However, sometimes it is nice to differentiate the case where the stream is empty rather than the case where there is a value that happens to match the identity being returned from the calculation. The signature returning Optional lets you differentiate these cases.
      	- The third method signature is used when we are dealing with different types. It allows Java to create intermediate reductions and then combine them at the end.
       		Stream<String> stream = Stream.of("w","o","l","f");
	 	int length = stream.reduce(0, (i,s) -> i+s.length(), (a,b) -> a+b);
   		System.out.println(length);
     	- The first parameter(0) is the value of the initializer. If we had an empty stream, this would be the answer.
      	- The second parameter is the accumulator. Unlike the accumulators you saw previously, this one handles mixed data types.
       	- The three argument reduce() operation is useful when working with parallel streams because it allows the stream to be decomposed and reassembled by separate threads.


 Collecting:

 	- The collect() method is a special type of reduction called a mutable reduction.
  	- It is more efficient than a regular reduction because we use the same mutable object while accumulating.
   	- Common mutable objects include StringBuilder and ArrayList.
    	- This s really useful method, because it lets us get data out of streams and into another form.
     		public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> acumulator, BiConsumer<R, R> combiner)
       		public <R, A> R collect(Collector<? super T, A, R> collector)
	 - Let's start with the first signature, which is used hen we want to code specifically how collecting should work. 
  		Stream<String> stream = Stream.of("w", "o", "l", "f");
    		StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
      		System.out.println(word); // wolf
	- The first parameter is the supplier, which creates the object that will store the results as we collect the data. 
 	- Remember, that a Supplier doesn't take any parameters and returns a value. In this case, it constructs a new StringBuilder.
  	- The second parameter is the accumulator, which is a BiConsumer that takes two parameters and doesn't return anything. It is responsible for adding one or more element to the data collection. 
   	- The final parameter is the combiner, which is another BiConsumer. It is responsible for taking two data collections and merging them.
    	- This is usefu when we are processing in parallel. Two smaller collections are formed and then merged into one. 
     	- This would work with StringBuilder only if we didn't care about the order of the letters.
      		Stream<String> stream = Stream.of("w","o","l","f");
		TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
  	- The collector has three parts as before. The supplier creates an empty TreeSet. The accumulator adds a single String from the Stream to the TreeSet.
   	- The combiner adds all of the elements of one TreeSet to another in the case the operations were done in parallel and need t be merged.
    	- We started with the long signature because that's how you implement your own collector.
     		Stream<String> stream = Stream.of("w","o","l","f");
       		TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
	 	System.out.println(set);
   	- If we didn't need the set to be sorted, we could make the code even shorter
    		Stream<String> stream = Stream.of("w","o","l","f");
      		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set);

  Using Common Intermediate Operations:

  	- Unlike a terminal operation, an intermediate operation produces a stream as its result. 
   	- An intermediate operation can also deal with an infinite stream simply by returning another infinite stream.

Filtering

	- The filter() method returns a Stream with elements that match a given expression. Here is the method signature:
 		public Stream<T> filter(Predicate<? super T> predicate)
   	- This operation is easy to remember and powerful because we can pass any Predicate to it. 
    		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
      		s.filter(x-> x.startsWith("m")).forEach(System.out::println);

Removing Duplicates:

	- The distinct() method returns a stream with duplicate values removed.
 	- The duplicates do not need to be adjacent to be removed. 
  		public Stream<T> distinct()
    	- Stream<String> s = Stream.of("duck","duck","goose");
     	  s.distinct().forEach(System.out::print);

 Restricting by Position:

   	- The limit() and skip() methods can make a Stream smaller or limit() could make a finite stream out of an infinite stream. 
    		public Stream<T> limit(long maxSize)
      		public Stream<T> skip(long n)
	- The following code creates an infinite stream of numbers counting from 1. 
 	- The skip() operation returns an infinite stream starting with the numbers.
  	- The limit() call takes the first two of those. 
   		Stream<Integer> s = Stream.iterate(1, n -> n + 1);
     		s.skip(5).limit(2).forEach(System.out::print); // 67

Mapping:

  	- The map() method creates a one-to-one mapping from the elements in the stream to the elements of the next step in the stream.
   		public <R> Stream<R> map(Function? super T, ? extends R> mapper)
     	- This one looks more complicates than the others you have seen. It uses the lambda expression to figure out te ype passed to that functon and the one returned.
      	- The return type is the stream that is returned.
       	- The map() method on streams is for transforming data. 
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
  		s.map(String::length).forEach(System.out.print) // 676
    	- Remember that the String::length is shorthand for the lambda x -> x.length() which clearly shows it is a function that turns a String into an Integer.
 			
Using flatMap()

	- The flatMap() method takes each element in the stream and makes any elements it contains top-level elements in a single stream.
 	- This is helpful when you want to remove empty elements from a stream or combine a stream of lists.
  		public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R?? mapper)
    	- It returns a Stream of the type that the function contains at a lower level. 
     		List<String> zero = list.of();
       		var one = List.of("Bonobo");
	 	var two = List.of("Mama Gorilla", "Baby Gorilla");
   		Stream<List<String>> animals = Stream.of(zero, one two);
     		animals.flatMap(m -> m.stream()).forEach(System.out::println);
       Output: Bonobo Mama Gorilla Baby Gorilla

Concatenating Streams:

	- While flatMap() is good for the general case, there is a more convenient way to concatenate two streams:
 		var one = Stream.of("Bonobo");
   		var two = Stream.of("Mama Gorilla", "Baby Gorilla");
     		Stream.concat(one, two).forEach(System.out::println);
       	- This produces the same three lnes as the previous example. The two streams are concatenated and the terminal operation, forEach() is called.

 Sorting:

 	- The sorted() method returns a stream with the elements sorted. Just like sortiing arrays, Java uses natura ordering unless we specify a comparator. The method signatures are as follows:
  		public Stream<T> sorted()
    		public Stream<T> sorted(Comparator<? super T> comparator)
      	- Calling the first signature uses the default sort order:
       		Stream<String> s = Stream.of("brown-", "bear-");
	 	s.sorted().forEach(System.out::print); // bear-brown-
   	- We can optionally use a Comparator implementation via a method or a lambda. In this example, we are using a method
    		Stream<String> s = Stream.of("brown bear-", "grizzly-");
      		s.sorted(Comparator.reverseOrder().forEach(System.out::print)); // grizzly-brown bear-
	- HEre we pass a Comparator to specify that we want to sort in the reverse of natural sort order.
 		Stream<String> s = Stream.of("brown-bear-", "grizzly");
   		s.sorted(Comparator::reverseOrder); // Does not compile
     	- Above, takes the Comparator, which is a functional interface that tales two parameters and returns an int. However, Comparator::reverseOrder doesn't do that.
      	- Because, reverseOrder() takes no arguments and returns a value, the method reference is equivalent to () -> Comparator.reverseOrder() which is really a Supplier<Comparator>. This is not compatible with sorted().


Taking a Peek:

	- The peek() method is our final intermediate operation. It is useful for debugging because it allows us to perform a stream operation without changing the stream
 		public Stream<T> peek(Consumer<? super T> action)
   	- You might notice the intermediate peek() operation takes the same argument as the terminal forEach() operation.
    	- Think of peek() as an intermediate version of forEach() that returns the original stream to you.
     	- The most common use for peek() is to output the contents of the stream as it goes by.
      		var stream = Stream.of("black bear", "brown bear", "grizzly");
		long count = stream.filter(s -> s.startsWith("g")).peek(System.out::println).count(); // grizzly
  		System.out.println(count);
    	- peek() looks only at the first element when working with a Queue. In a stream, peek() looks at each element that goes through that part of the stream pipeline.

Changing state with peek():

	- Remember that peek() is intended to perform an operation without changing the result. 
 		var numbers = new ArrayList<>();
   		var letters = new ArrayList<>();
     		numbers.add(1);
       		letters.add('a');
	 	Stream<List<?>> stream = Stream.of(numbers, letters);
   		stream.map(List::size).forEach(System.out::print); // 11
     	- Now we add a peek call and note that Java doesn't prevent us from writing bad peek code
      		Stream<List<?>> bad = Stream.of(numbers, letters);
		bad.peek(x -> x.remove(0)).map(List::size).forEach(System.out::print); // 00
  	- This example is bad because peek() is modifying the data structure that is used in the stream which causes the result of the stream pipeline to be different than if the peek wasn't present.


Putting together the Pipeline:

	- Streams allow you to use chaining and express what you want to accomplish rather than how to do so. 
 	- Let's say that we wanted to get the first two names of our friends alphabetically that are four characters long.
  	- Without streams, we would have to write something like the following:
   		var list = List.of("Tobby","Anna","Leroy", "Alex");
     		List<String> filtered = new ArrayList<>();
       		for(String name: list) {
	 		if (name.length() ==4) {
    				filtered.add(name);
			}
   		}
     		Collections.sort(filtered);
       		var iter = filtered.iterator();
	 	if(iter.hasNext()) System.out.println(iter.next());
   		if(iter.hasNext()) System.out.println(iter.next());
	- With streams, equivalent code is:
 		var list = List.of("Tobby","Anna","Leroy", "Alex");
   		list.stream().filter(n->n.length() == 4).sorted().limit(2).forEach(System.out::println);

Examples:

	Stream.generate(() -> "Elsa")
 		.filter(n -> n.length() == 4)
   		.sorted()
     		.limit(2)
       		.forEach(System.out::println);
	 It hangs until you kill the program, or it throws an exception after running out of memory. 
  	 The foreperson has instructed sorted() to wait until everything to sort is present.
    	 That never happens because there is an infinite stream.
      	 Stream.generate(() -> "Elsa")
		.filter(n-> n.length() == 4)
  		.limit(2)
    		.sorted()
      		.forEach(System.out::println);
	This one prints Elsa twice. The filter sets elements through and limit() stops the earlier operations after two elements. 
 	Now sorted() can sort because we have a finite list.
  	Finally, what do you think this does?
   	Stream.generate(() -> "Olaf Lazisson").filter(n->n.length() ==4).limit(2).sorted().forEach(System.out::println);
    	This one hangs as well until we kill the program. The filter doesn't allow anything though, so limit() never sees two elements.
     	This means we have to keep waiting and hope they show up.

Working with Primitive Streams:

	- Up until now, all of the strams we have created using the Stream interface with a generic type, like Stream<String>, Stream<Integer> and so on.
 	- For numeric values, we have been using wrapper classes. We did this with the CollectionsAPI.
  	- Java actually includes other stream classes besides Stream that you can use to work with select primitives: int, double, long
   		Stream<Integer> stream = Stream.of(1, 2, 3);
     		System.out.prntln(stream.reduce(0, (s,n)->s+n)); // 6
       	- There is another way of doing that
		Stream<Integer> stream = Stream.of(1, 2, 3);
  		System.out.println(stream.mapToInt(x -> x).sum()); // 6
    	- This time we converted our Stream<Intege> to an IntStream and asked the IntStream to calculate the sum for us.
     	- An IntStream has many of the same intermediate and terminal methods as a Stream but includes specialized methods for working with numeric data. 
      	- The primitive streams know how to perform certain common operations automatically.
       		IntStream intStream = IntStream.of(1, 2, 3);
	 	OptionalDouble average = intStream.average();
   		System.out.println(average.getAsDouble()); // 2.0


Creating Primitive Streams:

	- Here are the three types of primitive streams:
 		- IntStream: Used for the primitive types int, short, byte, char
   		- LongStream: Used for the primitive type long
     		- DoubleStream: Used for the primitive types Double and Float
	- Common Primitive Stream Methods:

  	OptionalDouble average()				IntStream		Arithmetic mean of elements
   								LongStream
	   							DoubleStream
   	Stream<T> boxed()					IntStream		Stream<T> where T is wrapper class associated with primitive value
    								LongStream
	    							DoubleStream
    	OptionalInt max()					IntStream		Maximum element of stream
     	OptionalLong max()					LongStream
      	OptionalDouble max()					DoubleStream
       	OptionalInt min()					IntStream		Minimum element of stream
	OptioanalLong min()					LongStream
 	OptionalDouble min()					DoubleStream
  	IntStream range(int a, int b)				IntStream		Returns primitive strea from a(inclusive) to b(exlusive)
   	LongStream range(long a, long b)			LongStream
    	IntStream rangeClosed(int a, int b)			IntStream		Returns primitive stream from a (inclusive) to b(inclusive)
     	LongStream rangeClosed(long a, long b)			LongStream
      	int sum()						IntStream		Returns sum of elements
       	long sum()						LongStream
	double sum()						DoubleStream		
 	IntSummaryStatistics summaryStatistics()		IntStream		Returns object containing numerous stream statistics such as average, min, max
  	LongSummaryStatistics summaryStatistics()		LongStream
   	DoubleSummaryStatistics summaryStatistics()		DoubleStream

	- Some of the methods for creating a primitve stream are equivalent to how we created the source for a regular stream.
 		DoubleStream empty = DoubleStream.empty();
   	- Another way is to use the of() factory method from a single value or by using the varargs overloaded.
    		DoubleStream oneValue = DoubleStream.of(3.14);
      		oneValue.forEach(System.out::println);
	- var random = DoubleSteam.generate(Math::random);
 	  var fractions = DoubleStream.iterate(.5, d -> d/2);
    	  random.limit(3).forEach(System.out::println);	
       	  fractions.limit(3).forEach(System.out::println);
	- Since the streams are infinite, we added a limit intermediate operation so that the output doesn't print values forever.
 	- The first stream calls a static method on Math to get a random double.


Mapping Streams:

 	- Another way to create a primitive stream is by mapping from another stream type.

  	Source Stream class	ToCreate Stream		ToCreate DoubleStream	ToCreate IntStream	ToCreate LongStream
   	Stream<T>		map()			mapToDouble()		mapToInt()		mapToLong()
    	DoubleStream		mapToObj()		map()			mapToInt()		mapToLong()
     	IntStream		mapToObj()		mapToDouble()		map()			mapToLong()
      	LongStream		mapToObj()		mapToDouble()		mapToInt()		map()

	- Obviously, they have to be compatible types for this to work. Java requires a mapping function to be provided as a parameter
 		Stream<String> objStream = Stream.of("penguin","fish");
   		IntStream intStream = objStream.mapToInt(s -> s.length());
     	- This function takes an Object, which is a String in this case. 
      	- The function returns an int.

Using flatMap()

	- We can use this approach on primitive streams as well. It works the same way as on a regular Stream except the method name is different
 		var integerList = new ArrayList<Integer>();
   		IntStream ints = integerList.stream().flatMapToInt(x -> IntStream.of(x));
     		DoubleStream doubles = integerList.stream().flatMapToDouble(x -> DoubleStream.of(x));
       		LongStream longs = integerList.stream().flatMapToLong(x -> LongStream.of(x));

  	- Function parameters when mapping between types of streams

    	Source Stream Class	ToCreate Stream		ToCreate DoubleStream	ToCreate IntStream	To create LongStream
     	Stream<T>		Function<T, R>		ToDoubleFunction<T>	ToIntFunction<T>	ToLongFunction<T>
      	DoubleStream		DoubleFunction<R>	DoubleUnaryOperator	DoubleToInt Function	DoubleToLongFunction
       	IntStream		IntFunction<R>		IntToDoubleFunction	IntUnaryOperator	IntToLong Function
	LongStream		LongFunction<R>		LongToDoubleFunction	LongToIntFunction	LongUnary Operator

 	- Additionally you can create a Stream from a primitive stream. These methods show two ways of accomplishing this:
  		private static Stream<Integer> mapping(IntStream stream) { return stream.mapToObj(x -> x); }
    		private static Stream<Integer> Stream<Integer> boxing(IntStream stream) { return stream.boxed(); }
      - The first one uses the mapToObj() method. The second one is more succint. It does not require a mapping function becuase it does is autobox each primitive to the corresponding wrapper object.
      - The boxed() method exists on all three types of primitive streams.


Using Optional with Primitive Streams:

	- var stream = IntStream.rangeClosed(1, 10);
 	  OptionalDouble optional = stream.average();

    	- The return type is not the Optional. It is a new type called OptionalDouble. Why do we have a separate type? Why not Optional<Double> ?
     	- The difference is that the OptionalDouble is for a primitive and Optional<Double> is for the Double wrapper class. 
      	- Working with the primitive optional class looks similar to working with Optional class itself.

		optional.ifPresent(System.out::println);
  		System.out.println(optional.getAsDouble());
    		System.out.println(optional.orElseGet(() -> Double.NaN));

      - The only noticeable difference is that we called getAsDouble() rather than get(). This makes it clear that we are working with a primitive.
      - Also, orElseGet() takes a DoubleSupplier instead of a Supplier.
      - As with the primitive streams, there are three-specific classes for primitives. 

      	Getting as primititve 		getAsDouble()		getAsInt()		getAsLong()
       	orElseGet() parameter type	DoubleSupplier		IntSupplier		LongSupplier
	Return type of max(), min()	OptionalDouble		OptionalInt		OptionalLong
 	Return type of sum()		double			int			long
  	Return type of average()	OptionalDouble		OptionalDouble 		OptionalDouble
       	
     	LongStream longs = LongStream.of(5, 10);
      	long sum = longs.sum();
       	DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
	OptionalDouble min = doubles.min(); // runs infinitely

Summarizing Statistics:

	- private static int max(IntStream ints) {
 		OptionalInt optional = ints.max();	
   		return optional.orElseThrow(RunTimeException::new);  
	  }
   	- We got an OptionalInt because we have an IntStream. If the Optional contains a value, we return t.
    	- Otherwise, we throw a new RuntimeException. 
     	- Now we want to change the method to take an IntStream and returns a range. The range is the minimum value subtracted from the maximum value.
      	- Both min() and max() are terminal operations which means that they use up the stream when they are run. 
       	- We can't run two terminal operations against the same stream. Statistic is just a big word for a number that was calculated from the data.
		private static int range(IntStream ints) {
  			IntSummaryStatistics stats = ints.summaryStatistics();
     			if (stats.getCount() == 0) throw new RuntimeException();
			return stats.getMax() - stats.getMin();
   	- Here we asked Java to perform any calculations about the stream. SummaryStatistics include the following:
    		getCount(): Returns a long representing the number of values
      		getAverage(): Returns a double representing the average. If the stream is empty it return 0.
		getSum(): Returns the sum as a double for DoubleSummaryStream and long for IntSummaryStream and LongSummaryStream
  		getMin(): Returns the smallest number as a double, int or long depending on the type of the stream. If the stream is empty, returns the largest numeric value based on the type.
    		getMax(): Returns the largest number(maximum) as a double int or long depending on the type of the stream. If the stream is empty, returns the smallest numeric value based on the type.
 
Working with Advanced Stream Pipeline Concepts:

Linking Streams to the underlying data:

	var cats = new ArrayList<String>();
 	cats.add("Annie");
  	cats.add("Ripley");
   	var stream = cats.stream();
    	cats.add("KC");
     	System.out.println(stream.count()); // 3
      	- Streams are lazily evaluated. This means the stream isnt created on line 4. An object is created that knows where to look for the data when it is needed.
       	- lne5, the list gets new element line6 stream pipeline runs. First, it looks at the source and then sees three elements.

 Chaining Optionals:

 	- By now, you are familiar with the benefits of chaining operations in a stream pipeline. A few of the intermediate operations for streams are available for Optional. Suppose that you are given an Optional<Integer> and asked to print the value, but only if it is a three-digit number 
  		private static void threeDigit(Optional<Integer> optional) {
    			if (optional.isPresent()) {
	    			var number = optional.get();
	       			var string = "" + num;
		  		if (string.length() == 3) 	
	     				System.out.println(string);
	  		}
	 	}
	- It works, but it contains nested if statements. That's extra complexity.
 		private static void threeDigit(Optional<Integer> optional) {
   			optional.map(n -> "" + n).filter(s -> s.length() == 3).ifPresent(System.out::println);
      -  Optional<Integer> result = optional.map(ChainingOptionals::calculator)' // Does not compile
      		The problem is that the calculator returns Optional<Integer>. The map() method adds another Optional, giving us Optional<Optional<Integer>>
	- Well that's not a good solution. The solution is to use flatMap() instead
 		Optional<Integer> result = optional.flatMap(ChainingOptionals::calculator);
   	- This one works because flatMap removes the unncessary layer. In other words, in flattens the result
    	- Chaining calls to flatMap() is useful when you want to transform one Optional type to another.


Checked Exceptions and Functional Interfaces:

	- You might have noticed by now that most functional interfaces do not declare checked exceptions. 
 	- However, it is a problem when working with methods that declare checked exceptions.
  		import java.io.*;
    		import java.util.*;
      		public class ExceptionCaseStudy {
			private static List<String> create() throws IOException {
   				throw new IOException();
       			}
	  	}
    	- Now we use it in a stream:
     		public void good() throws IOException {
       			ExceptionCaseStudy.create().stream().count();
	  	}
    	- The create() method throws a checked exception. The calling method handles or declares it. 
     		public void bad() throws IOException {
       			Supplier<List<String>> s = ExceptionCaseStudy::create;
	  	}
    	- The problem is that the lambda to which this method reference expands does not declare an exception. The Supplier interface does not allow checked exceptions.
     	- There are two approaches to get around this problem. One is to catch the exception and turn it into an unchecked exception.
      	
Using a Spliterator:

	- A Spliterator starts with a Collection or a stream. The characteristics of a Spliterator depends on the underlying data source. 
 	- A collection data source is a basic Spliterator.
  	- By Constrast, when using a Stream data source, the Spliterator can be parallel or even infinite. 
   	- The Stream itself is executed lazily rather than when the Spliterator is created.
    	- Spliterator methods:

       		Spliterator<T> trySplit()		Returns Spliterator containing ideally half of the data which is removed from the current Spliterator.
	 						This method can be called multiple times and will eventually return null when data is no longer splittable.
		void forEachRemaining(Consumer<T> c)	Processes remaining elements in Spliterator
  		boolean tryAdvance(Consumer<T> c)	Processes single element from Spliterator if any remain. Returns whether element was processed.

    		var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
      		Spliterator<String> originalBagOfFood = stream.spliterator();
		Spliterator<String> emmasBag = originalBagOfFood.trySplit();
  		emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat-
    		Spliterator<String> jillsBag = originalBagOfFood.trySplit();
      		jillsBag.tryAdvance(System.out::print); //dog-
		jillsBag.forEachRemaining(System.out::print); // fish-

    		originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-

      	- Line 1 and Line 2 we define a List.. Line 3 and Lne 4 create two Spliterator references. The first is original bag, which contains all seven elements.
       	- The second is our split of the original bag, putting roughly half of the elements at the front into Emma's bag. 
	- We then print the three contents of Emma's bag on line4.
 	- Our original bag of food now contains four elements. We create a new Spliterator on line 6 and put the first two elements into Jill's bag. 
  	- We use tryAdvance() on line 6 to output a single element, and then line 7 prints all remaining elements. 

     		var originalBag = Stream.iterate(1, n->++n).spliterator();
       		Spliterator<Integer> newBag = originalBag.trySplit();
	 	newBag.tryAdvance(System.out::print) // 1
   		newBag.tryAdvance(System.out::print) // 2
     		newBag.tryAdvance(System.out::print) // 3

       - The Spliterator recognized that the stream is infinite and doesn't attempt to give you half.
       - Instead, newBag Contains a large number of elements. We get the first three since we call tryAdvance() three times. 
       - It would be a bad idea to call forEachRemaining() on an infinite stream.


Collecting Results:

	- The collect() terminal operation. There are many predefined collectors. These collectors are available via static methods on the Collectors class.
 		var ohMy = Stream.of("lions","tigers","bears");
   		String result = ohMy.collect(Collectors.joining(", "));
     		System.out.println(result); // lions, tigers, bears
       	- Notice how the predefined collectors are in the Collectors class rather than the Collectors interface similar to Collection vs Collections.
	- We pass the predefined joining() collector to the collect() and it performs the average for us. 
 		Double result = ohMy.collect(Collectors.averagingInt(String::length);
   		System.out.println(result);
     	- The pattern is the same. We pass a collector to collecT() and it performs the avergae for us.
      	- This time we needed to pass a function to tell the Collector what is the average. 
       	- We used a method reference which returns an int upon execution. With primitive streams, the result of an avergae was always a double, regardless of what type is being averaged. For collectors, it is a Double since those need an Object.
		var ohMy = Stream.of("lions", "tigers","bears");
  		TreeSet<String> result = ohMy.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
    		System.out.println(result);
      
	
Collecting into Maps:

	- Code using Collectors involving maps can get quite long. We will build it up slowly. 
 		var ohMy = Stream.of("lions", "tigers", "bears");
   		Map<String, String> map = ohMy.collect(Collectors.toMap(s -> s, String::length));
     	- When creating a map, you need to specify two functions. The first function tells the collector how to create the key. The second function tells the collector how to create the value.
      	- Returning the same value passed into a lambda is a common operation, so Java provides a method for it. You can rewrite s->s as Function.Identity(). 
        - Now we want to do the reverse and map the length of the animal name to the name itself. Our first incorrect attempt:
		var ohMy = Stream.of("lions", "tigers", "bears");
  		Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, k->k);
    		// Exception in thread "main" java.lang.IllegalStateException - Duplicate key 5
      	- Whats wrong? Two of the animal names are the same length. We didn't tell Java what to do? Should the collector choose the first one it encounters?
       	  The last one it encounters? Concatenate the two? Since the collector has no idea what to do it solves the problem by throwing the exception. 
	  	var ohMy = Stream.of("lions","tigers","bears");
    		Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, k->k, (S1, s2) -> s1 + " " + s2));
      		System.out.println(map);
		System.out.println(map.getClass()); // class java.util.HashMap
  	- It so happens that the Map returned is a HashMap. This behavior is not guaranteed. Sippose that we want to mandate the code return a TreeMap instead.
   	- We would just add a constructor reference as a parameter.
    		var ohMy = Stream.of("lions", "tigers", "bears");
      		TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + " " + s2, TreeMap::new));

Grouping, Partitioning, Mapping:

	- Suppose that we want to get groups of names by their length. We can do that by saying that we want to group by length
 		var ohMy = Stream.of("lions","tigers","bears");
   		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
     		System.out.println(map); // 5=[lions, bears], 6=[tigers]
       - The groupingBy() collector tells the collect() that it should group all of the elements in the stream into a Map. 
       - The function determines the keys in the Map. Each value in the Map is a List of all entries that match the key.
       - Now that the function you call in groupingBy() cannot return null. It does not allow null keys.
       - Suppose that we don't want a List as the value in the map and prefer a Set instead. There is another method signature that lets us pass a downstream collector.
       - This is a second collector that does something special with the values.
       		var ohMy = Stream.of("lions", "tigers", "bears");
	 	Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
   	We can even change the type of map returned through yet another parmater
    		TreeMap<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        This is very flexible. What if we want to change the type of Map returned but leave the type of values alone as a List? 
		 TreeMap<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.ToList()));


 	Partitioning is a special case of grouping. With partitioning, there are only two possible groups: true and false
  	Partitioning is like splitting a list into two parts
   		var ohMy = Stream.of("lions", "tigers", "bears");
     		Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s-> s.length() <= 5));
        Here we pass a Predicate with the logic for which group each animal name belongs in. 
		Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s-> s.length() <=7));
  	Notice that there are still two keys in the map - one for each boolean value. It so happens that one of the values is an empty list, bit it is still there.
   	As with groupingBy() we can change the type of List to something else
    		Map<Boolean, Set<String>> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
      	Unline groupingBy(), we cannot change the type of Map that is returned. However, there are only two keys in the map, so does it really matter which Map type we use?
       	Instead of using the downstream collector to specify the type, we can use any of the collectors. 
		Map<Integer, Long> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.counting()));

  Debugging Complicated Generics:

  	- When working with collect() there are often many levels of generics, making compiler errors unreadable. 
   		- Start over with a simple statement, and keep adding to it By making one tiny change at a time, you will know which code introduced the error.
     		- Extract arts of the statement into separate statements. For Examle, try writign Collectors.groupingBy(String::length, Collectors.counting());
       		- If it compiles you know that the problem lies elsewhere. If it doesn't compile you have a much shorter statement to trouleshoot.
	 	- Use generic wildcards for the return type of the final statement: For example: Map<?, ?> 
   		- if that change alone allows the code to compile you will know that the problem lies with the return type not being what you expect


     	- Finally, there is a mapping() collector that lets us go down a level and add another collector.
      		Map<Integer, Optional<Character>> map = ohMy.collect(Collectors.groupingBy(String::length, 
			Collectors.mapping(s -> s.charAt(0), Collectors.mnBy((A,b)->a-b)));

   		var map = ohMap.collect(groupingBy(String::length, mapping(s -> s.charAt(0), minBy((a,b) -> a-b)));


Teeing Collectors:

	- Suppose you want to return two things. As we have learned, this is problematic with streams becuase you only get one pass.
 	- The summary statistics are good when you want those operations.
  	- Luckily you can use teeing() to return multiple values of your own
   	- First, define the return type. We use a record here
    		record Separations(String spaceSearated, String commaSeparated) {}
      	- Now we write the stream. As you read, pay attention to the number of Collectors:
       		var list = List.of("x", "y", "z");
	 	Separations result = list.stream().collect(Collectors.teeing(Collectors.joining(" "), Collectors.joining(","), (s,c) -> new Separations(s,c)));
   	- WHen executed prints
    		Separations[spaceSeparated- x y z, commaSeparated=x,y,z]
      	- There are three Collectors in this code. Two of them are for joining() and roduce the values we want to return.
       	- The third is teeing() which combines the results into the single object we want to return.
	- This way, java is happy because only one object is returned, and we are happy because we don't have to go through the stream twice.
   

Understanding Exceptions:

	- A program can fail for just about any reason. Here are just few possibilities:
 		- The code tries to connect to a website, but the internet connection is down.
   		- You made a coding mistake and tried to access an invalid index in an array.
     		- One method calls another with a value that the method doesn't support.
       	- As you can see, some of these are coding mistakes. Others are completey beyond your control. Your program can't help it if the Internet connection goes down.

 The Role of Exceptions:

 	- An exception is Java's way of daying: "I give up, I don't know what to do right now. You deal with it".
  	- When you write a method, you can either deal with the exception or make it the calling code's problem.
   	- There are the two approaches Java uses when dealing with exceptions. A method can handle the exception case itself or make it the caller's responsibility.

Return Codes vs Exceptions:

 	- Exceptions are used when "something goes wrong". Howeber, the word wrong is subjective. 
  	- The following code returns -1 instead of throwing an exception if no match is found:
   		public int indexOf(String[] names, String name) {
     			for (int i=0; i<names.length; i++) {
				if (names[i].equals(name))
    					return i;
	 		}
    			return -1;
       		}
	 - While common for certain tasks for searching, return codes should generally be avoided. After all, Java provided an exception framework, so you should use it.

Understanding Exception types:

	- An exception is an event that alters program flow. 
 	- Java has a Throwable class for all objects that represent these events.
  	- Not all of them have the word exception in their class name, which can be confusing.
   		java.lang.Throwable <-------- java.lang.Exception <----------- java.lang.RuntimeException
     				    <-------- java.lang.Error

Checked Exceptions:

	- A checked exception is an exception that must be declared or handed by the application code where it is thrown. 
 	- In Java, checked exceptions all inherit Exception but not RuntimeException.
  	- Checked exceptions tend to more anticipated - for example trying to read a file that doesn't exist.
   	- Checked exceptions also include any class that inherits Throwable but not Error or RuntimeException.
    	- Checked Exceptions? What are we checking? Java has a rule called the handle or declare rule.
     	- The handle or declare rule means that all checked exceptions that could be thrown within a methor are either wrapped in compatible try and catch blocks or declared in the method signature.
      	- Because checked exceptions tend to be anticipated. Java enforces the rule that the programmer must do something to show that the exception was thought about. 
       	- May be it was handled in the method. Or maybe the method declares that it can't handle the exception and someone else should.
		void fall(int distance) throws IOException {
  			if (distance > 10) {
     				throw new IOException();
	 		}
    		}
      	- Notice that you are using two different keywords here. 
       	- The throw keyword tells Java that you want to throw an Exception, while the throws keyword simply declares that the method might throw an Exception. It also might not.
	- Now that you know how to declare an exception, how to handle it? The following alternate version of the fall() method handles the exception:
 		void fall(int distance) {
   			try {
      				if (distance > 10)
	  				throw new IOException();
       			} catch (Exception ex) {
	  			ex.printStackTrace();
      			}
	 	}
   	- Notice that the catch statement uses Exception, not IOException. Since IOException is a subclass of Exception, the catch block is allowed to catch it. 

Unchecked Exceptions:

	- An unchecked exception is any exception that does not need to be declared or handled by the application code where it is thrown. Unchecked exceptions are often referred to as runtime exceptions, although in Java, unchecked exceptions include any class that inherits RuntimeException or Error.
 	- It is permissibe to handle or declare an unchecked exception. That said, it is better to document the unchecked exceptions callers should know about in a Javadoc comment rather than declaring an unchecked exception.
  	- A runtime excetion is define as the RuntimeException class and its subclasses.
   	- Runtime exceptions tend to be unexpected but not necessarily fatal.
    	- For example, accessing an invalid array index is unexpected. Even though they do inherit the Excetion class, they are not checked exceptions.
     	- An unchecked exception can occur on nearly any line of code, as it is not required to be handled or declared. For example, a NullPointerException can be thrown in the body of the following method if the input reference is null
      	void fall(String input) {
       		System.out.println(input.toLowerCase());
	 }
  	- We work with objects in Java so frequently that a NullPointerException can happen almost anywhere. 
   	- If you had to declare unchecked exceptions everywhere, every single method would have that clutter!
    	- The code will compile if you declare an unchecked exception. However, it is redundant.

Error and Throwable:

	- Error means something went so horribly wrong that your program should not attempt to recover from it.
 	- For example, the disk drive "disappeared" or the program ran out of memory.
  	- These are abnormal conditions that you aren't likely to encounter and cannot recover them.
   	- Throwable is the parent class of all exceptions including the Error class.
    	- While you can handle Throwable and Error exceptions, it is not recommended you do so in your application code.
     	- When we refer to exceptions, we generally mean any class that inherits Throwable, although we are almost always working with the Exception class or subclasses of it. 

Reviewing Exception types:

	- Throwable is either an Exception or an Error. 
 	- You should not catch Throwable directly in your code.

  	Type 			How to recognize		Okay for program to catch?	Is program required to hanfle/declare
   												
	Unchecked exception	Subclass of RuntimeException	Yes				Yes
 	Checked Exception	Subclass of Exception but not 	Yes				Yes
  				subclass of RuntimeException	
  	Error			Subclass of Error		No				No
	     	

Throwing an Exception:

	- Any Java code can throw an exception, this includes code you write.
 	- Some exceptions are provided with Java.
  		String[] animals = new String[0];
    		System.out.println(animals[0]); // ArrayIndexOutOfBoundsException
      	- This code throws an ArrayIndexOutOfBoundsException since the array has no elements. 
       	- That means questions about exceptions can be hidden in questions that appear to be something else.
	- The second way for code to result in an exception is to especially request Java to throw one.
 		throw new Exception();
   		throw new Exception("Ow! I fell.");
     		throw new RuntimeException();
       		throw new RuntimeException("Ow! I fell.");
	- The throw keyword tells Java that you want some part of the code to deal with the exception. 

throw vs throws:

	- The throw keyword is used as a statement inside a code block to throw a new exception or rethrow an existing exception
 	- The throws keyword is used only at the end of a method declaration to indicate what exception it supports.
  	- When creating an exception, you can usually pass a String parameter with a message, or you can pass no parameters and use the defaults. We can usually because this is a convention. Someone has declared a constructor that takes a String. 
   	- Additionally, you should know that an Exception is an Object. This means you can store it in an object reference.
    		var e = new RuntimeException();
      		throw e;
	- The code instantiates an exception on one line and then throws on the next. 
 	- The exception can come from anywhere, even passed into a method. As long as t is a valid exception, it can be thrown.
  		throw RuntimeException(); // Does not compile
    	- This is because of missing keyword. The exception is never instantiated with the new keyword.
     		try {
       			throw new RuntimeException();
	  		throw new ArrayIndexOutOfBoundsException(); // Does not compile
     		} catch(Exception e) {}
       - Line 2 throws an exception and line 3 can never be reached during runtime. The compiler recognizes this and reports an unreachable code error. 


Calling methods that throw exceptions:

	- When you are calling a method that throws an exception, the rules are the same as within a method. 
 		class NoMoreCarrotsException extends Exception {}
   		public class Bunny {
     			public static void main(String[] args) {
				eatCarrot(); // Does not compile
    			}
       			private static void eatCarrot() throws NoMoreCarrotsException {}
	  	}
    	- The problem is that NoMoreCarrotsException is a checked exception. Checked Exceptions must be handled or declared. 
     	- The code would compile if you changed the main() method to either of these:
      		public static void main(String[] args) throws NoMoreCarrotsException {
			eatCarrot(); 
   		}
     		public static void main(String[] args) {
       			try {
	  			eatCarror();
      			} catch (NoMoreCarrotsException ex) {
	 			System.out.print("Sad Rabbit");
     			}
		}
  	- When you see a checked exception declared inside a catch block make sure the code in the associated try block is capable of throwing an exception or a subclass of the exception. 
   	- If not, the code is unreachable and does not compile. This does not extend to unchecked exceptions or exceptons declared in a method signature.


Overriding Methods with Exceptions:

	- An overridden method may not declare any new or broader checked exceptions than the method it inherits. 
 		class CanNotHopException extends Exception {}
   		class Hopper { public void hop(); }
     		class Bunny extends Hopper { public void hop() throws CanNotHopException{}} // does not compile
       - Java knows hop() isn't allowed to throw any checked exceptions becuase the hop() method in the superclass Hopper doesn't declare any. Imagine what would happen if the subclasses versions of the method could add checked exceptions- you could write code that calls Hopper's hop() method and not handle any exceptions. 
       - An overridden method in a subclass is allowed to declare fewer exceptions than the superclass or interface. 
       - This is legal because callers are already handling them
       		class Hopper {
	 		public void hop() throws CanNotHopException {}
    		}
      		class Bunny extends Hopper {
			public void hop() {} // this is fine
   		}
     	- An overridden method not declaring one of the exceptions thrown by the parent method is similar to the method declaring that it throws an exception it never actually throws. 
      	- This is perfectly legal. Similarly, a class is allowed to declare a subclass of an exception type. 
       	- The superclass or interface has already taken care of a broaden type.

 Printing an Exception:

 	- There are three ways to print an exception. You can let Java print it out, print just the message, or print where the stacktrace comes from. 
  		public static void main(String[] args) {
    			try {
       				hop();
	   		} catch (Exception ex) {
      				System.out.println(ex + "\n"); 
	  			System.out.println(ex.getMessage() + "\n");
      				ex.printStackTrace();
	  		}
     		}
       		public static void hop() {
	 		throw new RuntmeException("Cannot hop");
    		}
      Output:
      java.lang.RuntimeException: cannot hop
      cannot hop
      java.lang.RuntimeException: cannot hop
      	at Handling.hop(Handling.java:15)
       	at Handling.main(Handling.java:7)

 
Recognizing Exception classes:

	- You need to recognize three groups of exception classes: RuntimeException, checked Exception and Error

RuntimeException classes:

	- RuntimeException and its subclasses are unchecked exceptions that you don't have to be handled or declared. 

 	Unchecked Exception						Description
  	ArithmeticException			Thrown when code attempts to divide by zero
   	ArrayIndexOutOfBoundsException		Thrown when code uses illegal index to access array
    	ClassCastException			Thrown when attempt is made to cast object to class of which it is not an instance.
     	NullPointerException			Thrown when there is null reference where an object is required
      	IllegalArgumentException		Thrown by programmer to indicate that method has been passed illegal/inappropriate arg
       	NumberFormatException			Subclass of IllegalArgumentException. Thrown when attempt is made to convert String 						to numeric type but String doesn't have appropriate format.

 
  ArithmeticException

  	- Trying to divide an int by zero gives an undefined result. When this occurs, the JV will thow an ArithmeticException
		int answer = 11/0;
  	  Running the code results in the following output:
     	  Exception in thread "main" java.lang.ArithmeticException: /byZero

ArraysIndexOutOfBoundsException:

	- You know by now that array indexes start with 0 and go up by 1 less than the length of the array which means this code will throw an ArrayIndexOutOfBoundsException
 		int[] countsOfMoose = new int[3];
   		System.out.println(countsOfMosse[-1]); // ArrayIndexOutOfBoundsException
     	- This is a problem becuase there is no such thing as a negative array index.

ClassCastException:

	- Java tries to protect you from impossible casts. This code doesn't compile because Integer is not a subclass of String.
 		String type = "moose";
   		Integer number = (Integer) type; // ClassCastException
     	- More complicated code Java thwarts Java's attempt to protect you. When the cast fails at runtme, Java will throw a ClassCastException
      		String type = "mosse";
		Integer number = (Integer) obj;
  	- The compiler sees as cast from Object to Integer. The compiler doesn't realize there is a String in that Object. 
   	- Java tells you both types that were involved in the problem

NullPointerException

	- Instance variables and methods must be called on a non-null reference. If the reference is null, the JVM will throw a NullPointerException.
 		public class Frog {
   			public void hop(String name, Integer jump) {
      				System.out.print(name.toLowerCase() + " " + jump.intValue());
	  		}
     			public static void main(String[] args) {
				new Frog().hop(null, 1);
    			}
       		}
	 - Running this code results in the following output:
  		Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toLowerCase()" because "<parameter1>" is null.
    	 - If you are new to Java17, you should have noticed something special about the output. The JVM now tells you the object reference that triggered the NullPointerException! This new feature is called Helpful NullPointerExceptions.
      		new Frog().hop("kermit", null);
	- By default, a NullPointerException on a local variable or method parameter is printed with a number indicating the order in which it appears in the method, such as <local2> or <parameter4>.

Enabling/Disabling Helpful NullPointerExceptions

	- When helpful NullPointerExceptions were in added in Java14, the feature was disabled by default and had to be enabled via a command-line argument ShowCodeDetailsInExceptionMessages in JVM
 		java -XX:+ShowCodeDetailsInExceptionMessages Frog
   	- In Java 15 and above, the default behavior was changed so that it is enabled by default, although it can still be disabled via the command-line argument
    		java ++XX:-ShowCodeDetailsInExceptionMessages Frog

IllegalArgumentException:

	- IllegalArgumentException is a way for your program to protected itself.
 	- You want to tell the caller that something is wrong- preferably in an obvious way that the caller can't ignore so the programmer will fix the problem
  		public void setNumberEggs(int numberEggs) {
    			if (numberEggs < 0)
    				throw new IllegalArgumentException("# eggs must not be negative");
			this.numberEggs = numberEggs;
   		}

NumberFormatException:

	- Java provides methods to convert strings to numbers. 
 	- When these are passed an invalid value, they throw a NumberFormatException.
  	- The idea is similar to IllegalArgumentException. Since, this is a common problem. Java gives it a separate class.
   	- In fact, NumberFormatException is a subclass of IllegalArgumentException. 
    		Integer.parseInt("abc");
      		Output:
		Exception in thread "main"
  		java.lang.NumberFormatException: For input string: "abc"
    	- NumberFormatException is a subclass of IllegalArgumentException.


Checked Exception Classes
     	
   	- Checked exceptions have Exception in their hierarchy but not RuntimeException.
    	- They must be handled or declared. 

     	Checked Exceptions				Description
       	FileNotFoundException	Subclass of IOException. Thrown programmatically when code tries to reference file does not exist.
	IOException		Thrown programmatically when program reading or writing file.
 	NotSerializableException Subclass of IOException. Thrown programmaticlaly when attempting to serialize or deserialize non serializable class
  	ParseException		Indicates problem parsing input
   	SQLException		Thrown when error related to accessing database


Error Classes:

	- Errors are unchecked exceptions that extend the Error class. They are shown by the JVM and should not be handled or declared
 	- Errors are rare, but you might see one

   	Error					Description
    	ExceptionInInitializerError		Thrown when static intilializer throws exception and doesn't handle it
     	StackOverflowError			Thrown when method calls itself too many times called infinite recursion becuase method typically calls itself without end
      	NoClassDefFoundError			Thrown when class that code uses is available at compile time but not runtime


Handling Exceptions
Using try and catch statements

	- The code in the try block is run normally. If any of the statements throws an exception that can be caught by the exception type listed in the catch block, the try block stops running and execution goes to the catch statement.
 	- If none of the statements in the try block throws an exception that can be caught the catch clause is not run.
  	- You probably noticed the words block and clause used interchangeably. Block is correct because there are braces present.
   	- Clause is correct because it is part of a try statement.
    	- There aren't a ton of syntax rules here. The curly braces are required for try and catch blocks.
     		void explore() {
       			try {
	  			fall();
      				System.out.println("Never get here");
	  		} catch (RuntimeException ex) {
     				getUp();
	 		}
    			seeAnimals();
       		}
	 	void fall() { throw new RuntimeException(); }

Chaining catch Blocks:

	class AnimalsOutForAWalk extends RuntimeException {}
 	class ExhibitClosed extends RuntimeException {}
  	class ExhibitClosedForLunch extends ExhibitClosed {}
   	- In tis example, there are three custom exceptions. All are unchecked exceptions because they directly or indirectly extend RuntimeException. Now we chain both types of exceptions with two catch blocks and handle tem by printing out the appropriate message
    		public void visitPorcupine() {
      			try {
	 			seeAnimal();
     			} catch(AnimalsOutForWalk e) {
				System.out.print("try back later");
    			} catch(ExhibitClosed e) {
       				System.out.print("not today");
	   		}
      		}
	- A rule exists for the order of the catch blocks. Java looks at them in the order they appear.
 	- If it is impossible for one of the catch blocks to be executed, a compiler error about unreachable code occurs.
  	- For example, this happens when a superclass catch block appears before for a subclass catch block.
   		public void visitMonkeys() {
     			try {
				seeAnimal();
    			} catch (ExhibitClosedForLunch e) {  // subclass exception
       				System.out.print("try back later");
	   		} catch (ExhibitClosed e) { // superclass exception
      				System.out.print("not today");
	  		}
     		}
       - If the more specific ExhibitClosedForLunch exception is thrown, the first catch block runs. If not, Java checks whether the superclass ExhibitClosed exception is thrown and catches it. 
       - This time, the order of the catch blocks does matter The reverse does not work
       		public void visitMonkeys() {
     			try {
				seeAnimal();
    			} catch (ExhibitClosed e) {  // superclass exception
       				System.out.print("not today");
	   		} catch (ExhibitClosedForLunch e) { // subclass exception
      				System.out.print("try back later");
	  		}
     		}
       - If the more specific ExhibitClosedForLunch exception is thrown, the catch block for ExhibitClosed runs - which means there is no way for the second catch block to ever run. Java correctly tells you there is an unreachable catch block.
       		public void visitSnakes () {
	 		try {
    			} catch (IllegalArgumentException e) {
       			} catch (NumberFormatException e) { // does not compile
	  		}
     	- Remember we said earlier that you needed to know that NumberFormatException is a subclass of IllegalArgumentException.
      	- Since NumberFormatException is a subclass it will always be caught by the first catch block making the second catch block unreachable code that does not compile. 
       	- Likewise, FileNotFoundException is the subclass of IOException and cannot be used in similar manner. 
	- To review multiple catch blocks, atmost one catch block will run and it will be the first catch block that can handle the exception. Also, remember that an exception defined by the catch statement is only in scope for that catch block.
 		public void visitManatees() {
   			try {
      			} catch(NumberFormatException e1) {
	 			System.out.println(e1);
     			} catch(IllegalArgumentException e2) {
				System.out.println(e2);
    			}

Applying a Multi-catch block

	Often we want the result of an exception that is thrown to be the same regardess of which particular exception is thrown.
 		public static void main(String[] args) {
   			try {
      				System.out.println(Integer.parseInt(args[1]);
	  		} catch (ArrayIndexOutOfBoundsException e) {
     				System.out.println("Missing or invaid input");
	 		} catch (NumberFormatException e) {
    				System.out.println("Missing or invalid input");
			}
   		}
     	Notice that we have the same println() statement for two different catch blocks. We can handle this more gracefully using a multi-catch block. A multi-catch block allows multiple exception types to be caught by the same catch block.
      		public static void main(String[] args) {
			try {
   				System.out.println(Integer.parseInt(1));
       			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
	  			System.out.println("Missing or invalid input");
      			}
	 	}

Examples:

	catch(Exception1 e | Exception2 e | Exception3 e) // Does not compile
 	catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // Does not compile
  	catch(Exception1 | Exception2 | Exception3 e)

    	The first line is incorrect as the variable name appears three times.
     	Just because it happens to be the same variable name doesn't make it okay.
      	The second line is incorrect because the variable name again appears three times. 
       	Usng different variable names doesn't make it any better.
	The third line does compile. It shows the correct syntax for specifying three exceptions.
 	Java intends multi-catch to be used for exceptions that aren't related and it prevents you from specifyinf redundant types in a multi-catch block. A multi-catch block allows multiple exception types to be caught by the same catch block. 
  		public static void main(String[] args) {
    			try {
       				throw new IOException();
	   		} catch (FileNotFoundException | IOException e) {
      				System.out.println("Missing or invalid input");
	  		}
     		}
       Since FileNotFoundException is a subclass of IOException, this code will not compile.
       A multi-catch block follows rules similar to chaining catch blocks together.
       The one difference between multicatch blcoks and chaining catch blocks is that order does not matter for a multi-catch block within a single catch expressions.
       		try {
	 		throw new IOException();
    		} catch (IOException e) {}


Adding a finally block:

	- The try statement also lets you run code at the end with a finally clause, regardess of whether an exception is thrown. 
 	- There are two paths through code with both a catch and a finally.
  	- If an exception is thrown, the finally block is run after the catch block.
   	- If no exception is thrown, the finally block is run after the try block completes.

System.exit()

	- There is one exception to the finally block will always be executed rule. Java defines a method that you call as System.exit(). It takes an integer parameter that represents the status code that is returned.
 		try {
   			System.exit(0);
      		} finally {
			System.out.print("Never going to get here"); 
   	- System.exit() tells Java "stop! end the program right now. Do not pass.


Automating Resource Management:

	- Often, your application works with files, databased and various connection objects.
 	- Commonly, these external data sources are referred to as resources.
  	- In many cases, you open a connection to the resource, whether it is over the network or within a file system.
   	- You then readwrite the data you want. Finally, you close the resource to indicate that you are done with it. 
    	- If you are connecting to a database, you could use up all available connections, meaning no one can talk to the database until you release your connections.
     	- Although you commonly hear about memory leaks causing programs to fail, a resource leak is just as bad and occurs when program fails to release its connections to a resource resulting in the resource becoming inaccessibe. 
      	- This could mean your program can no longer talk to the database - or even worse, all programs are unable to reach the database!
       	- A resource is typically a file or database that requires some kind of stream or connection to read or write data.


 Introducing try-with-resources:

 	public void readFile(String file) {
  		FileInputStream is = null;
    		try {
      			is = new FileInputStream("myFile.txt");
	 	} catch ( IOException ex) {
   			ex.printStackTrace();
      		} finally {
			if ( is != null ) {
   				try {
       					is.close();
	    			} catch (IOException ex) {
					ex.printStackTrace();
     				}
	 		}
    		}
      	}
       - To solve this, Java includes the try-with-resources statement to automatically close all resources opened in try clause.
       - The feature is also known as automatic resource management because Java automatically takes care of closing
       		public void readFile(String file) {
	 		try (FileInputStream is = new FileInputStream("myFile.txt")) {
    				// Read file data
			} catch (IOException ex) {
   				ex.printStackTrace();
       			}
	  	}
    	- More importantly, though by using a try-with-resources statement we guarantee that as soon as a connection passes out of scope, Java will attempt to close it within the same method.
     	- Behind the scenes, the compiler replaces a try-with-resources block with a try and finally block.
      	- We refer to this "hidden" finally block as an implicit finally block since it is created and used by the compiler automatically. You can still create a programmer defined finally block when using a try-with-resources statement just be aware that the implict one will be called first.
       	- Unlike garbage collection, resources are not automatically closed when they go out of the scope.
	- Therefore, it is recommended that you close resources in the same block of code that opens them. 
 	- By using a try-with-resources statement to open all your resources this happens automatically.

Basics of try-with-resources:

	- One or more resources can be opened in the try clause.
 	- When multiple resources are opened, they are closed in the reverse of the order in which they are created.
  	- Also, notice that parentheses are used to list those resources and semicolons are used to separate the declarations.
   	- This works just like declaring multiple indexes in a for loop.
    		try (var in = FileInputStream("data.txt"); var out = new FileOutputStream("output.txt"); ) {
      			// Protected code
	 	} catch (IOException ex) {
   			// Exception Handler
      		} finally {
			// finally block
   		}
     	- What happened to the catch block. Well, it turns out a catch block is optional with a try-with-resources statement.
      	- For example, we can rewrite the previous readFile() example so that the method declares the exception to make it even shorter.
       		public void readFile(String file) throws IOException {
	 		try (FileInputStream is = new FileInputStream("myfile.txt")) {
    				// Read file data
			} 
   		}
     	- A try-with-resources statement differs from a try statement in that neither of these is required, although a developers may add both.


Constructing try-with-resources statements:

	- Only classes that implement AutoCloseable interface can be used in a try-with-resources statement.
 	- The following does not compile as String does not implement the AutoCloseable interface:
  		try (String reptile = "lizard") {}
    	- Inheriting AutoCloseable requires implementing a compatible close() ethod
     		interface AutoCloseable {
       			public void close() throws Exception;
	  	}
    	- The implemented version of close() can choose to throw Exception or a subclass or not throw any exceptions at all.
     	- Throughout the rest of this section, we use the following custom resource class that simply prints a message when the close() method is called:
      		public class MyFileClass implements AutoCloseable {
			private final int num;
   			public MyFileClass(int num) {
      				this.num = num;
	  		}
     			@Override
			public void close() {
   				System.out.println("Closing: " + num);
       			}
	  	}
    	- You encounter resources that implement Closeable rather than AutoCloseable.
     	- Since Closeable extends AutoCloseable they are both supported in try-with-resources statements.
      	- The only difference between the two is that Closeable's close() method declares IOException, while AutoCloseable's close() method declares Exception.


Declaring Resources:

	- While try-with-resources does support declaring multiple variables, each variable must be declared in a separate statement. 
 		try (MyFileClass is = new MyFileClass(1), os = new MyFileClass(2)) {
   		} // Does not compile
     		try (MyFileClass ab = new MyFileClass(1), MyFileClass cd = new MyFileClass(2)) {
       		} // Does not compile
	- The first example does not compile becuase it is missing the data type and it uses a comma instead of semicolon.
 	- The second example does not compile because it also uses a comma instead of semicolon.
  	- Each resource must include the data type and be separated by a semicolon.
   	- You can declare a resource using var as the data type in a try-with-resources statement since resources are local variables.
    		try (var f = new BufferedInputStream(new FileInputStream("it.txt"))) {
      			// Process file
	 	}
   	- Declaring resources is a common situation where using var is quite helpful as it shortens the already long line of code.

Scope of try-with-resources:

	- The resources created in the try clayse are in scope only within the try block.
 	- This is another way to remember that the implicit finally runs before any catch/finally blocks that you code yourself.
  	- The implicit code has run already, and the resource is no longer available.
   		try (Scanner s = new Scanner(System.in)) {
     			s.nextLine();
		} catch (Exception e) {
  			s.nextInt(); // Does not compile
     		} finally {
       			s.nextInt(); // Does not compile
	  	}
    	- The problem is that Scanner has gone out of scope at the end of try clause. Line 4, 6 do not have access to it.
     	- This is a nice feature. 
      	- You can't accidentally use an object that has been closed. 
       	- In a traditional try statement, the variable has to be dclared before the try statement so both the try and finaly blocks can access it, which as the unpleasant side effect of making the variable in scope for the rest of the method, just inviting you to call it by accident.

Following order of operations:

	- When working with try-with-resources statement, it is important to know that resources are closed in the reverse of the order in which they are created.
 		public static void main(String... xyz) {
   			try(MyFileClass bookReader = new MyFileClass(1); MyFileClass movieReader = new MyFileClass(2)) {
      				System.out.println("Try block");
	  			throw new RuntimeException();
      			} catch (Exception e) {
	 			System.out.println("Catch block");
     			} finally {
				System.out.println("Finally block");
    			}
       		}
	 	Output:
   		Try block
     		Closing: 2
       		Closing: 1
	 	Catch Block
   		Finally Block


Applying Effectively Final

	- While resources are often created in the try-with-resources statement, it is possible to declare them ahead of time, provided they are marked final or effectivey final. The syntax uses the resource name in place of the resource declaration separated by semicolon.
 		public static void main(String... xyz) {
   			final var bookReader = new MyFileClass(4);
      			MyFileClass movieReader = new MyFileClass(5);
	 		try (bookReader; var tvReader = new MyFileClass(6); movieReader) {
    				System.out.println("Try Block");
			} finally {
   				System.out.println("Finally Block");
       			}
	  	}
    	- If you come across a question on the exam that uses try-with-resources statement with a variable not declared in the try clause, make sure it is effectively final. For example, the following does not compile
     		var writer = Files.newBufferedWriter(path);
       		try (writer) { // Does not compile
	 		writer.append("Welcome to zoo!");
    		}
      		writer = null;
	- The writer variable is reassigned on last line, resulting in the compiler not considering it effectively final.
 	- Since it is not an effectively final variable, it cannot be used in a try-with-resources 
  		var writer = Files.newBufferedWriter(path);
    		writer.append("This write is permitted byt a really bad idea!!");
      		try (writer) {
			writer.append("Welcome to the zoo");
   		}
     		writer.append("This write will fail"); // IOException
       	- The code compiles but throws an exception at last line with the message Stream is closed. While it is possible to write to the resource before the try-with-resources statement it is not afterward.


 Understanding Suppressed Exceptions:
 
	- What happens if the close() method throws Exception?
 		public class TurkeyCage implements AutoCloseable {
   			public void close() {
      				System.out.println("Close gate");
	  		}
     			public static void main(String[] args) {
				try (var t = new TurkeyCage()) {	
    					System.out.println("Put turkeys in");
	 			}
     			}
		}
  	- If the TurkeyCage doesn't close, the turkeys could all escape. Clearly, we need to handle such condition.
   	- We already know that the resources are closed before any programmer coded catch blocks are run.
    	- This means we can catch the exception thrown by close() if we want to.
     	- Alternatively, we can allow the caller to deal with it.
      	- what happens if the try block also throws an exception? When multiple exceptions are thrown, all but the first are called suppressed exceptions. The idea is that Java treats the first exception as the primary one and tacks on any that come up while automatically closing.
       	- Java remembers the supressed exceptions that go with a primary exception even if we don't handle them in code.
	- If more than two resources throw an exception, the first one to be thrown becomes the primary exception and the rest are grouped as suppressed exceptions. 
 	- And since resources are closed in the reverse of the order in which they are declared, the primary exception will be on the last declared resource that throws an exception.
  	- Keep in mind that suppressed exceptions apply only to exceptions thrown in the try clause. 
   		public static void main(String[] args) {
     			try (JammedTurkeyCage t = new JammedTurkeyCage()) {
				throw new IllegalStateException("Turkeys ran off");
    			} finally {
       				throw new RuntimeException("and we couldn't find them");
	   		}
      		}
	- Line 3 throws an exception. Then Java tries to close the resource and adds a suppressed exception to it. 
 	- The finally block runs after all this. Since Line 5 finally also throws an exception, the previous exception from line 3 is lost, with the code printing the following:
  		Exception in thread "main" java.lang.RuntimeException:
    			and we couldn't find the
       			at JammedTurkeyCage.main(JammedTurkeyCage.java:9)
	- This has always been and continuous to be bad programming practice. We don't want to lose exceptions!


 Formatting values:

 	- For formatting, we introduce the NumberFormat interface which has two commonly used methods:
  		public final String format(double number)
    		public final String format(long number)
      	- Since NumberFormat is an interface, we need the concrete DecimalFormat class to use it.
       	- It includes a constructor that takes a pattern String
		public DecimalFormat(String pattern)
  	- The patterns can get quite complex.

    	Symbol			Meaning						Examples
     	#			Omit position if no digit exists for it 	$2.2
      	0			Put 0 in position if no digit exists for it 	$002.20

       		double d = 1234.567;
	 	NumberFormat f1 = new DecimalFormat("###,###,###.0");
   		System.out.println(f1.format(d)); // 1,234.6
     		NumberFormat f2 = new DecimalFormat("000,000,000.00000");
       		System.out.println(f2.format(d)); // 000,001,234.56700
	 	NumberFormat f3 = new DecimalFormat("Your balance $#,###,###.##");
   		System.out.println(f3.format(d)); // Your balance $1,234.57
     	- # omits the extra positions 
      	- 0 adds leading and trailing zeros to make the output to desired length.


Formatting Dates and Times:

	The date and time classes support many methods to get data out of them
 		LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
   		System.out.println(date.getDayOfWeek()); // THURSDAY
     		System.out.println(date.getMonth()); // OCTOBER
       		System.out.println(date.getYear()); // 2022
	 	System.out.println(date.getDayOfYear()); // 293
   	Java provides a class called DateTimeFormatter to display standard formats
    		LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
      		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dt = LocalDateTime.of(date, time);
  		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
    		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
      		System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		Output:
  		2022-10-20
    		11:12:34
      		2022-10-20T11:12:34
	The DateTieFormatter will throw an exception if it encounters an incompatible type.
 	For example, each of the following will produc an exception at runtime sice it attempts to format a date with a time value
  		date.format(DateTimeFormatter.ISO_LOCAL_TIME); // RuntimeException
    		time.format(DateTimeFormatter.ISO_LOCAL_DATE); // RuntimeException

Customizing the Data/Time format:

	If you don't want to use one of the predefined formats, DateTimeFormatter supports a custom format using a date format strng
		var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
  		System.out.println(dt.format(f)); // October 20, 2022 at 11:12

Learning the standard Date/Time Symbols:

	You should be familiar enough with the various symbols that you can look at a date/time String and have a good idea of what the output will be

  	Symbol 			Meaning			examples
   	y			Year			22, 2022
    	M 			Month			1, 01, Jan, January
     	d 			Day 			5, 05
      	h			hour			9, 09
       	m			Minute			45
	S			Second			52
 	a			a.m/p/m			AM, PM
  	z			Time zone name		Eastern Standard Time, EST
   	Z 			Tme zone offset		-0400

    	var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
     	var formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy", "hh:mm:ss");
      	System.out.println(dt.format(formatter1));
       	var formatter2 = DateTimeFormatter.ofPattern("MM_yyyy_-_dd");
	System.out.println(dt.format(formatter2)); // 10_2022_-_20
 	var formatter3 = DateTimeFormatter.ofPattern("h:mm z");
  	System.out.println(dt.format(formatter3)); // DateTimeException

    	- The first example prints the date with the month before the day, followed by the time.
     	- The second example prints the date in a weird format with extra characters that are just displayed as part of the output.
      	- The third example throws an exception at runtime becuase the underlying LocalDateTime does not have a time zone specified.
       	- If ZonedDateTme were used instead, the code would complete successfully and prints something like 06:15 EDT depending on the time zone.
	- Make sure you know which symbols are compatible with which date/time types.

Selecting a format() method:

	- The date/time classes contain a format() method that will take a formatter, while the formatter classes contain a format() method that will take a date/time value. The result is that either of the following is acceptable
 		var dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 06, 15, 30);
   		var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
     		System.out.println(dateTime.format(formatter));
       		System.out.println(formatter.format(dateTime));
	 - These statements print the same value at runtime.

Adding Custom Text Values:

	- What if you want your format to include some custom text values?
 	- If you just type them as part of the format String, the formatter will interpret each character as date/time symbol.
  	- In the best case, it will display weird data based on extra symbols you enter.
   	- In thw worst case, it will throw an exception because the characters contain invalid symbols. 
    	- One way to address this would be to break the formatter into multiple smaller formatters and then concatenate the results.
     		var dt = LocalDateTime.of(2022, Month.OCTOBER, 20,6,15,30);
       		var f1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
	 	var f2 = DateTimeFormatter.ofPattern("hh:mm");
   		System.out.println(dt.format(f1) + "at" + dt.format(f2));
     	- While this works, it could become difficult if a lot of text values and date symbols are intermixed.
      	- Luckily, Java includes a much simpler solution. You can escape the text by surrounding it with a parit of single quotes.
       	- Escaping text instructs the formatter to ignore the values inside the single quotes and just insert them as part of final value.
		var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
  		System.out.println(dt.format(f));


 Supporting Internationalization and Localization

 	- Many applications need to work in different countried and with different languages.
  	- Internationalization is the process of designing your program so it can be adapated. 
   	- This involves placing strings in a properties file and ensuring that the proper data formatters are used.
    	- Localization means supporting multiple locales or geographic regions.
     	- You can think of a locale as being like a language and country pairing. 
      	- Localization includes translating strings to a different langiages. 
       	- It also includes outputting dates and numbers in the correct format for that locale.
	- Initially, your program does not need to support multiple locales.
 	- The key is to future-proof your application by these techniques. 
  	- This way, when your product becomes successful, you can add support for new languages or regions without rewriting everything.

Picking a Locale:

	- While Oracle defines a locale as a specific geographical, political or cultural region. You will only see languages and countries on the exam. Oracle certainly isn't going to delve into political regions that are not countries.
 	- The Locale class is in the java.util package. The first useful Locale to find is the user's current locale.
  	- Try running the following code on your computer
   		Locale locale = Locale.getDefault();
     		System.out.println(locale);
       	- When you run it prints en_US. It might be different for you. This default output tells us that our computers are using English and are sitting in the United States.
	- First comes the lowercase language code. The language is always required. Then comes an underscore followed by the upper case country code. The country is optional. 
 	- Locale formats: Locale (language) 	Locale(language, country)
  				fr 			en_US
      			LowerCase LanguageCode	LowercaseLanguageCode_Uppercase CountryCode
	 - As practice, make sure that you understand why each of these Locale identifiers is invalid:
  		US	// Cannot have country without language
    		enUS	// Missing underscore
      		US_en   // The country and language are reversed
		EN      // Language must be lowercase
  	- The corrected versions are en and en_US
   	- You donot need to memorize language or country codes. You do need to recognize valid and invalid formats.
    	- Pay attention to uppercase/lowercase and the underscore.
     	- For example, if you see a locale expressed as es_CO, then you should know that the language is es and country s CO, even if you didn't know that they represent Spanish and Columbia respectively.

      - As a developer, you often need to write code that selects a locale other than the default one.
      - There are three common ways of doing this. The first is to use the built-in constants in the Locale class
      		System.out.println(Locale.GERMAN); // de
		System.out.println(Locale.GERMANY); // de_DE
      - The first example selects the German language, which is spoken in many countries, including Austria (de_AT) and Liechtenstein(de_LI). The second example selects both German the language and Germany the country.
      - The second way of selecting a Locale is to use the constructors to create a new object. You can pass just a language or both a language and country
      		System.out.println(new Locale("fr"));		// fr
		System.out.printn(new Locale("hi", "IN")); 	// hi_IN
      - The first is the language French, and the second is Hindi in India.
      - Again, you don't need to memorize the codes. There is another constructor that lets you be even more specific about locale.
      - Java will let you create a Locale with an invalid language or country such as xx_XX.
      - However, it will not match the Locale that you want to use and your progra will not behave as expected.
      - There is a third way to create a Locale that is more flexible. The builder design pattern lets you set all of the properties that you care about and then build the Locale at the end.
      - This means that you can specify the properties in any order. The following two Locale values both represent en_US
      		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2 = new Locale.Builder().setRegion("US").setLanguage("en").build();
      - When testing a program, you might need to use a Locale other than your computer's default.
      		System.out.println(Locale.getDefault()); // en_US
		Locale locale = new Locale("fr"); 
  		Locale.setDefault(locale);
    		System.out.println(Locale.getDefault()); // fr
      - The Locale changes for only that one Java program. It does not change any settings on your computer It does not even change future executions of the same program.


Localizing Numbers:

	- Formatting or parsing currency and number values can change depending on your locale.
 	- For example, in the UnitedStates, the dollar sign is prepended before the value along with the decimal point for the value less than one dollar such as $2.15. In Germany, though, the euro symbol is appended to the value along with a comma for values less than one euro such as 2,15 e
  	- Luckily, the java.text package includes classes to save the day
   	- The first step to format or parse data is the same: obtain an instance of a NumberFormat. Once you have the NumberFormat instance, you can cal format() to turn a number into a String, or you can use parse() to turn a String into a number.
    	- The format classes are not thread safe. Do not store them in instance variables or static variables. 

Factory methods to get a NumberFormat:

	Description					Using default Locale and a specified Locale

	General-purpose formatter		NumberFormat.getInstance()
 						NumberFormat.getInstance(Locale locale)
       	Same as getInstance			NumberFormat.getNumberInstance()
						NumberFormat.getNumberInstance(Locale locale)
      	For formatting monetary amounts		NumberFormat.getCurrencyInstance()
       						NumberFormat.getCurrencyInstance(Locale locale)
	For formatting percentages		NumberFormat.getPercentInstance()
 						NumberFormat.getPercentInstance(Locale locale)
       	Rounds decimal values			NumberFormat.getIntegerInstance()
	before displaying			NumberFormat.getIntegerInstance(Locale locale)
 	Returns compact number formatter	NumberFormat.getCompactNumberInstance()
  						NumberFormat.getCompactNumberInstance(Locale locale, NumberFormat.Style, formatStyle)


 Formatting Numbers

 	When we format data, we convert it from a structured object or primitibe value into a String.
  	The NumberFormat.format() method formats the given number based on locale associated with the NumberFormat object

     		int attendeesPerYear = 3_200_000;
       		int attendeesPerMonth = attendeesPerYear/12;
	 	var us = NumberFormat.getInstance(Locale.US);
   		System.out.println(us.format(attendeesPerMonth)); // 266,666
     		var gr = NumberFormat.getInstance(Locale.GERMANY);
       		System.out.println(gr.format(attendeesPerMonth)); // 266.666
	 	var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
   		System.out.println(ca.format(attendeesPerMonth)); // 266 666

	This shows how our US, German and French Canadian guests can all see the same information in the number format they are accustomed to using. In practice, we would just call NumberFormat.getInstance() and rely on the user's default locale to format.

   		double price = 48;
     		var myLocale = NumberFormat.getCurrencyInstance();
       		System.out.println(myLocale.format(price)); 

  	When run with the default locale of en_US for the UnitedStates, this code outputs $48.00. 
   	On the other hand, when run with default locale of en_GB for Great Britain, it outputs e48.00

    		double successRate = 0.802;
      		var us = successRate.getPercentInstance(Locale.US);
		System.out.println(us.format(successRate)); // 80%
  		var gr = NumberFormat.getPercentInstance(Locale.GERMANY);
    		System.out.println(gr.format(successRate)); // 80%

Parsing Numbers

	- When we parse data, we convert it from a String to a structured object or primitive value.
 	- The NumberFormat.parse() method accomplishes this and takes the locale into consideration.
  	- The parse() method found in various types, declares a checked exception ParseException that must be handled or declared in the method in which it is called.

    		String s = "40.45";
      		var en = NumberFormat.getInstance(Locale.US);
		System.out.println(en.parse(s)); // 40.45
  		var fr = NumberFormat.getInstance(Locale.FRANCE);
    		System.out.println(fr.parse(s)); // 40

      	- In the United States, a dot is part of number and the number is parsed as you might expect.
       	- France does not use a decimal point to separate numbers.
	- Java parses it as a formatting character and it stops looking at the rest of the number.
 	- The parse() method is also used for parsing currency.

    		String income = "$92,807.99";
      		var cf = NumberFormat.getCurrencyInstance();
		double value = (Double) cf.parse(income);
  		System.out.println(value); // 92807.99

     	- The currency string "$92,807.99" contains a dollar sign and comma. The parse method strips out the characters and converts the value to a number. The return value of parse is a Number object. 
      	- Number is the parent class of all the java.lang Wrapper classes so the return value can be cast to its appropriate data type. The Number is cast to a Double and then automatically unboxed into a double.


Formatting with CompactNumberFormat:

	- The second class that inherits NumberFormat that you need to know is CompactNumberFormat.
 	- It is new to Java17. CompactNumberFormat is similar to DecimalFormat but it is designed to be used in places where print space may be limited. It is opinionated in the sense that it picks a format for you and locale specific in that output can change depending on your location.
  	- Consider the following sample code that applies a CompactNumberFormat five times to two locales using a static import for Style

   		var formatters = Stream.of(
     			NumberFormat.getCompactNumberInstance(),
			NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT),
   			NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.LONG),
      			NumberFormat.getCompactNumberInstance(Locale.GERMAN, Style.SHORT),
	 		NumberFormat.getCompactNumberInstance(Locale.GERMAN, Style.LONG),
    			NumberFormat.getNumberInstance());
		formatters.map(s -> s.format(7_123_456).forEach(System.out::println);
  		Output:
    		7M
      		7M
		7 million
  		7 Mio.
    		7 Millionen
      		7,123,456

 	- Notice that the first two lines are the same. If you don't secify a style, SHORT is used by default.
  	- Next, notice that the values except the last one which doesn't use a compact number formatter are truncated.
   	- There is a readon it is called a comact number formatter.
    	- Also notice that the short form uses common labels for large values such as K for thousand.
     	- Last, but not least, the output may differ for you when you run this, as it was run in en_US Locale.

      		formatter.map(s -> s.format(314_900_000)).forEach(System.out::println);
		Output:
  		315M
    		315M
      		315 million
		315 Mio.
  		315 Millionen
    		314,900,000

	- Notice that the third digit is automatically rounded up for the entries that use a CompactNumberFormat.
 	- The following summarized the rules for CompactNumberFormat:
  		- First it determines the highest range for the number such as thousand(K), million(M), billion(B), trillion(T)
    		- It then returns up to the first three digits of that range rounding the last digit as needed
      		- Finally, it prints an identifier. If SHORT is used, a symbol is returned. If LONG is used, a space followed by a word is returned.
	
 			
Localizing Dates:

	- Like numbers, date formats can vary by locale.
	- Factory methods to get a DateTimeFormatter

   	Description					Using default Locale
    	For formatting dates			DateTimeFormatter.ofLocalizedDate(FormatStyle dateStyle)
     	For formatting times			DateTimeFormatter.ofLocalizedTime(FormatStyle dateStyle)
      	For formatting dates and times		DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateStyle, FormatStyle timeStyle)
       						DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateTimeStyle)

      - Each method in the table takes a FormatStyle parameter or two with possible values SHORT, MEDIUM, LONG and FULL.
      - What if you need a formatter for a specific locale? Easy enough- just append withLocale(locale) to the method call.
      			public static void print(DateTimeFormatter dtf, LocalDateTme dateTime, Locale locale) {
	 			System.out.println(dtf.format(dateTime) + "-------" + dtf.withLocale(locale).format(dateTime));
     			}
			public static void main(String[] args) {
   				Locale.setDefault(new Locale("en", "US"));
       				var italy = new Locale("it", "IT");
	   			var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 12, 34);
       				print(DateTimeFormatter.ofLocalizedDate(SHORT), dt, italy); // 10/20/22 --- 20/10/22
	   			print(DateTimeFormatter.ofLocalizedTime(SHORT), dt, italy); // 3:12 PM --- 15:12
				print(DateTimeFormatter.ofLocalizedDateTime(SHORT, SHORT), dt, italy); 
    				// 10/20/22, 3:12 PM --- 20/10/22, 15:12 	
			}
   	- First we establish en_US as the default locale, with it_IT as the requested locale.
    	- We then output each value using the two locales.


Specifying a Locale Category:

	- When you call Locale.setDefault() with a locale, several display and formatting options are internally selected.
 	- If you require finer-grained control of the default locale, Java subdivides the underlying formatting options into distinct categories with the Locale.Category enum.
  	- The Locale.Category enum is a nested element in Locale that supports distinct locales for displaying and formatting data.

   	DISPLAY			Category used for displaying data about locale
    	FORMAT			Category used for formatting dates, numbers or currencies.

      	- When you call Locale.setDefault() with a locale, the DISPLAY and FORMAT are set together.
       		public static void printCurrency(Locale locale, double money) {
	 		System.out.println(NumberFormat.getCurrencyInstance().format(money) + ", " + locale.getDisplayLanguage());
    		}
      		public static void main(String[] args) {
			var spain = new Locale("es", "ES");
   			var money = 1.23;
      			Locale.setDefault(new Locale("en", "US"));
	 		printCurrency(spain, money);  //$1.23, Spanish
    			Locale.setDefault(Category.DISPLAY, spain);
       			printCurrency(spain, money); // $1.23, espanol
	  		Locale.setDefault(Category.FORMAT, spain);
     			printCurrency(spain, money); // 1,23 e, espanol
		}

  Loading Properties with Resource Bundles:

  	- Up until now, we have kept all of the text strings displayed to our users as part of the program inside the classes that use them. Localization requires externalizing them to elsewhere.
   	- A resource bundle contains the locale-specific objects to be used by a program.
    	- It is like a map with keys and values. 	
     	- The resource bundle is commonly stored in a properties file. 
      	- A properties file is a text file in a specific format with key/value pairs
       	- We immediately realize that we are going to need to internationalize our program.
	- Resource Bundles will be quite useful. They will let us easily translate out application to multile locales or even support multiple locales at once. 

 		Locale us = new Locale("en", "US");
   		Locale france = new Locale("fr", "FR");
     		Locale englishCanada = new Locale("en", "CA");
       		Locale frenchCanada = new Locale("fr", "CA");

   	- In the next sections, we create a resource bundle using properties file.
    	- It is conceptually similar to Map<String, String> with each line representing a different key/value.
     	- The key and value are separated by an equal sign or colon


Creating a Resource Bundle:

	- Java doesn't require us to create four different resource bundles. If we don't have a country specific resource bundle, Java will use a language-specific one. 
 	Zoo_en.properties
  	hello=hello
   	open=The zoo is open
    	Zoo_fr.properties
     	hello=Bonjour
      	open=Le zoo est ouvert
       	- The filenames match the name of our resource bundle, zoo. They are then followed by an underscore target locale and .properties file extension. We can write out very first program that uses resource bundle to print this information
		public static void printWelcomeMessage(Locale locale) {
  			var rb = ResourceBundle.getBundle("Zoo", locale);
     			System.out.println(rb.getString("hello") + ", " + rb.getString("open"));
		}
  		public static void main(String[] args) {
    			var us = new Locale("en", "US");
       			var france = new Locale("fr", "FR");
	  		printWelcomeMessage(us); // Hello, The zoo is open
     			printWelcomeMessage(france); // Bonjour, Le zoo est ouvert
	- Since a resource bundle contains key/value pairs, you can even loop through them to list all of the pairs.
 	- The ResourceBundle class provides a keySet() method to get a set of all keys.
  			var us = new Locale("en", "US");
     			ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
			rb.keySet().stream().map(k -> k + ": " + rb.getString(k)).forEach(System.out::println);
   	- This example goes through all of the keys. It maps each key to a String with both the ey and the value before printing everything
    		hello: Hello
      		open: The zoo is open


 Loading Resource Bundle Files at Runtime

 	- If your own aplications, though, the resource bundles can be stored in a variety of places.
  	- While they can be stored inside the JAR that uses them, doing so is not recommended.
   	- This approach forces you to rebuild the application JAR any time some text changes.
    	- One of the benefits of using resource bundles is to decouple the application code from the locale-specific text data
     	- Another approach is to have all of the properties file in a separate properties JAR or folder and load them in the classpath at runtime. In this manner, a new language can be added without changing the application JAR.


Picking a Resource Bundle:

	- There are two methods for obtaining a resource bundle that you should be familiar with:
 		ResourceBundle.getBundle("name");
   		ResourceBundle.getBundle("name", locale);
     	- The first uses the default locale. You are likely to use this one in program that you write.

       	Picking a resource bundle for French/France with default locale English/US

	Step		Looks for file			Reason
 	1		Zoo_fr_FR.properties		Requested Locale
  	2		Zoo_fr.properties		Language was requested with no country
   	3		Zoo_en_US.properties		Default Locale
    	4.		Zoo_en.properties		Default locale's language with no country
     	5. 		Zoo.properties			No locale at all - default bundle
      	6. 		If still not found, throw MissingResourceException- No locale or default bundle available

       - Look for the resource bundle for the requested locale, followed by the one for the default locale.
       - For each locale, check the language/country followed by just the language
       - Use the default resource bundle if no matching locale can be found.

       - As mentioned earlier, Java supports resource bundles from Java classes and properties alike.
       - When Java is searching for a matching resource bundle, it will first check for a resource bundle with the matching class name.


 	What is the maximum number of files that Java would need to consider in order to find the appropriate resource bundle with the following code ?

    		Locale.setDefault(new Locale("hi"));
      		ResourceBundle rb = ResourceBundle.getBundle("Zoo", new Locale("en"));

 	The answer is three. They are listed here:
  	1. Zoo_en.properties
   	2. Zoo_hi.properties
    	3. Zoo.properties

     The requested locale is en, so we start with it. Since the en locale does not contain a country we move on to the default locale, hi. Again, there is no country so we end with the default bundle.

Selecting Resource Bundle Values

	- The steps that we have discussed so far are for finding matching resource bundle to use as a base.
 	- Java isn't required to get all of the keys from the same resource bundle.
  	- It can get them from any parent of the matching resource bundle.
   	- A parent resource bundle in the hierarchy just removes components f the name until it gets to the top.

    	Matching resource bundle 			Properties files keys can come from
     	Zoo_fr_FR					Zoo_fr_FR.properties
      							Zoo_fr.properties
	     						Zoo.properties

     	- Once a resource bundle has been selected, only properties along with a single hierarchy will be used.
      	- Contrast this behavior in which the default en_US resource bundle is used if no other resource bundles are available.
       	- What does this mean, exactly? Assume the requested locale is fr_FR and the default is en_US.
	- The JVM will provide data from en_US only if there is no matching fr_FR or fr resource bundle.
 	- If it finds a fr_FR or fr resource bundle then only those bundles along with the default bundle will be used.
  	- Let's put all of this together and print some information about our zoos. We have a number of properties files this time.

   		Zoo.properties
     		name=Vancouver Zoo
       		Zoo_en.properties
	 	hello=Hello
   		open=is open
     		Zoo_en_US.properties
       		name=The Zoo
	 	Zoo_en_CA.properties
   		visitors=Canada Visitors

      	- Suppose that we have a visitor from Quebec which has a default locale of French Canada) who has asked the program to provide information in English. What is the output?

       		Locale.setDefault(new Locale("en", "US"));
	 	Locale locale = new Locale("en", "CA");
   		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
     		System.out.println(rb.getString("hello"));
       		System.out.print(". ");
	 	System.out.println(rb.getString("name"));
       		System.out.print(" ");
	 	System.out.println(rb.getString("open"));
       		System.out.print(" ");
	 	System.out.println(rb.getString("visitors"));

   		The program prints the following:
     		Hello. Vancouver Zoo is open Canada visitors

       - The default locale is en_US and the requested locale is en_CA
       - First, Java goes through the available resource bundles to find a match.
       - It finds one right away with Zoo_en_CA.properties. This means the default locale of en_US is irrelevant.
       - Line 3 doesn't find a match for the key help in Zoo_en_CA.properties so it goes up the hierarchy to Zoo_en.properties.
       - Line 5 doesn't find a match for name in either of the first two properties files so it has to go all the way to the top of the hierarchy Zoo.properties. Even when the property wasn't found in en_CA or en resource bundles, the program preferred using Zoo.properties the default resource bundle rather than Zoo_en_US.properties 
       - What if a property is not found in any resource bundle? Then an exception is thrown. For example, attempting to call rb.getString("close") in the previous program results in a MissingResourceException at runtime.

Formatting Messages:

	- Often we just want to output the text data from a resource bundle, but sometimes you want to format the data with parameters. In real programs, it is common to substitute variables in the middle of a resource bundle string.
 	- The convention is to use a number inside braces such as {0}, {1} etc.
  	- The number indicates the order in whch the parameters will be passed. Although resource bundles don't support this directly, the MessageFormat class does.
   	- For example, suppose that we had this property defined:
    		helloByName=Hello, {0} and {1}
      	- In Java, we can read in this value normally. After that, we can run it through the MessageFormat class to substitute the parameters. The second parameter to format() is vararg, allowing you to specify any number of input values.
       	- Suppose, we have a resource bundle, rb
		String format = rb.getString("helloByName");
  		System.out.print(MessageFormat.format(format, "Tammy", "Henry"));

     	Output:
	Hello, Tammy and Henry

Using the properties class:

	- When working with the ResourceBundle class, you may also come across the Properties class.
 	- It functions like the HashMap class except that it uses String values for the keys and values.
  		import java.util.Properties;
    		public class ZooOptions {
      			public static void main(String[] args) {
	 			var props = new Properties();
     				props.setProperty("name", "Our zoo");
	 			props.setProperty("open", "10am");
     			}
		}
  	- The Properties class is commonly used in handling values that may not exist.
   		System.out.println(props.getProperty("camel")); // null
     		System.out.println(props.getProperty("camel", "Bob")); // Bob
       - If a key were passed that actually existed, both statements would print it.
       - This is commonly referred to as providing a default, or a backup value for missing key.
       - The Properties class also includes a get() method, but only getProperty() allows for a default value.
       - For example, the following call is invalid since get() takes only a single parameter
       		props.get("open");
	 	props.get("open", "The Zoo will open soon"); // Does not compile
      	
Introducing Modules:

	- A real project will consist of hundreds or thousands of classes grouped into packages.
 	- These packages are grouped into Java archive (JAR) files.
  	- A JAR is a ZIP file with some extra information and the extension is .jar
   	- In addition to code written, most appications also use code written by others.
    	- Open source is software with the code supplied and is often free to use. 
     	- Java has a vibrant open source software OSS community, and those libraries are also supplied as JAR files.
      	- For example, these are libraries to read files, connect to a database and much more.
       	- Some open source projects even depend on functionality in other open source projects.
	- For example, Spring is a commonly used framework, and Junit is commonly used testing library.
 	- To use either, you need to make sure you have compatible versions of all the relevant JAR's available at runtime.
  	- This complex chain of dependencies and minimum versions is often referrred to by the community as JAR hell.
   	- Hell is an excellent way of describing the wrong version of the class being loaded or even a ClassNotFoundException at runtime.
	- The Java Platform Module System(JPMS) groups code at a higher level. The main purpose of a module is to provide groups of related packages that offer developers a particular set of functionality. 
 	- It's like a JAR file, except a developer chooses which packages are accessible outside the module.
  	- The Java Platform Module System includes the following:
   		- A format for module JAR files
     		- Partitioning of the JDK into modules
       		- Additional command-line options for the Java tools

Exploring a Module:

  	- A modue is a group of one or more packages plus a special file called module-info.java
   	- The contents of this file are the module declaration. 

Benefits of Modules:

	- Modules look like another layer of things you need to know in order to program. While using modues is optional, it is important to understand the problems they are designed to solve:
 	- Better access control: In addition to the levels of access control, methods you can have packages that are only accessible to other packages in the module.
  	- Clearer dependency management: Since modules specify what they rely on, Java can complain about a missing JAR when starting up the program rather than when it is first accessed at runtime.
   	- Custom Java Builds: You can create a Java runtime that has only the parts of JDK that your program needs rather than the full one at over 150MB
    	- Improved security: Since you can omit parts of the JDK from your custom build, you don't have to worry about vulnerabilities discovered in a part you don't use.
     	- Improved performance: Another benefit of a smaller Java package is improved startup runtime and a lower memory requirement.
      	- Unique package enforcement: Since modules specify exposed packages, Java can ensure that each package comes from only one module and avoid confusion about what is being run.


Creating and Running a Modular Program:

Creating files:

 	- First we have a really simple class that prints one line in a main() method. We know, that's not much of an implementation.
  	- All those programmers we hired can fill it in with business logic.
   		package zoo.animal.feeding;
     		public class Task {
       			public static void main(String... args) {
	  			System.out.println("All fed!");
      			}
	 	}
   	- Next comes the module-info.java file. This is the simplest possible one
    		module zoo.animal.feeding {}
      	- There are a few key differences between a module declaration and a regular Java class declaration:
       		- The module-info.java file must be in the root directory of your module. Regular Java classes should be in packages
	 	- The module declaration must use the keyword module instead of class, interface or enum
   		- The module name follows the naming rules for package names. It often includes periods in its name.
     		- Regular class and package names are not allowed to have dashes(-). Module names follow the same rule.
       	- The next step is to make sure the files are n the right directory structure.

Compiling our First Module:

	- Before we can run modular code, we need to compile it Other than module-path option, ths code should look famiiar
 		javac --module-path mods -d feeding feeding/zoo/animal/feeding/*.java feeding/module-info.java
   	- As a review, -d option specifies the directory to place the class files in.
    	- The end of the command is a list of the .java files to compile.
     	- You can list the files individually or use a wildcard for all .java files in a subdirectory.
      	- The new part is module-path. This option indicates the location of any custom module files.
       	- In this example, the module-path could have been omitted since there are no dependencies.
	- You can think of module-path as replacing the classpath option when you are working on a modular program.
 	 What about the classpath?
   	- The classpath option has three possible forms: -cp, --class-path and -classpath. You can still use these options
    	- In fact, it is common to do so when writing nonmodular programs.
     	- Just like classpath, you can use an abbreviation in the command. The syntax --module-path and -p are equivalent.
      	- That means we could have written many other commands in place of the previous command. 
       	- The following four commands show the -p option
		javac -p mods -d feeding feeding/zoo/animal/feeding/*.java feeding/*.java
  		javac -p mods -d feeding feeding/zoo/animal/feeding/*.java feeding/module-info.java
    		javac -p mods -d feeding feeding/zoo/animal/feeding/Task.java feeding/module-info.java
      		javac -p mods -d feeding feeding/zoo/animal/feeding/Task.java feeding/*.java
	- While you can use whichever you like the best, be sure that you can recognize all valid forms 

 	Options you need to know for using modules with javac

   	Use for				Abbreviation		Long form
    	Directory for class files	-d <dir>		n/a
     	Module path			-p <path>		--module-path <path>

Building Modules:

	- Even without modules, it is rare to run javac and java commands manually on a real project.
 	- They get long and complicated very quickly.
  	- Most developers use a build tool such as Maven or Gradle.
   	- These build tools suggest directories in which to place the class files, like target/classes.
    	- It is likely that the only time you need to know the syntax of these commands. 

Running our first module:

	- Before we package our module, we should make sure it works while running.
 	- To do that, we need to learn the full syntax. Suppose, there is a module named book.module.
  	- Inside the module is a pacage called com.sybex which has a class named OCP with main() method.
   	- It is important to remember that you specify the modile name followed by slash followed by fully qualified name

     		java --module-path mods --module book.module/com.sybex.OCP
		java --module-path feeding --module zoo.animal.feeding/zoo.animal.feeding.Task

   	- Since you already saw that --module-path uses the short form of -p
    	- There is a short form for --module as well. The short option is -m. That means the following command is equivalent
     		java -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task

       	Options you need to know for using modules with java

 	Module name 		-m <name>		--module<name>
  	Module Path		-p <path>		--module-path <path>

Packaging our First Module:

	- A module isn't much use if we can run it only in th folder it was created in.
 	- Our next step is to package it. 
  	- Be sure to create a mods directory before running this command:
		jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .
  	- There is nothing module-specific here. We are packaging everything under the feeding directory and storing it in a JAR file named zoo.animal.feeding.jar under the mods folder. This represents how the module JAR will look to other code that wants to use it.
   	- Now let's run the program again, but this time using the mods directory instead of loose classes
    		java -p mods -m zoo.animal.feeding/zoo.animal.feeding.Task
      	- You might notice that the command looks identical to the one in the previous section except for the directory.
       	- In the previous example, it was feeding. In tis one it is the module path of mods. 
	- Since the module path is used, a module JAR is being run.

 Updating our example for multiple modules:

 	Modules depending on zoo.animal.feeding

    		zoo.animal.feeding <---------------- zoo.animal.care
      			|				|
	 	zoo.animal.talks <----------------- zoo.staff

Updating the Feeding Module

	Since we will be having our other modules call code in the zoo.animal.feeding package, we need to declare this intent in the module declaration
 	The exports directive is used to indicate that the module intends for those packages to be used by Java code outside the module. As you might expect, without any exports directive, the module is only available to be run from the command line on its own.
  	In the following we can export package
   		module zoo.animal.feeding {
     			exports zoo.animal.feeding;
		}
  	Recompiling and repackaging the module will update the module-info.class inside our zoo.animal.feeding.jar file.
   	These are the same javac and jar commands you ran previously

    		javac -p mods -d feeding feeding/zoo/animal/feeding/*.java feeding/module-info.java
      		jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .


Creating a Care module:

	Next, let's create the zoo.animal.care module. This time, we are going to have two packages.
 	The zoo.animal.care.medical package will have the classes and methods tat are intended for use by other modules.
  	The zoo.animal.care.details package is going to be used by this module. It will not be exported from the module.

   		zoo.animal.care

     		zoo.animal.care.medical				module-info.java
       			Diet.java
	  	zoo.animal.care.details
    		    HippoBirthday.java

   	The module contains two basic packages and classes in addition to the module-info.java
    	// HippoBirthday.java
     	package zoo.animal.care.details;
      	import zoo.animal.feeding.*;
       	public class HippoBirthday {
		private Task task;
  	}
   	// Diet.java
    	package zoo.animal.care.medical;
     	public class Diet {}
      	This time the module-info.kava file specifies three things:
       	module zoo.animal.care {
		exports zoo.animal.care.medical;
  		requires zoo.animal.feeding;
    	}
     	Line 1 specifies the name of the module
      	Line 2 lists the package we are exporting so it can be used by other modules. So far, this is similar to the zoo.animal.feeding module. 
       Line 3 we see a new directive. The requires statement specifies that a module is needed.
       The zoo.animal.care module depends on zoo.animal.feeding module.
       Next, we need to figure out the directory structure. We will create two packages. The first s zoo.animal.care.details and contains one class named HippoBirthday. The second is zoo.animal.care.medical which contains one class named Diet. 
       You might have noticed that the packages begin with the same prefix as the module name.
       This is intentional. You can think of it as if the module name "claims" the matching package and all subpackages.
       To review we now compile and package the module:

		javac -p mods -d care care/zoo/animal/care/details/*.java care/zoo/animal/care/medical/*.java care/module-info.java

   	We compile both packages and the module-info.java file. In the real world, you will use a build tool rather than doing this by hand. Now that we have compiled code, it's time to create the modular JAR
    		jar -cvf mods/zoo.animal.care.jar -C care/ .

Creating the Talks Module:

	- So far, we have used only one exports and requires statement in a module.
 		zoo.animal.feeding  <---------------- zoo.animal.care
   			|				   |
      		zoo.animal.talks    <---------------- zoo.staff
	- Contents of zoo.animal.talks
 		zoo.animal.talks
   			zoo.animal.talks.content	zoo.animal.talks.schedule
      			     ElephantScript.java		Weekday.java
	      		     SeaLionScript.java			Weekend.java
	      		zoo.animal.talks.media		
	 		     Announcement.java			module-info.java
	 		     Signage.java

  		module zoo.animal.talks {
    			exports zoo.animal.talks.content;
       			exports zoo.animal.talks.media;
	  		exports zoo.animal.talks.schedule;

			requires zoo.animal.feeding;
   			requires zoo.animal.care;
      		}
	- Line 1 shows the module name. Line 2-4 allows other modules to refernce all three packages.
 	- Line 6 and 7 specify the two modules that tis module depends on. Then we have 6 classes as shown
  		// ElephantScript.java
    		package zoo.animal.talks.content;
      		public class ElephantScript {}
		// SeaLionScript.java
  		package zoo.animal.talks.content;
    		public class SeaLionScript {}
      		// Announcement.java
		package zoo.animal.talks.media;
  		public class Announcement {
    			public static void main(String[] args) {
       				System.out.println("We will be havinb talks");
	   		}
      		}
		// Signage.java
  		package zoo.animal.talks.media;
    		public class Signage {}
      		// Weekday.java
		package zoo.animal.talks.schedule;
  		public class Weekday{}
    		// Weekend.java
      		package zoo.animal.talks.schedule;
		public class Weekend {}

  		Command to compile and build the module

     		javac -p mods -d talks talks/zoo/animal/talks/content/*.java talks/zoo/animal/talks/media/*.java talks/zoo/animal/talks/schedule/*.java talks/module-info.java
       		jar --cvf mods/zoo.animals.talks.jar -C talks/ .


  Creating the Staff Module:

  	- Our final module is zoo.staff. Below shows that there is only one package inside. We will not be exposing this package outside the module
   		zoo.staff
     			zoo.staff		module-info.java
			Jobs.java

 		zoo.animal.feeding	zoo.animal.care
   			|			|
      		zoo.animal.talks	zoo.staff

  
   		module zoo.staff {
     			requires zoo.animal.feeding;		
			requires zoo.animal.care;
   			requires zoo.animal.talks;
      		}
		In this module, we have a single class in the Jobs.java file
  		package zoo.staff;
    		public class Jobs { }
      		Command to compile and build the module:
			javac -p mods -d staff staff/zoo/staff/*.java staff/module-info.java
   			jar --cvf mods/zoo.staff.jar -C staff/ .

Diving into the Module declaration:

	Now that we have successfully created modules, we can learn more about module declaration.

Exporting a package:

	- We have already seen how exports packageName exports a package to other modules. It's also possible to export a package to specific module.
 	- Suppose the zoo decides that only staff members should have access to talks. We could update the module declaration as follows:
  		module zoo.animal.talks {
    			exports zoo.animal.talks.content to zoo.staff;
       			exports zoo.animal.talks.media;
	  		exports zoo.animal.talks.schedule;

     			requires zoo.animal.feeding;
			requires zoo.animal.care;
   		}
     	- from the zoo.staff module, nothing has changed. However, no other modules would be allowed to access that package.
      	- you might have noticed that none of our other modules requires zoo.animal.talks in the first place.
       	- However, we don't know what other modules will exist in the future. It is important to consider future use when designing modules.
	- Since we want only the one module to have access, we only allow access to the module.

 Exported types:

 	- We have been talking about exporting a package. All public classes, interfaces, enums and records are exported.
  	- Futher, any public and protected fields and methods in those fields are visible.
   	- Fields and methods that are private are not visible because they are not accessible outside the class. 
    	- Similarly package fields and methods are not visible because they are not accessible outside the package.

     	The exports directive esentially gives us more levels of access control.
      	Level		Within module code				Outside module
       	private		Available only within class			No access
	package		Available only within package			no access
 	protected	Available only within package or to subclasses	Accessible to subclasses only if package is exported
  	public		Available to all classes			Accessible only if package is exported

Requiring a Module transitively:

	- requires moduleName specifies that the current module depends on moduleName. There is also a requires transitive moduleName which means that any module that requires this module will also depend on moduleName.
 	- for example- zoo.animal.talks depends on zoo.animal.care which depends on zoo.animal.feeding. This means that the arrow between zoo.animal.talks and zoo.animal.feeding no longer appears.
  	- Now let's look at the four module declarations. The first module remains unchanged. We are exporting one package to any packages that use the module
   		module zoo.animal.feeding {
     			exports zoo.animal.feeding;
		}
  	- The zoo.animal.care module is the first opportunity to improve things. Rather than forcing all remaining modules to explicitly specify zoo.animal.feeding the code uses requires transitive
   		module zoo.animal.care {
     			exports zoo.animal.care.medical;
			requires transitive zoo.animal.feeding;
   		}
     	- In the zoo.animal.talks module, we make a similar change and don't force other modules to specify zoo.animal.care. We also no longer to specidy zoo.animal.feeding so that line is commented out
      		module zoo.animal.talks {
			exports zoo.animal.talks.content to zoo.staff;
   			exports zoo.animal.talks.media;
      			exports zoo.animal.talks.schedule;
	 		// no longer needed requires zoo.animal.feeding;
    			// no longer needed requires zoo.animal.care;
       			requires transtive zoo.animal.care;
	  	}
    	- finally, in the zoo.staff module we can get rid of two requires statements
     		module zoo.staff {
       			// no longer needed requires zoo.animal.feeding;
	  		// no longer needed requires zoo.animal.care
     			requires transitive zoo.animal.talks;
		}
  	the more modules you have, the greater the benefits of the requires transitive compound.
   	It is also more convenient for the caller. If you were trying to work with this zoo, you could just require zoo.staff and hae remaining dependencies automatically inferred.


Effects of requires transitive:

	- Given our new module declarations, what is the effect of applying the transitive modifier to the requires statement in our zoo.animal.care module?
 	- Applying the transitive modifiers has the following effects:
  		- Module zoo.animal.talks can optionally declare that it requires the zoo.animal.feeding module but it is not required.
    		- Module zoo.animal.care cannot be compiled or executed without access to the zoo.animal.feeding module.
      		- Module zoo.animal.talks cannot be compiled or executed without access to the zoo.animal.feeding module.
	- These rules hold even if the zoo.animal.care and zoo.animal.talks modules do not expliticly reference any packages in the zoo.animal.feeding module
	- on the other hand, without the transitive modifier in our module declaration of zoo.animal.care the other modules would have to explicitly use requires in order to reference any packages in the zoo.animal.feeding module.


 Duplicate requires statements:

 	One place the exam might trick you is mixing requires and requires transitive. Can you think of a reason this code doesn't compile?
  		module bad.module {
    			requires zoo.animal.talks;
       			requires transitive zoo.animal.talks;
	  	}
    	Java doesn't allow you to repeat the same module in a requires clause. It is redundant and most likely an error in coding. 
     	requires transitive is like requires + some extra behavior

opening a package:

	- Java allows callers to inspect and call code at runtime with a technique called reflection.
 	- Reflection is a powerful approach that allows calling code that might not be available at compile time. 
  	- It can be even used to subvert access control! 
   	- The opens directive is used to enable reflection of a package within a module.
    	- Since reflection can be dangerous, the module system requires developers to explicitly allow reflection in the module declaration if they want calling modules to be allowed to use it. The following shows how to enable reflection for two packages in the zoo.animal.talks module:
     		module zoo.animal.talks {
       			opens zoo.animal.talks.schedule;
	  		opens zoo.animal.talks.media to zoo.staff;
     		}
       	- The first example allows any module using this one to use reflection.
	- The second exmaple only gives the previlige to the zoo.staff module.
 	- There are two more directives - provides and uses.

Opening an entire module:

	- In previous example, we opened two packages in the zoo.animal.talks module but suppose we instead wanted to open all the packages for reflection. 
 	- We can use the open module modifier rather than the opens directive
  		open module zoo.animal.talks { }
    	- With this module modifier, Java knows we want all the packages in the module to be opened. what happens if you apply both together ?
     		open module zoo.animal.talks {
       			open zoo.animal.talk.schedule; // does not compile
	  	}
    	- This does not compile because a modifier that uses the open modifier is not permitted to use the opens directive. After all the packages are already open

Creating a Service:

	- A service is composed of an interface any classes the interface references and a way of looking up implementations of the interface.
 	- The implementations are not part of the service. 

Declaring the Service Provider Interface:

 	- First, the zoo.tours.api module defines a Java object called Souvenier. It is considered part of the service because it will be referenced by the interface
  		// Souvenier.java
    		package zoo.tours.api;
      		public record Souvenier(String description) {}
	- Next, the module contains a Java interface type. This interface is called the service provider interface because it species what behavior our service will have. In this case, it is a simple Api with three methods:
 		// Tour.java
   		package zoo.tours.api;
     		public interface Tour {
       			String name();
	  		int length();
     			Souvenier getSouvenier();
		}
  	- All three methods use the implicit public modifier. Since we are working with modules, we also need to create a module-info.java file so our module definition exports the package containing the interface.
   		// module-info.java
     		module zoo.tours.api {
       			exports zoo.tours.api;
	  	}
    	- Now that we have both files, we can compile and package this module
     		javac -d serviceProviderInterfaceModule serviceProviderInterfaceModule/zoo/tours/api/*.java serviceProviderInterfaceModule/module-info.java
       		jar --cvf mods/zoo.tours.api.jar -C serviceProviderInterfaceModule/ .
	- A service provider "interface" can be an abstract class rather than an actual interface.
 	- To review, the service includes the service provider interface and supporting classes it references.
  	- The service also includes the lookup functionality

Creating a Service Locator:

	- To complete our service, we need a service locator. A service locator can find any classes that implement a service provider interface.
 	- Java provides a ServiceLoader class to help with this task. You pass the service provider interface type to its load() method and Java will return any implementation services it can find. The following class shows it in action:
  		//TourFinder.java
    		package zoo.tours.reservations;
      		import java.util.*;
		import zoo.tours.api.*;
  		public class TourFinder {
    			public static Tour findSingleTour() {
       				ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
	   			for (Tour tour: loader)
       					return tour;
	    			retun null;
			}
   			public static List<Tour> findAllTours() {
      				List<Tour> tours = new ArrayList<>();
	  			ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
      				for (Tour tour: loader)		
	  				tours.add(tour);
       				return tours;
	   		}
      		}
	- As you can see, we provided two lookup methods. The first is a convenience method is you are expecting exactly one tour to be returned.
 	- The other returns a List, which accommodates any number os service providers. The other returns a List which accomodates any number of service providers.
  	- At runtime, there may be many service provider that are found by the service locator.
   	- The ServiceLoader call is relatively expensive. If you are writing a real application, it is best to cache the result.
    	- Our module definition exports the package with the lookup class TourFinder. it requires the service provider interface package. it also has the uses directive since it will be looking up a service.

       		// module-info.java
	 	module zoo.tours.reservations {
   			exports zoo.tours.reservations;
      			requires zoo.tours.api;
	 		uses zoo.tours.api.Tour;
    		}
      	- Remember that both requires and uses are needed, one for compilation and one for lookup. Finally, we compile and package the module
       		javac -p mods -d serviceLocatorModule serviceLocatorModule/zoo/tours/resservations/*.java serviceLocatorModule/module-info.java
	 	jar -cvf mods/zoo.tours.reservations.jar -C serviceLocatorModule/ .

Using ServiceLoader:

   	There are two methods in ServiceLoader that you need to know. The declaration is as follows, sans the full implementation:
    		public final class ServiceLoader<S> implements Iterable<S> {
      			public static <S> ServiceLoader<S> load(Class<S> service) {...}
	 		public Stream<Provider<S>> stream() {...}
    			// Additional methods
       		}
	 As we already saw, calling ServiceLoader.load() returns an object that you can loop through normally.
  	 However, requesting a Stream gives you a different type. 
    	 The reason for this is that a Stream controls when elements are evaluated.
      	 Therefore, a ServiceLoader returns a Stream of Provider objects.
	 You have to call get() to retrieve te value you wanted out of each Provider
  		ServiceLoader.load(Tour.class).stream().map(Provider::get).mapToInt(Tour::length)
    			.max().ifPresent(System.out::println);

Invoking from a Consumer:

	Next up is to call the service locator by a consumer.
 	A consumer or client refers to a modue that obtains and uses a service.
  	Once the consumer has acquired a service via the service locator, it is able to invoke the methods provided by the service provider interface.
   		//Tourist.java
     		package zoo.visitor;
       		import java.util.*;
	 	import zoo.tours.api.*;
   		import zoo.tours.reservations.*;
     		public class Tourist {
       			public static void main(String[] args) {
	  			Tour tour = TourFinder.findSingleTour();
      				System.out.println("Single Tour: " + tour);
	  			List<Tour> tours = TourFinder.findAllTours();
      				System.out.println("# tours: " + tours.size());
	  		}
     		}
       	Our module definition doesn't need to know anything about the implementation since the zoo.tours.reservations module is handling the lookup
	// module-info.java
 	module zoo.visitor {
  		requires zoo.tours.api;
    		requires zoo.tours.reservations;
      	}
       	This time we get to run a program after compiling and packaging:
	javac -p mods -d consumerModule consumerModule/zoo/visitor/*.java consumerModule/module-info.java
 	jar -cvf mods/zoo.visitor.jar -C consumerModule/ .
  	java -p mods -m zoo.visitor/zoo.visitor.tourist

Adding a Service Provider:

	- A service provider is the implementation of a service provider interface.
 	- At runtime it is possible to have multiple implementation classes or modules.
  	- Our service provider is the zoo.tours.agency package because we have outsourced the running of tours to a third party.
   		// TourImpl.java
     		package zoo.tours.agency;
       		import zoo.tours.api.*;
	 	public class TourImpl implements Tour {
   			public String name() { return "Behind the scenes"; }
      			public int length() { return 120; }
	 		public Souvenir getSouvenir() { return new Souvenir("Stuffed animal"); }
    		}
      		// module-info.java
		module zoo.tours.agency {
  			requires zoo.tours.api;
     			provides zoo.tours.api.Tour with zoo.tours.agency.TourImpl;
		}
  	The module declaration requires the module containing the interface as a dependency.
   	We don't export the package that implements the interface since we don't want callers referring to it directly.
    	Instead, we use the provides directive. This allows us to specify that we provide an implementation of the interface with a specific implementation class. The syntax looks like this:
     		provides interfaceName with className;
       We have not exported the package containing the implementation.
       Instead we have made the implementation available to a service provider using the interface.
       Finally, we compile it and package it up
       		javac -p mods -d serviceProviderModule serviceProviderModule/zoo/tours/agency/*.java servceProviderModule/module-info.java
	 	jar -cvf mods/zoo.tours.agency.jar -C serviceProviderModule/ .
   		java -p mods -m zoo.visitor/zoo.visitor.Tourist
     	Notice, how we didn't recompile the zoo.tours.reservations or zoo.visitor package.
      	The service locator was able to observe that there was now a service provider implementation available and find it for us.
       	This is useful when you have functionality that changes independently of the rest of code base.
	In software development, the concept of separating different components into standalonw pieces is referred to as loose coupling. One advantage of loosely coupled code is that it can be easily swapped out or replaced with minimal or zero changes to code that uses it. 
 	Relying on a loosely coupled structure allows service modules to be easily extensibe at runtime.

Reviewing Directives and Services:

	Artifact			Part of the service		Directives required
 	Service Provider Interface	Yes				exports
  	Service Provider		No				requires
   									provides
	Service locator			Yes				exports
 									requires
	  								uses
	Consumer			No				requires

 Reviewing Directives:

  	Directive						Description

    	exports package;			Makes package available outside module
     	exports package to module;	
      	requires module;			Specifies another module as dependency
       	requires transitive module;
	opens package;				Allows package to be used with reflection
 	opens package to module;		Makes service available
  	provides serviceInterface with implName;
   	uses serviceInterface;			References service

Discovering Modules:

	Even the classes built into the JDK are modularized.

Identifying Built-in modules:

  	The most important module to know is java.base
   	In fact, it is so important that you don't even have to use the requires directive; it is available to all modular applications. Your module-info.java file will still compile if you explicitly require java.base. However, it is redundant, so it's better to omit it

Common modules:

	ModuleName					What it contains
 	java.base				Collections, math, IO, NIO2, concurrency etc
  	java.desktop				AbstractWindowsToolkit(AWT) and Swing
   	java.logging				Logging
    	java.sql				JDBC
     	java.xml				Extensible Markup Language(XML)

Java modules prefixed with java

 	java.base
  	java.compiler
   	java.datatransfer
    	java.desktop
     	java.naming
      	java.net.http
       	java.prefs
	java.rmi
 	java.smartcardio
  	java.sql
   	java.sql.rowset
    	java.transaction.xa
     	java.instrument
      	java.logging
       	java.management
	java.management.rmi
 	java.scripting
  	java.se
   	java.security.jgss
    	java.security.sasl
     	java.xml
      	java.xml.crypto

Java modules prefixed with jdk

	jdk.accessibility
 	jdk.attach
  	jdk.charsets
   	jdk.compiler
    	jdk.crypto.cryptoki
     	jdk.crypto.ec
      	jdk.dynalink
       	jdk.editpad
	jdk.hotspot.agent
 	jdk.httpserver
  	jdk.incubator.foreign
   	jdk.incubator.vector
   	jdk.jartool
    	jdk.javadoc
     	jdk.jcmd
      	jdk.jconsole
       	jdk.jdeps
	jdk.jdi
 	jdk.jdwp.agent
  	jdk.jfr
   	jdk.jlink
    	jdk.jshell
     	jdk.jsobject
      	jdk.jstatd
       	jdk.localedata
	jdk.manegement
 	jdk.management.agent
  	jdk.management.jfr
   	jdk.naming.dns
    	jdk.naming.rmi
     	jdk.net
      	jdk.nio.mapmode
       	jdk.sctp
	jdk.security.auth
 	jdk.security.jgss
  	jdk.xml.dom
   	jdk.zipfs

Getting Details with Java:

	The java command has three module-related options.
 	Once describes a module, another lists the available modulles and the third shows the module resolution logic. It is also possible to add modules, exports, and more at the command line.

Describing a Module:

	- Suppose you are given the zoo.animal.feeding module JAR file and want to know about module
 	- You could unjar it and open the module-info.java file.
  	- This would show you that the module exports one package and doesn't explicitly require any modules.
   		module zoo.animal.feeding {
     			exports zoo.animal.feeding;
		}
  	- However, there is an easier way. The java command has an option to describe a module. The folowing two commands are equivalent.
   		java -p mods --describe-module zoo.animal.feeding
     	- Each prints information about module
      		zoo.animal.feeding file:///absolutePath/mods/zoo.animal.feeding.jar exports zoo.animal.feeding requires zoo.base mandated
	- The first line is the module we asked about: zoo.animal.feeding
 	- The second line starts with the information about the module. In our case, it is the same package exports statement we had in the method declaration file.
  	- On the third line we see requires java.base mandated. The module declaration very clearly does not specify any modules that zoo.animal.feeding has as dependencies.
   	- Remember that the java.base module is special. It is automatically added as a dependency to all modules. This module has frequently used packages like java.util. You get java.base regardless of whether you asked for it. 
    	- In classes, the java.lang package is automatically imported whether you type it or not. The java.base module works the same way. It is automatically available to all modules.

More about describing modules:

	- Assume the following are the contents of module-info.java in zoo.animal.care
 		module zoo.animal.care {
   			exports zoo.animal.care.medical to zoo.staff;
      			requires transitive zoo.animal.feeding;
	 	}
   	- Now we have the command to describe the module and the output
    		java -p mods -d zoo.animal.care

      		zoo.animal.care file:///absolutePath/mods/zoo.animal.care.jar
		requires zoo.animal.feeding transitive
  		requires java.base mandated
    		qualified exports zoo.animal.care.medical to zoo.staff
      		contains zoo.animal.care.details

 	- The first line of the output is the absolute path of the module file.
  	- The two requires lines should look familiar as well. The first is the module-info and the other is added to all modules. The qualified exports is the full name of the package we are exporting to a specific module. Finally, the contains means thet there is a package in the module that is not exported at all. This is true. Our module has two packages and one is available only to code inside the module.

Listing available modules:

	- In addition to describing modules, you can use the java command to list the modules that are available. The simplest form lists the modules that are part of the JDK
 		java --list-modules (Lists all the java modules)
   	- More interestingly you can use this command with custom code. Let's try again with the directory containing our zoo modules
    		java -p mods --list-modules
      	- If there are custom modules we get a location on the file system. If the project had a module version number, it would have both the version number and the file system path.
       	- Note that the --list-modules exists as soon as it prints the observables modules. it doesn't run program.

Showing Module Resolution:

	- If listing the modules doesn't give you enough output you can also use the --show-module-resolution option. You can think of it as a way of debugging modules. It spits out a lot of output when the program starts up. Then it runs the program
 		java --show-module-resolution -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task
   	- It starts by listing the root module. That's the one we are running: zoo.animal.feeding. Then it lists many lines of packages included by the mandatory java.base module. After a while, it lists modules that have dependencies. Finally, it outputs the result of the program: All fed!

Describing with jar:

	Like the java command, the jar command can describe a module. These commands are equivalent:
 		jar -f mods/zoo.animal.feeding.jar -d jar --file mods/zoo.anmal.feeding.jar --describe-module
   	The output is slightly different from when we used the java command to describe the module. With jar, it outputs the following:
    		zoo.animal.feeding jar:file:///absolutePath/mods/zoo.animal.feeding.jar/!module-info.class
      		exports zoo.animal.feeding
		requires java.base mandated
  	The JAR version includes the module-info.class in the filename, which is not a particularly significant difference in the scheme of things. 

Learning about dependencies with jdeps:

	- The jdeps command gives you information about dependencies within a module. Unlike describing a module, it looks at the code in addition to the module declaration. 
 	- This tells you what dependencies are actually used rather than simply declared. 
  	- You are expected to understand how to use jdeps with projects that have not been modularized to assist in identifying dependencies and problems. 
   	- First, we will create a JAR file from this class.
    	// Animatronic.java
     	package zoo.dinos;
      	import java.time.*;
       	import java.util.*;
	import sun.misc.Unsafe;
 	public class Animatronic {
  		private List<String> names;
    		private LocalDate visitDate;
      		public Animatronic(List<String> names, LocalDate visitDate) {
			this.names = names;
   			this.visitDate = visitDate;
      		}
		public void unsafeMethod() {
  			Unsafe unsafe = Unsafe.getUnsafe();
     		}
       	}
	- Now when we compile this file. you might have noticed that there is no module-info.java file. That is because we aren't creating a module. We are looking into what dependencies we will need when we do modularize this JAR.
 		javac zoo/dinos/*.java
   	- Compiling works, but it gives you some warnings about Unsafe being an internal API. Next, we create a JAR file.
    		jar -cvf zoo.dino.jar .
      	- We can run the jdeps command against the JAR to learn about its dependencies. First, let's run the command without any options. On the first two lines, the command prints the modules that we would need to add with a requires directive to migrate to the module system. It also prints a table showing what packages are used and what modules they correspond to.
       		jdeps zoo.dino.jar
	 	zoo.dino.jar -> java.base
   		zoo.dino.jar -> jdk.unsupported
     		zoo.dions -> java.lang 	java.base
       		zoo.dions -> java.time	java.base
	 	zoo.dions -> java.util	java.base
   		zoo.dinos -> sun.misc 	JDK Internal API (jdk unsupported)
     - Note that java.base is always included. It also says which modules contain classes used by the JAR.
     - If we run in summary mode, we only see just the first part where jdeps lists the modules.
     		jdeps -s zoo.dino.jar
       		jdeps -summary zoo.dino.jar
     - For a real project, the dependency list could include dozens or even hundreds of packages.
     - It's useful to see summary of just the modules. This approach also makes it easier to see whether jdk.unsupported is in the list.
     - There is also a --module-path option that you can use if you want to look for modules outside the JDK. Unlike other commands, there is no short form for this option on jdeps.
     - You might have noticed that jdk.unsupported is not in the list of modules. 
     - It's special because it contains internal libraries that developers in previous versons of Java were discouraged from using, although many people ignored this warning.

Using the --jdk-internals flag:

	- The jdeps command has an option to provide details about these unsupported APIs. 
 		jdeps --jdk-internals zoo.dino.jar
   		Output
     		zoo.dino.jar -> jdk.unsupported
       			zoo.dinos.Animatronic -> sun.misc.Unsafe
	  			JDK internal API (jdk.unsupported)

	- The --jdk-internals option lists any classes you are using that call an internal API along with which API. At the end, it provides a table suggesting that you should do about it.
 	- If you wrote the code calling the internal API, this message is useful.
  	- If not, the message would be useful to the team that did write the cde. 
   	- On the other hand, you need to update or replace that JAR file entirely with one that fixes the issue.
    	- Note that --jdkinternals is equivalent to --jdk-internals.

About sun.misc.Unsafe

	- Prior to the Java Platform Module system, classes had to be public, if you wanted them to be used outside the package. It was reasonable to use the class in JDK code since that is low level code that is already tight coupled to the JDK.
 	- Since it was needed in multiple packages, the class was made public. Sun even named it Unsafe figuring that would prevent anyone from using it outside JDK.
  	- The jdeps command allows you to look at these JARs to see whether you will see any problems when Oracle finally prevents the usage of this class. If you find any uses, you will look at whether there is a later version of the JAR that you can upgrade to.


Using Module files with jmod:

	- The final command is jmod. Oracle recommends using JAR files for most modules.
 	- JMOD files are recommended only when you have native libraries or something that can't go inside a JAR file. This is unlikely to affect you in real world.
  	- The most important thing to remember is that jmod is the only for working with the JMOD files.

    	Modes using jmod

     	Operation			Description
      	create				Creates the JMOD file
       	extract				Extracts all files from JMOD. Works like unzipping
	describe			Prints module details such as requires
 	list				Lists all the files in JMOD file.
  	hash				Prints or records hashes

Creating Java Runtimes with jlink:

	- One of the benefits of modules is being able to supply just the parts of Java you need.
 	- If the user already doesn't have Java or is on a device without much memory, downloading a JDK that is over 150MB is a big ask. This command creates our smaller distribution:
  	jlink --module-path mods --add-modules zoo.animal.talks --output zooApp
   	- First we specify where to find the custom modules with -p or --module-path. Then we specify our module names with --add-modules. This will include the dependencies it requires as long as they can be found.
    	- Finally, we specify the fold3er name of our smallest JDK with --output.
     	- The output directory contains the bin, conf, include, legal, lib and man directories along with a release file. These should look familiar as you find them in the full JDK as well.

Reviewing Command line options:

	Description					Syntax
 	Compile nonmodular code		javac -cp classpath -d directory classesToCompile
  					javac --class-path classpath -d directory classesToCompile
       					javac -classpath classpath -d directory classesToCompie
	Run nonmodular code		java -cp classpath package.className
 					java -classpath classpath package.className
      					java --class-path classpath package.className
	Compile module			javac -p moduleFolderName -d directory classesToCompileIncludingModuleInfo
 					javac --module-path moduleFolderName -d directory classesToCompileIncludingModuleInfo
      	Run module			java -p moduleFolderNmae -m moduleName/package.className
       					java --module-path moduleFolderName --module moduleName/package.className
	Describe module			java -p moduleFolderName -d moduleName
 					java --module-path moduleFolderName --describe-module moduleName
      					jar --file jarName --describe-module
	   				jar -f jarName -d
	List available modules		java --module-path moduleFolderName --list-modules
 					java -p moduleFolderName --list-modules
      					java --list-modules
	View Dependencies		jdeps -summary --module-path moduleFolderName jarName
 					jdeps -s --module-path moduleFilderName jarName
      					jdeps --jdk-internals jarName
	   				jdeps -jdkinternals jarName
	Show modulle resolution		java --show-module-resolution -p moduleFolderName -m moduleName
 					java --show-module-resolution --module-path moduleFolderName --module moduleName
      	Create runtime JAR		jlink -p moduleFolderName --add-modules moduleName --output zooApp
       					jlink --module-path moduleFolderName --add-modules moduleName --output zooApp


javac:  

   	Option				Description
    	-cp<classpath>			Location of JARs in a nonmodular program
     	--classpath<classpath>	
      	--class-path<classpath>
       	-d <dir>			Directory in which to place generated class files
	-p <path>			Location of JARs in a modular program
 	--module-path<path>

java:

 	-p <path>			Location of JARs in modular program	
  	--module-path<path>		
   	-m <name>			Module name to run
    	--module<name>	
     	-d 				Describes details of module
      	--describe-module
  	--list-modules			Lists observable modules without running program
   	--show-module-resolution	Shows modules when running program

jar

	-c				Creates new JAR file
 	--create
  	-v				Prints details when working with JAR files
   	--verbose
    	-f				JAR filename
     	--file
      	-C				Directory containing files to be used to create JAR
       	-d				Describes details of module
	--describe-module

jdeps

	--module-path <path>		Location of JARs in modular program
 	-s				Summarized output
  	-summary	
   	--jdk-internals			Lists uses of internal APIs
    	-jdkinternals

jlink

	-p				Location of JARs in modular program
 	--module-path <path>
  	--add-modules			List of modules to package
   	--output			Name of output directory

Comparing types of modules:

	There are two other types of modules: automatic modules and unnamed modules. 

Named Modules:

	- A named module is one containing a module-info.java file. 
 	- To review this file appears in the root of thr JAR alongside one or more packages.
  	- Unless otherwise specified, a module is a named module. 
   	- Named modules appear on the module path rather than the classpath. 
    	- As a way of remembering this, a named module has the name inside module-info.java file and is on the module path.

Automatic Modules:

	- An automatic module appears on the modulepath but does not contain a module-info.java file.
 	- It is simply a regular JAR file that is placed on the module path and gets treated as a module.
  	- As a way of remembering this, Java automatically determines the module name.
   	- The code referencing an automatic module treats it as if there is a module-info.java file present.
    	- It automatically exports all packages. It also determines the module name.
     	- How does it determine the module name? To answer this, we need to provide a bit of history on JAR files and module adoption
      	- Every JAR file contains a special folder called META-INF and within it, a text file called MANIFEST.MF
       	- It can be created automatically when the JAR is created or by hand or by the JAR's author.
	- Getting back to modules, many Java libraries weren't quite ready to modularize when the feature was introduced.
 	- The authors were encouraged to declare the name they intended to use for the module by adding a property named Automatic-Module-Name into their Manifest.MF file.


About the MANIFEST.MF file:

	A JAR file contains a special text file called META-INF/MANIFEST.MF that contains information about the JAR.
 	It is been around significantly longer than modules - since the early days of Java and JARs to be exact
  		zoo -> META-INF	---> sales -> healthy
			|		   -> data
   		      MANIFEST.MF
	The manifest contains extra information about the JAR file. 
 	For example, it often contains the version of Java is used to build the JAR file
  	For command-line programs, the class with the main() method is commonly specified.
   	Each line in the manifest is a key/value pair separated by a colon.
    	You can think of the manifest as a map of property names and values.
     	The default manifest in Java 17 looks like this
      			Manifest-version: 1.0
	 		Created-By: 17 (Oracle Corporation)
    	Specifying a single property in the manifest allowed library providers to make things easier for applications that wanted to use their library in a modular application.
     	You can think it of as a promise that when the library becomes a named module it will use the specified module name.
      	If the JAR file does not specify an automatic module name, Java will still allow you to use it in the module path.
       	In this case, Java will determine the module name for you
	Java determines the automatic module name by basing it on the filename of the JAR file. Suppose we have a JAR file named holiday-calendar-1.0.0.jar
 	First Java will remove the extension.jar 
  	Then Java will remove the version from the end of the JAR filename. This is important because we want module names to be consistent. Having a different automatic module name everytime you upgraded to a new version would not be good.
   	This would force you to change the module declaration of your nice, clean modularized application everytime you pulled in later version JAR.
    	Removing the version and extension gives us holiday-calendar. This leaves us with a problem.
     	Dashes are not allowed in module names. Java solves this problem by converting any special characters in the name of dots.
      	As a result, the module name is holiday.calendar. Any characters other than letters and numbers are considered special characters in this replacement. Finally, any adjacent dots or leading/trailing dots are remobed.
       	Since that's number of rules let's review the algorithm in a list for determining the name of an automatic module:
		- If the MANIFEST.MF specifies an Automatic-Module-Name use that. Otherwise proceed with the remaining rules
  		- Remove the file extension from the JAR name
    		- Remove any version information from the end of the name. A version is digits and dots with possible extra information at the end
      		- Replace any remaining characters other than letters and numbers with dots
		- Replace any sequences of dots with a single dot
  		- Remove the dot if it is the first or last character of the result.

Practicing with automatic module name:

	Beginning with JAR name			commons2-x-1.0.0-SNAPSHOT.jar		mod_$_1.0.jar
 	Remove file extension			commons2-x-1.0.0-SNAPSHOT		mod_$_1.0
  	Remove version information		commons2-x				mod_$
   	Replace special characters		commons2.x				mod..
    	Replace sequence of dots		commons2.x				mod.
     	Remove leading/trailing dots		commons2.x				mod
    	
 Unnamed Modules:

 	- An unnamed module appears on the classpath.
  	- Like an automatic module, it is a regular JAR. 
   	- Unlike an automatic module, it is on the classpath rather than the modulepath.
    	- This means an unnamed module is treated like old code and a second-class citizen to modules.
     	- An unnamed module does not usually contain module-info.java file. If it happens to contain one, that file will be ignored since it is on the classpath.
      	- Unnamed modules do not export any packages to named or automatic modules.
       	- The unnamed module can read from any JARs on the classpath or module path.
	- You can think of an unnamed module as code that works the way Java worked before modules.

Reviewing Module Types:

	A key point to remember is that code on the classpath can access the module path.
 	By contrast, code on the module path is unable to read from classpath.

 	Property							Named			Automatic	Unnamed
   	Does a _____ module contain a module-info.java file?		Yes			No		Ignored if present
    	Which package does a ____ module export to other modules	Those in 		All packages	No packages
     									module-info.java file
	Is a ___ module readable by other modules on the modulepath	Yes			Yes		No
 	Is a ___ module readable by other JARs on the classpath?	Yes			Yes		Yes

Migrating an Application:

	- Many applications were not designed to use the Java Platform Module Syste, because they were written before it was created
 	- Ideally, they were atleast designed with projects instead of big ball of mud. 
  	- Overview of strategies for migrating an existing application to use modules. - bottom-up migration, top-down migration

   	-In the real world, applications have libraries that haven't been updated in 10 or more years
    	- Note that you can use all the features of Java17 without converting your application to modules.

Determining the order:

	- Before we can migrate our application to use modules, we need to know how the packages and libraries in the existing application are structured.
 	- The dependencies between projects form a graph. The arrow shows the dependencies by pointing from the project that will require the dependency so the one that makes it available.

				  |-> chicken 				chicken ----->  				
  			nest -----					   |	     |
     				  |-> egg				 nest	     |
	   								   |	     |
									  egg <-------   
	- The right side of the diagram makes it easier to identiy the top and bottom that top-down and bottom-up migration refer to.
 	- Projects that do not have any dependencies are at the bottom.
  	- Projects that do have dependencies are at the top.
   	Determining the order when not unique:

    		chicken		penguin				chicken ----> 			penguin ------|
		   |		   |				   	    |			              |
	 	   |--->egg<-------|				penguin	    |			chicken       |
      								   |	    |                                 |
		 						  egg ------|			  egg --------|

Exploring a Buttom-Up migration strategy:

	- The easiest approach to migration is a bottom-up migration.
 	- This approach works best when you have the power to convert any JAR files that aren't already modules.
  	- For bottom-up approach migration, you follow these steps:
   		1. Pick the lowest level project that has not yet been migrated.
     		2. Add a module-info.java file to the project. Be sure to add any exports to exposure any package used by higher-level JAR files. Also, add a requires directive for any modules this module depends on.
       		3. Move this newly migrated named module from the classpath to the modulepath
	 	4. Ensure that any projects that have not yet been migrated stay as unnamed modules on the classpath.
   		5. Repeat with the next-lowest level project until you are done.
     	- With a bottom up migration, you are getting the lower-level projects in good shape. This makes it easier to migrate the top-level projects at the end. During migration, you have a mix of named modules and unnamed modules. The named modules are the lower level ones that have been migrated. They are on the module path and not allowed to access any unnamed modules.
      	- The unnamed modules are on the classpath. They can access JAR files on both the classpath and the module path.

Exploring a Top-Down Migration Strategy:

	- A top-down migration strategy is most useful when you don't have control of every JAR file used by your application.
 	- They are just too busto to migrate. You wouldn't want this situation to hold up your entire migration. 
  	- For a top-down migration follow these steps:
   		1. Place all projects on the module path
     		2. Pick the highest level project that has not yet been assigned.
       		3. Add a module-info.java file to that project to convert the automatic module into named module.
	 	4. Again, remember to add any exports or requires directives.
   		5. You can use the automatic module name of other modules when writing the requires directive since most of the projects on the module path do not have names yet.
     		6. Repeat with the next-higher level project until you are done.
       		7. With a top-down migration, you are conceding that all of the lower-level dependencies are not ready but that you want to make the application itself a module.
	 	8. During migration, you have a mix of named modules and automatic modules.
   		9. The named modules are the higher level ones that have been migrated. They are on the module path and have access to the automatic modules. The automatic modules are also on the module path.


Comparing migration Strategies:

	Category				Bottom-Up				Top-Down

  	Project that depends on all others	Unnamed module on classpath		Named Module on module path
   	Project that has no dependencies	Named module on module path		Automatic module on module path


Splitting a Big Project into odules:

	- There is a problem with this decomposition.
 	- The Java Platform Module System does not allow for cyclic dependencies.
  	- A cyclic dependency or circular dependency is when two things directly or indirectly depend on each other. 
   	- What if decomposition doesn't work? A common technique is to introduce another module. That module contains the code that the other two modules. 


Introducing Threads:

	- Computers are capable of reading, writing data to external sources.
 	- Unfortunately, as compared to CPU operations, these disk/network operations tend to be extremely slow.
  	- In fact, that if your computer's operatig system were to stop and wait for every disk or network operation to finish, your computer would appear to freeze constantly.
   	- Luckily, all operating systems support what is known as multithreaded processing. 
    	- The idea behind multithreaded processing is to allow an application or group of applications to execute multiple tasks at the same time. This allows tasks waiting for other resources to give way to other resources to give way to other processing requests.
     	- Threads provide numerous ways using the Concurrency API. Threads and concurrency are challenging topics for many programmers to grasp, as problems with threads can be frustrating even for developers.
      	- In practice, concurrency issues are among the most difficult problems to diagnose and resolve.

       	- A thread is the smallest unit of execution that can be scheduled by the operating system.
	- A process is a group of associated threads that can execute in the same thread environment.
 	- It follows then, that a single threaded process is one that contains exactly one thread whereas a multi threaded process supports more than one thread.
  	- By shared enironment, we mean that the threads in the same process share the same memory space and can communicate directly with one another.

   						Process(Java Program)
	 		------------------------>Shared Memory<---------------------------
    				|			|			|
			      Thread		       Thread		      Thread
	 		----------------------> OS Thread Scheduler <---------------------
    				|						|	
				CPU1		 	...			CPUn
    	-Above figure for an overview of threads and their shared environment within a process
     	- This figure shows a single process with three threads. It also shows how they are mapped to an rbitary number of n CPUs available within the system.
      	- A task is a single unit of work performed by a thread. A task will commonly be implemented as a lambda expression.
       	- By shared memory we are generally referring to static variables as well as instance and local variables passed to a thread.
	- Yes, you finally see how static variables can be useful for performing complex, multithreaded tasks.
 	- Methods that static methods and variables are defined on a single class object that all instances share.
  	- For example, one thread updates the value of a static object, this information is immediately available for other threads within the process to read.


Understanding Thread Concurrency:

	- The property of executing multiple threads and processes at the same time s referred to as concurrency.
 	- How does the system decide to execute when there are more threads available than CPUs?
  	- Operating systems use a thread scheduler to determine which threads should be currently executing
   	- For example, a thread scheduler may employ a round-robin schedule in which each thread receives an ewual number of CPU cycles with which to execute with threads visited in a circular order.
    	- When a thread's alloted time is complete but the thread has not finished processing, a context switch occurs.
     	- A context switch is the process of storing a thread's current state and later restoring the state of the thread to continue execution. Be aware that a cost is often associated with a context switch due to lost time and having to reload a thread's state. 
      	- Intelligent thread schedulers do their best to minimize the number of context switches while keeping an application running smoothly. 
       	- Finally, a thread can interrupt or supersede another thread if it has a higher thread priority other than the other thread.
	- A thread priority is a numeric value associated with a thread that is taken into consideration by the thread scheduler when determining which threads should currently be executing.
 	- In Java, thread priorities are specfied as integer values.


Creating a Thread:

	- One of the most common ways to define a task for a thread is by using the Runnable instance. 
 	- Runnable is a functional interface that takes no arguments and returns no data.
  			@FunctionalInterface
     			public interface Runnable { void run(); }
	- With this, it's easy to create and start a thread. In fact, you can do so in one line of code using the Thread class
 			new Thread(() -> System.out.println("Hello")).start();
    			System.out.println("World");
       	- The first line creates a new Thread object and then starts it with the start() method. 
	- Does this compile HelloWorld or WorldHello ? The answer is that we don't know.
 	- Depending on the thread priority/scheduler either is possible. Remember that the order of thread execution is often not guaranteed. 

  			Runnable printInventory = () -> System.out.println("Printing zoo inventory");
     			Runnable printRecords = () -> {
				for (int i=0; i<3; i++) {
    					System.out.println("Printing Record " + i);
	 		};
    	- Given these instances what is the output of the following?
     		System.out.println("begin");
       		new Thread(printInventory).start();
	 	new Thread(printRecords).start();
   		new Thread(printInventory).start();
     		System.out.println("end");
       - The sample uses a total of four threads the main() user thread and three additional threads. 
       - Each thread created on these lines is executed as an asynchronous task.
       - By asynchronous, we mean that the thread executing the main() method does not wait for the results of each newly created thread before continuing. The opposite of this is the synchronous task in which the program waits for the thread to finish before moving on to the next line. 
       - While the order of thread execution is indeterminate once the threads have been the started, the order within a single thread is still linear. In particular, the for() loop is still ordered. Also, begin always appears before end.

Calling run() instead of start():

	- Calling run() on thread or a Runnable does not start a new thread. While the following code snippets will compile, none will execute a task on a separate thread.

 			System.out.println("begin");
    			new Thread(printInventory).run();
       			new Thread(printRecords).run();
	  		new Thread(printInventory).run();
     			System.out.println("end");

 	- Unlike the previous example, each line of the code will wait until the run() method is complete before moving onto the next line. Also, unlike the previous program, the output for this code sample will be the same everytime it is executed.
  	- More generally we can create a Thread and its associated task in two ways in Java:
   		- Provide a Runnable object or lambda expression to the Thread constructor.
     		- Create a class that extends Thread and overrides the run() method.


Distinguishing Thread Types:

	- All Java applications including atr multithreaded because they include system threads.
 	- A system thread is created by the Java Virtual Machine and runs in the background of the application.
  	- For example, a garbage collection is managed by a system thread created by the JVM.
   	- Alternatively, a user-defined thread is one created by the application developer to accomplish a specific task.
    	- The majority of the programs we have presented so far have contained only one user-defined thread, which calls the main() method. For simplicity, we commonly refer to programs that contain only a single user-defined thread as single threaded application.
     			public class Zoo {
				public static void pause() { // Defines the thread task
    					try {
	 					Thread.sleep(10_000);
       					} catch (InterruptedException ex) {
	    					System.out.println("Thread finished..");
	  				}
       				}
	   			public static void main(String[] unused) {
       					var job = new Thread(() -> pause()); // Create thread
	    				job.start();
	 				System.out.println("Main thread finished!"); // Start thread
      				}
	  		}
     	- Even though the main() method is done, the JVM will wait for the user thread to be done before ending the program.
      	- What if we change job to be a deamon thread 
       				job.setDaemon(true);


Managing a Thread's life cycle:


	- After a thread has been created, it is one of the six states. You can query a thread's state by calling getState() on the thread object.

 		Create Thread
   		      |
	   	     NEW  ------------start()----------> RUNNABLE----------------run()-----------------> TERMINATED
	  Created but not started		Running or able to be run------				Task Complete
  						|   |	 |	 	|        |-----------------------
		Resource Requested <--------------  |	wait()		|	sleep()			| Time elapsed
			|	    		    |	 |		|	|-------------------TIMED_WAITING
   		      BLOCKED ----Resource Granted--|	 WAITING-----notify()			Waiting a specified time
	      Waiting to enter synchronized block     Waiting indefinitely to be notifed
       		

	- Every thread is initialized with a NEW state
 	- As soon as start() method is called, the thread is moved to a RUNNABLE state.
  	- Does that mean it is actually running? Not exactly, it may be running or it may not be.
   	- The RUNNABLE state just means the thread is able to run.
    	- Once the work for the thread is completed or an uncaught exception is thrown, the thread state becomes TERMINATED and no more work is performed.
     	- While in a RUNNABLE state, the thread may transition to one of three states where it pauses its work: BLOCKED, WAITING, TIMED_WAITING. The above figure includes common transitions between thread states, but there are other possibilities.
      	- For example, a thread in WAITING state might be triggered by notifyAll().
       	- Likewise, a thread that is interrupted by another thread will exit TIMED_WATHCING and go straight into RUNNABLE.
	- Some thread methods such as wait(), notify() and join(). You should avoid them and use the CONCURRENCY APIs as much as possible. 


 Polling with Sleep:

 	Even though multithreaded programming allows you to execute multiple tasks at the same time, one thread often needs to wait for the results of another thread to proceed. One solution is to use polling.
  	Polling is the process of intermittently checking data at some fixed interval.
   	Let's say you have a thread that modifies a shared static ounter value and your main() thread is waiting for the thread to reach 1 million

    			public class CheckResults {
       				private static int counter = 0;
	   			public static void main(String[] args) {
       					new Thread(() -> {
						for(int i=0; i<1_000_000; i++) counter++;
      					}).start();
	   				while (counter <1_000_000) {
						System.out.println("Not reached yet");
      					}
	   				System.out.println("Reached: " + counter);
				} }
    	Using while loop to check for data without some kind of delay is considered a bad coding practice as it ties up CPU resources for no reason. We can improve this result by using the Thread.sleep() method to implement polling and sleep for 1000 milliseconds.

	While polling does prevent the CPU from being overwhelmed with a potentially infinite loop, it does not guarantee when the loop will terminate. For example, the separate thread could be loosing CPU time to a higher priority process resulting in multple executions of the while() loop before it finishes.
 	Another issue to be concerned about is the shared counter variable. What if one thread is reading the counter variable while another thread is writing it? The thread reading the shared variable may end up with an invalid or unexpected value.


Interrupting a Thread:

	- While our previous solution prevented the CPU from waiting endlessly on a while() loop, it did come at the cost of inserting a one-second delays into our program
 	- If the task takes 2.1 seconds to run, the program will use the full 3 seconds, wasting 0.9 seconds.
  	- One way to improve the program is to allow the thread to interrupt the main() thread when it's done
   	- The improved version includes both sleep() to avoid tying up the CPI and interrupt() so the thread's work ends without delaying the program.
    	- As before, our main() thread's state alternates between TIMED_WAITING and RUNNABLE.
     	- Calling interrupt() on a thread in the TIMED_WAITIING or WAITING state causes the main() thread to become RUNNABLE again, triggering an InterruptedException. The thread may also move to a BLOCKED state if it needs to reacquire when it wakes up.
      	- Calling interrupt() on a thread already in RUNNABLE state doesn't change the state. 
       	- In fact, it only changes the behavior if the thread is periodically checking the Thread.isInterrupted() value state.


 Creating Threads with the Concurrency API:

 	- Java includes the java.util.concurrenct package which we refer to as the Concurrency API to handle the complicated work of managing threads for you. The Concurrency API includes the ExecutorService interface which defines services that create and manage threads.
  	- You first obtain an instance of an ExecutorService interface and then you can send the service tasks to be processed.
   	- The framework includes numerous useful features such as thread pooling and scheduling.
    	- It is recommended that you use this framework anytime you need to create and execute a separate task even if you need only a single thread.
     	- When writing multithreaded programs in practice, it is often better to use the Concurrency API for some other multithreaded SDK rather than work with Thread objects directly. The libraries are much more robust, and it is easier to handle complex interactions.


Introducing the Single Thread Executor:

	- Since ExecutorService is an interface, how do you obtain an instance of it? The ConcurrencyAPI includes the Executors factory class that can be used to create instances of the ExecutorService object. 
 	Let's rewrite our earlier example with the two Runnable instances to using an ExecutorService:

    		ExecutorService service = Executors.newSingleThreadExecutor();
      		try {
			System.out.println("begin");
   			service.execute(printInventory);
      			service.execute(printRecords);
	 		service.execute(printInventory);
    		} finally {
      			service.shutdown();
	 	}
   	In this example, we are using the newSingleThreadExecutor() method to create the service.
    	Unlike our earlier example, in which we had four threads one main() and three new threads, we have only two threads here one main() and one new thread. This means that the output will still be unpredictable will have less variation than before. 

     	With single-thread executor, tasks are guaranteed to be executed sequentially. 

Shutting down a Thread Executor:

	- Once you have finished using a thread executor, it is important that you call the shutdown() method. 
 	- A thread executor creates a non daemon thread on the first task that is executed, so failing to call shutdown() will result in your application never terminating.
  	- The shutdown process for a thread executor will continue to execute any previously submitted tasks.
   	- During this time, calling the isShutDown() will return true, while isTerminated() will return false.
    	- If a new task is submitted to the thread executor while it is shutting won, a RejectedExecutionException will be trown.
     	- Once all active tasks have been completed, isShutDown() and isTerminated() will both return true.

      	ExecutorService Lifecycle:


       		New Executor Service
	 		|
    		      ACTIVE -------shutdown()----> SHUTTING DOWN --------All Tasks Finished---> Shutdown
	    	Accepts new tasks		Rejects new tasks				Rejects new tasks
      		Executes tasks			Executes tasks					No tasks running
		isShutDown() - false		isShutDown() - true				isShutDown() - true
  		isTerminated()-false		isTerminated() - false				isTerminated()- true

    	- shutdown() does not stop any tasks that have already been submitted to the thread executor.
     	- What if you want to cancel all running and upcoming tasks ? The ExecutorService provides a method called shutDownNow() which attempts to stop all running tasks and discard any that have not been started yet. It is not guaranteed to succeed because it is possible to create a thread that will never terminate, so any attempt to interrupt it may be ignored.
	- Resources such as thread executors should be properly closed to prevent memory leaks.
 	- Unfortunately, the ExecutorService interface does not extend the AutoCloseable interface, so you cannot use try-with-resources statement. You can still use a finally block as we do throughout. 
  	- While you are not required to use a finally block it is considered a good practice to do so.

Submitting Tasks:

	- You can submit tasks to an ExecutorService instance multiple ways. The first method we presented, execute() is inherited from the Executor interface which the ExecutorService interface extends.
 	- The execute() method takes a Runnable instance and completes the task asynchronously.
  	- Because the return type of the method is void, ir does not tell us anything about the result of the task.
   	- It is considered a fire and forget method as once it is submitted the results are not dieectly available to calling thread.
    	- Fortunately, the writers of Java added submit() methods to the ExecutorService interface which like execute() can be used to complete tasks asynchronously. 
     	- Unlike execute() though submit() returns a Future instance that can be used to determine whether the task is complete. 
      	- It can also be used to return a generic result object after the task has been completed.
       	- The below table shows five methods including execute() and two submit() methods. 
	- In practice, using the submit() method is quite similar to using the execute() methood except that the submit() method returns a Future instance that can be used to determine whether the task has completed execution


ExecutorService methods:

	Method name								Description

 	void execute(Runnable command)		Executes Runnable task at some point in future
  	Future<?> submit(Runnable task)		Executes Runnable task at some point in future and returns Future representing task
   	<T> Future<T> submit(Callable<T> task)	Executes Callable Task at some point in future and returns Future representing 							pending results of task
    	<T> List<Future<T>> invokeAll(		Executes given tasks and waits for all tasks to complete. Returns List of Future
     	Collection<? extends 			instances in same order in which they were in original collection.
      	Callable<T>> tasks)
       	<T> T invokeAny(			Executes given tasks and waits for at least one to complete
	Collection<? extends 
 	Callable<T>> tasks)
      	

Submitting Tasks: execute() vs submit():

	- As you might have noticed, the execute() and submit() methods are nearly identical when applied to Runnable expressions.
 	- The submit() method has the obvious advantage of doing the same thing execute() does, but with a return object that can be used to track the result.
  	- Because of this advantage and the fact that execute() even if we don't store the Future reference.


Waiting for Results:

	- How do we know when a task is submitted to an ExecutorService is complete?
 	- As mentioned in the previous section, the submit() method returns a Future<V> instance that can be used to determine this result.
  		Future<?> future = service.submit(() -> System.out.println("Hello"));
    	- The Future type is actually an interface.

Future Methods:

	Method name							Description

  	boolean isDone()				Returns true if task was completed threw exception or was cancelled
   	boolean isCancelled()				Returns true if task was cancelled before it completed normally
    	boolean cancel(boolean mayInterruptIfRunning)	Attempts to cancel execution of task, returns true if cancelled else false.
     	V get()						Retrieves result of task, waiting endlessly if it is not yet available
      	V get(long timeout, TimeUnit unit)		Retrieves result of task, waiting specified amount of time. If result is not 							ready by time checkout is reached, checked TimeoutException will be thrown.


		import java.util.concurrent.*;
  		public class CheckResults {
    			private static int counter = 0;
       			public static void main(String[] unused) throws Exception {
	  			ExecutorService service = Executors.newSingleThreadExecutor();
      				try {
	  				Future<?> result = service.submit(() -> {
       						for(int i=0; i<1_000_000; i++) counter++;
	     				});
	  				result.get(10, TimeUnit.SECONDS); // Returns null for Runnable
       					System.out.println("Reached!");
	    			} catch (TimeoutException ex) {
					System.out.println("Not reached in time");
     				} finally {
	 				service.shutdown();
      				}
	  		}
     		}

	In part, this is the essence of the Concurrency API: to do complex things with threads without having to manage threads directly. It also waits for 10 seconds throwing a TieoutException on the call to result.get() if the task is done.
 	What is the return value of this task? As Future<V> is a generic interface, the type V is determined by the return type of the Runnable method. Since the return type of Runnable.run() is void, the get() method always returns null when working with Runnable expressions. The Future.get() method can take an optional value and enum type java.util.concurrent.


TimeUnit values:

			Enum name					Description
		
		 	TimeUnit.NANOSECONDS			Time in one-billionth of a second
		  	TimeUnit.MICROSECONDS			Time in one-millionth of a second
		   	TimeUnit.MILLISECONDS			Time in one-thousandths of a second 
		    	TimeUnit.SECONDS			Time in Seconds
		     	TimeUnit.MINUTES			Time in minutes
		      	TimeUnit.HOURS				Time in hours
		       	TimeUnit.DAYS				Time in days


Introducing Callable:

	- The java.util.concurrent.Callable functional interface is similar to Runnable except that its call() method returns a value and can throw a checked exception. The following is the definition of the Callable interface:
			@FunctionalInterface
   			public interface Callable<V> {
      				V call() throws Exception;
	  		}
     	- The Callable interface is often preferable over Runnable, since it allows more details to be retrieved easily from the task after it is completed. That said, we use both interfaces as they are interchangeable in situations where the lambda does not throw an exception and there is no return type. 
      	- Luckily, the ExecutorService includes an overloaded version of the submit() method that takes a Callable object and returns a generic Future<T> instance.
       	- Unlike Runnable, in which the get() methods always return null, the get() methods on a Future instance return the matching generic type(which could also be a null value)
	- Let's take a look at an example using Callable:
		var service = Executors.newSingleThreadExecutor();
  		try {
    			Future<Integer> result = service.submit(()-> 30+11);
       			System.out.println(result.get()); // 41
	  	} finally {
    			service.shutdown();
       		}
	 - We could rewrite this example using Runnable some shared object and an interrupt() or timed wait, but this implementation is a lot easier to code and understand.


Waiting for All tasks to finish:

	- After submitting a set of tasks to a thread executor, it is common to wait for the results.
 	- One solution is to call get() on each Future object returned by the submit() method.
  	- If we don't need the results of the tasks and are finished using our thread executor there is a simpler approach.
   	- First, we shutdown the thread executor using the shutdown() method.
    	- Next, we use the awaitTermination() method available for all thread executors. 
     	- The method waits the specified time to complete all tasks returning sooner if all tasks finish or an InterruptedException is detected. 
      		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
  			// Add tasks to the thread executor
     			...
		} finally {
  			service.shutdown();
     		}
       		service.awaitTermination(1, TimeUnit.MINUTES);
	 	// Check whether all tasks are finished
   		if (service.isTerminated()) 
     			System.out.println("Finished");
		else
  			System.out.println("At least one task is still running!!");

      	- In this example, we submit a number of tasks to the thread executor and then shutdown the thread executor and wait up to one minute for the results. Notice that we can call isTerminated() after the awaitTermination() method finishes to confirm that all tasks are finished. 


Scheduling Tasks:

	- Often in Java, we need to schedule a task to happen at some future time.
 	- We might even need to schedule the task to happen repeatedly, at some set interval.
  	- ScheduledExecutorService which is a subinterface of ExecutorService can be used for just such a task.
   	- Like ExecutorService, we obtain an instance of ScheduledExcutorService using a factory method in the Executors class
    		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
      	- We could store an instance of ScheduedExecutorService is an ExecutorService variable, although doing so woule mean we would have to cast the object to call any scheduling methods.

       ScheduledExecutorService methods:


       schedule(Callable<V> callable, long delay, TimeUnit unit):
       		Creates and executes Callable task after given delay
       schedule(Runnable command, long delay, TimeUnit unit)
       		Creates and executes Runnable task after given delay
       schedueAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
       		Creates and executes Runnable task after given initial delay, creating new task every period value that passes
       scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
       		Creates and executes Runnable task after given initial delay and subsequently with given delay between termination of 		one execution and commencement of next.

  	- In practice, these methods are among the most convenient in the ConcurrencyAPI as they perform relatively complex tasks with a single line of code. 
   	- The delay and period parameters rely on the TimeUnit argument to determine the format of the value, such as seconds or milliseconds.
    	- The first two schedule() methods take a Callable or Runnable respectively, perform the task after some delay and return a ScheduledFuture instance. The ScheduledFuture interface is identical to the Future interface except that it includes a getDelay() method that returns the remaining delay. The following uses the schedule() method with Callable and Runnable tasks:

      		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Hello Zoo");
  		Callable<String> task2 = () -> "Monkey";
    		ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
      		ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES);
	- The first task is scheduled 10 seconds in the future, whereas the second task is scheduled 8 minutes in the FUTURE.

 	- While these tasks are scheduled in future, the actual execution may be delayed.
  	- For examle there may be no threads available to perform the tasks at which point they will just wait in the queue.
   	- Also, if the ScheduledExecutorService is shutdown by the time the scheduled task execution time is reached, then these tasks will be discarded.
    	- Each of the ScheduledExecutorService methods is important and has real-world applications.
     	- For example, you can use the schedule() command to check on the state of cleaning a lion's cage.
      	- It can then send out notifications if it is not finished or even call schedule() to check again later.
       	- The scheduleAtFixedRate() method creates a new task and submits it to the executor every period, regardless of whether the previous task finished. The following example executes a Runnable task every minute, following an initial five-minute delay:
		service.scheduleAtFixedRate(command, 5, 1, TimeUnit.MINUTES);
  	- The scheduleAtFixedRate() method is useful for tasks that need to be run at specific intervals.
   	- On the other hand, the scheduleWithFixedDelay() method creates a new task only after the previous task has finished.
    	- The scheduleWithFixedDelay() method is useful for processes that you want to happen repeatedly.

Increasing Concurrency with Pools:

	
	- We now present three additional factory methods in the Executors class that act on a pool of threads rather than on a single thread.
 	- A thread pool is a group of pre-instantiated reusable threads that are available to perform a set of arbitary tasks.
  	- Below table includes our two previous single thread executor methods along with the new ones.

   	Executors Factory Methods:

     	ExecutorService newSingleThreadExecutor():
      		Creates single-threaded executor that uses single worker thread operating off unbounded queue.
		Results are processed sequentially in order in which they are submitted.
      	ScheduledExecutorService newSingleThreadScheduledExecutor():
       		Creates single-threaded executor that can schedule commands to run after given delay or to execute periodically
       	ExecutorService newCachedThreadPool():
		Creates thread pool that creates new threads as needed but reuses previously constructed threads when they are available
	ExecutorService newFixedThreadPool(int):
 		Creates thread pool that reuses fixed number of threads operating off shared unbounded queue
 	ScheduledExecutorService newScheduledThreadPool(int)
  		Creates thread pool that schedule commands to run after given delay or execute periodically.

    These methods return the same instance types, ExecutorService and ScheduledExecutorService 
    The difference between a single-thread and a pooled-thread executor is what happens when a task is already running.
    While a single-thread executor will wait for the thread to become available before running the next task, a pooled thread executor can execute the next task concurrently.
    If the pool runs out of the available threads, the task will be queued by the thread executor and wait to be completed


Writing Thread safe Code:

	- Thread safety is the property of an object that guarantees safe execution by multiple threads at the same time.
 	- Since threads run in a shared environment and memory space how do we prevent two threads from interfering with each other?
  	- We must organize access to data so that we don't end up with invalid or unexpected results.

Understanding Thread safety:

	- Both threads read and write the same values causng one of the two operations to be lost.
 	- Therefore, the operation is not thread-safe. The unexpected result of two tasks executing at the same time is referred to as a race condition.


Accessing Data with volatile:

	- The volatile keyword is used to guarantee that access to data within memory is consistent.
 	- The volatile attribute ensures that only one thread is modifying a variable at one time and that data read among multiple threads is consistent. 

Protecting data with Atomic classes:

	- As we saw the increment operator is not thread-safe when volatile is used.
 	- It is not thread-safe because the operation is not atomic carrying out two tasks read and write that can be interrupted by other threads.
  	- Atomic is the property of an operation to be carried out as a single unit of executon without any interference from another thread. A thread-safe atomic version of the increment operator would perform the read and write of the variable as a single operation not allowing any other threads to access the variable during the operation.
   	- In this case, any thread trying to access the variable while an atomic operation is in process will have to wait until the atomic operation on the variable is complete.

    		Thread Synchronization using atomic operations:

      		--------------------------------> Thread1 <------------------------------------
				|					|
    		--------------------------------> Shared Memory <-----------------------------
      							|
	     	---------------------------------> Thread2 <---------------------------------

       		-------------------------------Time----------------------------------------->

  	- Since accessing primitives and references is common in Java, the Concurrency API includes numerous useful classes in the java.util.concurrent.atoic package.

   		AtomicBoolean			A boolean value that may be updated atomically
     		AtomicInteger			An int value that may be updated atomically
       		AtomicLong			A long value that may be updated atomically

  	- How do we use an atomic class? Each class includes numerous methods that are equivalent to many of the primitive built-in operations that we use on primitives such as assignment operator and the increment operators (++)

   		private AtomicInteger sheepCount = new AtomicInteger(0);
     		private void incrementAndReport() {
       			System.out.println(sheepCount.incrementAndGet() + " ");
	  	}

Common atomic methods:

	get()				Retrieves current value
 	set(type newValue)		Sets given value, equivalent to assignment operator
  	getAndSet(type newValue)	Atomically sets new value and returns old value
   	incrementAndGet()		For numeric classes, atomic preincrement operation equivalent to ++value
    	getAndIncrement()		For numeric classes, atomic postincrement operation equivalent to value++
     	decrementAndGet()		For numeric classes, atomic predecrement operation equivalent to ++value
      	getAndDecrement()		For numeric classes, atomic postdecrement operation equivalent to value++

Improving access with synchronized blocks:

	- While atomic classes are great at protecting single variable they aren't particularly useful if you need to execute a series of commands or call a method. For example, we can't use them to update two atomic variables at the same time.
 	- How do we improve the results so that each worker is able to increment and report the results in order?
  	- The most common technique is to use a monitor to synchronize access.
   	- A monitor, also called as lock is structure that supports mutual exclusion, which is the property that at most one thread is executing particular segment of code at a given time.
    	- In Java, any Object can be used as a monitor along with the synchronized keyword as shown in the following example:
     		var manager = new SheepManager();
       		synchronized(manager) {}
	- This example is referred to as synchronized block. Each thread that arrives ill first check if any threads are already running the block. If the lock is not available, the thread will transition to a BLOCKED state until it can acquire the lock. 
 	- If the lock s available for the thread already holds the lock, the single thread will enter the block preventing all threads from entering. Once the thread finishes executing the block, it will release the lock allowing one of the waiting threads to proceed.
  	- To synchronize access across multiple threads, each thread must have access to the same Object.
   	- If each thread synchronizes on different objects the code is not thread safe.


Synchronizing on Methods:

	- We established our monitor using synchronized(this) around the body of the method.
 	- Java provides a more convenient compiler enhancement for doing so. 
  	- We can add the synchronized modifier to any instance method to synchronize automatically on the object itself.
   		void sing() {	
     			synchronized(this) { System.out.print("La la la!"); }
		}
  		synchronized void sing() { System.out.print("La la la!"); }
    	- The first uses a synchronized block, whereas the second uses the synchronized method modifier. 
     	- We can also apply the synchronized modifier to static methods.
      	- What object is used as the monitor when we synchronize on a static method? The class object.
       	- For example, the following two methods equivalent for static synchronization inside class
		static void dance() {	
  			synchronized(SheepManager.class) { System.out.print("Time to dance!"); }
     		}
       		static synchronized void dance() { System.out.print("Time to dance!"); }
	 - As before, the first uses a synchronized block, with the second example using the synchronized modifier. 
  	 - You can use static synchronization if you need to order thread access across all instances rather than a single instance.
 				
Understanding the Lock Framework:

	- A synchronized block supports only a limited set of functionality.
 	- For example, what if we want to check whether a lock is available and if it is not perform some other task?
  	- Furthermore, if the lock is never available and we synchronize on it we might wait forever.
   	- The Concurrency API includes the Lock interface, which is conceptually similar to using the synchronied keyword but with a lot more bells and whistles. Instead of synchronizing on any object, though we lock only on an object that imlements the Lock interface.

Applying a ReentrantLock:

 	- The Lock interface is pretty easy to use. When you need to protect a piece of code from multithreaded processing, create an instance of Lock that all threads have access to.
  	- Each thread then calls lock() before it enters the protected code and calls unlock() before it exits the protected code.
   	- By contrast, the following shows two implementations, one with a synchronized block and one with a Lock instance.
    	- While longer, the Lock solution has a number of features not available to the synchronized block

     		// Implementation #1 with a synchronized block
       		Object object = new Object();
	 	synchronized(object) { // Protected code }

   		// Implementation #2 with a lock
     		Lock lock = new ReentrantLock();
       		try {
	 		lock.lock();
    		} finally {
      			lock.unlock();
	 	}

    	- These two implementations are conceptually equivalent. 
     	- The ReentrantLock class is a simple monitor that implements the Locak interface and supports mutual exclusion.
      	- In other words, at most one thread is allowed to hold a lock at any given time.
       	- While certainly not required, it is a good practice to use a try/finally block with Lock instances.
	- Doing so ensures that any required locks are properly released.

 	- The ReentrantLock class ensures that once a thread has called lock() and obtained the lock, all other threads that call lock() will wait until the first thread calls unlock(). Which thread gets the lock next depends on the parameters used to create the Lock object. 
  	- The ReentrantLock class includes a constructor that takes a single booean and sets a fairness parameter.
   	- If the parameter is set to true, the lock will usually be granted to each thread in the order in which it was requested.
    	- It is false by default when using the no-argument constructor. In practice, you should enable fairness only when ordering is absolutely required, as it could lead to a significant slowdown.
     	- Besides always making sure to release a lock, you also need to be sure that you only release a lock that you have.
      	- If you attempt to release a lock that you do not have, you will get an exception at runtime.
       			Lock lock = new ReentrantLock();
	  		lock.unlock(); // IllegalMonitorStateException


Attempting to acquire a lock:

	- While the ReentrantLock class allows you to wait for a lock, it so far suffers from the same problem as a synchronized block. A thread could end up waiting forever to obtain a lock.

  	Lock Methods:

   	void lock()					Requests lock and blocks unti lock is acquired
    	void unlock()					Releases lock
     	boolean tryLock()				Requests lock and returns immediately. Returns boolean indicating whether 							lock was successfully acquired
      	boolean tryLock(long timeout, TimeUnit unit)	Requests lock and blocks for specified time or until lock is acquired. 								Returns boolean indicating whether lock was successfully acquired


	- For convenience we use the method for the code
 		public static void printHello(Lock lock) {
   			lock.lock();
      			System.out.println("Hello");
	 	} finally {
   			lock.unlock();
      		}}

  tryLock():

   	- The tryLock() method will attempt to acquire a lock and immediately return a boolean result indicating whether the lock was obtained. Unlike the lock() method, it does not wait if another thread already holds the lock. It returns immediately, regardless of whether a lock is available. The following is the sample implementation using the tryLock() method:
    	Lock lock = new ReentrantLock();
     	new Thread(() -> printHello(lock)).start();
      	if (lock.tryLock()) {
       		try {
	 		System.out.println("Lock obtained, entering protected code");
    		} finally {
      			lock.unlock();
	 	}
   	} else {
    		System.out.println("Unable to acquire lock, doing something else");
      	}
       - When you run this code, it could produce either the if or else message, depending on the order of execution.
       - It will always print Hello though,  as the call to lok() in printHello() will wait indefinitely for the lock to become available.
	- Like lock(), the tryLock() method should be used with a try/finally block. Fortunately, you need to release the lock only if it was successfully acquired. For this reason, it is common to use the output of tryLock() in an if statement so that unlock() is called only when the lock is obtained.
 	- It is imperative that your program always checks the return value of the tryLock() method.
  	- It tells your program whether it is safe to proceed with the operation and whether the lock needs to be released later.

tryLock(long.TimeUnit):

 	- The Lock interface includes an overloaded version of tryLock(long, TimeUnit) that acts like a hybrid of lock() and tryLock(). Like the other two methods, if a lock is available, it will immediately return with it. 
  	- If a lock is unavailable, it will wait up to the specified time limit for the lock.
   	- The following code snippet uses the overloaded version of tryLock(long, TimeUnit)
    		Lock lock = new ReentrantLock();
      		new Thread(() -> printHello(lock)).start();
		if (lock.tryLock(10, TimeUnit.SECONDS) {
  			try {
     				System.out.println("Lock obtained, entering protected code");
	 		} finally {
    				lock.unlock();
			}
		} else {
  			System.out.println("Unable to acquire lock, doing something else");
     		}
       - The code is same as before, except this time, one of the threads waits up to 10 seconds to acquire the lock.

Acquiring the same lock twice:

	- The ReentrantLock class maintains a counter of the number of times a lock has been successfully granted to a thread.
 	- To release the loc for other threads to use, unlock() must be called the same number of times the lock was granted.
  	- The following code snippet contains an error. Can you spot it?
   		Lock lock = new ReentrantLock();
     		if(lock.tryLock()) {
       			try {
	  			lock.lock();
      				System.out.println("Lock obtained, entering protected code");
	  		} finally {
     				lock.unlock();
	 		}
    		}
      - The thread obtains the lock twice but releases only once. You can verify this by spawning a new thread after this code runs thats attempts to obtain a lock. The following prints falsE:
      		new Thread(() -> System.out.print(loc.tryLock())).start(); // false
	- It is critical that you release a lock the same number of times it is acquired! For calls with tryLock() you need to call unlock() only if the method returned true.


Reviewing the Lock Framework:


	- The ReentrantLock class supports the same features as synchronized block while adding number of improvements:
 		- Ability to request a lock without blocking
   		- Ability to request a lock while blocking for a specified amount of time.
     		- A lock can be created with a fairness property in which the loc is granted to threads in the order requested.
       	- ReentrantReadWriteLock is a really useful class. It includes separate locks for reading and writing data and is useful on data structures where reads are far more common than writes. For example, if you have thousands of threads reading data only one thread writing data, this class can help you in maximize concurrent access.


 Orchestrating Tasks with a CyclicBarrier:

 	- We started the thread safety topic by discussing protecting individual variables and then moved on to blovks of code and locs. We complete our discussion of thread-safety by showing how to orchestrate complex tasks with many steps
  	- The CyclicBarrier takes in its constructors a limit value, indicating the number of threads to wait for.
   	- As each thread finishes, it cals the await() method on the cyclic barrier. One the specified number of threads have each called await() the barrier is released and all threads can continue.
    	- The CyclicBarrier class allows us to perform complex, multithreaded tasks while all threads stop and wait at logical barriers. This solution is superior to a single-threaded solution as the individual tasks

Reusing CyclicBarrier:

	- After a CyclicBarrier limit is reached all threads are released, and the number of threads waiting on the CyclicBarrier goes back to zero. At this point, the CyclicBarrier may be used agan for a new set of waiting threads. 
 	- For example, if our CyclicBarrier limit is 5 and we have 15 threads that call await(), the CyclicBarrier will be activated a total of three times. 


Usng Concurrent Collections:

	- Besides managing threads, the concurrency API includes interfaces and classes that help you coordinate access to collections shared by multiple tasks.

Understandng Memory Consistency Errors:

	- The purpose of the concurrent collection classes is to solve common memory consistency errors.
 	- A memory consistency error occurs when two threads have inconsitent views of what should be the same data.
  	- Conceptually, we want writes on thread to be available to another thread if it accesses the concirrent collection after the write has occurred.
   	- When two threads try to modify the same nonconcurrent collection, the JVM may throw a ConcurrentModificationException at runtime. In fact, it can happen with a single thread.
    		var foodData = new HashMap<String, Integer>();
      		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
  		for(String key: foodData.keySet()) foodData.remove(key);
    - This snippet will throw a ConcurrentMoificationException during the second iteration of the loop, since the iterator on the keySet() is not properly updated after the first element is removed. Changing the first line to use a ConcurrentHashMap will prevent the code from throwing an exception at runtime.
    		var foodData = new ConcurrentHashMap<String, Integer>();
      - Although we don't usually modify a loop variable, this example highlights the fact that ConcurrentHashMap is ordering read/wrte access such that all access to the class is consistent. In the code snippet, the iterator created by keySet() is updated as soon as an object is removed from the Map.
      - The concurrent classes were created to help avoid common issues in which multiple threads are adding and removing objects from the same collections. At any given instance, all threads should have the same consistent view of the structure of the collection.

Working wth Concurrent Classes:

	- You should use a concurrent collection class anytime you have multiple threads modify a collection outside a synchronized block or method even if you don't expect a concurrency problem.
 	- Without a concurrent collections, multiple threads accessing a collection could result in an exception being thrown or worse corrupt data!
  	- If the collection is immutale and contains immutable objects the concurrent collections are not necessary. 
   	- Immutable objects can be accessed by any number of threads and do not require synchronization. 
    	- By definition, they do not change so there is a chance of memory consistency error.
     	- When passing around a concurrent collection a caller may need to know the particular implementaton class. 
      	- That said, it is considered a good practice to pass around a non-concurrent interface reference when possible, similar to how we instantiate the HashMap but often pass around a Map reference
       		Map<String, Integer> map = new ConcurrentHashMap<>();

Concurrent Collection classes:
	ClassName			Java collection Interfaces	Sorted?		Blocking?

	ConcurrentHashMap		Map				No		No
 					ConcurrentMap	
      	ConcurrentLinkedQueue		Queue				No		No
       	ConcurrentSkipListMap		Map				Yes		No
					SortedMap
     					NavigableMap
	  				ConcurrentMap
       					ConcurrentNavigableMap
	ConcurrentSkipListSet		Set				Yes		No
 					SortedSet
      					NavigableSet
	CopyOnWriteArrayList		List				No		No
 	CopyOnWriteArraySet		Set				No		No
  	LinkedBlockingQueue		Queue				No		Yes
   					BlockingQueue


  	Most of the classes are just concurrent versions of their nonconcurrent counterpart classes such as ConcurrentHashMap vc Map or ConcurrentLinkedQueue vs Queue.
   	The Skip classes might sound strange but they are just sorted versions of the associated concurretn collections.
    	When you see a class with Skip in the name just think sorted have seen. 
     	These classes create a copy of collection anytime a reference is added removed or changed in the collection and then update the origina collection reference to point to the copy. 
      	These classes are commonly used to ensure an iterator doesn;t seemodifications to the collection.
       		List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
	 	for (var n: favNumbers) {
   			System.out.print(n + " ");
      			favNumbers.add(n+1);
	 		System.out.println();
    			System.out.println("Size: " + favNumbers.size());

	Despite addng elements, the iterator is not modified and the loop executes exactly three times.
 	Alternatively, if we had used a regular ArrayList object, a ConcurrentModificationException would have been thrown at runtime. The CopyOnWrite classes can use alot of memory, since a new collection structure is created anytime the collection is modified. therefore they are commonly used in multithreaded environment situations where reads are far more common than writes.

  	A CopyOnWrite instance is similar to an immutable object as a new underlying structure is created everytime the collection is modified. Unlike a true immutable object though, the reference to the Object stays the same even while the underlying data is changed.

   	LinkedBlockingQueue which implements the concurrentBlockingQueue interface.
    	This class is just like a regular queue, except that it includes overloaded versions of offer() and poll() that take a timeout. These methods wait or block up to a specific amount of time to complete an operation.


Obtaining Synchronized Collections:

	- Besides the concurrent collection classes that we have covered, the Concurrency API also includes methods for obtaining synchronized versions of existing non concurrent collection objects.
 	- These synchronized methods are defined in the Collections class. They operate on the inputted collection and return a reference that is the same type as the underlying collection.


Synchronized Collection methods:

	- synchronizedCollection(Collection<T> c)
 	- synchronizedList(List<T> list)
  	- synchronizedMap(Map<K, V> m)
   	- synchronizedNavigableMap(NavigableMap<K,V> m)
    	- synchronizedSet(Set<T> s)
     	- synchronizedSortedMap(SortedMap<K, v> s)
      	- synchronizedSortedSet(SortedSet<T> s)

       If you are writing code to create a collection and it requires synchronization you should use the classes. 
       On the other hand if you are passed a nonconcurrent collection and need synchronization

Identifying Threading Problems:

	- Now that you know how to write thread-safe code let's talk about what qualifies as a threading problem
 	- A threading problem can occur in multithreaded applications when two or more threads interact in an unexpected and undesirable way. For example, two threads may block each other from accessing a particular segment of code.
  	- The Concurrency API was created to help eliminate potental threading issues common to all developers.
   	- As you have seen, the concurrency API creates threads and manages complex thread interactions for you often in just few lines of code.
    	- Although the ConcurrencyAPI reduces potential for threading issues, it does not eliminate them. In practice, finding and identifying threading issues within an application is often one of the most difficult tasks a developer can undertake.

Understanding Liveness:

	- Many thread operations can be performed independenly, but some require coordination.
	- For example, synchronizing on a method requires all threads that call the method to wait for other threads to finish before continuing.
	- What happens to the application while all of these threads are waiting? In many cases, the waiting is ephemeral and the user has very little idea that any delay has occurred. In other cases though, the waiting may be extremely difficult.
	- Liveness is the ability of an application to be able to execute in a timely manner. Liveness problems then are those in which the application becomes unresponsive or is in some kind of "struck" state.
	- More precisely, liveness problems are often the result of a thread entering a BLOCKING or WAITING state forever, or repeatedly entering/exiting these states.
	There are three types of liveness issues with which you should be familiar: deadlock, starvation and lock


Deadlock:
	
	- Deadlock occurs when two or more threads are blocked forever each waiting on the other

Starvation:

	- Starvation occurs when a single thread is perpetually denied access to a shared resource or lock.
	- The thread is still active but it is unable to complete its work as a result of other threads constantly taking the resource that it is trying to access.

LiveLock:
	
   	- Livelock occurs when two or more threads are conceptually blocked forever although they are each still and trying to complete their task.
   	- Livelock is a special case of resource starvation in which two or more threads actively try to acquire a set of locks are unable to do so and restart part of the process.
   	- LiveLock is often a result of two threads trying to resolve a deadlock.
	- In practice, livelock is often difficult issue to detect. Threads is a livelock state appear active and able to respond to requests even when they are struck in endless cycle.


Managing Race Conditions:

	- A race condition is an undesirable result that occurs when two tasks that should be completed sequentially are completed at the same time. 
	- Possible outcomes for this race condition:
		○ Both users are able to create accounts 
		○ Neither user is able to create an account with the username and error message is returned to both users.
		○ One user is able to create an account with username while the other user receives an error message.
	- The first outcome is really bad, as it leads to users trying to log in with the same username.
	- The second outcome causes both users to have to try again which is frustrating but at least doesn't lead to corrupt or bad data.
	- The third outcome is often considered as the best solution. Like the second situation, we preserve data integrity but unlike the second situation at least one user is able to move forward on the first request, avoiding additional race condition scenarios.


Working with Parallel Streams:

	- One of the most powerful feature of Stream API is built-in concurrency support. Up until now, all of the streas you have worked with have been serial streams. A serial stream is a stream in which the results are ordered wth only one entry being processed at a time.
	- A parallel stream is capable of processing results concurrenty using multiple threads.
	- For example, you can use a parallel stream and the map() operation to operate concurrently on the elements in the stream, vastly improving performance over processing a single element at a time.
	- Using a parallel stream can change not only the performance of your application but also the expected results. Some operations also require special handling to be able to be processed in a parallel manner.
	- The number of threads available in a parallel stream is proptional to the number of available CPUs in your environment.


Creating Parallel Streams:

	- The Stream API was designed to make creating parallel streams quite easy. 
	- There are two ways of creating parallel streams:
		○ Collection<Integer> collection = List.of(1,2);
		Stream<Integer> p1 = collection.stream().parallel();
		Stream<Integer> p2 = collection.parallelStream();
		
	- The first way to create a parallel stream is from an existing stream. Any stream can be made parallel! The second way to create a parallel stream is from a Java Collection class.  We use both of these methods throughout this section
	- The Stream interface includes a method isParallel() that can be used to test whether the instance of a stream supports parallel processing. Some operations on streams preserve the parallel attribute, while others do not.

Performing a Parallel Decomposition:

	- A parallel decomposition is the process of taking a task, breaking it into smaller pieces that can be performed concurrently and then reassembling the results. 
	- The more concurrent a decomposition, the greater the performance improvement of using parallel streams.
			private static int doWork(int input) {
				try  {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				return input;
			}
	- We can pretend that in a real application, this work might involve calling a database or reading a file.
			long start = System.currentTimeMillis();
			List.of(1,2,3,4,5).stream().map(w-> doWork(w)).forEach(s->System.out.println(s+ " ");
			System.out.println();
			var timeTaken = (System.currentTimeMillis()-start)/1000;
			System.out.println("Time: " + timeTaken+"  seconds");
			
	- The map() and forEach() operations on a parallel stream are equivalent to submitting multiple Runnable lambda expressions to a pooled thread executor and then waiting for the results.
	What about the time required? In this case, our system has enough CPUs for all of the tasks to be run concurrently.

 Ordering Results:

	- If your stream operation needs to guarantee ordering and you are not sure if it is serial or parallel, you can replace with one that uses forEachOrdered()
				forEachOrdered(s-> System.out.print(s+ " "));
	- While we have lost some of the performance gains of using a parallel stream our map() operation can still take advantage of the parallel stream.


Processing Parallel Reductions:

	- Besides potentially improving performance and modifying the order of operations, using parallel streams can impact how you write your application. A parallel reduction is a reduction operation applied to a parallel stream. The results for parallel reductions can differ from what you expect when working with serial streams

Performing Order-Based Tasks:

	- Since order is not guaranteed with parallel streams, methods such as findAny() on parallel streams may result in unexpected behavior.
			System.out.print(List.of(1, 2, 3, 4, 5, 6).parallelStream().findAny().get())
	- The JVM allocates a number of threads and returns the value of the first one to return a result.
	- While neither the serial nor the parallel stream is guaranteed to return the first value, the serial stream often does.
	- With a parallel stream, the results are likely to be random.
	- What about operations that consider order such as  findFirst(), limit() and skip()? Order is still preserved, but performance may suffer on a parallel stream as a result of a parallel processing task being forced to coordinate all of its threads in a synchronized-like fashion.


Creating Unordered streams:

	- All of the streams you have been working with are considered ordered by default. It is possible to create an unordered stream from an ordered stream, similar to how you create a parallel stream from a serial stream.
				List.of(1,2,3,4,5,6).stream().unordered()
	- This method does not reorder the elements. It just tells the JVM that if an order-based stream operation is applied, the order can be ignored. 
	- For serial streams, using an unordered version has no effect. But on parallel streams the results can greatly improve performance.
				List.of(1,2,3,4,5,6).stream().unordered().parallel()


Combining Results with reduce():

	- The stream operation reduce() combines a stream into a single object.
	- Recall that the first parameter to reduce method is called the identity and the second parameter is called the accumulator, and the third parameter is called the combiner. The following is the signature for the method:
				<U> U reduce(U identiy, BiFunction<U, ? Super T, U> accumulator, BinaryOperation<U> combiner)
	- We can concentrate a list of char values using the reduce() method
		System.out.println(List.of('w','o','l','f').parallelStream().reduce("", (s1,c) -> s1+c, (s2,s3) ->s2+s3));
	- On parallel streams, the reduce() method works by applying the reduction to pairs of elements within the stream to create intermediate values and then combining those intermediate values to produce a final result.
	- With parallel streams, we have to be concerned about order. What if the elements of a string are combined in the wrong order.
	- The stream API prevents this problem while still allowing streams to be processed in parallel, as long as you follow one simple rule:
		Make sure that the accumulator and combiner produce the same result regardless of the order they are called in.
	- The accumulator and combiner must be associative, non-interfering and stateless.
	- While the requirements for the input arguments to the reduce() method hold true for both serial and parallel streams you may not have noticed any problems in serial streams because the result was always ordered.
	- With parallel streams, though order is no longer guaranteed and any argument that violates these rules in much more likely to produce side effects or unpredictable results.

Selecting a reduce() method:

	- Although the one- and two- argument versions of reduce() support parallel processing. It is recommended that you use the three-argument version of reduce() when working with parallel streams.
	- Providing an explicit combiner method allows the JVM to partition the operations in the stream more efficiently.

Combining Results with collect():

	- Like reduce(), the Stream API includes three argument versionn of collect() that takes accumulator and combiner operators along with a supplier operator instead of an identity.
	<R> R collect(Supplier<R> supplier, BiConsumer<R ? Super T> accumulator, BiConsumer<R, R> combiner)
	- Also, like reduce() the accumulator and combiner operations must be able to process results in any order.
	- In this manner, the three argument version of collect() can be performed as a parallel reduction
			Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
			SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
			System.out.println(set);
	- Recall that elements in a ConcurrentSkipListSet are sorted according to their natural ordering.
	- You should use a concurrent collection to combine the results, enduring that the results of concurrent threads do not cause a ConcurrentModificationException.
	- Performing parallel reductions with a collector requires additional considerations. 
	- For example, if the collection into which you are inserting is an ordered data set such as List, the elements in the resulting collection must be in the same order regardless of whether you use a seria or parallel stream. This may reduce performance, though as some operations cannot be completed in parallel.

Performing a Parallel reduction on a Collector:

	- Every Collector instance defines a characteristics() method that returns a set of Collector.characteristics attributes.
	- When usng a Collector to perform a parallel reduction, a number of properties must hold true.
	- Otherwise the collect() operation will execute in a single threaded fashion.
	Requirements for Parallel reduction with collect():
		○ The stream is parallel
		○ The parameter of the collect() operations has the Characteristics.CONCURRENT characteristic.
		○ Either the stream is unordered or the collector has the characteristic Characteristics.UNORDERED
	- For example, while Collectors.toSet() does have the UNORDERED characteristic, it does not have the CONCURRENT characteristic.
	- Therefore the following is not a parallel reduction even with a parallel stream
			parallelStream.collect(Collectors.toSet()); // Not a parallel reduction
	- The Collectors class includes two sets of static methods for retrieving collectors, toConcurrentMap() and groupingByConcurrent() both of which are UNORDERED and CONCURRENT. 
	- These methods produce Collector instances capable of performing parallel reductions efficiently. 
			Stream<String> oMy = Stream.of("lions", "tigers", "bears").parallel();
			ConcurrentMap<Integer, String> map = oMy.collect(Collectors.toConcurrentMap(String::length, k->k, (s1, s2)-> s1+" "+s2)):
			System.out.println(map);
			System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
	- We use a ConcurrentMap reference, although the actual class returned is likely ConcurrentHashMap. The particular class is not guranteed it will just be a class that implements the interface ConcurrentMap.
	- Finally, we can rewrite our groupingBy() 
			var oMy = Stream.of("lions", "tigers", "bears").parallel();
			ConcurrentMap<Integer, List<String>> map  = ohMy.collect(Collectors.groupingByConcurrent(String::length));
			The returned object can be assigned to a ConcurrentMap reference
			

Avoiding Stateful Streams:

	- Side effects can appear in parallel streams if your lambda expressions are stateful.
	- A stateful lambda expression is one whose result depends on any state that might change during the execution of a pipeline.
	public List<Integer> addValues(IntStream source) {
		var data = Collections.synchronizedList(new ArrayList<Integer>());
		source.filter(s -> s%2==0).forEach(i-> {data.add(i); })
		return data;
	}
	Serial stream:
	var list = addValues(IntStream.range(1, 11)); // [2, 4, 6, 8, 10]
	Parallel Stream:
	var list = addValues(IntStream.range(1, 11).parallel()); [6, 8, 10, 2, 4]
	public List<Integer> addValuesBetter(IntStream source) {
		return source.filter(s->s%2==0).boxed().collect(Collectors.toList());
	}
	This method processes the stream and then collects all the results into a new list. 
	It produces the same ordered result on both serial and parallel streams.
	It is strongly recommended that you avoid stateful operations when using parallel streams to remove any potential data side effecys.
	In fact they should be avoided in serial streams since doing so limits the code's ability to someday take advantage of parallelization.


