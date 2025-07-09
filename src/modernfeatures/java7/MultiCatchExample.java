package modernfeatures.java7;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Demonstrates Java 7's multi-catch exception handling.
 * You can catch multiple exception types in a single catch block using '|'.
 */
public class MultiCatchExample {
    public static void main(String[] args) {
        try {
            riskyOperation(2); // Try 1, 2, or 3 as argument to simulate different exceptions
        } catch (IOException | SQLException e) {
            System.out.println("Caught exception: " + e);
            // e is effectively final—you can't assign to it
        }
    }

    /**
     * Simulates code that can throw different checked exceptions.
     *
     * @param exceptionType Type of exception to throw:
     *                      1 for IOException, 2 for SQLException, other for no exception.
     * @throws IOException if exceptionType == 1
     * @throws SQLException if exceptionType == 2
     */
    static void riskyOperation(int exceptionType) throws IOException, SQLException {
        switch (exceptionType) {
            case 1:
                throw new IOException("Simulated IO error");
            case 2:
                throw new SQLException("Simulated SQL error");
            default:
                System.out.println("Operation completed successfully!");
        }
    }
}