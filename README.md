# Java8Plus

This repository contains sample Java programs that explore features introduced in Java 8 and beyond.

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

- System.out.printf() formatting  
  Enables formatted console output, useful for aligning data or embedding variables.

- ANSI Colors in Terminal Output  
  Uses escape codes to colorize console text, helpful for highlighting output.

- Git version control (project is fully committed)  
  The project uses Git for tracking changes and versioning source code.

## Upcoming Topics

- Streams API
- Method References
- Optional
- Date and Time API
- And more...