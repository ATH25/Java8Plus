package modernfeatures.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>Demonstrates basic usage of {@code CompletableFuture} for asynchronous programming in Java 8+.</p>
 * <ul>
 *   <li>Run asynchronous tasks that return a result using {@code CompletableFuture.supplyAsync()}.</li>
 *   <li>Run asynchronous tasks without a result using {@code CompletableFuture.runAsync()}.</li>
 *   <li>Block and wait for asynchronous computations to complete using {@code get()}.</li>
 * </ul>
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
 *     // Long-running computation
 *     Thread.sleep(10000);
 *     return "Hello from CompletableFuture!";
 * });
 * String result = future.get();
 * System.out.println("Result: " + result);
 * }
 * </pre>
 */
public class CompletableFutureBasicsExample {
    /**
     * <p>Main method demonstrating basic {@code CompletableFuture} usage.</p>
     * <ul>
     *   <li>Starts an asynchronous task that returns a result.</li>
     *   <li>Starts an asynchronous task without a result.</li>
     *   <li>Blocks the main thread to wait for completion of both tasks.</li>
     * </ul>
     *
     * @param args command line arguments (not used)
     * @throws ExecutionException if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
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