package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Supplier;
import java.time.LocalDateTime;

/**
 * Class: SupplierExample
 * -----------------------
 * This class demonstrates:
 * 1. The built-in functional interface Supplier<T>
 *
 * - Supplier<T> represents a supplier of results.
 * - It has no input argument and returns a value of type T.
 * - The method to implement is get().
 */
public class SupplierExample {

    public static void main(String[] args) {
        // Simple Supplier that returns a constant string message
        Supplier<String> messageSupplier = () -> "Hello from Supplier!";

        // Invoke the supplier by calling get()
        System.out.println("Message: " + messageSupplier.get());

        // Supplier that generates the current timestamp
        Supplier<LocalDateTime> currentTimeSupplier = () -> LocalDateTime.now();

        // Invoke to get current timestamp
        System.out.println("Current time: " + currentTimeSupplier.get());
    }
}
