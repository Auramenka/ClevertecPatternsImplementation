package ru.clevertec.chainOfResponsibility;

public abstract class RequestHandler {

    protected RequestHandler next;

    public void setNext(RequestHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String message);
}
