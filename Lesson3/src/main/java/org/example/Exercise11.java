package org.example;

import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива:");
        int len = scanner.nextInt();
        int arr[] = new int[len];
        System.out.println("Введие числа массива:");
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Ваш массив:");
        for (int i = 0; i < len; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}
