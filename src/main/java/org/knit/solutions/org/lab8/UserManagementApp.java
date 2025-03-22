//13
package org.knit.solutions.org.lab8;

import java.io.*; // для работы с файлами и сериализацией объектов
import java.util.ArrayList; //для хранения списка пользователей
import java.util.List;
import java.util.Scanner;

class User implements Serializable {
    private static final long serialVersionUID = 1L; //для идентификации версии класса

    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Email: " + email;
    }
}

// Класс для управления пользователями
class UserManager {
    private static final String FILE_NAME = "users.ser";

    // Метод для сохранения списка пользователей в файл
    public static void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }

    // Метод для загрузки списка пользователей из файла
    public static List<User> loadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}


public class UserManagementApp {
    private static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Загружаем пользователей из файла при запуске программы
            userList = UserManager.loadUsers();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Добро пожаловать в систему управления пользователями!");

        // Основное меню
        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Сохранить список пользователей в файл");
            System.out.println("4. Загрузить список пользователей из файла");
            System.out.println("5. Выйти");
            System.out.print("Введите номер действия: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректный номер действия.");
                continue;
            }

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    displayUsers();
                    break;
                case 3:
                    saveUsersToFile();
                    break;
                case 4:
                    loadUsersFromFile();
                    break;
                case 5:
                    saveUsersToFile(); // Сохранение данных перед выходом
                    System.out.println("Программа завершена. До свидания!");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }

        scanner.close();
    }

    // Метод добавления
    private static void addUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Возраст должен быть числом. Пользователь не добавлен.");
            return;
        }

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        userList.add(new User(name, age, email));
        System.out.println("Пользователь добавлен.");
    }

    // Метод для отображения
    private static void displayUsers() {
        if (userList.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            for (int i = 0; i < userList.size(); i++) {
                System.out.println((i + 1) + ". " + userList.get(i));
            }
        }
    }

    // Метод для сохранения в файл
    private static void saveUsersToFile() {
        try {
            UserManager.saveUsers(userList);
            System.out.println("Список успешно сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    // Метод для загрузки пользователей из файла
    private static void loadUsersFromFile() {
        try {
            userList = UserManager.loadUsers();
            System.out.println("Список успешно загружен из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}