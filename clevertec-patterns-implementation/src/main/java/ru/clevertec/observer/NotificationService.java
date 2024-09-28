package ru.clevertec.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<User> subscribers = new ArrayList<>();

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void notifySubscribers(String newBookTitle) {
        for (User user : subscribers) {
            user.update(newBookTitle);
        }
    }
}
