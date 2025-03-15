package org.knit.solutions.lab11.task24;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Task24 {
    public void execute() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            UserDAO userDAO = new UserDAOImpl(connection);
            UserService userService = new UserService(userDAO);
            Scanner scanner = new Scanner(System.in);

            loop:
            while (true) {
                System.out.println("\nКоманды: \nadd [name] [email]\nlist\ndelete [id]\nupdate [id] [new_name] [new_email]\nexit");
                String command = scanner.nextLine();
                String[] comspl = command.split(" ");

                switch(comspl[0]) {
                    case "add":
                        userService.registerUser(comspl[1], comspl[2]);
                        System.out.println("Пользователь успешно добавлен");
                        break;
                    case "list":
                        for(var i : userService.listAllUsers())
                            System.out.println(i);
                        break;
                    case "delete":
                        userService.deleteUser(Integer.parseInt(comspl[1]));
                        System.out.println("Пользователь успешно удален");
                        break;
                    case "update":
                        userService.updateUser(Integer.parseInt(comspl[1]), comspl[2], comspl[3]);
                        System.out.println("Пользователь успешно обновлен");
                        break;
                    case "exit":
                        System.out.println("Выход из системы...");
                        break loop;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД: " + e.getMessage());
        }
    }
}
