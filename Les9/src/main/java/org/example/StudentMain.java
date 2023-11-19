package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        int sumAge = 0;
        int manStudentCount = 0;

        for (Student student : students) {
            if (student.getGender() == Gender.MAN) {
                sumAge += student.getAge();
                manStudentCount++;
            }
        }

        int averageAgeOfMen = manStudentCount > 0 ? sumAge / manStudentCount : 0;
        System.out.println("Средний возраст парней: " + averageAgeOfMen);

        for (Student student : students) {
            if (student.getAge() >= 18 && student.getAge() <= 27 && student.getGender() == Gender.MAN) {
                System.out.println(student.getName() + " может получить повестку в этом году.");
            }
        }
    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
