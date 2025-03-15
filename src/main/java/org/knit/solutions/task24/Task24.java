package org.knit.solutions.task24;

import java.sql.SQLException;
import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные команды для управления пользователями:\n" +
                "\tadd [name] [email] - добавляет нового пользователя;\n" +
                "\tupdate [id] [new_name] [new_email] - обновляет данные пользователя;\n" +
                "\tdelete [id] - удаляет пользователя по номеру;\n" +
                "\tlist - выводит список всех пользователей;\n" +
                "\texit - выход из программы.");
        String action = "";
        while (!action.equals("exit")) {
            System.out.print("\nВведите команду: ");
            String[] params = scanner.nextLine().split(" ");
            action = params[0];
            switch (action) {
                case "add":
                    if (params.length == 3) {
                        System.out.println(userService.addUser(params[1], params[2]));
                    } else {
                        System.out.println("Неверное количество параметров.");
                    }
                    break;
                case "update":
                    if (params.length == 4) {
                        System.out.println(userService.updateUser(Integer.parseInt(params[1]), params[2], params[3]));
                    } else {
                        System.out.println("Неверное количество параметров.");
                    }
                    break;
                case "delete":
                    if (params.length == 2) {
                        System.out.println(userService.deleteUser(Integer.parseInt(params[1])));
                    } else {
                        System.out.println("Неверное количество параметров.");
                    }
                    break;
                case "list":
                    System.out.println("Список пользователей:");
                    userService.getAllUsers().forEach(System.out::println);
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Ошибка: команда \"" + action + "\" не найдена.");
            }
        }
    }
}
