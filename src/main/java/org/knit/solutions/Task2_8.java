package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_8Classes.Car;
import org.knit.solutions.lab2_2.Task2_8Classes.Railway;
import org.knit.solutions.lab2_2.Task2_8Classes.RandomStringGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@TaskDescription(taskNumber = 8, taskDescription = "На перекрестке светофор управляет движением: " +
        "Красный свет – машины стоят (wait()). " +
        "Зеленый свет – машины едут (notifyAll()). " +
        "Светофор переключается каждые 5 секунд.", href = "org/knit/solutions/lab2_2/Task2_8Classes")
public class Task2_8 implements Solution{

    public void execute() throws InterruptedException {
        Railway railway = new Railway();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ExecutorService executor = Executors.newFixedThreadPool(1);


        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                try {
                    railway.goThroughRailway(new Car(RandomStringGenerator.getString(7)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        scheduler.scheduleAtFixedRate(railway::setNextLight, 3, 3, TimeUnit.SECONDS);

        scheduler.schedule(scheduler::shutdown, 20, TimeUnit.SECONDS);
        executor.shutdown();

    }

}
