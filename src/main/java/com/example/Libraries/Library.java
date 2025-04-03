package com.example.Libraries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.Books.Book;

public class Library {
    private final List<Book> books;
    private static final String FILE_PATH = "books.json";

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Library() {
        this.books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("Book added successfully.");
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailability(false);
                saveBooks();
                System.out.println("You borrowed: " + title);
                return;
            }
        }
        System.out.println("Book not available or doesn't exist.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailability(true);
                saveBooks();
                System.out.println("You returned: " + title);
                return;
            }
        }
        System.out.println("Invalid return.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void saveBooks() {
        JSONArray jsonArray = new JSONArray();

        for (Book book : books) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", book.getTitle());
            jsonObject.put("author", book.getAuthor());
            jsonObject.put("availability", book.isAvailable());
            jsonArray.put(jsonObject);
        }

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(jsonArray.toString(4)); // Pretty print JSON
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public void loadBooks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray jsonArray = new JSONArray(jsonString.toString());
            books.clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                Book book = new Book(obj.getString("title"), obj.getString("author"));
                book.setAvailability(obj.getBoolean("availability"));
                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }
}
