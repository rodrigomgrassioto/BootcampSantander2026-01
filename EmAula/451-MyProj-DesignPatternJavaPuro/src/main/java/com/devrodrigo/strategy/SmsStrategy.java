package com.devrodrigo.strategy;

public class SmsStrategy implements NotificationStrategy {
    public void send(String dest, String msg) { System.out.println("SMS enviado para " + dest + ": " + msg); }
}
