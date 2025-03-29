package org.knit.solutions.TaskSem1;

import java.sql.SQLException;
import java.util.Scanner;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab11.Task24.*;


import org.knit.TaskDescription;

/**
 * Задача 24: Реализация CRUD через командную строку
 * <p>
 * Описание:
 * 1. Приложение позволяет добавлять, удалять, обновлять и просматривать пользователей через консоль.
 * 2. Используется паттерн DAO для работы с базой данных.
 * 3. Вся бизнес-логика вынесена в класс UserService.
 * <p>
 * Функциональность:
 * - add [name] [email] — добавляет нового пользователя (email должен быть уникальным).
 * - list — выводит список всех пользователей.
 * - delete [id] — удаляет пользователя по ID.
 * - update [id] [new_name] [new_email] — обновляет имя и email пользователя.
 * - exit — завершает выполнение программы.
 * <p>
 * Требования:
 * - Валидация уникальности email при добавлении.
 * - Проверка существования пользователя перед удалением и обновлением.
 * <p>
 * Классы:
 * - UserDAO (интерфейс): методы для работы с пользователями.
 * - UserDAOImpl (реализация UserDAO с JDBC).
 * - DatabaseConnection (Singleton для управления подключением).
 * - UserService (бизнес-логика работы с пользователями).
 * - User (POJO-класс с полями id, name, email).
 */


@TaskDescription(taskNumber = 24,
        taskDescription = "Реализация CRUD через командную строку",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task24 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = null;
        try {
            userService = new UserService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Список команд:");
        System.out.println("Добавить <имя> <email> - Добавить нового пользователя");
        System.out.println("Список - Показать список всех пользователей");
        System.out.println("Удалить <id> - Удалить пользователя по ID");
        System.out.println("Обновить <id> <новое_имя> <новый_email> - Обновить данные пользователя");
        System.out.println("Выход - Завершить работу программы");

        while (true) {
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");

            try {
                switch (commandParts[0]) {
                    case "Добавить":
                        if (commandParts.length == 3) {
                            userService.registerUser(commandParts[1], commandParts[2]);
                        } else {
                            System.out.println("Неверные аргументы. Формат: добавить <имя> <email>");
                        }
                        break;

                    case "Список":
                        userService.listAllUsers();
                        break;

                    case "Удалить":
                        if (commandParts.length == 2) {
                            int id = Integer.parseInt(commandParts[1]);
                            userService.deleteUser(id);
                        } else {
                            System.out.println("Неверные аргументы. Формат: удалить <id>");
                        }
                        break;

                    case "Обновить":
                        if (commandParts.length == 4) {
                            int id = Integer.parseInt(commandParts[1]);
                            userService.updateUser(id, commandParts[2], commandParts[3]);
                        } else {
                            System.out.println("Неверные аргументы. Формат: обновить <id> <новое_имя> <новый_email>");
                        }
                        break;

                    case "Выход":
                        System.out.println("Завершение работы.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Неизвестная команда. Доступные команды: Добавить, Список, Удалить, Обновить, Выход.");
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при работе с базой данных: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ID должен быть числом.");
            }
        }
    }
}


//CREATE TABLE IF NOT EXISTS users (
//        id SERIAL PRIMARY KEY,             -- Уникальный идентификатор пользователя
//        name VARCHAR(100) NOT NULL,        -- Имя пользователя
//email VARCHAR(100) NOT NULL UNIQUE -- Email пользователя, уникальное значение
//);

//INSERT INTO users (name, email) VALUES
//('John Doe', 'john.doe@example.com'),
//        ('Jane Smith', 'jane.smith@example.com'),
//        ('Alice Johnson', 'alice.johnson@example.com'),
//        ('Bob Brown', 'bob.brown@example.com'),
//        ('Charlie White', 'charlie.white@example.com')
//ON CONFLICT (email) DO NOTHING;

