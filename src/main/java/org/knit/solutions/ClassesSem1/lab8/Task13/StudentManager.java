package org.knit.solutions.ClassesSem1.lab8.Task13;

import java.util.TreeSet;

public class StudentManager {
    private TreeSet<String> students = new TreeSet<>();

    public void addStudent(String studentName) {
        if (students.contains(studentName)) {
            System.out.println("Ошибка: Студент с таким именем уже существует.");
        } else {
            students.add(studentName);
            System.out.println("Студент добавлен.");
        }
    }

    public void removeStudent(String studentName) {
        if (students.remove(studentName)) {
            System.out.println("Студент удален.");
        } else {
            System.out.println("Ошибка: Студент не найден.");
        }
    }

    public void showAllStudents() {
        System.out.println("Список студентов:");
        if (students.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            students.forEach(System.out::println);
        }
    }

    public void findStudent(String studentName) {
        if (students.contains(studentName)) {
            System.out.println("Студент найден.");
        } else {
            System.out.println("Студент не найден.");
        }
    }
}
