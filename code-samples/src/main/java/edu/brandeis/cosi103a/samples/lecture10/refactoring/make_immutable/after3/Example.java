package edu.brandeis.cosi103a.samples.lecture10.refactoring.make_immutable.after3;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

// Here we've taken the tiny step of marking the BookInfo fields as final.
// This clearly conveys (and allows the compiler to enforce) that the fields are never reassigned.

// One caution about final: it only makes the reference to the object immutable, not the object itself.
// So a final List can still have elements added or removed, and a final object can still have its fields modified.
// If immutability is critical, it's important to compose your objects of other immutable types.

final class BookInfo {
    private final String title;
    private final String author;
    private final int year;
    private final ImmutableList<String> reviews;

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

        ImmutableList<String> reviews = book.getReviews();
        System.out.println("Initial reviews: " + reviews);
        // Can't modify an ImmutableList

        // Modify the list through BookInfo mutators
        book = book.removeReview("Great book on Java best practices.");
        System.out.println("Local reviews after removing a review through BookInfo: " + reviews);
        System.out.println("Instance reviews after removing a review through BookInfo: " + book.getReviews());
    }
}
