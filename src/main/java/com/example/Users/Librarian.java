package com.example.Users;

import com.example.Books.Book;
import com.example.Libraries.Library;

public class Librarian extends User {
    public Library library;

    public Librarian(String name, Library library) {
        super(name);
        this.library = library;
    }

    public void addBooks(Book book) {
        library.addBook(book);
    }

}