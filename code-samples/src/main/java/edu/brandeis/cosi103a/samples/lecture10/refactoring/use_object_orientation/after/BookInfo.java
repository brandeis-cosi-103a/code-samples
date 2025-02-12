package edu.brandeis.cosi103a.samples.lecture10.refactoring.use_object_orientation.after;

// We've taken better advantage of object orientation by using instance methods on BookInfo where possible.
// This situation might arise in a codebase when a class arises organically from a set of helper methods - 
// the class is introduced, but not all relevant functionality is immediately moved to it.

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

    public void printBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Pages: " + pages);
    }

    public boolean validateBookInfo() {
        BookInfo info = fetchBookInfo(isbn);
        if (!info.title.equals(title) || !info.author.equals(author) || info.pages != pages) {
            return false;
        }
        return true;
    }

    public void addBookToLibrary() {
        // add book to library
    }

    public void promoteBook() {
        // promote book
    }

    private BookInfo fetchBookInfo(String isbn) {
        // Stub implementation
        return new BookInfo("Sample Title", "Sample Author", isbn, 100);
    }

    public static void main(String[] args) {
        BookInfo book = new BookInfo("Effective Java", "Joshua Bloch", "978-0134685991", 416);

        book.printBookInfo();

        boolean isValid = book.validateBookInfo();
        System.out.println("Is valid: " + isValid);

        book.addBookToLibrary();
        book.promoteBook();
    }
}
