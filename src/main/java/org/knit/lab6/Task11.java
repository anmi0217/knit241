package org.knit.lab6;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task11 {
    public static void execute() {
        Set<String> students = new TreeSet<>();
        boolean k = false;
        while (!k) {
            System.out.println("Меню:\n" +
                    "1. Добавить студента\n" +
                    "2. Удалить студента\n" +
                    "3. Показать всех студентов\n" +
                    "4. Найти студента\n" +
                    "5. Выйти");

            System.out.print("Выберите опцию: ");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();

            Scanner sw_scanner = new Scanner(System.in);
            switch (command) {
                case 1:
                    System.out.print("✏Введите ФИ студента для добавления: ");
                    String nta = sw_scanner.nextLine();
                    if (!students.contains(nta)) {
                        students.add(nta);
                        System.out.println("\n✅Студент добавлен\n");
                    } else {
                        System.out.println("\n❌Такой студент уже существует!\n");
                    }
                    break;
                case 2:
                    System.out.print("✏Введите ФИ студента для удаления: ");
                    String ntr = sw_scanner.nextLine();
                    if (!students.contains(ntr)) {
                        System.out.println("\n❌Такого студента не существует!\n");
                    } else {
                        students.remove(ntr);
                        System.out.println("\n✅\uD83D\uDDD1Студент удален\n");
                    }
                    break;
                case 3:
                    System.out.println("\n==============Студенты:==============");
                    for (var i : students)
                        System.out.println(i);
                    System.out.println("=====================================\n");
                    break;
                case 4:
                    System.out.print("✏Введите ФИ студента для поиска: ");
                    String ntf = sw_scanner.nextLine();
                    if (!students.contains(ntf)) {
                        System.out.println("\n❌Не найдено такого студента!\n");
                    } else {
                        System.out.println("\n✅Такой студент найден\n");
                    }
                    break;
                case 5:
                    k = true;
            }
        }
    }
}
