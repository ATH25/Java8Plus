package modernfeatures.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamBasicsExampleV3 {

    public static void main(String[] args) {
        // Sample list of names
        List<String> names = List.of("Alice", "Bob", "Charlie", "Dave");

        // Step-by-step explanation of stream operations:
        // 1. Create a stream from the list
        // 2. Filter names longer than 3 characters
        // 3. Convert them to uppercase
        // 4. Print each result

        Stream<String> nameStream = names.stream(); // Step 1: Create a stream
                Predicate<String> isLengthGT3 = (String name) -> name.length() > 3;

        nameStream
                .filter(isLengthGT3)       // Step 2: Intermediate operation - filter
                .map(String::toUpperCase)               // Step 3: Intermediate operation - map to uppercase
                .forEach(System.out::println);          // Step 4: Terminal operation - print each name
    }
}
