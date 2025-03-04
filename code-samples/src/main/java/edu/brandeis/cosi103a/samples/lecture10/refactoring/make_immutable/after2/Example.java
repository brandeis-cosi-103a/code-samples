package edu.brandeis.cosi103a.samples.lecture10.refactoring.make_immutable.after2;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

// Here we've gone a step further and made the entire BookInfo class immutable.
// We've removed the public fields and made them private, and added methods to modify the fields,
// which function by creating a new instance and returning it.
// This can be inefficient, and isn't appropriate in a performance sensitive context,
// but when that isn't a consideration, making objects immutable can vastly improve
// readability.

final class BookInfo {
    private String title;
    private String author;
    private int year;
    private ImmutableList<String> reviews;

    public BookInfo(String title, String author, int year, ImmutableList<String> reviews) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.reviews = reviews;
    }

    public BookInfo() {
        this("", "", 0, ImmutableList.of());
    }

    public BookInfo withTitle(String title) {
        return new BookInfo(title, this.author, this.year, this.reviews);
    }

    public BookInfo withAuthor(String author) {
        return new BookInfo(this.title, author, this.year, this.reviews);
    }

    public BookInfo withYear(int year) {
        return new BookInfo(this.title, this.author, year, this.reviews);
    }

    public BookInfo addReview(String review) {
        ImmutableList<String> newReviews = new ImmutableList.Builder<String>().addAll(this.reviews).add(review).build();
        return new BookInfo(this.title, this.author, this.year, newReviews);
    }

    public BookInfo removeReview(String review) {
        List<String> mutableReviews = new ArrayList<>(this.reviews);
        mutableReviews.remove(review);
        ImmutableList<String> newReviews = ImmutableList.copyOf(mutableReviews);
        return new BookInfo(this.title, this.author, this.year, newReviews);
    }

    public ImmutableList<String> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "BookInfo{title='" + title + "\', author='" + author + "\', year=" + year + "}";
    }
}

public class Example {
    public static void main(String[] args) {
        BookInfo book = new BookInfo()
                .withTitle("Effective Java")
                .withAuthor("Joshua Bloch")
                .withYear(2008)
                .addReview("Great book on Java best practices.")
                .addReview("A must-read for Java developers.");

        BookInfo book2 = book.withYear(2022);
        
        ImmutableList<String> reviews = book.getReviews();
        System.out.println("Initial reviews: " + reviews);
        // Can't modify an ImmutableList

        // Modify the list through BookInfo mutators
        book = book.removeReview("Great book on Java best practices.");
        System.out.println("Local reviews after removing a review through BookInfo: " + reviews);
        System.out.println("Instance reviews after removing a review through BookInfo: " + book.getReviews());
    }
}
