package org.knit.solutions.lab2_2.task2_2_5;

public class Task2_2_5 {
    public static void Run() {
        Thread trafficLight = new Thread(new TrafficLight());
        trafficLight.start();

        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i)).start();
        }
    }
}
