package ru.clevertec.proxy.service.impl;

import ru.clevertec.proxy.annotation.Log;
import ru.clevertec.proxy.service.BookService;

public class BookServiceImpl implements BookService {

    @Override
    @Log
    public void addBook(String bookName) {
        System.out.println("Adding a book - " + bookName);
    }

    @Override
    public void removeBook(String bookName) {
        System.out.println("Deleting a book - " + bookName);
    }
}
