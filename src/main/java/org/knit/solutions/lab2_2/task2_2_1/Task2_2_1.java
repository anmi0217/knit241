package org.knit.solutions.lab2_2.task2_2_1;

public class Task2_2_1 {
    public static void Run() {
        Petrol petrol = new Petrol(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                petrol.Refuel(finalI + " машина");
            }).start();
        }
    }
}
