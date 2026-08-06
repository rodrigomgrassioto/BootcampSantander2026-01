package com.devrodrigo._22marketplaceeventos.ticketing.domain;

public class SeatAlreadyReservedException extends RuntimeException {
    public SeatAlreadyReservedException() {
        super("Acento já reservado");
    }
}
