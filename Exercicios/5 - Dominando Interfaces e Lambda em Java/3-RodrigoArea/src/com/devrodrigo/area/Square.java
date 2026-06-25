package com.devrodrigo.area;

public record Square(double side) implements GeometricShape {

    @Override
    public double getArea() {
        return side * side;
    }
}
