package org.example;

public class Main {
    public static void main(String[] args) {
        Dog.dogCount++;
        Cat.catCount++;
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.run(125);
        dog.swim(11);
        cat.run(122);
        cat.swim(4);
        FoodPlate catFoodPlate = new FoodPlate();
        Cat[] cats = new Cat[2];
        for (int i = 0; i < 2; i++) {
            cats[i] = new Cat();
            Cat.catCount++;
        }
        for (Cat singleCat : cats) {
            singleCat.eat(catFoodPlate, 10);
        }
        catFoodPlate.addFood(15);
        for (Cat singleCat : cats) {
            singleCat.eat(catFoodPlate, 10);
        }
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " наелся" + " " + cats[i].isFed());
        }

    }
}
