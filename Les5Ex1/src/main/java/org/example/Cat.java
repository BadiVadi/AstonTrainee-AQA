package org.example;

public class Cat extends Animal {
    static int catCount = 0;
    private boolean fed = false;

    public void eat(FoodPlate plate, int amount) {
        if (amount <= plate.food) {
            plate.decreaseFood(amount);
            fed = true;
            System.out.println("Кот съел " + amount + " еды");
        } else {
            System.out.println("Недостаточно еды, пополните миску");
        }
    }

    boolean isFed() {
        return fed;
    }

    public void run(int length) {
        if (length <= 200) {
            System.out.println("Кот пробежал " + length + " м.");
        } else {
            System.out.println("Кот не может пробежать такую дистанцию");
        }
    }

    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }
}
