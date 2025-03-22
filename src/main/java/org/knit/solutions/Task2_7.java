package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_7Classes.Consumer;
import org.knit.solutions.lab2_2.Task2_7Classes.Producer;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@TaskDescription(taskNumber = 7, taskDescription = "Многопоточность. " +
        "Производитель создает товары (максимум 5). " +
        "Потребитель забирает товары. " +
        "Если товаров нет, потребитель ждет (wait()). " +
        "Если товаров максимум, производитель ждет (wait()). ", href = "org/knit/solutions/lab2_2/Task2_7Classes")
public class Task2_7 implements Solution{
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    public void execute() {
        Task2_7 task = new Task2_7();
        Consumer consumer = new Consumer(task.queue);
        Producer producer = new Producer(task.queue);

        producer.start();
        consumer.start();


    }




}
