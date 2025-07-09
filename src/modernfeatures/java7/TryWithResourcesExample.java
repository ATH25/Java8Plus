package modernfeatures.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Demonstrates Java 7's try-with-resources statement for automatic resource management.
 * The file "sample.txt" should exist in your project's root or specify the correct path.
 */
public class TryWithResourcesExample {
    public static void main(String[] args) {
        // The resource (BufferedReader) is declared inside the try statement.
        // It will be closed automatically, even if an exception occurs.
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // No need to call reader.close()!
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Reader is closed here, outside the try block.
    }
}