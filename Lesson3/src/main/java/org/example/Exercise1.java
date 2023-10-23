package org.example;

public class Exercise1 {
    public static void main(String[] args) {
        compareTwoNumbers();
    }
    private static void compareTwoNumbers() {
        int a = 10, b = 9;
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}