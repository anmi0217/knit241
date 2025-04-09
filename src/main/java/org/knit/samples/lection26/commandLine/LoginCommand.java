package org.knit.samples.lection26.commandLine;

import picocli.CommandLine.Command;

import java.io.Console;
import java.util.Scanner;

@Command(name = "login", description = "Вход в систему", mixinStandardHelpOptions = true)
public class LoginCommand implements Runnable {

    private String username;
    private char[] password;

    @Override
    public void run() {
        System.out.println("🔐 Добро пожаловать в систему!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("👤 Введите имя пользователя: ");
        username = scanner.nextLine();

        Console console = System.console();
        if (console != null) {
            password = console.readPassword("🔑 @|yellow Введите пароль: |@");
        } else {
            // Fallback для IDE, если System.console() недоступен
            System.out.print("🔑 Введите пароль (будет видно): ");
            password = scanner.nextLine().toCharArray();
        }

        System.out.println("\n✅ Авторизация прошла для пользователя: " + username);
        System.out.println("Пароль длиной: " + password.length + " символов");

        // Обнуляем пароль в памяти
        java.util.Arrays.fill(password, ' ');
    }
}
