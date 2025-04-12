package org.knit.solutions.task20;

import org.knit.solutions.task20.clipboard.ClipboardService;
import org.knit.solutions.task20.config.AppConfig;
import org.knit.solutions.task20.crypto.EncryptionService;
import org.knit.solutions.task20.security.MasterPasswordHolder;
import org.knit.solutions.task20.service.PasswordService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Менеджер паролей\n");

        MasterPasswordHolder masterPasswordService = context.getBean(MasterPasswordHolder.class);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            masterPasswordService.clear();
            System.out.println("Мастер-пароль очищен из памяти (из shutdownHook).");
        }));

        PasswordService passwordService = context.getBean(PasswordService.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Команда (add/list/delete/copy/exit): ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "add":
                    System.out.print("Имя сервиса: ");
                    String service = scanner.nextLine();
                    System.out.print("Логин: ");
                    String login = scanner.nextLine();
                    System.out.print("Пароль: ");
                    String password = scanner.nextLine();
                    passwordService.addPassword(service, login, password);
                    System.out.println("Пароль добавлен.");
                    break;
                case "list":
                    passwordService.listPasswords();
                    break;
                case "delete":
                    System.out.print("Имя сервиса: ");
                    String deleteService = scanner.nextLine();
                    passwordService.deletePassword(deleteService);
                    System.out.println("Удалено.");
                    break;
                case "copy":
                    System.out.print("Имя сервиса: ");
                    String copyService = scanner.nextLine();
                    passwordService.copyPasswordToClipboard(copyService);
                    break;
                case "exit":
                    System.out.println("Выход...");
                    context.close();
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }
}