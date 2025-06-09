//11
package org.knit.solutions.org.lab6;

import java.util.Scanner;
import java.util.TreeSet;

public class ListStudent {
    public static void main(String[] args) {
        TreeSet<String> students = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:\n1. Добавить студента\n2. Удалить студента\n3. Показать всех студентов" +
                    "\n4. Найти студента\n5. Выйти\nВыберите опцию: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число от 1 до 5");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите имя студента: ");
                    String newStudent = scanner.nextLine().trim();
                    if (students.contains(newStudent)) {
                        System.out.println("Ошибка: студент с таким именем уже существует.");
                    } else {
                        students.add(newStudent);
                        System.out.println("Студент добавлен.");
                    }
                    break;

                case 2:
                    System.out.print("Введите имя студента для удаления: ");
                    String studentToRemove = scanner.nextLine().trim();
                    if (students.remove(studentToRemove)) {
                        System.out.println("Студент удален.");
                    } else {
                        System.out.println("Ошибка: студент не найден.");
                    }
                    break;

                case 3:
                    System.out.println("Список студентов:");
                    if (students.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        students.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Введите имя студента для поиска: ");
                    String studentToFind = scanner.nextLine().trim();
                    if (students.contains(studentToFind)) {
                        System.out.println("Студент найден.");
                    } else {
                        System.out.println("Студент не найден.");
                    }
                    break;

                case 5:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Выберите число от 1 до 5");
            }
        }
    }
}