package modernfeatures.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Demonstrates the basics of Java Streams, including usage of Predicate, Function, and Consumer
 * for filter, map, and forEach operations, respectively.
 * <p>
 * This example creates a pipeline to process a list of names, filtering for names longer than
 * 3 characters, converting them to uppercase, and printing each result.
 * </p>
 *
 * @author Aju
 * @version 1.0
 */
public class StreamBasicsExampleV5 {

    /**
     * Entry point for the demonstration of stream operations using Predicate, Function, and Consumer.
     * The method shows how to create a stream pipeline to process a list of names step by step.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Sample list of names to process using streams
        List<String> names = List.of("Alice", "Bob", "Charlie", "Dave");

        // Step-by-step explanation of stream operations:
        // 1. Create a stream from the list
        // 2. Filter names longer than 3 characters
        // 3. Convert them to uppercase
        // 4. Print each result

        // Step 1: Create a stream from the names list
        Stream<String> nameStream = names.stream();

        // Predicate: Checks if a name's length is greater than 3
        Predicate<String> isLengthGT3 = name -> name.length() > 3;

        // Function: Converts a name to uppercase
        Function<String, String> toUpper = name -> name.toUpperCase();

        // Consumer: Prints a name to the console
        Consumer<String> printName = name -> System.out.println(name);

        // Stream pipeline: filter, map, forEach
        nameStream
                .filter(isLengthGT3)        // Step 2: Keep only names longer than 3 characters
                .map(toUpper)               // Step 3: Convert names to uppercase
                .forEach(printName);        // Step 4: Print each name
    }
}
