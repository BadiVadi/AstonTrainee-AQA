package org.example;

public class FruitBoxTransfer {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 10; i++) {
            appleBox.addFruit(new Apple());
        }

        for (int i = 0; i < 5; i++) {
            orangeBox.addFruit(new Orange());
        }

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
    }
}
