package org.knit.solutions.lab2_2.task2_2_3;

public class Task2_2_3 {
    public static void Run() {
        RailwayCrossing railwayCrossing = new RailwayCrossing();

        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(railwayCrossing), "Машина " + i).start();
        }

        new Thread(new Train(railwayCrossing), "Поезд").start();
    }
}
