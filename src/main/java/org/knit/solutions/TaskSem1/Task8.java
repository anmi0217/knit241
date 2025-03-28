package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab5.Task8.ShopItem;

import java.util.*;

import org.knit.TaskDescription;

/***
 * Задача №8
 *
 * Создайте класс ShopItem (Модель товарной позиции) с полями:
 * - name (название товара)
 * - price (цена)
 * - category (категория товара)
 *
 * Переопределите методы:
 * - toString() — строковое представление объекта
 * - equals() — сравнение товаров
 * - hashCode() — хеш-код для корректного хранения в коллекциях
 *
 * Генерация данных:
 * - Создайте массив имен товарных позиций
 * - Сгенерируйте 100 объектов ShopItem с случайными и повторяющимися полями
 * - Сохраните их в массив
 *
 * Обработка данных:
 * - Отсортируйте массив по любому из полей (используйте компаратор)
 * - Выведите объекты в консоль
 * - Подсчитайте и выведите количество одинаковых ShopItem
 */
@TaskDescription(taskNumber = 8,
        taskDescription = "Объекты магазина",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task8 implements Solution {
    public void execute() {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        Random random = new Random();
        ShopItem[] items = new ShopItem[1000];

        // Генерация 100 объектов ShopItem
        for (int i = 0; i < items.length; i++) {
            String name = names[random.nextInt(names.length)];
            int price = 10 + random.nextInt(90); // цена
            int quantity = random.nextInt(20) + 1; // количество
            items[i] = new ShopItem(name, price, quantity);
        }

        // Сортировка массива по цене
        Arrays.sort(items, Comparator.comparingDouble(ShopItem::getPrice));

        // Вывод объектов
        for (ShopItem item : items) {
            System.out.println(item);
        }

        // Подсчет количества одинаковых ShopItem
        Map<ShopItem, Integer> itemCount = new HashMap<>();
        for (ShopItem item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        System.out.println("\nКоличество одинаковых ShopItem:");
        itemCount.forEach((item, count) -> {
            if (count > 1) {
                System.out.println(item + " - " + count + " шт.");
            }
        });
    }
}


