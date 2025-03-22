package org.knit.solutions;



import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_8Classes.RandomStringGenerator;
import org.knit.solutions.lab2_3.BarrierAction;
import org.knit.solutions.lab2_3.Runner;

import java.util.concurrent.CyclicBarrier;


@TaskDescription(taskNumber = 10, taskDescription = "Группа спортсменов участвует в забеге. " +
        "Однако перед началом гонки все должны собраться на старте. " +
        "Как только все участники будут готовы, забег начнётся одновременно. " +
        "Как только все бегуны завершат дистанцию, " +
        "программа выводит сообщение о завершении гонки.", href = "org/knit/solutions/lab2_3")
public class Task2_10 implements Solution{
    public void execute() {

        int runnerCount = 5;
        CyclicBarrier barrier = new CyclicBarrier(runnerCount, new BarrierAction());

        for (int i = 0; i < runnerCount; i++) {
            new Thread(new Runner(RandomStringGenerator.getString(6), barrier)).start();
        }

    }
}
