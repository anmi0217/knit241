/*
Вы разрабатываете приложение для биржевой торговли, где пользователи могут подписываться
на обновления акций определённых компаний.
 */

package org.knit.solutions;
import org.knit.TaskDescription;


import org.knit.solutions.annotations.Discription;
import org.knit.solutions.org2.lab11.EmailNotifier;
import org.knit.solutions.org2.lab11.MobileApp;
import org.knit.solutions.org2.lab11.Stock;


import java.util.Scanner;


@TaskDescription(taskNumber = 11, taskDescription = "Реализация системы уведомлений в биржевом приложении")
public class Task11 implements Solution
{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Создаем акцию
        System.out.print("Введите название акции: ");
        String stockName = scanner.nextLine();
        System.out.print("Введите начальную цену акции: ");
        double initialPrice = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        Stock stock = new Stock(stockName, initialPrice);

        // Создаем наблюдателей
        System.out.print("Введите имя пользователя для мобильного приложения: ");
        String mobileUser = scanner.nextLine();
        MobileApp mobileApp = new MobileApp(mobileUser);

        System.out.print("Введите email для уведомлений: ");
        String email = scanner.nextLine();
        EmailNotifier emailNotifier = new EmailNotifier(email);

        // Подписываем наблюдателей на акцию
        stock.addObserver(mobileApp);
        stock.addObserver(emailNotifier);

        // Основной цикл программы
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Изменить цену акции");
            System.out.println("2. Отписать мобильное приложение");
            System.out.println("3. Отписать email-уведомление");
            System.out.println("4. Выйти");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите новую цену акции: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Очистка буфера
                    stock.setPrice(newPrice);
                    break;
                case 2:
                    stock.removeObserver(mobileApp);
                    break;
                case 3:
                    stock.removeObserver(emailNotifier);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
