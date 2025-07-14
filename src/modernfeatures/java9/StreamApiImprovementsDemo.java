package modernfeatures.java9;

import java.util.List;
import java.util.stream.Stream;

/**
 * Demonstrates Java 9 Stream API improvements:
 * <ul>
 *   <li>{@code takeWhile}: takes elements from a stream while a condition holds.</li>
 *   <li>{@code dropWhile}: drops elements from a stream while a condition holds, then takes the rest.</li>
 *   <li>{@code ofNullable}: creates a stream of zero or one element, safely handling nulls.</li>
 * </ul>
 */
public class StreamApiImprovementsDemo {
    public static void main(String[] args) {
        // Example 1: takeWhile
        List<Integer> sortedNumbers = List.of(1, 2, 3, 6, 4, 2, 1);
        List<Integer> taken = sortedNumbers.stream()
                .takeWhile(n -> n < 5) // Stops at first n >= 5
                .toList();
        System.out.println("takeWhile (<5): " + taken); // Output: [1, 2, 3]

        // Example 2: dropWhile
        List<Integer> dropped = sortedNumbers.stream()
                .dropWhile(n -> n < 5) // Skips all <5, then takes rest
                .toList();
        System.out.println("dropWhile (<5): " + dropped); // Output: [6, 4, 2, 1]

        // Example 3: ofNullable
        String present = "Hello";
        String absent = null; // Intentionally set to null for demonstration

        // ofNullable returns a Stream with the value if not null, otherwise an empty Stream.
        long countPresent = Stream.ofNullable(present).count(); // 1 element
        long countAbsent = Stream.ofNullable(absent).count();   // 0 elements

        System.out.println("ofNullable (present): " + countPresent); // Output: 1 element
        System.out.println("ofNullable (absent): " + countAbsent + " elements");   // Output: 0 elements
    }
}