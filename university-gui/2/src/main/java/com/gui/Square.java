package com.gui;

public class Square extends GeometricPrimitive {

    private Double a;

    public Square(Double a) throws IllegalArgumentException {
        if(a <= 0 )throw new IllegalArgumentException("side has to be positive");
        this.a = a;
    }

    @Override
    public Double getPerimeter() {
        return 4*a;
    }

    @Override
    public Double getArea() {
        return a*a;
    }

    public Double getA() {
        return a;
    }
}
