package com.gui;

public class Parallelogram extends GeometricPrimitive {

    private Double base;
    private Double b;
    private Double height;

    public Parallelogram(Double base, Double b, Double height) throws IllegalArgumentException {
        if(base <= 0 || b <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.base = base;
        this.b = b;
        this.height = height;
    }

    @Override
    public Double getPerimeter() {
        return (2* base) + (2*b);
    }

    @Override
    public Double getArea() {
        return base *height;
    }

    public Double getBase() {
        return base;
    }

    public Double getB() {
        return b;
    }

    public Double getHeight() {
        return height;
    }
}
