package modernfeatures.java21;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

/**
 * Demonstrates SequencedMap in Java 21 using a LinkedHashMap.
 * SequencedMap provides consistent ordering and access to the first and last entries.
 */
public class SequencedMapExample {
    /**
     * Main method to demonstrate usage of SequencedMap.
     * It creates a map with insertion order preserved, displays the first and last entries,
     * and prints the map in reversed order.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a SequencedMap using LinkedHashMap
        SequencedMap<Integer, String> map = new LinkedHashMap<>();
        map.put(101, "Alice");
        map.put(102, "Bob");
        map.put(103, "Charlie");

        // Display the full map
        System.out.println("Original Map: " + map);

        // Access the first and last entries
        System.out.println("First Entry: " + map.firstEntry());
        System.out.println("Last Entry: " + map.lastEntry());

        // View the map in reverse order
        SequencedMap<Integer, String> reversed = map.reversed();
        System.out.println("Reversed Map: " + reversed);
        // Print key and value of the last map item in the reversed view.
        System.out.println("Last Entry in reversed Map:: " + "Key: " + reversed.lastEntry().getKey() + ", Value: " + reversed.lastEntry().getValue());
    }
}
