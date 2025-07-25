package modernfeatures.java21;

import java.util.ArrayList;
import java.util.SequencedCollection;

/**
 * Demonstrates SequencedCollection in Java 21 using an ArrayList.
 * <p>
 * SequencedCollection is a new interface introduced in Java 21 that ensures a predictable order
 * for collection elements. It provides methods to access the first and last elements, as well as a reversed view.
 */
public class SequencedCollectionDemo {

    /**
     * Main method to demonstrate usage of SequencedCollection.
     * It creates a sequenced collection, adds elements, retrieves first and last elements,
     * and prints a reversed view of the collection.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a SequencedCollection using ArrayList
        SequencedCollection<String> items = new ArrayList<>();
        items.add("Alpha");
        items.add("Beta");
        items.add("Gamma");

        // Print the original collection
        System.out.println("Original collection: " + items);

        // Access and print the first and last elements
        System.out.println("First element: " + items.getFirst());
        System.out.println("Last element: " + items.getLast());

        // Print the reversed view of the collection
        SequencedCollection<String> reversed = items.reversed();
        System.out.println("Reversed view: " + reversed);
    }
}
