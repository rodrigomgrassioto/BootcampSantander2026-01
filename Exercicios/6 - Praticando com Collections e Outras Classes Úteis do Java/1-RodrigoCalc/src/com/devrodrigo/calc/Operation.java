package com.devrodrigo.calc;
import java.util.stream.LongStream;

public enum Operation {
    SUM(n -> LongStream.of(n).reduce(0, Long::sum), " + ") ,
    SUBTRACTION(n -> LongStream.of(n).reduce((n1, n2) -> n1-n2).orElse(0), " - ");

    private final Calc operationCallback;
    private final String signal;

    Operation(final Calc operationCallback, String signal) {
        this.operationCallback = operationCallback;
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }

    public Calc getOperationCallback() {
        return operationCallback;
    }
}
