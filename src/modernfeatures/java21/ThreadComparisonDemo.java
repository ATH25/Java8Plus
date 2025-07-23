package modernfeatures.java21;

/**
 * Compares classic (platform) threads and virtual threads in Java 21+.
 * Demonstrates differences in creation, behavior, and scalability.
 */
public class ThreadComparisonDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Classic (platform) threads ===");
        for (int i = 1; i <= 3; i++) {
            int id = i; // Must be effectively final
            Thread t = new Thread(() -> {
                System.out.println("[Platform] Thread " + id + " - " + Thread.currentThread());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("[Platform] Thread " + id + " interrupted!");
                }
            });
            t.start();
        }
        Thread.sleep(800); // Let classic threads finish

        System.out.println("\n=== Virtual threads ===");
        for (int i = 1; i <= 3; i++) {
            int id = i;
            Thread vt = Thread.startVirtualThread(() -> {
                System.out.println("[Virtual] Thread " + id + " - " + Thread.currentThread());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("[Virtual] Thread " + id + " interrupted!");
                }
            });
            // No need to keep a reference; the JVM will manage these threads.
        }
        Thread.sleep(800); // Let virtual threads finish

        System.out.println("\nMain thread exiting.");
    }
}