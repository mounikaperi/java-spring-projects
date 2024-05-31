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
      4. Java doesn't alloe cyclic constructor calls.


      
Core Java 8, 11, 17, 21

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
            
      
