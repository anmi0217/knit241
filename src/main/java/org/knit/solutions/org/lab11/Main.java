package org.knit.solutions.org.lab11;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAOImpl();

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1: Создать пользователя");
            System.out.println("2: Найти пользователя по ID");
            System.out.println("3: Показать всех пользователей");
            System.out.println("4: Обновить данные пользователя");
            System.out.println("5: Удалить пользователя");
            System.out.println("6: Проверить, существует ли email");
            System.out.println("0: Выйти");

            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();
                    userDAO.create(new User(name, id, email));
                    System.out.println("Пользователь создан.");
                    break;

                case 2:
                    System.out.print("Введите ID пользователя: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();
                    User user = userDAO.findById(findId);
                    if (user != null) {
                        System.out.println("Найден пользователь: " + user);
                    } else {
                        System.out.println("Пользователь с таким ID не найден.");
                    }
                    break;

                case 3:
                    List<User> allUsers = userDAO.findAll();
                    System.out.println("Список всех пользователей:");
                    for (User u : allUsers) {
                        System.out.println(u);
                    }
                    break;

                case 4:
                    System.out.print("Введите ID пользователя для обновления: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новое имя: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новый email: ");
                    String newEmail = scanner.nextLine();
                    userDAO.update(new User(newName, updateId, newEmail));
                    System.out.println("Пользователь обновлен.");
                    break;

                case 5:
                    System.out.print("Введите ID пользователя для удаления: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    userDAO.delete(deleteId);
                    System.out.println("Пользователь удален.");
                    break;

                case 6:
                    System.out.print("Введите email для проверки: ");
                    String checkEmail = scanner.nextLine();
                    boolean exists = userDAO.emailExists(checkEmail);
                    System.out.println("Email " + checkEmail + (exists ? " существует." : " не существует."));
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
    }
}