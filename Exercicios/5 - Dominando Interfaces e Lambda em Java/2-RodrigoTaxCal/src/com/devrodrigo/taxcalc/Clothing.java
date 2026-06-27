package com.devrodrigo.taxcalc;

public record Clothing(double value) implements TaxCalc {
    @Override
    public double calcTax(){
        return value * 0.025; // 2,5%
    }
}
