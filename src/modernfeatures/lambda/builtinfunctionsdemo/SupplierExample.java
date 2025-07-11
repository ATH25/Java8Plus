package modernfeatures.lambda.builtinfunctionsdemo;

import java.util.function.Supplier;
import java.time.LocalDateTime;

/**
 * Demonstrates the use of the built-in functional interface {@code Supplier<T>}.
 * <p>
 * <ul>
 *   <li>{@code Supplier<T>} represents a supplier of results.</li>
 *   <li>No input argument; returns a value of type {@code T}.</li>
 *   <li>Key method to implement: {@code get()}.</li>
 * </ul>
 * <p>
 * <b>Example usage:</b>
 * <pre>
 *   Supplier&lt;String&gt; s = () -> "Hello";
 *   System.out.println(s.get());
 * </pre>
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
