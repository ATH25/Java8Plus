package modernfeatures.streams;

import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates advanced sorting techniques with Java Streams and Comparators.
 * <p>
 * Includes examples of:
 * <ul>
 *   <li>Sorting by string length (ascending and descending)</li>
 *   <li>Sorting by the last character of each name</li>
 *   <li>Sorting in reverse (alphabetical) order</li>
 * </ul>
 * Edge cases are handled: the list is checked for null and emptiness before processing.
 */
public class StreamAdvancedSortingExample {

    /**
     * Runs advanced sorting examples on a sample list of names.
     * <ol>
     *     <li>Checks for null and empty lists to prevent runtime errors.</li>
     *     <li>Sorts names by length (shortest to longest).</li>
     *     <li>Sorts names by length (longest to shortest).</li>
     *     <li>Sorts names by the last letter (assumes non-empty strings).</li>
     *     <li>Sorts names in reverse (alphabetical) order.</li>
     * </ol>
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Dave");

        // Check for null list before proceeding with stream operations
        if (names == null) {
            System.out.println("List is null");
            return;
        }
        // Check for empty list to avoid unnecessary processing
        if (names.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        // Sort names by length (shortest to longest)
        System.out.println("\nNames sorted by length:");
        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        // Sort names by length (longest to shortest)
        System.out.println("\nNames sorted by length (reversed):");
        names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);

        // Sort names by the last letter
        // Assumes all names are non-empty strings
        System.out.println("\nNames sorted by the last letter:");
        names.stream()
                .sorted(Comparator.comparing(name -> name.charAt(name.length() - 1)))
                .forEach(System.out::println);

        // Sort names in reverse (alphabetical) order
        System.out.println("\nNames sorted in reverse order:");
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

}