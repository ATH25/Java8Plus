package modernfeatures.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Demonstrates the use of Java 8 Streams and functional interfaces to process a list of names.
 * <p>
 * This example showcases how to:
 * <ul>
 *     <li>Create a Stream from a List</li>
 *     <li>Use Predicate for filtering names</li>
 *     <li>Use Function for mapping/transformation</li>
 *     <li>Use Consumer for processing/output</li>
 *     <li>Chain intermediate operations (filter, map, sorted)</li>
 *     <li>Trigger terminal operation (forEach)</li>
 * </ul>
 * The stream pipeline prints all names longer than 3 characters,
 * in uppercase, sorted in alphabetical order.
 */
public class StreamBasicsPrintNamesAlpha {

    /**
     * Main method demonstrating the stream pipeline:
     * <ol>
     *     <li>Create a Stream from a list of names</li>
     *     <li>Filter names with length greater than 3</li>
     *     <li>Convert each name to uppercase</li>
     *     <li>Sort the names alphabetically</li>
     *     <li>Print each name to the console</li>
     * </ol>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Sample list of names to process
        List<String> names = List.of("Alice", "Bob", "Zach", "Yana", "Charlie", "Dave");

        // Create a stream from the list of names
        Stream<String> nameStream = names.stream();

        // Predicate: checks if a name's length is greater than 3
        Predicate<String> isLengthGT3 = (String name) -> name.length() > 3;

        // Alternative Predicate: checks if length > 3 and starts with uppercase A-Z (not used here)
        Predicate<String> isLengthGT3Alpha = (String name) ->
                name.length() > 3 && name.charAt(0) >= 'A' && name.charAt(0) <= 'Z';

        // Function: converts a name to uppercase
        Function<String, String> toUpper = name -> name.toUpperCase();

        // Consumer: prints a name to the console
        Consumer<String> printName = name -> System.out.println(name);

        // Stream pipeline:
        // 1. Filter names longer than 3 characters
        // 2. Convert to uppercase
        // 3. Sort alphabetically (natural order)
        // 4. Print each name
        nameStream
                .filter(isLengthGT3)       // Intermediate operation: filter
                .map(toUpper)              // Intermediate operation: map to uppercase
                .sorted()                  // Intermediate operation: sort alphabetically
                .forEach(printName);       // Terminal operation: print each name
    }
}
