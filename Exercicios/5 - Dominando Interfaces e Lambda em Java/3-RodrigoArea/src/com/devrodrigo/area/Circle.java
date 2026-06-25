package com.devrodrigo.area;

public record Circle(double radius) implements GeometricShape {

    private static final double pi = 3.14;

    @Override
    public double getArea() {
        return pi * (radius * radius);
    }
}
