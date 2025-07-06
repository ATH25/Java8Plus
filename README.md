# Java8Plus

This repository contains sample Java programs that demonstrate and explain key features introduced in Java 8 and newer versions.  
It is designed as a hands-on learning reference for experienced Java developers returning to modern Java, or anyone wanting practical, example-driven explanations of features such as lambdas, streams, method references, functional interfaces, and much more.

You’ll find:
- Concise, well-commented example code for each topic
- Explanations, “gotchas,” and Java best practices
- Incremental learning—new features and exercises added as you progress

## Topics Covered

- Lambda Expressions
  - Streams API
    - Stream creation from List
    - Intermediate operations: filter(), map()
    - Terminal operations: forEach()
- Functional Interfaces
- Method References
- Optional
- Date and Time API
- And more...

# Java8Plus

This repository contains sample Java programs that explore features introduced in Java 8 and beyond.

## Topics Covered (So Far)

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
  | Instance method of particular object | `object::instanceMethod`    | `obj::printLower`                      |
  | Instance method of object in stream  | `ClassName::instanceMethod` | `String::toUpperCase`                     |
  | Constructor reference                | `ClassName::new`            | `Person::new`                             |

## Upcoming Topics

- Date and Time API
- And more...