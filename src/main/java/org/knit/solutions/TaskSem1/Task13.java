package org.knit.solutions.TaskSem1;


import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab6.Task11.StudentManager;
import org.knit.solutions.ClassesSem1.lab8.Task13.*;

import java.util.Scanner;

import org.knit.TaskDescription;

/***
 * Задача 13: Управление людей
 * Создайте программу, которая управляет списком студентов с использованием TreeSet.
 */

@TaskDescription(taskNumber = 13,
        taskDescription = "Студент менеджер",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task13 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        User user = new User("Ваня", 18, "abcd@gmail.com");
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

