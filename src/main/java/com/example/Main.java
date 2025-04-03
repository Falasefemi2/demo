package com.example;

import java.util.Scanner;

import com.example.Books.Book;
import com.example.Libraries.Library;
import com.example.Users.Librarian;
import com.example.Users.Member;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Librarian librarian = new Librarian("Admin", library);
        Member member = new Member("Dan", library);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- Library Cli ---");
            System.out.println("1. Add book");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Display book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author = scanner.nextLine();
                    librarian.addBooks(new Book(title, author));
                }
                case 2 -> {
                    System.out.println("Enter book title:");
                    String titleBorrow = scanner.nextLine();
                    member.borrowBooks(titleBorrow);
                }
                case 3 -> {
                    System.out.println("Enter book title to return: ");
                    String titleReturn = scanner.nextLine();
                    member.returnBooks(titleReturn);
                }
                case 4 -> {
                    System.out.println("Display all books: ");
                    library.displayBooks();
                }
                case 5 -> {
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}