# Java8Plus

This repository contains sample Java programs that demonstrate and explain key features introduced in Java 8 and newer versions.  
It is designed as a hands-on learning reference for experienced Java developers returning to modern Java, or anyone wanting practical, example-driven explanations of features such as lambdas, streams, method references, functional interfaces, and much more.

You’ll find:
- Concise, well-commented example code for each topic
- Explanations, “gotchas,” and Java best practices
- Incremental learning—new features and exercises added as you progress

## Topics List

- Lambda Expressions
  - Streams API
    - Stream creation from List
    - Intermediate operations: filter(), map()
    - Terminal operations: forEach()
- Functional Interfaces
- Method References
- Optional
- Date and Time API
- Collectors (Basics and Advanced)
  - Basics: toList(), toSet(), toMap(), joining(), groupingBy(), partitioningBy(), summarizing collectors
  - Advanced: mapping() for downstream value transformation, collector composition, grouping with mapping
- CompletableFuture and Modern Concurrency
  - Asynchronous task execution: supplyAsync(), runAsync()
  - Chaining: thenApply(), thenAccept()
  - Combining: thenCombine(), allOf(), anyOf()
  - Exception handling: exceptionally(), handle(), whenComplete()
- Try-With-Resources (Java 7)
  - Automatic resource management for Closable/AutoCloseable objects
- Strings in switch (Java 7)
  - Use switch statements with String values for concise branching
- Multi-Catch Exception Handling (Java 7)
  - Catch multiple exception types in a single catch block for concise error handling
- NIO.2 File API (Java 7)
  - Modern file and directory handling with Path and Files classes
- Fork/Join Framework (Java 7)
  - Parallel divide-and-conquer with RecursiveTask, RecursiveAction, and ForkJoinPool
- Collection Factory Methods (Java 9)
  - Immutable lists, sets, and maps via List.of(), Set.of(), Map.of()
- JShell (Java 9 REPL)
  - Interactive Read-Eval-Print Loop for rapid prototyping and exploration
- Stream API Improvements (Java 9)
  - takeWhile(), dropWhile(), ofNullable(), and more
- Private Interface Methods (Java 9)
  - Private and private static methods for code reuse within interface default/static methods
- JPMS (Java Platform Module System, Java 9 Modules)
  - Explicit module boundaries, requires/exports in module-info.java, strong encapsulation and dependency management
- Local Variable Type Inference (Java 10)
  - Use of 'var' for local variable declarations with type inference
- String API Enhancements (Java 11)
  - isBlank(), lines(), strip(), repeat(), and related improvements
- HTTP Client API (Java 11)
  - Modern synchronous and asynchronous HTTP requests with java.net.http.HttpClient
- var in Lambda Parameters (Java 11)
  - Allows use of 'var' and annotations in lambda parameter lists
- Text Blocks (Java 13/15+)
  - Multi-line string literals using triple double-quotes (""")
- Switch Expressions (Java 14+)
  - Modern switch as an expression, arrow (`->`) syntax, yield, multiple labels
- Records (Java 16+)
  - Concise, immutable data carrier classes with auto-generated accessors, equals, hashCode, and toString
- Pattern Matching for instanceof (Java 16/17+)
  - Simplifies type checks and casts by combining them in a single, safe syntax
- Sealed Classes (Java 15/17+)
  - Restrict which classes can extend or implement a class/interface, enforcing closed hierarchies
- Pattern Matching for switch (Java 17/21+)
  - Use patterns and type matching directly in switch cases, supporting records, sealed hierarchies, enums, and classic classes


# Java8Plus

This repository contains sample Java programs that explore features introduced in Java 8 and beyond.

## Details 

- Anonymous Inner Classes  
  Enables creation of one-off class implementations without separate class declarations, often used to implement interfaces in place.

- Lambda Expressions  
  Introduces a concise way to implement functional interfaces using `()->{}` syntax for inline behavior.
  - Lambdas with no parameters  
    Lambda expressions that take no input and perform a specific task.
  - Lambdas with parameters  
    Accept input arguments, offering greater flexibility and reusability.
  - Lambdas with multiple parameters  
    Can handle logic involving more than one input variable, enhancing expressiveness.

- Functional Interfaces  
  Interfaces with a single abstract method, intended for lambda expression usage.
  - Custom Functional Interfaces (e.g., Greeting, Calculator)  
    User-defined interfaces with one abstract method tailored to specific functional needs.
  - Built-in Functional Interfaces (from java.util.function)  
    A rich set of standard interfaces provided by Java for functional programming patterns.
    - Consumer<T>  
      Represents an operation that takes a single input and returns no result.
    - Consumer andThen() chaining  
      Chains multiple consumers to execute sequentially using `andThen()`.
    - Supplier<T>  
      Supplies a result without taking any input.
    - Function<T, R>  
      Takes an input and produces a result.
    - Predicate<T>  
      Represents a boolean-valued function of one argument, useful for filtering.
    - BiFunction<T, U, R>  
      Takes two arguments and produces a result.
    - BiFunction andThen() chaining with Function<? super R, ? extends V>  
      Chains a `Function` after a `BiFunction` to transform its output.

- Streams API  
  Functional-style operations on collections. Includes:
  - Stream creation from List
  - Intermediate operations: filter(), map(), sorted(), distinct(), limit(), skip()
    - filter(): Filters elements based on a Predicate.
    - map(): Transforms each element.
    - sorted(): Sorts elements (default or custom comparator).
    - distinct(): Removes duplicate elements from the stream.
    - limit(): Limits the output to a specified number of elements.
    - skip(): Skips a specified number of elements.
  - Terminal operations: forEach(), collect(), count(), findFirst(), allMatch()
    - forEach(): Performs an action for each element.
    - collect(): Gathers elements into a List or other collection.
    - count(): Counts elements.
    - findFirst(): Finds the first element, if present.
    - allMatch(): Checks if all elements match a given condition.
  - Advanced Sorting with Comparator
    - Sorting streams by string length, last character, or reverse order.

- System.out.printf() formatting  
  Enables formatted console output, useful for aligning data or embedding variables.

- ANSI Colors in Terminal Output  
  Uses escape codes to colorize console text, helpful for highlighting output.


- Optional  
  Introduces a container object which may or may not contain a non-null value, eliminating the need to use `null` for missing results and reducing the risk of `NullPointerException`.
  - Creating Optionals: `Optional.of(value)`, `Optional.ofNullable(value)`, and `Optional.empty()`
  - Checking for presence: `isPresent()`, `isEmpty()`, and safe access patterns
  - Getting values or defaults: `get()`, `orElse(default)`, `orElseGet(Supplier)`, `orElseThrow(Supplier)`
  - Executing code if present: `ifPresent(Consumer)`
  - Transforming and filtering: `map(Function)`, `flatMap(Function)`, `filter(Predicate)`
  - Best practices: Prefer safe access (not `get()`), chain transformations, and use with streams for null-safe pipelines.
  - Example exercises include:  
    • Returning Optional from “lookup” methods  
    • Using `orElseGet` to provide lazy defaults  
    • Handling absence with `orElseThrow`  
    • Chaining with `map`, `flatMap`, and `filter`  
    • Using Optional with streams and custom helper methods


- **Default and Static Methods in Interfaces**  
  Prior to Java 8, interfaces could only declare abstract methods (no implementation).  
  Java 8 introduced:
  - **default methods:** Methods with a concrete implementation using the `default` keyword, enabling interface evolution without breaking existing code.
  - **static methods:** Methods defined in interfaces that are called using the interface name, useful for utilities and shared logic.

  Example:  
  ```java
  interface MyInterface {
      default void greet() { System.out.println("Hello"); }
      static void help() { System.out.println("Help method"); }
  }
  ```


- **Method References**  
  Provides a concise way to refer to methods or constructors, making code shorter and more readable than equivalent lambda expressions.
  - **Static method reference** (`ClassName::staticMethod`):  
    Example: `names.forEach(MethodReferenceExample::printUpper);`
  - **Instance method reference of a particular object** (`object::instanceMethod`):  
    Example: `helper::printLower;`
  - **Instance method reference of an object in the stream** (`ClassName::instanceMethod`):  
    Example: `names.stream().map(String::toUpperCase).forEach(System.out::println);`
  - **Constructor reference** (`ClassName::new`):  
    Example: `names.stream().map(Person::new).forEach(System.out::println);`
    - The `Person` class overrides `toString()` to produce output like `Person{name='Alice'}` when printed, instead of a default hashcode.

  **Quick Reference Table:**

  | Type                                | Syntax                      | Example                                   |
  |------------------------------------- |-----------------------------|-------------------------------------------|
  | Static method reference              | `ClassName::staticMethod`   | `MethodReferenceExample::printUpper`      |
  | Instance method of particular object | `object::instanceMethod`    | `obj::printLower`                         |
  | Instance method of object in stream  | `ClassName::instanceMethod` | `String::toUpperCase`                     |
  | Constructor reference                | `ClassName::new`            | `Person::new`                             |



- **Date and Time API (`java.time`)**  
  Java 8 introduced a modern, immutable, and thread-safe date/time API to replace the older, error-prone `Date` and `Calendar` classes.  
  - Core classes:  
    - `LocalDate` (date without time)
    - `LocalTime` (time without date)
    - `LocalDateTime` (date and time without timezone)
    - `Instant` (an instantaneous point on the timeline, UTC)
    - `ZonedDateTime` (date and time with timezone)
    - `Period` (date-based amount of time)
    - `Duration` (time-based amount of time)
  - Formatting and parsing with `DateTimeFormatter`
  - Immutability: All classes are immutable and thread-safe.
  - Example exercises:
    - Creating and manipulating dates/times (now, specific dates, plus/minus)
    - Formatting and parsing dates
    - Calculating differences using `Period` and `Duration`
    - Handling time zones

- **Collectors (Basics and Advanced)**  
  Demonstrates the use of the `Collectors` utility class for processing streams in modern Java.  
  - **Basics:**  
    - `toList()`, `toSet()`, `toMap()`: Collect elements into standard Java collections.
    - `joining()`: Concatenate stream elements into a single String.
    - `groupingBy()`: Group elements by a property or function, producing a map of lists.
    - `partitioningBy()`: Split elements into two groups based on a predicate.
    - `summarizingInt()`: Collect summary statistics (count, min, max, sum, average) of stream elements.
  - **Advanced:**  
    - `mapping()`: Apply a transformation to each element before collecting them, especially useful as a downstream collector (e.g., grouping names by first letter and collecting the lengths of names in each group).
    - Collector composition: Combining collectors for more complex grouping and summarization (e.g., grouping and mapping, grouping and counting).
    - Practical grouping by value transformation: Demonstrates how to use `mapping()` with `groupingBy()` to transform and collect data, with clear printouts of results.
  - Example exercises include:  
    • Grouping and mapping values in a stream  
    • Printing detailed breakdowns of grouped values  
    • Using different downstream collectors to change the result type (List, Set, summary)

- **CompletableFuture and Modern Concurrency**  
  Introduces Java 8’s CompletableFuture API for writing non-blocking, asynchronous, and parallel code.  
  - Creating async tasks: `supplyAsync()` for computations with results, `runAsync()` for tasks with no result.
  - Chaining operations: Using `thenApply()` and `thenAccept()` to process or consume results as they become available.
  - Combining multiple async results: `thenCombine()` to merge results of two computations; overview of `allOf()` and `anyOf()` for aggregating many tasks.
  - Exception handling and result inspection:  
    - `exceptionally()` for handling errors and supplying fallback values.
    - `whenComplete()` for post-completion side effects, similar to a finally block.
    - `handle()` for examining both normal and exceptional outcomes and providing alternate results.
  - Example exercises include:  
    • Running and chaining async computations  
    • Combining multiple futures  
    • Demonstrating practical exception handling and result transformation  
    • Logging and cleanup actions after task completion


- Try-With-Resources (Java 7)  
  Introduces automatic resource management for objects like files, sockets, or database connections that implement AutoCloseable.  
  - Resources declared in the try(...) statement are automatically closed at the end of the block, even if an exception occurs.
  - Simplifies code and prevents resource leaks by eliminating the need for explicit finally blocks.
  - Example exercises: reading a file using BufferedReader, safely managing multiple resources in one try statement.
  
- Strings in switch (Java 7)  
  Allows using String values in switch statements, greatly improving readability when branching on string commands or data.
  - Enables direct comparison of a String variable/expression against constant case labels.
  - Matching is case-sensitive and uses String.equals() internally.
  - Example exercises: building command interpreters or data mappers with concise, readable code.

- Multi-Catch Exception Handling (Java 7)  
  Lets you handle two or more exception types in a single catch block using the `|` (pipe) separator.
  - Reduces code duplication when multiple exceptions require the same handling logic.
  - Improves readability and maintainability.
  - Example exercises: Simulating operations that throw different checked exceptions and handling them together.

- NIO.2 File API (Java 7)  
  Introduces the java.nio.file package, replacing most legacy java.io.File use cases with a safer, more flexible, and feature-rich API.
  - Core classes: Path (represents a file or directory location), Files (utility class for common file operations).
  - Supports reading/writing files, copying, moving, deleting, checking attributes, and scalable directory traversal.
  - Example exercises: creating, reading, and deleting files using Path and Files.

- Fork/Join Framework (Java 7)  
  Enables parallel processing of divide-and-conquer problems by recursively splitting tasks into smaller subtasks that are processed in parallel and then combined.
  - Key classes:
    - RecursiveTask<V>: For tasks that return results (implement compute()).
    - RecursiveAction: For tasks that don’t return results.
    - ForkJoinPool: Special thread pool for executing Fork/Join tasks.
  - Example exercises:
    • Summing an array in parallel by splitting, forking, and joining subtasks.
    • Demonstrating how fork() schedules a task for parallel execution and join() waits for results.
    • Shows thread pool parallelism and safe, efficient result aggregation.


- Collection Factory Methods (Java 9)  
  Introduces static factory methods {@code List.of()}, {@code Set.of()}, and {@code Map.of()} for quick creation of immutable collections.
  - Collections created with these methods are unmodifiable and throw exceptions on modification attempts.
  - Example exercises: creating and using read-only lists, sets, and maps for concise, safer code.

- JShell (Java 9 REPL)  
  JShell is Java’s Read-Eval-Print Loop tool for interactive programming, prototyping, and API exploration.
  - Allows multi-line code, instant feedback, and easy testing of statements, methods, and expressions.
  - Supports variable declarations, class and method definitions, loops, and conditionals.
  - Example exercises: testing code snippets, exploring new Java features, and debugging small algorithms interactively.

- Stream API Improvements (Java 9)  
  Java 9 adds several enhancements to the Stream API, making functional-style processing of collections more expressive:
  - {@code takeWhile(Predicate)}: Collects elements from a stream while a condition holds, stopping at the first non-match.
  - {@code dropWhile(Predicate)}: Skips leading elements while a condition holds, then returns the rest.
  - {@code ofNullable(T)}: Safely creates a stream from a potentially-null value, avoiding NullPointerExceptions.
  - Example exercises: splitting sorted streams with {@code takeWhile}, processing stream “tails” with {@code dropWhile}, safely handling nulls in stream pipelines.

- Private Interface Methods (Java 9)  
  Java 9 allows interfaces to declare private and private static methods. These methods:
  - Enable code sharing and organization within interface default and static methods.
  - Are not inherited by implementing classes or accessible from outside the interface.
  - Must be used only by other methods within the same interface.
  - Example exercises: factoring out common code in default methods, demonstrating encapsulation of helper logic within interfaces.

- JPMS (Java Platform Module System, Java 9 Modules)  
  Java 9 introduced a module system for strong encapsulation and explicit dependency management.
  - Each module includes a `module-info.java` file that declares its name, dependencies (`requires`), and public packages (`exports`).
  - Only packages exported in `module-info.java` are accessible to other modules, even for public classes.
  - Modules prevent accidental usage of internal APIs and allow the JVM to check dependencies at compile and run time.
  - Example exercises: building a two-module project (`greetings` and `app`), using `requires` and `exports` for inter-module communication.


- Local Variable Type Inference (Java 10)  
  Java 10 introduced the {@code var} keyword for local variables, enabling type inference by the compiler:
  - {@code var} can be used only for local variables inside methods, constructors, or code blocks.
  - The type is inferred at compile time based on the initializer (the right-hand side).
  - Improves code readability and reduces boilerplate, especially for complex generic types.
  - Cannot be used for fields, method parameters, or return types.
  - Example exercises: replacing explicit type declarations with {@code var}, demonstrating inferred types for collections, maps, and loop variables.


- String API Enhancements (Java 11)  
  Java 11 introduced several new and improved String methods for more powerful text processing:
  - {@code isBlank()}: Returns true if the string is empty or contains only whitespace.
  - {@code lines()}: Splits the string into a stream of lines, handling all line terminators.
  - {@code strip()}, {@code stripLeading()}, {@code stripTrailing()}: Remove whitespace (Unicode-aware) from both ends, the start, or the end of the string.
  - {@code repeat(int)}: Returns a new string consisting of the original repeated the specified number of times.
  - Example exercises: Checking for blank strings, splitting into lines, trimming with Unicode support, and repeating text for formatting or testing.

- HTTP Client API (Java 11)  
  Java 11 introduced the {@code java.net.http.HttpClient} class for making HTTP requests in a modern, easy-to-use, and highly configurable way:
  - Supports both synchronous and asynchronous HTTP requests using a builder pattern and fluent API.
  - Provides improved support for HTTP/1.1 and HTTP/2, timeouts, custom headers, and request/response bodies.
  - Asynchronous operations use {@code CompletableFuture} for non-blocking, callback-driven workflows.
  - Example exercises:  
    • Performing GET requests synchronously and asynchronously  
    • Using lambda callbacks to process HTTP responses  
    • Demonstrating why blocking (e.g., {@code .join()}) is sometimes needed in console programs to ensure asynchronous operations complete.

- var in Lambda Parameters (Java 11)  
  Java 11 allows the use of the {@code var} keyword in lambda parameter lists, enabling type inference and support for annotations:
  - Lets you annotate lambda parameters or use modifiers such as {@code final} alongside {@code var}.
  - All parameters in a lambda must use {@code var} if one does; you cannot mix explicit types and {@code var}.
  - This is primarily for enhanced readability, documentation, or static analysis, especially in cases where parameter annotations are needed.
  - Example exercises: using {@code var}, {@code final var}, and custom annotations on lambda parameters, and understanding the effect of annotations in this context.


- Text Blocks (Java 13/15+)  
  Java introduced text blocks as a feature for writing multi-line string literals using triple double-quotes ({@code """}):
  - Makes it easier to write, read, and maintain multi-line text such as JSON, SQL, HTML, or formatted documentation.
  - Removes the need for excessive escaping and awkward string concatenation.
  - Preserves line breaks, indentation, and allows embedded quotes without special escaping.
  - Example exercises: formatting JSON, SQL, and HTML snippets; demonstrating preservation of whitespace and line structure; comparing classic string literals with text blocks.


- Switch Expressions (Java 14+)  
  Java 14 introduced switch expressions, allowing switch to be used as both a statement and an expression:
  - Supports returning a value directly from switch with the `->` syntax and multiple case labels separated by commas.
  - No fall-through by default; no need for explicit break statements.
  - Use of `yield` in a block to provide a value from a multi-statement case.
  - Cleaner and safer for pattern-based logic, especially with enums and strings.
  - Example exercises: assigning results from switch expressions, using yield for multi-line cases, comparing classic and new switch syntax.


- Records (Java 16+)  
  Java 16 introduced records, a special class type designed to serve as transparent, immutable data carriers with a compact syntax:
  - Records automatically generate final fields, a canonical constructor, accessors (getters), `equals()`, `hashCode()`, and `toString()`.
  - Ideal for DTOs and value objects—records are always immutable, and cannot declare mutable instance fields.
  - Supports custom methods and custom constructors for validation or computed properties.
  - Example exercises:  
    • Defining and using records for concise data modeling  
    • Demonstrating immutability, equality, and auto-generated methods  
    • Adding custom methods and compact constructors for validation

- Pattern Matching for instanceof (Java 16/17+)  
  Java 16/17 introduced pattern matching for the {@code instanceof} operator, letting you combine type checking and casting into a single, concise syntax:
  - Reduces boilerplate by eliminating the need for a separate cast after {@code instanceof}.
  - Increases safety by limiting the variable’s scope to the block where the type check is true.
  - Supports pattern variable introduction for clean and readable code.
  - Example exercises:  
    • Checking if an object is an instance of a type and immediately using it as that type  
    • Comparing classic and pattern matching {@code instanceof} usage  
    • Pattern matching for multiple types in conditional logic

- Sealed Classes (Java 15/17+)  
  Java 15 introduced sealed classes (finalized in Java 17), allowing class designers to control which classes or interfaces can extend or implement them:
  - Use the `sealed` modifier on a class or interface, and the `permits` clause to specify allowed subclasses or implementors.
  - Subclasses must be explicitly marked as `final`, `sealed`, or `non-sealed`.
  - Enforces closed class hierarchies, enabling safer, exhaustive pattern matching and easier maintenance.
  - Example exercises:  
    • Defining sealed hierarchies and permitted subclasses  
    • Using final, sealed, and non-sealed subclasses  
    • Leveraging sealed classes in pattern-matching switch expressions for exhaustive checks

- Pattern Matching for switch (Java 17/21+)  
  Java 17 (preview) and Java 21 (final) enable using type patterns and destructuring directly in switch cases:
  - Supports type-checking and variable binding for records, enums, sealed types, and classic classes.
  - Enables more concise, readable, and exhaustive switch logic.
  - Facilitates nested and hierarchical patterns for complex data structures.
  - Example exercises:  
    • Switching on records and extracting fields directly  
    • Switching on enums with pattern cases  
    • Handling classic classes and sealed types with pattern-matching cases


## Upcoming Topics

- And more...
