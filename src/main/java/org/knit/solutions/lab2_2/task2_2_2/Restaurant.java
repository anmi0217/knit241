package org.knit.solutions.lab2_2.task2_2_2;
import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private final int capacity = 3;
    private Queue<String> mealsQueue = new LinkedList<>();

    public synchronized void cook(String name) throws InterruptedException {
        while (mealsQueue.size() >= capacity) {
            System.out.println("Подносы заняты, повар ожидает....");
            wait();
        }
        mealsQueue.add(name);
        System.out.println("Повар приготовил " + name);
        Thread.sleep(500);
        notify();
    }

    public synchronized void serve() throws InterruptedException {
        while (mealsQueue.isEmpty()){
            System.out.println("Повар еще ничего не положил на поднос...");
            wait();
        }
        System.out.println("Официант подал " + mealsQueue.poll());
        notify();
    }
}
