package modernfeatures.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Demonstrates basic usage of CompletableFuture for asynchronous programming in Java 8+.
 */
public class CompletableFutureBasicsExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Example 1: Run a task asynchronously and get the result
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate some long-running computation
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello from CompletableFuture!";
        });

        // You can do other things here while the task runs...

        // Block and wait for the asynchronous computation to finish.
        // This will pause the main thread until the result is available.
        String result = future.get();
        System.out.println("Result: " + result);

        // Example 2: Run a task asynchronously without a result
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Running a task asynchronously!");
        });

        // Block and wait for the asynchronous task started by runAsync() to finish.
        // This ensures the async print statement completes before the program exits.
        future2.get();
    }
}