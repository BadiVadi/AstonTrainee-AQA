package org.example;

import java.util.*;


public class RandomWords {
    public static void main(String[] args) {
        String[] wordsArray = {"Hello", "Mike", "World", "Java", "QA", "Water", "Soil", "Wind", "Mike", "Grass"};

        Set<String> uniqueWords = findUniqueWords(wordsArray);
        Map<String, Integer> wordOccurrences = countWordOccurrences(wordsArray);

        System.out.println("Уникальные слова: " + uniqueWords);

        System.out.println("\nКоличество повторений слов:");
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }

    private static Set<String> findUniqueWords(String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }

    private static Map<String, Integer> countWordOccurrences(String[] words) {
        Map<String, Integer> wordOccurrences = new HashMap<>();

        for (String word : words) {
            wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
        }

        return wordOccurrences;
    }
}