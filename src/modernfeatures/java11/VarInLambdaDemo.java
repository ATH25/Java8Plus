package modernfeatures.java11;

import java.util.List;

/**
 * Demonstrates the use of {@code var} in lambda parameters introduced in Java 11.
 * This includes examples of using {@code var} alone, with {@code final}, and with custom annotations
 * on lambda parameters to enhance readability and enable static analysis or framework integrations.
 */
public class VarInLambdaDemo {
    /**
     * Shows different ways to declare lambda parameters:
     * - Traditional explicit type declaration
     * - Using {@code var} keyword
     * - Using {@code final var} to make the parameter effectively final
     * - Using a custom annotation on the {@code var} parameter
     *
     * Each approach demonstrates how lambda parameters can be declared and annotated in Java 11 and beyond.
     */
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Aju");

        // Traditional way (before Java 11)
        names.forEach((String name) -> System.out.println("Hello, " + name));

        // Java 11+: Use 'var' in lambda parameters
        names.forEach((var name) -> System.out.println("Hello again, " + name));

        // You can also mix with final or annotations (example: 'final var')
        // Note: Each lambda execution receives a new, separate (final) parameter variable.
        // The value of 'name' is fixed for that execution, but each iteration assigns the next list element to a new variable.
        names.forEach((final var name) -> System.out.println("Bye, " + name));

        // Example with annotation: using @MyDemoAnnotation on a lambda parameter
        // This annotation is for demonstration purposes only and has no runtime effect on lambda parameters.
        // It can be used for documentation, static analysis, or by frameworks that process annotations.
        names.forEach((@MyDemoAnnotation var name) -> System.out.println("Custom Annotated: " + name)); // No runtime effect. It simply shows that you can now annotate lambda parameters (for documentation, static analysis, or framework use)

    }

    // Custom annotation to demonstrate annotating lambda parameters
    @interface MyDemoAnnotation {}
}