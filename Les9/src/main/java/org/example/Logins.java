package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logins {
    public static void main(String[] args) {
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Напишите логин и нажмите Enter для ввода: ");
        while (true) {
            String login = scanner.nextLine().trim();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        System.out.println("Логины на букву 'f': ");
        for (String login : logins) {
            if (login.startsWith("f")) {
                System.out.println(login);
            }
        }
    }
}