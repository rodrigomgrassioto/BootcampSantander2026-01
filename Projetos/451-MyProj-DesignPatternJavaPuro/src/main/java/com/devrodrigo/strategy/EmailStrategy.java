package com.devrodrigo.strategy;

public class EmailStrategy implements NotificationStrategy {
    public void send(String dest, String msg) { System.out.println("E-mail enviado para " + dest + ": " + msg); }
}
