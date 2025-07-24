package modernfeatures.java21;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates joining and checking the status of both classic (platform) threads and virtual threads in Java 21+.
 * <p>
 * This example launches multiple classic and virtual threads, waits for them to finish using {@code join()},
 * and then prints their final state to illustrate thread lifecycle management.
 * <p>
 * Key features demonstrated:
 * <ul>
 *     <li>Creating and starting classic (platform) threads and virtual threads</li>
 *     <li>Tracking threads with a list for later joining</li>
 *     <li>Using {@code join()} to wait for thread completion</li>
 *     <li>Checking and displaying thread state after joining</li>
 * </ul>
 */
public class ThreadJoinAndStatusDemo {

    /**
     * Main method: launches, tracks, joins, and checks the status of both platform and virtual threads.
     *
     * @param args command-line arguments (not used)
     * @throws InterruptedException if joining is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Classic (platform) threads ===");
        List<Thread> classicThreads = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            int id = i; // Each thread gets its own id
            Thread t = new Thread(() -> {
                System.out.println("[Platform] Thread " + id + " - " + Thread.currentThread() );
                try {
                    Thread.sleep(5000); // Sleep to keep thread alive for debugging/observation
                } catch (InterruptedException e) {
                    System.out.println("[Platform] Thread " + id + " interrupted!");
                }
            });
            t.start();
            classicThreads.add(t);
        }

        // Join all classic threads and show their state after completion
        for (Thread t : classicThreads) {
            t.join();
            System.out.println("Joined classic thread: " + t.getName() + " - State: " + t.getState());
        }

        System.out.println("\n=== Virtual threads ===");
        List<Thread> virtualThreads = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            int id = i;
            Thread vt = Thread.startVirtualThread(() -> {
                System.out.println("[Virtual] Thread " + id + " - " + Thread.currentThread());
                try {
                    Thread.sleep(5000); // Sleep for demonstration
                } catch (InterruptedException e) {
                    System.out.println("[Virtual] Thread " + id + " interrupted!");
                }
            });
            virtualThreads.add(vt);
        }

        // Join all virtual threads and show their state after completion
        for (Thread vt : virtualThreads) {
            vt.join();
            System.out.println("Joined virtual thread:: Name:" + vt.getName() + ", State: " + vt.getState() +", Thread Id: " + vt.threadId());
        }

        System.out.println("\nMain thread exiting.");
    }
}