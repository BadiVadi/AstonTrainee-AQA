package org.example;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(4, "Красный", "Синий");
        System.out.println("Периметр круга: " + circle.getPerimeter());
        System.out.println("Площать круга: " + circle.getArea());
        System.out.println("Цвет границ круга: " + circle.getBorderColor());
        System.out.println("Цвет фона круга: " + circle.getFillColor());

        Shape rectangle = new Rectangle(3, 4, "Зеленый", "Красный");
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());
        System.out.println("Площадь  прямоугольника: " + rectangle.getArea());
        System.out.println("Цвет границ прямоугольника: " + rectangle.getBorderColor());
        System.out.println("Цвет фона прямоугольника: " + rectangle.getFillColor());

        Shape triangle = new Triangle(3, 4, 5, "Синий", "Красный");
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Цвет границ треугольника: " + triangle.getBorderColor());
        System.out.println("Цвет фона треугольника: " + triangle.getFillColor());
    }
}