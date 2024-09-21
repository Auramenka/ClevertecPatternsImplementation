package ru.clevertec.decorator;

import ru.clevertec.model.Book;

public abstract class BookDecorator {

    protected Book book;

    public BookDecorator(Book book) {
        this.book = book;
    }

    public String getDescription() {
        return book.getDescription();
    }
}
