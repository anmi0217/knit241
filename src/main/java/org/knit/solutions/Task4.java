package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.labor2.lab2.task4.GazStation;

@TaskDescription(taskNumber = 4, taskDescription = "Задача 4")
public class Task4 implements Solution {
    @Override
    public void execute() {
        GazStation gazStation = new GazStation(2);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                gazStation.Refuel(finalI + " машина");
            }).start();
        }
    }
}
