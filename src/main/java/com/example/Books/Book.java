package com.example.Books;

import java.io.Serializable;

public class Book implements Serializable {
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Updated method name following Java convention
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    // Overriding toString() for better usability
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Availability: " + (isAvailable ? "Yes" : "No");
    }
}
