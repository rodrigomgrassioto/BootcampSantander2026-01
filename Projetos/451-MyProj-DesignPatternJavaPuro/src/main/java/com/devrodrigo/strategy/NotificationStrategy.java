package com.devrodrigo.strategy;

public interface  NotificationStrategy {
    void send(String destination, String message);
}
