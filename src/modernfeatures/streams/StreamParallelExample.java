package modernfeatures.streams;

import java.util.List;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Demonstrates the use of parallel streams in Java.
 * Compares performance and behavior of sequential vs. parallel processing on a large dataset.
 */
public class StreamParallelExample {

    /**
     * Main method compares regular and parallel streams for summing even numbers.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a large list of integers from 1 to 10 million
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .collect(Collectors.toList());


        // Sequential stream: sum of all even numbers
        long startSequential = System.currentTimeMillis();
        long sumSequential = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long timeSequential = System.currentTimeMillis() - startSequential;
        System.out.printf("Sequential sum: %d, Time taken: %d ms%n", sumSequential, timeSequential);

        // Parallel stream: sum of all even numbers
        long startParallel = System.currentTimeMillis();
        long sumParallel = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long timeParallel = System.currentTimeMillis() - startParallel;
        System.out.printf("Parallel sum:   %d, Time taken: %d ms%n", sumParallel, timeParallel);

        // Note: Results should match, but timing may vary depending on your CPU and system.
    }
}