package com.example.Libraries;

import com.example.Books.Book;


public interface ILibrary {
    void addBook(Book book);
    
    void borrowBook(String title);

    void returnBook(String title);

    void displayBooks();

    Book findBook(String title);

    void saveBooks();
}
