package modernfeatures.java21;

/**
 * Demonstration of Virtual Threads in Java 21+.
 * <p>
 * This class showcases the use of virtual threads, a lightweight concurrency model introduced in Java 21 as part
 * of Project Loom. Virtual threads allow for the creation of thousands (or even millions) of concurrent threads
 * with minimal resource overhead compared to traditional platform threads. This makes high-concurrency programming
 * more scalable and accessible. Virtual threads are significant because they decouple the Java thread from the
 * underlying OS thread, enabling efficient management of concurrent tasks and better utilization of modern hardware.
 * </p>
 */
public class VirtualThreadsDemo {
    /**
     * Main method demonstrating how to launch and use virtual threads.
     * <p>
     * The method launches 5 virtual threads. Each thread prints its identifier and thread info,
     * then sleeps for 1 second to simulate some work. The main thread then sleeps for a short time
     * to allow the virtual threads to complete before the program exits. (In production code,
     * proper synchronization or thread joining would be used instead of sleeping.)
     * </p>
     *
     * @param args command-line arguments (not used)
     * @throws InterruptedException if the main thread is interrupted while sleeping
     */
    public static void main(String[] args) throws InterruptedException {
        // Launch several virtual threads, each with a unique ID.
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            Thread.startVirtualThread(() -> {
                // Each virtual thread prints its ID and thread information.
                System.out.println("Virtual thread " + id + " running in " + Thread.currentThread());
                try {
                    // Simulate some work by sleeping for 1 second.
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Virtual thread " + id + " interrupted!");
                }
            });
        }

        // For demonstration purposes: sleep the main thread briefly to let virtual threads finish
        // before the main thread exits. In real applications, use proper synchronization.
        Thread.sleep(1500);
        System.out.println("Main thread exiting.");
    }
}