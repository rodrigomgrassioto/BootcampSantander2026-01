package com.devrodrigo.taxcalc;

// saúde e bem estar
public record Health(double value) implements TaxCalc {
    @Override
    public double calcTax(){
        return value * 0.015; // 1,5%
    }
}
