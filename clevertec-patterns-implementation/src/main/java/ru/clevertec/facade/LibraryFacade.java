package ru.clevertec.facade;

import ru.clevertec.model.Book;
import ru.clevertec.model.BookStore;
import ru.clevertec.observer.NotificationService;
import ru.clevertec.observer.User;
import ru.clevertec.strategy.SearchStrategy;

import java.util.List;

public class LibraryFacade {

    private BookStore bookStore;
    private NotificationService notificationService;

    public LibraryFacade() {
        this.bookStore = new BookStore();
        this.notificationService = new NotificationService();
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void addBook(String title, String author) {
        bookStore.addBook(new Book(title, author));
        notificationService.notifySubscribers(title);
    }

    public void borrowBook(String title, User user) {
        bookStore.borrowBook(title, user);
    }

    public List<Book> findBooks(SearchStrategy strategy) {
        return strategy.search(bookStore.getBooks());
    }
}
