package modernfeatures.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class demonstrates advanced CompletableFuture features:
 * chaining, combining, and exception handling.
 */
public class CompletableFutureMoreFeatures {

    /**
     * Demonstrates chaining, combining, and exception handling with CompletableFuture.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Starting two async tasks in parallel
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            sleep(700);
            return 10;
        });
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            sleep(400);
            return 20;
        });

        // Chaining transformation with thenApply
        CompletableFuture<Integer> chained = task1.thenApply(result -> result * 2); // Doubles the result (should be 20)

        // Combining results with thenCombine
        CompletableFuture<Integer> combined = task1.thenCombine(task2, Integer::sum); // Adds the results (10 + 20 = 30)

        // Handling exceptions and completion with exceptionally, whenComplete, and handle
        CompletableFuture<Integer> withErrorHandling = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return 42;
        })
        // exceptionally handles only exceptions and can provide a fallback value
        .exceptionally(ex -> {
            System.out.println("exceptionally: Caught exception: " + ex);
            return -1;
        })
        // whenComplete runs after completion (success or failure), for side-effects like logging
        .whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("whenComplete: Logging exception: " + ex);
            } else {
                System.out.println("whenComplete: Task completed successfully, result = " + result);
            }
        })
        // handle can process both the result and exception and can transform the outcome
        .handle((result, ex) -> {
            if (ex != null) {
                System.out.println("handle: Handling exception, returning fallback value -2");
                return -2;
            }
            System.out.println("handle: Result is " + result);
            return result;
        });

        // Printing results
        System.out.println("----------------------------\nChained result (task1 * 2): " + chained.get());
        System.out.println("Combined result (task1 + task2): " + combined.get());
        System.out.println("Result with error handling: " + withErrorHandling.get());

    }

    /**
     * Helper method for sleep.
     * Pauses the current thread for the specified number of milliseconds.
     */
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

}
