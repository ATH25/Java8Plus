package modernfeatures.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Demonstrates counting, finding, and matching operations with Java 8 Streams.
 * <p>
 * This example shows how to:
 * <ul>
 *     <li>Count the number of names matching a condition</li>
 *     <li>Find the first name alphabetically (in uppercase)</li>
 *     <li>Check if all names start with an uppercase letter</li>
 * </ul>
 */
public class StreamCountFindMatchExample {

    /**
     * Main method demonstrating the use of count, findFirst, and allMatch stream operations.
     * <ol>
     *     <li>Count names longer than 4 characters</li>
     *     <li>Find the first name in alphabetical order (uppercase)</li>
     *     <li>Check if all names start with uppercase letters</li>
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

        // 1. Count how many names in the list have more than 4 characters
        long count = names.stream()
                .filter(name -> name.length() > 4)
                .count();
        System.out.println("Number of names with more than 4 characters: " + count);

        // 2. Find first name alphabetically in uppercase, with two output approaches
        String firstNameAlphabetically = names.stream()
                .map(toUpper)
                .sorted()
                .findFirst()
                .orElse("No name found");
        System.out.println("First name alphabetically (uppercase): " + firstNameAlphabetically);

        // Alternative: directly print with ifPresentOrElse
        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .findFirst()
                .ifPresentOrElse(
                        printName,
                        () -> System.out.println("No name found")
                );

        // 3. Check if all names start with an uppercase letter (using Character.isUpperCase for robustness)
        boolean allStartWithUppercase = names.stream()
                .allMatch(name -> Character.isUpperCase(name.charAt(0)));
        if (allStartWithUppercase) {
            System.out.println("All names start with uppercase letters");
        } else {
            System.out.println("Not all names start with uppercase letters");
        }
    }
}
