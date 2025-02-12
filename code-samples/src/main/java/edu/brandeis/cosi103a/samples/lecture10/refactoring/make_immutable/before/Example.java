package edu.brandeis.cosi103a.samples.lecture10.refactoring.make_immutable.before;

import java.util.ArrayList;
import java.util.List;

class BookInfo {
    public String title;
    public String author;
    public int year;
    public List<String> reviews = new ArrayList<>();

    public void addReview(String review) {
        reviews.add(review);
    }

    public void removeReview(String review) {
        reviews.remove(review);
    }

    public List<String> getReviews() {
        return reviews;
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

        List<String> reviews = book.getReviews();
        System.out.println("Initial reviews: " + reviews);

        // Modify the list directly
        reviews.add("An insightful read.");
        System.out.println("Reviews after direct modification: " + reviews);

        // Modify the list through BookInfo mutators
        book.removeReview("Great book on Java best practices.");
        System.out.println("Reviews after removing a review through BookInfo: " + reviews);
    }
}
