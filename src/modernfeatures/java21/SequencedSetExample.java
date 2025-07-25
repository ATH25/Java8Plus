package modernfeatures.java21;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

/**
 * Demonstrates SequencedSet in Java 21 using LinkedHashSet.
 * SequencedSet provides order-aware operations for sets, including
 * access to the first and last elements, and a reversed view of the set.
 */
public class SequencedSetExample {

    /**
     * Main method to demonstrate SequencedSet features such as insertion order,
     * first/last access, and reversed view.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a SequencedSet using LinkedHashSet
        SequencedSet<String> set = new LinkedHashSet<>();
        set.add("Red");
        set.add("Green");
        set.add("Blue");

        // Print the original set (in insertion order)
        System.out.println("Original Set: " + set);

        // Access and print the first and last elements
        System.out.println("First Element: " + set.getFirst());
        System.out.println("Last Element: " + set.getLast());

        // View and print the reversed set (order is reversed)
        SequencedSet<String> reversed = set.reversed();
        System.out.println("Reversed Set: " + reversed);
    }
}
