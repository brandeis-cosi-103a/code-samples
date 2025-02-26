package edu.brandeis.cosi103a.samples.lecture12;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BookRpcClient {

    private static final String BASE_URL = "http://example.com/rpc";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public BookRpcClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public Book getBook(String isbn) {
        String url = BASE_URL + "/getBook/" + isbn;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), Book.class);
        } catch (IOException | InterruptedException e) {
            // Note: Not good practice for handling exceptions! Just for demonstration purposes.
            System.err.println("Error fetching book: " + e.getMessage());
            return null;
        }
    }

    public boolean addBook(String isbn, String title, String author) {
        String url = BASE_URL + "/addBook";
        Book book = new Book(isbn, title, author);

        try {
            String requestBody = objectMapper.writeValueAsString(book);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Book addedBook = objectMapper.readValue(response.body(), Book.class);

            System.out.println("Response:");
            System.out.println(addedBook);
            return true;
        } catch (IOException | InterruptedException e) {
            // Note: Not good practice for handling exceptions! Just for demonstration purposes.
            System.err.println("Error adding book: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        BookRpcClient client = new BookRpcClient();

        // Test adding a new book
        System.out.println("Adding a book...");
        client.addBook("978-1-4028-9462-6", "The Pragmatic Programmer", "Andy Hunt & Dave Thomas");

        // Test retrieving a book
        System.out.println("\nFetching book details...");
        client.getBook("978-1-4028-9462-6");

        // Test retrieving a non-existent book
        System.out.println("\nFetching a non-existent book...");
        client.getBook("999-9-99-999999-9");
    }

    static class Book {
        public String isbn;
        public String title;
        public String author;

        public Book() {} // Default constructor for Jackson

        public Book(String isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }
}