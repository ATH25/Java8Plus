package modernfeatures.streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates advanced usage of Collectors in Java Streams,
 * particularly how to use groupingBy combined with mapping to transform
 * values inside grouped collections.
 */
public class CollectorsAdvancedExample {

    /**
     * The main method demonstrates grouping a list of names by their first letter,
     * and then mapping those names to their lengths within each group.
     */
    public static void main(String[] args) {
        // Sample data: List of strings
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Anna", "Alice");

        // --- Grouping: Group names by first letter ---
        // groupingBy groups the stream elements based on the first character of each name,
        // resulting in a Map where keys are first letters and values are lists of names starting with that letter.
        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped by first letter: " + groupedByFirstLetter);

        // Group names by first letter and collect their lengths
        // mapping transforms each name into its length, and collects these lengths into a list for each group.
        Map<Character, List<Integer>> namesByFirstLetterLengths = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0),
                        Collectors.mapping(String::length, Collectors.toList()) // mapping maps names to their lengths inside each group
                ));
        System.out.println("Name lengths grouped by first letter: " + namesByFirstLetterLengths);

        // Print each group and its list of name lengths for better understanding
        System.out.println("Detailed view of name lengths grouped by first letter:");
        namesByFirstLetterLengths.forEach((firstLetter, lengthsList) -> {
            System.out.println("First letter '" + firstLetter + "' has name lengths: " + lengthsList);
        });

    }

}
