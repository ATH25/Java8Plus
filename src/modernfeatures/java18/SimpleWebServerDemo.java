package modernfeatures.java18;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.concurrent.Executors;

/**
 * A simple static file server using Java 18's built-in HttpServer.
 * <p>
 * This server serves static files from the "public" directory located
 * at the root of the project (i.e., alongside the README.md).
 * </p>
 * <p>
 * Once running, access it in your browser at:
 * http://localhost:8080/
 * </p>
 */
public class SimpleWebServerDemo {

    public static void main(String[] args) throws IOException {
        // Convert the root directory to an absolute path
        Path rootDir = Path.of("public").toAbsolutePath();

        // Create the server to listen on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Create a handler that serves static files from the rootDir
        HttpHandler handler = SimpleFileServer.createFileHandler(rootDir);
        server.createContext("/", handler);

        // Optional: Use a thread pool
        server.setExecutor(Executors.newFixedThreadPool(4));

        // Start the server
        server.start();

        System.out.println("Simple Web Server running at http://localhost:8080/");
        System.out.println("🗂️ Serving files from: " + rootDir);
    }
}