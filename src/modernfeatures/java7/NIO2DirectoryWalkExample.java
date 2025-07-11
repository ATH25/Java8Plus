package modernfeatures.java7;

import java.io.IOException;
import java.nio.file.*;

/**
 * This example demonstrates how to walk a directory tree using the NIO.2 Files.walk method.
 * It shows how to limit the recursion depth and handle IO exceptions that may occur during the walk.
 */
public class NIO2DirectoryWalkExample {
    public static void main(String[] args) {
        // "." represents the current directory
        Path startDir = Paths.get("."); // or specify any directory
        // limit the recursion depth
        int maxDepth = 2; // limit the recursion depth

        System.out.println("Walking directory: " + startDir.toAbsolutePath());

        // Try to walk the directory tree up to the specified max depth and print each path
        try {
            Files.walk(startDir, maxDepth)
                    .forEach(p -> System.out.println(p.toAbsolutePath())); // print the absolute path of each file/directory
        } catch (IOException e) {
            System.err.println("Error walking directory: " + e.getMessage());
        }
    }
}