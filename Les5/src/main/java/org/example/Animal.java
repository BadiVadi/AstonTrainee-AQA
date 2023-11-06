package org.example;

public class Animal {
    static int animalCount = 0;

    public void run(int length) {
        System.out.println("Животное пробежало " + length + " метров");
    }

    public void swim(int length) {
        System.out.println("Животное проплыло " + length + " метров");
    }
}
