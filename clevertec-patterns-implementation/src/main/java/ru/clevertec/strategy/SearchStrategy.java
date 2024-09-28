package ru.clevertec.strategy;

import ru.clevertec.model.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> bookList);
}
