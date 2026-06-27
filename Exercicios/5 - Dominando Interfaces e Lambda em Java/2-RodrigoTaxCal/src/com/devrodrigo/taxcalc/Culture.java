package com.devrodrigo.taxcalc;

public record Culture(double value) implements TaxCalc {
    @Override
    public double calcTax(){
        return value * 0.04; // 4%
    }
}
