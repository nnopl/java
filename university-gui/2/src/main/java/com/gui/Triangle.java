package com.gui;

public class Triangle extends GeometricPrimitive {

    private Double base, b, c;
    private Double height;

    public Triangle(Double base, Double b, Double c, Double height) throws IllegalArgumentException {
        if(base <= 0 || b <= 0 || c <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.base = base;
        this.b = b;
        this.c = c;
        this.height = height;
    }

    @Override
    public Double getPerimeter() {
        return base+b+c;
    }

    @Override
    public Double getArea() {
        return base*height/2;
    }

    public Double getHeight() {
        return height;
    }

    public Double getBase() {
        return base;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }
}
