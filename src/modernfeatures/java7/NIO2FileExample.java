package modernfeatures.java7;

import java.io.IOException;
import java.nio.file.*;

/**
 * Demonstrates Java 7's NIO.2 file API (Path, Files, etc.)
 * Shows how to create, write, read, and delete files using the modern API.
 */
public class NIO2FileExample {
    public static void main(String[] args) {
        Path path = Paths.get("nio2_sample.txt"); // Create a Path object

        //If you want to see the Path implementation class
        System.out.println("Actual Path class: " + path.getClass().getName());

        // 1. Create and write to a file
        try {
            // Files.write creates the file if it doesn't exist, and writes the content
            Files.write(path, "Hello, NIO.2 World!\nThis is a second line.".getBytes());
            System.out.println("File written: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }

        // 2. Check if file exists
        if (Files.exists(path)) {
            System.out.println("File exists.");
        }

        // 3. Read all lines from the file
        try {
            System.out.println("Reading file:");
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // 4. Delete the file
        try {
            Files.delete(path);
            System.out.println("File deleted.");
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}