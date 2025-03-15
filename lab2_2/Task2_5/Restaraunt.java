package org.dina.lab2_2.Task2_5;

import java.util.LinkedList;
import java.util.Queue;

/* 2.5 Задача «Ресторан: Повар и Официант» 🍽️👨‍🍳
📌 Описание:
В ресторане работает один повар и один официант.

Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
Официант берет готовые блюда и подает их клиентам.
🔹 Что нужно реализовать?
✔ Повар не может готовить больше 3 блюд (ждет wait()).
✔ Официант ждет, если поднос пуст (wait()).
✔ При каждой передаче блюда используется notify(). */

public class Restaraunt {
    private final int CAPACITY = 3;
    private final Queue<String> mealsQueue = new LinkedList<>();

    public synchronized void cook(String name) {
        while (mealsQueue.size() >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mealsQueue.add(name);
        System.out.println("Повар приготовил блюдо " + name);
        notify();
    }

    public synchronized void serve() {
        while (mealsQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Официант подал блюдо " + mealsQueue.poll());
        notify();
    }
}
