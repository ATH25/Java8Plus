package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Consumer;

/**
 * Demonstrates the use of {@link Consumer} and its chaining with {@code andThen()}.
 * <p>
 * Features covered:
 * <ul>
 *   <li>Creating {@code Consumer<T>} instances to process strings</li>
 *   <li>Using {@code andThen()} to chain multiple {@code Consumer} operations</li>
 *   <li>Examples of independent and combined {@code Consumer} execution</li>
 * </ul>
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
