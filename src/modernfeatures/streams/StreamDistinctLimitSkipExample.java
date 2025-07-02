package modernfeatures.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of distinct, limit, and skip operations with Java Streams.
 * <p>
 * This example shows how to:
 * <ul>
 *   <li>Remove duplicates from a list using distinct()</li>
 *   <li>Limit the output to the first N elements with limit()</li>
 *   <li>Skip the first N elements with skip()</li>
 * </ul>
 */
public class StreamDistinctLimitSkipExample {

    /**
     * Main method demonstrates the stream operations:
     * <ol>
     *   <li>Create a list of names with duplicates</li>
     *   <li>Print unique names using distinct()</li>
     *   <li>Print the first 3 names using limit()</li>
     *   <li>Print all names except the first 5 using skip()</li>
     * </ol>
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating a list of names with duplicates
        List<String> names = Arrays.asList(
                "John", "Alice", "Bob", "John", "Charlie",
                "David", "Alice", "Eve", "Frank", "Bob"
        );

        // Demonstrate distinct() - removes duplicates and prints unique names
        System.out.println("Distinct names:");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        // Demonstrate limit() - takes first 3 elements and prints them
        System.out.println("\nFirst 3 names:");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        // Demonstrate skip() - skips the first 5 elements and prints the rest
        System.out.println("\nSkipping first 5 names:");
        names.stream()
                .skip(5)
                .forEach(System.out::println);
    }
}
