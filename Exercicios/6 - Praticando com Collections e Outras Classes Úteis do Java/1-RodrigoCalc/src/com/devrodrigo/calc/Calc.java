package com.devrodrigo.calc;

@FunctionalInterface
public interface Calc {
    long exec(long... numbers);
}
