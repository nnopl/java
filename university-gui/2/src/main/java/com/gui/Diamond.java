package com.gui;

public class Diamond extends GeometricPrimitive {

    private Double a;
    private Double height;

    public Diamond(Double a, Double height) throws IllegalArgumentException {
        if(a <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.a = a;
        this.height = height;
    }

    @Override
    public Double getPerimeter() {
        return 4*a;
    }

    @Override
    public Double getArea() {
        return a*height;
    }

    public Double getA() {
        return a;
    }

    public Double getHeight() {
        return height;
    }
}
