package com.gui;

public class Trapezium extends GeometricPrimitive {

    private Double a,b,c,d;
    private Double height;

    public Trapezium(Double a, Double b, Double c, Double d, Double height) throws IllegalArgumentException {
        if(a <= 0 || b <= 0 || c <= 0 || d <= 0 || height <= 0) throw new IllegalArgumentException("All sides and height has to be positive");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.height = height;
    }

    @Override
    public Double getPerimeter() {
        return a+b+c+d;
    }

    @Override
    public Double getArea() {
        return (a+b)*height/2;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    public Double getD() {
        return d;
    }

    public Double getHeight() {
        return height;
    }
}
