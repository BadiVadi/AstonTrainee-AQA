package org.example;

import java.util.Random;

public class RandomDigits {
    public static int[] generateRandomDigits(int size, int minValue, int maxValue) {
        int[] digits = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            digits[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return digits;
    }

    private static int countEvenDigits(int[] digits) {
        int evenCount = 0;
        for (int digit : digits) {
            if (digit % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] digits = generateRandomDigits(10, 1, 100);
        int evenCount = countEvenDigits(digits);
        System.out.println("Случайные числа: " + arrayToString(digits));
        System.out.println("Четные числа: " + evenCount);

    }
}