package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCollection {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        elements.add("f10");
        elements.add("f15");
        elements.add("f2");
        elements.add("f4");
        elements.add("f4");

        Collections.sort(elements, new NumericStringComparator());

        String[] sortedArray = elements.toArray(new String[0]);

        System.out.println("Отсортированый список элементов: " + arrayToString(sortedArray));
    }
    private static String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
class NumericStringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int num1 = Integer.parseInt(s1.substring(1));
        int num2 = Integer.parseInt(s2.substring(1));
        return Integer.compare(num1, num2);
    }
}