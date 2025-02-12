package edu.brandeis.cosi103a.samples.lecture10.refactoring.use_object_orientation.before;

public class BookInfo {

    private String title;
    private String author;
    private String isbn;
    private int pages;

    public BookInfo(String title, String author, String isbn, int pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    public static void printBookInfo(String title, String author, String isbn, int pages) {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Pages: " + pages);
    }

    public static boolean validateBookInfo(String title, String author, String isbn, int pages) {
        BookInfo info = fetchBookInfo(isbn);
        if (!info.title.equals(title) || !info.author.equals(author) || info.pages != pages) {
            return false;
        }
        return true;
    }

    public static void addBookToLibrary(String title, String author, String isbn, int pages) {
        // add book to library
    }

    public static void promoteBook(String title, String author, String isbn, int pages) {
        // promote book
    }

    private static BookInfo fetchBookInfo(String isbn) {
        // Stub implementation
        return new BookInfo("Sample Title", "Sample Author", isbn, 100);
    }

    public static void main(String[] args) {
        String title = "Effective Java";
        String author = "Joshua Bloch";
        String isbn = "978-0134685991";
        int pages = 416;

        printBookInfo(title, author, isbn, pages);

        boolean isValid = validateBookInfo(title, author, isbn, pages);
        System.out.println("Is valid: " + isValid);

        addBookToLibrary(title, author, isbn, pages);
        promoteBook(title, author, isbn, pages);
    }
}