package com.example.Users;

import com.example.Libraries.Library;

public class Member extends User {
    public Library library;

    public Member(String name, Library library) {
        super(name);
        this.library = library;
    }

    public void borrowBooks(String title) {
        library.borrowBook(title);
    }

    public void returnBooks(String title) {
        library.returnBook(title);
    }
}
