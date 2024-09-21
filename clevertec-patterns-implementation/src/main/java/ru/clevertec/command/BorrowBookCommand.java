package ru.clevertec.command;

import ru.clevertec.facade.LibraryFacade;
import ru.clevertec.observer.User;

public class BorrowBookCommand implements Command {

    private LibraryFacade libraryFacade;
    private String title;
    private User user;

    public BorrowBookCommand(LibraryFacade libraryFacade, String title, User user) {
        this.libraryFacade = libraryFacade;
        this.title = title;
        this.user = user;
    }

    @Override
    public void execute() {
        libraryFacade.borrowBook(title, user);
    }
}
