package modernfeatures.java7;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;

    private static final int THRESHOLD = 5;

    /**
     * Constructs a SumTask for summing a segment of the array.
     *
     * @param arr the array to sum
     * @param start the starting index (inclusive) of the segment
     * @param end the ending index (exclusive) of the segment
     */
    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    /**
     * Computes the sum of the assigned array segment.
     * If the segment size is below the threshold, sums sequentially;
     * otherwise, splits the task into subtasks that run in parallel.
     *
     * @return the sum of the segment
     */
    @Override
    protected Integer compute() {
        // Print current task range and thread name for demonstration
        System.out.println("Computing sum from index " + start + " to " + end + " on thread " + Thread.currentThread().getName());

        if (end - start <= THRESHOLD) {
            // Sequential sum for small enough segment
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);
            // Fork the left subtask to run in parallel
            left.fork();
            // Compute the right subtask directly
            int rightResult = right.compute();
            // Wait for the left subtask to complete and get its result
            int leftResult = left.join();
            return leftResult + rightResult;
        }
    }
}

/**
 * Demonstrates the use of the Fork/Join framework to sum an array of integers in parallel.
 * The array is recursively divided into smaller tasks that are processed concurrently,
 * improving performance on multi-core processors.
 */
public class ForkJoinSumDemo {
    public static void main(String[] args) {
        // Create an array of numbers to sum
        int[] numbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        // Create a ForkJoinPool to manage worker threads and invoke the SumTask
        try (ForkJoinPool pool = new ForkJoinPool()) {
            int total = pool.invoke(new SumTask(numbers, 0, numbers.length));
            // Print the final sum result
            System.out.println("Sum is: " + total); // Output: 110
        }
    }
}