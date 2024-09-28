package ru.clevertec.strategy;

import ru.clevertec.model.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorSearchStrategy implements SearchStrategy {
    private String author;

    public AuthorSearchStrategy(String author) {
        this.author = author;
    }

    public List<Book> search(List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
}
