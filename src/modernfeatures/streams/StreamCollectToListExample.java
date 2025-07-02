package modernfeatures.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Demonstrates the use of Java 8 Streams to filter, transform, sort, and collect results into a List.
 * <p>
 * This example shows how to:
 * <ul>
 *   <li>Create a Stream from a List</li>
 *   <li>Filter elements using a Predicate</li>
 *   <li>Transform elements using a Function</li>
 *   <li>Sort the results</li>
 *   <li>Collect the results into a List</li>
 *   <li>Process the final List with a Consumer</li>
 * </ul>
 */
public class StreamCollectToListExample {

    /**
     * Main method demonstrating the use of Stream pipeline operations.
     * <ol>
     *     <li>Filter names longer than 3 characters</li>
     *     <li>Convert names to uppercase</li>
     *     <li>Sort names alphabetically</li>
     *     <li>Collect the results into a List</li>
     *     <li>Print each name in the final List</li>
     * </ol>
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // List of names to process
        List<String> names = List.of("Alice", "Bob", "Zach", "Yana", "Charlie", "Dave");

        // Predicate to check if the name has more than 3 characters
        Predicate<String> isLengthGT3 = name -> name.length() > 3;

        // Function to convert the name to uppercase
        Function<String, String> toUpper = name -> name.toUpperCase();

        // Consumer to print the name
        Consumer<String> printName = name -> System.out.println(name);

        // Stream pipeline:
        //   - filter names longer than 3 characters
        //   - map to uppercase
        //   - sort alphabetically
        //   - collect into a new List
        List<String> sortedList = names.stream()
                .filter(isLengthGT3)
                .map(toUpper)
                .sorted()
                .collect(Collectors.toList());

        // Print each name from the resulting List
        sortedList.forEach(printName);
    }
}