// Пароль 789Nast

package org.knit.solutions.org2.lab20;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.knit.solutions.org2.lab20.security.MasterPasswordHolder;
import org.knit.solutions.org2.lab20.service.PasswordService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( "org.knit.solutions.org2.lab20");

        // Установка хука для очистки мастер-пароля при завершении
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MasterPasswordHolder holder = context.getBean(MasterPasswordHolder.class);
            holder.clear();
            context.close();
        }));

        // Запрос мастер-пароля
        System.out.print("Введите мастер-пароль: ");
        char[] masterPassword = System.console() != null
                ? System.console().readPassword()
                : new Scanner(System.in).nextLine().toCharArray();

        MasterPasswordHolder passwordHolder = context.getBean(MasterPasswordHolder.class);
        passwordHolder.setMasterPassword(masterPassword);

        PasswordService passwordService = context.getBean(PasswordService.class);
        Scanner scanner = new Scanner(System.in);

        // Основной цикл приложения
        boolean running = true;
        while (running) {
            System.out.println("\nДоступные команды:");
            System.out.println("add - добавить запись");
            System.out.println("list - показать список записей");
            System.out.println("copy <site> - скопировать пароль для сайта");
            System.out.println("delete <site> - удалить запись");
            System.out.println("exit - выход");
            System.out.print("> ");

            String command = scanner.nextLine().trim();
            String[] parts = command.split("\\s+", 2);

            try {
                switch (parts[0]) {
                    case "add":
                        System.out.print("Введите сайт: ");
                        String site = scanner.nextLine();
                        System.out.print("Введите логин: ");
                        String login = scanner.nextLine();
                        System.out.print("Введите пароль: ");
                        String password = scanner.nextLine();
                        passwordService.addEntry(site, login, password);
                        System.out.println("Запись добавлена.");
                        break;
                    case "list":
                        System.out.println("\nСохранённые записи:");
                        passwordService.getAllEntries().forEach(entry ->
                                System.out.printf("Сайт: %s, Логин: %s%n", entry.getSite(), entry.getLogin()));
                        break;
                    case "copy":
                        if (parts.length < 2) {
                            System.out.println("Укажите сайт: copy <site>");
                            break;
                        }
                        passwordService.copyPasswordToClipboard(parts[1]);
                        System.out.println("Пароль скопирован в буфер обмена.");
                        break;
                    case "delete":
                        if (parts.length < 2) {
                            System.out.println("Укажите сайт: delete <site>");
                            break;
                        }
                        passwordService.deleteEntry(parts[1]);
                        System.out.println("Запись удалена.");
                        break;
                    case "exit":
                        running = false;
                        break;
                    default:
                        System.out.println("Неизвестная команда.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // Очистка мастер-пароля перед выходом
        passwordHolder.clear();
        context.close();
    }
}