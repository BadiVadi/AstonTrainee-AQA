package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StringCollection {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("Highload");
        stringCollection.add("High");
        stringCollection.add("Load");
        stringCollection.add("Highload");
        int highCount = countHighTimes(stringCollection);
        System.out.println("Количество упоминаний 'High': " + highCount);

        String firstElement = getFirstElement(stringCollection);
        System.out.println("Первый элемент: " + firstElement);

        String lastElement = getLastElement(stringCollection);
        System.out.println("Последний элемент: " + firstElement);


    }

    private static int countHighTimes(List<String> collection) {
        return Collections.frequency(collection, "High");
    }

    private static String getFirstElement(List<String> collection) {
        if (collection.isEmpty()) {
            return "0";
        }
        return collection.get(0);
    }

    private static String getLastElement(List<String> collection) {
        if (collection.isEmpty()) {
            return "0";
        }
        return collection.get(collection.size() - 1);
    }
}