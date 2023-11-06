package org.example;

class Triangle implements Shape {
    private final int sideA;
    private final int sideB;
    private final int sideC;
    private final String borderColor;
    private final String fillColor;

    Triangle(int sideA, int sideB, int sideC, String borderColor, String fillColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }
}