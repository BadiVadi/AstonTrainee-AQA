package org.example;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год для проверки:");
        int year = scanner.nextInt();
        boolean leapYear = determineYear(year);

        if (leapYear) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean determineYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

