package org.example;

public class Dog extends Animal {
    static int dogCount = 0;
    @Override

    public void run(int length) {
        if (length <= 500) {
            System.out.println("Собака пробежала " + length + " м.");
        } else {
            System.out.println("Собака не может пробежать такую дистанцию");
        }
    }
    @Override

    public void swim(int length) {
        if (length <= 10) {
            System.out.println("Собака проплыла " + length + " м.");
        } else {
            System.out.println("Собака не может так далеко плыть");
        }
    }
}