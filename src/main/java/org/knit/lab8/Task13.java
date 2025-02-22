package org.knit.lab8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task13 {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        try {
            users = UserSerDeser.loadUsers();
            System.out.println("Список пользователей успешно загружен из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл с пользователями не найден. Начинаем с пустого списка.");
        }

        while (true) {
            System.out.println("\nДобро пожаловать в систему управления пользователями!");
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Сохранить список пользователей в файл");
            System.out.println("4. Загрузить список пользователей из файла");
            System.out.println("5. Выйти");
            System.out.print("\nВведите номер действия: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();
                    users.add(new User(name, age, email));
                    System.out.println("Пользователь добавлен.");
                    break;

                case 2:
                    // Показать всех пользователей
                    System.out.println("\nСписок пользователей:");
                    if (users.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println((i + 1) + ". " + users.get(i));
                        }
                    }
                    break;

                case 3:
                    try {
                        UserSerDeser.saveUsers(users);
                        System.out.println("Список успешно сохранён в файл.");
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении списка: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        users = UserSerDeser.loadUsers();
                        System.out.println("Список успешно загружен из файла.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Ошибка при загрузке списка: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        UserSerDeser.saveUsers(users);
                        System.out.println("Список сохранён. До свидания!");
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении списка: " + e.getMessage());
                    }
                    return;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
