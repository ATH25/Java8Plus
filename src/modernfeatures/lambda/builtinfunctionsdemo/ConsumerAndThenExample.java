package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Consumer;

/**
 * Class: ConsumerAndThenExample
 * ------------------------------
 * This class demonstrates:
 * 1. The built-in functional interface {@code Consumer<T>}
 * 2. The usage of the {@code andThen()} method to chain multiple {@code Consumer}s.
 *
 * - {@code Consumer<T>} represents an operation that accepts a single input argument and returns no result.
 * - The {@code andThen()} method allows you to compose {@code Consumer}s sequentially.
 */
public class ConsumerAndThenExample {

    public static void main(String[] args) {
        // First Consumer: converts the input message to uppercase and prints it
        Consumer<String> upperCasePrinter = message -> {
            System.out.printf("Uppercase: %s%n", message.toUpperCase());
        };

        // Second Consumer: calculates and prints the length of the input message
        Consumer<String> lengthPrinter = message -> {
            System.out.printf("Length: %d%n", message.length());
        };

        // Chaining the two Consumers using andThen()
        // The combined Consumer will first run upperCasePrinter, then lengthPrinter on the same input
        Consumer<String> combinedPrinter = upperCasePrinter.andThen(lengthPrinter);

        // Invoking the combined Consumer with a test message
        combinedPrinter.accept("Functional Interfaces are powerful!");

        // Example of directly invoking each Consumer independently
        System.out.println("\n--- Running independently ---");
        upperCasePrinter.accept("Hello World");
        lengthPrinter.accept("Hello World");
    }
}
