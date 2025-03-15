package org.knit.solutions.task36;

public class Task36 {
    public static void main(String[] args) {
        Stock stock = new Stock("Tesla");
        MobileApp mobileApp = new MobileApp();
        EmailApp emailApp = new EmailApp();

        stock.attach(mobileApp);
        stock.attach(emailApp);

        System.out.println("Изменение стоимости.");
        stock.setPrice(21000);

        System.out.println("\nОтписка от уведомлений и изменение стоимости.");
        stock.detach(emailApp);
        stock.setPrice(20500);
    }
}
