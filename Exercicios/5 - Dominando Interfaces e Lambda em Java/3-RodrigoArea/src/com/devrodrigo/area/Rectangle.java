package com.devrodrigo.area;

public record Rectangle(double base, double height) implements GeometricShape {

    @Override
    public double getArea() {
        return base * height;
    }
}
