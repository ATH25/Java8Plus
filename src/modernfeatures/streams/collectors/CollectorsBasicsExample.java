package modernfeatures.streams.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demonstrates basic usage of Collectors in Java Streams.
 * Covers toList(), toSet(), toMap(), joining(), groupingBy(), partitioningBy(), and summarizing collectors.
 */
public class CollectorsBasicsExample {
    public static void main(String[] args) {
        // Sample data: List of strings
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Anna", "Alice");

        // --- Collect to List ---
        List<String> namesList = names.stream()
                .collect(Collectors.toList());
        System.out.println("Names as list: " + namesList);

        // --- Collect to Set (duplicates removed) ---
        Set<String> namesSet = names.stream()
                .collect(Collectors.toSet());
        System.out.println("Names as set: " + namesSet);

        // --- Collect to Map (name -> length) ---
//        Function<String, String> personName = name -> name;
//        Function<String, Integer> nameLength = String::length;
//        Map<String, Integer> nameLengthMap = names.stream().distinct()
//                .collect(Collectors.toMap(personName, nameLength));

        Map<String, Integer> nameLengthMap = names.stream().distinct()
                .collect(Collectors.toMap(
                        name -> name,
                        String::length
                ));
        System.out.println("Name to length map: " + nameLengthMap);

        // --- Joining: Concatenate names with delimiter ---
        String joinedNames = names.stream()
                .collect(Collectors.joining("| "));
        System.out.println("Joined names: " + joinedNames);

        // --- Grouping: Group names by first letter ---
        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped by first letter: " + groupedByFirstLetter);

        // --- Partitioning: Partition names by length > 3 ---
        Map<Boolean, List<String>> partitionedByLength = names.stream()
                .collect(Collectors.partitioningBy(name -> name.length() > 3));
        System.out.println("Partitioned by length > 3: " + partitionedByLength);

        // --- Summarizing: Get statistics on name lengths ---
        IntSummaryStatistics stats = names.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("Summary stats for name lengths: " + stats);
    }
}