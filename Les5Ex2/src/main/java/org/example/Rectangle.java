package org.example;

class Rectangle implements Shape {
    private final int width;
    private final int length;
    private final String borderColor;
    private final String fillColor;

    Rectangle(int width, int length, String borderColor, String fillColor) {
        this.width = width;
        this.length = length;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public double getArea() {
        return width * length;
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