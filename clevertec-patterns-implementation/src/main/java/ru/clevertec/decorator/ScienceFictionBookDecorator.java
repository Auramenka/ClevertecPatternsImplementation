package ru.clevertec.decorator;

import ru.clevertec.model.Book;

public class ScienceFictionBookDecorator extends BookDecorator {

    public ScienceFictionBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String getDescription() {
        return book.getDescription() + ", genre: science fiction";
    }
}
