package org.knit.solutions.lab2_4.task2_4_1;

import java.util.Scanner;

public class Task2_4_1 {
    public static void Run() {
        Stock stock = new Stock();
        MobileApp mobileApp = new MobileApp();
        EmailNotifier emailNotifier = new EmailNotifier();

        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        stock.addObserver(mobileApp);
        stock.addObserver(emailNotifier);

        System.out.println("Обновление цены:");
        stock.setPrice(59.954f);

        System.out.println("\nУдаление одного подписчика (EmailNotifier) и обновление цены:");
        stock.removeObserver(emailNotifier);
        stock.setPrice(30.305f);
    }
}
