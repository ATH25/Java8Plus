package modernfeatures.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Demonstrates usage of Java 11's {@code HttpClient} for HTTP requests.
 * <p>
 * This example covers:
 * <ul>
 *   <li>Synchronous HTTP GET requests using {@code HttpClient.send()}</li>
 *   <li>Asynchronous HTTP GET requests using {@code HttpClient.sendAsync()}</li>
 * </ul>
 * <p>
 * The class shows how to:
 * <ul>
 *   <li>Build and send a synchronous request, and process the response.</li>
 *   <li>Build and send an asynchronous request, register a callback to handle the response,
 *   and ensure the program waits for the async operation to complete.</li>
 * </ul>
 * <pre>
 * Usage:
 *   java modernfeatures.java11.HttpClientDemo
 * </pre>
 */
public class HttpClientDemo {
    /**
     * Main method demonstrating:
     * <ul>
     *   <li>How to perform a synchronous HTTP GET request and print the response.</li>
     *   <li>How to perform an asynchronous HTTP GET request, register a callback for the response,
     *   and wait for the asynchronous operation to finish.</li>
     * </ul>
     *
     * @param args command-line arguments (not used)
     * @throws Exception if an error occurs during HTTP operations
     */
    public static void main(String[] args) throws Exception, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Synchronous GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        System.out.println("Sending synchronous GET request...");
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body:");
        System.out.println(response.body());

        // Asynchronous GET request
        HttpRequest asyncRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/2"))
                .GET()
                .build();

        System.out.println("\nSending asynchronous GET request...");
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(
                asyncRequest, HttpResponse.BodyHandlers.ofString());

        // Register a callback to handle the asynchronous response.
        // The thenAccept method schedules the provided lambda to be called when the response arrives.
        // The join() call ensures the main thread waits for the async processing to complete
        // before exiting the program.
        future.thenAccept(asyncResponse -> {
            System.out.println("Async Response status code: " + asyncResponse.statusCode());
            System.out.println("Async Response body:");
            System.out.println(asyncResponse.body());
        }).join(); // .thenAccept registers the callback; .join() waits for completion.

        System.out.println("Done!");
    }
}