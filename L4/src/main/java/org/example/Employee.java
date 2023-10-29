package org.example;

public class Employee {
    private String name;
    private String possition;
    private String email;
    private String phoneNumer;
    private double salary;
    private int age;

    public Employee(String name, String possition, String email, String phoneNumer, double salary, int age) {
        this.name = name;
        this.possition = possition;
        this.email = email;
        this.phoneNumer = phoneNumer;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + possition);
        System.out.println("Имейл: " + email);
        System.out.println("Номер телефона: " + phoneNumer);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println("- - - - - - - - - - - - - - - - -");
    }

    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ильинец Вадим Андреевич", "CV-speacialist", "Badivadid2@gmail.com", "375292161706", 100.0, 27);
        empArray[1] = new Employee("Иванова Андрей Инванович", "QA", "abc@gmail.com", "876543324", 100.6, 26);
        empArray[2] = new Employee("Кузьмин Петр Аркадьевич", "Developer", "qwe@gmail.com", "6543543543", 100.0, 30);
        empArray[3] = new Employee("Семенов Вадим Петрович", "BA / SA", "wsda@gmail.com", "2342626", 100.3, 55);
        empArray[4] = new Employee("Михно Павел Геннадьевич", "DevOps", "bbc@gmail.com", "54354353", 100.9, 34);

        for (Employee list : empArray) {
            list.info();
        }
    }
}