package edu.brandeis.cosi103a.samples.lecture10.refactoring.make_immutable.after1;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

// Here we've exposed reviews as an ImmutableList, which makes it clear that it will never change
// after we fetch it, and that if we want the most updated version of it we need to fetch it again.

class BookInfo {
    public String title;
    public String author;
    public int year;
    private List<String> reviews = new ArrayList<>();

    public void addReview(String review) {
        reviews = new ImmutableList.Builder<String>().addAll(reviews).add(review).build();
    }

    public void removeReview(String review) {
        reviews.remove(review);
    }

    public ImmutableList<String> getReviews() {
        return ImmutableList.copyOf(reviews);
    }

    @Override
    public String toString() {
        return "BookInfo{title='" + title + "\', author='" + author + "\', year=" + year + "}";
    }
}

public class Example {
    public static void main(String[] args) {
        BookInfo book = new BookInfo();
        
        book.title = "Effective Java";
        book.author = "Joshua Bloch";
        book.year = 2008;

        book.addReview("Great book on Java best practices.");
        book.addReview("A must-read for Java developers.");

        ImmutableList<String> reviews = book.getReviews();
        System.out.println("Initial reviews: " + reviews);
        // Can't modify an ImmutableList

        // Modify the list through BookInfo mutators
        book.removeReview("Great book on Java best practices.");
        // It's clear at this point that `reviews` has not changed - it's immutable
        System.out.println("Local reviews after removing a review through BookInfo: " + reviews);
        System.out.println("Instance reviews after removing a review through BookInfo: " + book.getReviews());
    }
}
