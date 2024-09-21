package ru.clevertec.model;

import ru.clevertec.observer.User;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getDescription());
    }

    public void borrowBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Borrowing book: " + title + " to " + user);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    public List<Book> getBooks() {
        return books;
    }
}
