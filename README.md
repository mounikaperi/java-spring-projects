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
            
      
