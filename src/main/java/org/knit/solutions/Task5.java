package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.labor2.lab2.task5.Restaurant;

@TaskDescription(taskNumber = 5, taskDescription = "Задача 5")
public class Task5 implements Solution{
    @Override
    public void execute() {
        Restaurant restaurant = new Restaurant();
        Thread threadCooker = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaurant.cook(i);
            }
        });

        Thread threadWaiter = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                restaurant.serve();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadCooker.start();
        threadWaiter.start();
    }
}
