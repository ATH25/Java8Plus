package modernfeatures.java18;

public class VirtualThreadsDemo {
    /**
     * To run this with Java Flight Recorder (JFR) from the terminal:
     *
     * 1. Open terminal in the project root directory.
     * 2. Run:
     *
     * java -XX:StartFlightRecording=filename=recording.jfr,duration=10s,settings=profile \
     *      -cp out/production/Java8Plus modernfeatures.java18.VirtualThreadsDemo
     *
     * This will create a `recording.jfr` file in the current directory.
     * You can analyze it using JDK Mission Control or IntelliJ JFR viewer.
     */
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().toString();
            System.out.println("Running in: " + threadName);
            try {
                Thread.sleep(2000); // Give JFR time to record
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted: " + threadName);
            }
            System.out.println("Finished: " + threadName);
        };

        for (int i = 0; i < 5; i++) {
            Thread.startVirtualThread(task);
        }

        try {
            Thread.sleep(3000); // Wait for all virtual threads to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main method complete.");
    }
}
