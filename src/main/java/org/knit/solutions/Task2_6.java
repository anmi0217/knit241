package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_4Classes.Car;
import org.knit.solutions.lab2_2.Task2_6Classes.Machine;
import org.knit.solutions.lab2_2.Task2_6Classes.Train;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@TaskDescription(taskNumber = 6, taskDescription = "Многопоточность. " +
        "Есть автомобили и поезд. " +
        "Если поезд приближается, машины останавливаются и ждут. " +
        "После того, как поезд проедет, машины продолжают движение. ", href = "org/knit/solutions/lab2_2/Task2_6Classes")
public class Task2_6 implements Solution{
    boolean trainIsGoing = false;

    public void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Task2_6 task = new Task2_6();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Train train = new Train();

        scheduler.scheduleAtFixedRate(() -> {
            try {
                task.goThroughRailway(train);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 4, 4, TimeUnit.SECONDS);



        for (int i = 0; i < 8; i++) {
            Car car = new Car();
            executor.submit(() -> {
                try {
                    task.goThroughRailway(car);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        scheduler.schedule(scheduler::shutdown, 15, TimeUnit.SECONDS);

        executor.shutdown();



    }


    public synchronized void goThroughRailway(Machine machine) throws InterruptedException {
        if (trainIsGoing) {
            wait();
        }
        System.out.println(machine + " проезжает через железнодорожные пути");
        if (machine.getClass().equals(Train.class)){
            trainIsGoing = true;

            sleep(1000);

        }


        sleep(1000);
        trainIsGoing = false;
        notifyAll();
    }


}
