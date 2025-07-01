package modernfeatures.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamBasicsExampleV4 {

    public static void main(String[] args) {
        // Sample list of names
        List<String> names = List.of("Alice", "Bob", "Charlie", "Dave");

        // Step-by-step explanation of stream operations:
        // 1. Create a stream from the list
        // 2. Filter names longer than 3 characters
        // 3. Convert them to uppercase
        // 4. Print each result

        Stream<String> nameStream = names.stream(); // Step 1: Create a stream

        nameStream
                .filter(name -> name.length() > 3)       // Step 2: Intermediate operation - filter
                .map(name -> name.toUpperCase())               // Step 3: Intermediate operation - map to uppercase
                .forEach(name -> System.out.println(name));          // Step 4: Terminal operation - print each name
    }
}
