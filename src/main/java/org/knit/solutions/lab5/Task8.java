package org.knit.solutions.lab5;

import java.util.*;

public class Task8 {
    public static void execute() {
        String[] names = {"книга", "ручка", "линейка", "пенал"};

        Random random = new Random();
        ShopItem[] items = new ShopItem[100];

        for (int i = 0; i < items.length; i++) {
            String name = names[random.nextInt(names.length)];
            int price = random.nextInt(490) + 10;
            String group = name.equals("книга") ? "литература" : name.equals("ручка") || name.equals("линейка") ? "канцелярия" : "прочее";
            items[i] = new ShopItem(name, price, group);
        }

        System.out.println("Оригинальный список:");
        for (var i : items) {
            System.out.println(i);
        }

        Arrays.sort(items, Comparator.comparing(ShopItem::getName).thenComparing(ShopItem::getPrice));
        System.out.println("\nСписок после сортировки по имени:");
        for (var i : items) {
            System.out.println(i);
        }

        Map<ShopItem, Integer> itemCount = new HashMap<>();
        for (ShopItem item : items) {
            if (itemCount.containsKey(item)) {
                itemCount.put(item, itemCount.get(item) + 1);
            } else {
                itemCount.put(item, 1);
            }
        }

        System.out.println("\nКоличество одинаковых ShopItem:");
        for (Map.Entry<ShopItem, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
            }
        }


        ShopItem item1 = new ShopItem("книга", 100, "литература");
        ShopItem item2 = new ShopItem("книга", 100, "литература");
        ShopItem item3 = new ShopItem("ручка", 20, "канцелярия");
        System.out.println("item1.equals(item2): " + item1.equals(item2));

        System.out.println("item1.hashCode(): " + item1.hashCode());
    }
}