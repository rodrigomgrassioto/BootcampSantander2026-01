package com.devrodrigo._22marketplaceeventos.ticketing.domain;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(EventId eventId, SeatId seatId) {
        super("Acento id: "+seatId+" não encontrado");
    }
}
