package modernfeatures.java21;

/**
 * Demonstrates and compares classic (platform) threads and virtual threads in Java 21+.
 * <p>
 * This class launches several classic threads and several virtual threads, showing their creation,
 * execution, and thread identity. It prints each thread's details and sleeps them briefly to
 * illustrate their independent execution. The example highlights differences between classic and
 * virtual threads, particularly in how they are created, managed, and reported by the JVM.
 * <p>
 * Note: This example uses Thread.sleep in the main method as a simple way to let child threads
 * finish before the main thread exits. In production code, more robust synchronization (like join)
 * should be used.
 */
public class ThreadComparisonDemo {

    /**
     * Entry point. Launches classic (platform) threads and virtual threads, each printing their
     * identity and sleeping to simulate work. Thread.sleep is used in each thread to simulate
     * workload and in the main method to give threads time to run before the main thread exits.
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if the main thread is interrupted while sleeping
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Classic (platform) threads ===");
        // Launch 3 classic (platform) threads
        for (int i = 1; i <= 3; i++) {
            int id = i; // Must be effectively final
            Thread t = new Thread(() -> {
                // Print thread identity and type for demonstration
                System.out.println("[Platform] Thread " + id + " - " + Thread.currentThread());
                try {
                    // Simulate work by sleeping (to keep the thread alive briefly)
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("[Platform] Thread " + id + " interrupted!");
                }
            });
            t.start();
        }
        // Pause main thread briefly to allow classic threads to start and run
        // (Not robust synchronization; just for demonstration)
        Thread.sleep(800); // Let classic threads finish

        System.out.println("\n=== Virtual threads ===");
        // Launch 3 virtual threads (Java 21+ feature)
        for (int i = 1; i <= 3; i++) {
            int id = i;
            Thread vt = Thread.startVirtualThread(() -> {
                // Print thread identity and type for demonstration
                System.out.println("[Virtual] Thread " + id + " - " + Thread.currentThread());
                try {
                    // Simulate work by sleeping (to keep the thread alive briefly)
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("[Virtual] Thread " + id + " interrupted!");
                }
            });
            // No need to keep a reference; the JVM will manage these threads.
        }
        // Pause main thread briefly to allow virtual threads to start and run
        // (Not robust synchronization; just for demonstration)
        Thread.sleep(800); // Let virtual threads finish

        System.out.println("\nMain thread exiting.");
    }
}