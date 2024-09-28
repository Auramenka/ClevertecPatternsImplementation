package ru.clevertec.chainOfResponsibility;

public class AdminHandler extends RequestHandler {

    @Override
    public void handleRequest(String message) {
        if (message.equals("lost book")) {
            System.out.println("Admin handling lost book request");
        } else if (next != null) {
            next.handleRequest(message);
        }
    }
}
