package com.devrodrigo.taxcalc;

public record Alimentation(double value) implements TaxCalc {
    @Override
    public double calcTax(){
        return value * 0.01; // 1%
    }
}
