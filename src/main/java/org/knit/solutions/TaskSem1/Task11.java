package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab6.Task11.StudentManager;

import java.util.Scanner;
import org.knit.TaskDescription;

/***
 * Задача 11: Управление списком студентов
 *
 * Создайте программу, которая управляет списком студентов с использованием TreeSet.
 *
 * Функции программы:
 * - Добавление нового студента в список (проверка на уникальность)
 * - Удаление студента (проверка на существование перед удалением)
 * - Отображение всех студентов в отсортированном порядке
 * - Поиск студента по имени
 *
 * Требования:
 * - Каждый студент представлен строкой (например, "Иванов Иван")
 * - TreeSet автоматически поддерживает порядок
 * - Реализовать консольное меню:
 *   1. Добавить студента
 *   2. Удалить студента
 *   3. Показать всех студентов
 *   4. Найти студента
 *   5. Выйти
 */


@TaskDescription(taskNumber = 11,
        taskDescription = "Управление списком студентов",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task11 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Выйти");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя студента: ");
                    String nameToAdd = scanner.nextLine();
                    studentManager.addStudent(nameToAdd);
                    break;
                case 2:
                    System.out.print("Введите имя студента для удаления: ");
                    String nameToRemove = scanner.nextLine();
                    studentManager.removeStudent(nameToRemove);
                    break;
                case 3:
                    studentManager.showAllStudents();
                    break;
                case 4:
                    System.out.print("Введите имя студента для поиска: ");
                    String nameToFind = scanner.nextLine();
                    studentManager.findStudent(nameToFind);
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}

