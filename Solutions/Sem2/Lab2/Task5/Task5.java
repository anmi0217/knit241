/*
2.5 Задача «Ресторан: Повар и Официант» 🍽️👨‍🍳

📌 Описание:
В ресторане работает один повар и один официант.

Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
Официант берет готовые блюда и подает их клиентам.
🔹 Что нужно реализовать?
✔ Повар не может готовить больше 3 блюд (ждет wait()).
✔ Официант ждет, если поднос пуст (wait()).
✔ При каждой передаче блюда используется notify().
 */


package org2.lab5;
import org2.annotations.Discription;

@Discription(value = 5, name = "Ресторан: Повар и Официант")
public class Task5 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(); // Создаем ресторан

        // Создаем потоки для повара и официанта
        Thread chefThread = new Thread(new Chef(restaurant));
        Thread waiterThread = new Thread(new Waiter(restaurant));

        // Запускаем потоки
        chefThread.start();
        waiterThread.start();

        // Ожидаем завершения потоков
        try {
            chefThread.join();
            waiterThread.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }

        System.out.println("Работа ресторана завершена.");
    }
}
