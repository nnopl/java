package com.gui;

public class Rectangle extends GeometricPrimitive
{
    private Double a;
    private Double b;

    public Rectangle(Double a, Double b) throws IllegalArgumentException {
        if(a <= 0 || b <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.a = a;
        this.b = b;
    }

    @Override
    public Double getPerimeter() {
        return (2*a) + (2*b);
    }

    @Override
    public Double getArea() {
        return a*b;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }
}
