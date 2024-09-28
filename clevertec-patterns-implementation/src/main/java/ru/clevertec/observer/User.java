package ru.clevertec.observer;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(String bookTitle) {
        System.out.println(name + " notified about new book - " + bookTitle);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
