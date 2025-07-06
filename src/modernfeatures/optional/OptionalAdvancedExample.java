package modernfeatures.optional;

import java.util.Optional;

public class OptionalAdvancedExample {
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

        // --- ADVANCED Optional methods demo ---
        System.out.println("\n--- Advanced Optional methods demo ---");
        // 4. Use map to transform value if present
        Optional<String> upperOpt = nameOpt.map(String::toUpperCase);
        upperOpt.ifPresent(upper -> System.out.println("Mapped (uppercase): " + upper));

        // 5. Use filter to keep only names starting with 'A'
        Optional<String> filteredOpt = nameOpt.filter(name -> name.startsWith("A"));
        System.out.println("Filtered (starts with 'A'): " + filteredOpt.orElse("No match"));

        // 6. Use map to call a function that already returns Optional<Integer>.
        //    This results in Optional<Optional<Integer>> (a nested Optional).
        Optional<Optional<Integer>> nested = nameOpt.map(name -> findNameLength(name));
        System.out.println("Nested Optional: " + nested);

        // 7. Use flatMap to "flatten" the result if your function already returns an Optional.
        //    This avoids double-wrapping and returns just Optional<Integer>.
        Optional<Integer> flat = nameOpt.flatMap(name -> findNameLength(name));
        System.out.println("FlatMapped length: " + flat.orElse(-1));

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

    /**
     * Returns an Optional containing the length of the given string if it's not null or empty.
     */
    static Optional<Integer> findNameLength(String name) {
        if (name == null || name.isEmpty()) return Optional.empty();
        return Optional.of(name.length());
    }

}
