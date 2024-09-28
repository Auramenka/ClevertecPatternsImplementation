package ru.clevertec;

import ru.clevertec.chainOfResponsibility.AdminHandler;
import ru.clevertec.chainOfResponsibility.LibrarianHandler;
import ru.clevertec.chainOfResponsibility.RequestHandler;
import ru.clevertec.command.BorrowBookCommand;
import ru.clevertec.command.Command;
import ru.clevertec.decorator.ScienceFictionBookDecorator;
import ru.clevertec.facade.LibraryFacade;
import ru.clevertec.model.Book;
import ru.clevertec.observer.User;
import ru.clevertec.proxy.LoggingProxy;
import ru.clevertec.proxy.service.BookService;
import ru.clevertec.proxy.service.impl.BookServiceImpl;
import ru.clevertec.strategy.AuthorSearchStrategy;
import ru.clevertec.strategy.SearchStrategy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Facade
        LibraryFacade library = new LibraryFacade();

        //Observer

        User user = new User("Anna");

        library.getNotificationService().subscribe(user);

        library.addBook("Java Programming methods", "Blinov");

        //Chain of responsibility

        RequestHandler librarian = new LibrarianHandler();
        RequestHandler admin = new AdminHandler();
        librarian.setNext(admin);

        librarian.handleRequest("lost book");
        librarian.handleRequest("borrow book");

        //Command

        Command borrowCommand = new BorrowBookCommand(library, "Java Programming methods", user);
        borrowCommand.execute();

        //Strategy

        SearchStrategy strategy = new AuthorSearchStrategy("Blinov");
        List<Book> books = library.findBooks(strategy);
        System.out.println("Books by Blinov: " + books.size());

        //Decorator

        System.out.println(new ScienceFictionBookDecorator(new Book("Dune", "Frank Herbert")).getDescription());

        //Proxy

        BookService bookService = new BookServiceImpl();
        LoggingProxy loggingProxy = new LoggingProxy(bookService);

        try {
            loggingProxy.invoke("Java in a Nutshell");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}