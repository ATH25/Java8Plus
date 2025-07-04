package modernfeatures.optional;

import java.util.Optional;

/**
 * Demonstrates the basics of using Optional in Java.
 * Shows how to avoid null values by using Optional for safer, more expressive code.
 * Covers creation, presence checking, default value handling, and empty optionals.
 */
public class OptionalBasicExample {

    /**
     * Main method: runs demonstrations of basic Optional usage.
     * - Looks up values with Optional
     * - Handles missing values safely
     * - Shows orElse, ifPresent, and isEmpty
     */
    public static void main(String[] args) {
        // Example: a method that might or might not find a name by ID (returns Optional)
        Optional<String> nameOpt = findNameById(1);

        // 1. Check if a value is present, and safely get the value if present
        if (nameOpt.isPresent()) {
            System.out.println("Name found: " + nameOpt.get());
        } else {
            System.out.println("No name found for ID 1.");
        }

        // As above, but this time pass in 99 to simulate "not found" (empty Optional)
        Optional<String> nameOpt1 = findNameById(99);
        if (nameOpt1.isPresent()) {
            System.out.println("Name found: " + nameOpt1.get());
        } else {
            System.out.println("No name found for ID 99.");
        }

        // 2. Use orElse to provide a default value when Optional is empty
        // Here, since nameOpt contains "Alice", the default will NOT be used
        String nameOrDefault = nameOpt.orElse("Default Name");
        System.out.println("Name (or default): " + nameOrDefault);

        // 3. Use ifPresent to execute logic only when value exists
        // This will print the uppercase name if present
        nameOpt.ifPresent(name -> System.out.println("Uppercase: " + name.toUpperCase()));

        // Demonstrate creating an empty Optional and handling it safely
        Optional<String> emptyOpt = Optional.empty();
        // This would throw NoSuchElementException if uncommented:
        // String value = emptyOpt.get();

        // Use orElse to provide a fallback for empty Optional
        String value = emptyOpt.orElse("Default Value");
        System.out.println("Empty value::: " + value);

        // Use isEmpty to check if Optional is empty before running logic
        if (emptyOpt.isEmpty()) {
            System.out.println("Empty?");
        }

    }

    /**
     * Simulates a lookup by ID that may or may not find a name.
     * @param id The ID to look up.
     * @return An Optional containing the found name, or empty if not found.
     */
    static Optional<String> findNameById(int id) {
        if (id == 1) return Optional.of("Alice");
        // Simulate not found (empty optional)
        return Optional.empty();
    }
}