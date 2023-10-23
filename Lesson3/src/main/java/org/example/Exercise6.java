package org.example;

public class Exercise6 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
            arr[i] = 1;
        } else if (arr[i] == 1) {
            arr[i] = 0;
        }
    }
    for (int value : arr) {
    System.out.println(value);
    }
}
}