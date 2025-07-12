package modernfeatures.java9.collections;

import java.util.List;
import java.util.Set;
import java.util.Map;

/**
 * Demonstrates the use of Java 9 collection factory methods.
 * <p>
 * Java 9 introduced convenient static factory methods for creating immutable collections:
 * <ul>
 *   <li>{@code List.of()}</li>
 *   <li>{@code Set.of()}</li>
 *   <li>{@code Map.of()}</li>
 * </ul>
 * These methods allow concise creation of collections that are unmodifiable (immutable).
 * Attempting to modify them results in {@link UnsupportedOperationException}.
 * <p>
 * <b>Example usage:</b>
 * <pre>
 *   List&lt;String&gt; names = List.of("Alice", "Bob", "Carol");
 *   Set&lt;Integer&gt; numbers = Set.of(1, 2, 3, 4, 5);
 *   Map&lt;String, Integer&gt; ages = Map.of("Alice", 30, "Bob", 25);
 * </pre>
 */

public class CollectionFactoryMethodsDemo {

    /**
     * Demonstrates creation of immutable collections using Java 9 factory methods,
     * and shows that modification attempts result in exceptions.
     * <p>
     * This method performs the following steps:
     * <ul>
     *   <li>Creates an immutable {@code List} using {@code List.of()} and prints it.</li>
     *   <li>Creates an immutable {@code Set} using {@code Set.of()} and prints it.</li>
     *   <li>Creates an immutable {@code Map} using {@code Map.of()} and prints it.</li>
     *   <li>Attempts to modify each collection to demonstrate that they throw {@link UnsupportedOperationException}.</li>
     * </ul>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating an immutable List using List.of()
        List<String> names = List.of("Alice", "Bob", "Carol");
        System.out.println("Names: " + names);

        // Creating an immutable Set using Set.of()
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        System.out.println("Numbers: " + numbers);

        // Creating an immutable Map using Map.of()
        Map<String, Integer> ages = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Carol", 28
        );
        System.out.println("Ages: " + ages);

        // Attempting to modify the immutable List (should throw exception)
        try {
            names.add("Dave");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add to immutable List: " + e);
        }

        // Attempting to modify the immutable Set (should throw exception)
        try {
            numbers.remove(1);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot remove from immutable Set: " + e);
        }

        // Attempting to modify the immutable Map (should throw exception)
        try {
            ages.put("Dave", 40);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot put in immutable Map: " + e);
        }
    }
}