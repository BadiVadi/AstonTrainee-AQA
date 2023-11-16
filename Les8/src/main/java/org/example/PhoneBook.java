package org.example;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> directory;

    public PhoneBook() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new LinkedList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, new LinkedList<>());
    }

    public static void main(String[] args) {
        PhoneBook directory = new PhoneBook();

        directory.add("Иванов", "123456789");
        directory.add("Петров", "543217689");
        directory.add("Ильинец", "987654321");

        List<String> ivanovNumbers = directory.get("Иванов");
        List<String> petrovNumbers = directory.get("Петров");
        List<String> ilyinetsNumbers = directory.get("Ильинец");

        System.out.println("Номер телефона Иванова: " + ivanovNumbers);
        System.out.println("Номер телефона Петрова: " + petrovNumbers);
        System.out.println("Номер телефона Ильинца: " + ilyinetsNumbers);
    }
}
