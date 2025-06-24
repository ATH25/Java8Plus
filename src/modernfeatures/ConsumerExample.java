package modernfeatures;

import java.util.function.Consumer;

/**
 * Demonstrates the built-in Consumer<T> functional interface.
 *
 * Consumer<T> takes a single input and returns nothing (void).
 * It is commonly used for performing actions like printing, logging, etc.
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // Consumer with lambda: prints the input string
        Consumer<String> printer = message -> System.out.printf("Message received: %s%n", message);

        // Invoking the Consumer using accept()
        printer.accept("Hello from Consumer!");

        // Consumer with multi-line body
        Consumer<String> fancyPrinter = message -> {
            System.out.printf("Printing message with decoration:%n");
            System.out.printf(">> %s <<%n", message);
        };

        fancyPrinter.accept("Decorated message");
    }
}