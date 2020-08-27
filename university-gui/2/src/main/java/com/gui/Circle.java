package com.gui;

public class Circle extends GeometricPrimitive {

    private Double r;

    public Circle(Double r) throws IllegalArgumentException {
        if(r <= 0) throw new IllegalArgumentException("radius has to be positive");
        this.r = r;
    }

    @Override
    public Double getPerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public Double getArea() {
        return Math.PI*r*r;
    }

    public Double getR() {
        return r;
    }
}
