package org.knit;

import org.knit.utils.TaskExecutor;
import org.knit.utils.TaskFinder;
import org.knit.utils.TaskHolder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        final String TASKS_PACKAGE = "org.knit.solutions.Tasks2Semestr";

        try {
            TreeMap<Integer, TaskHolder> availableTasks = TaskFinder.findTasks(TASKS_PACKAGE);

            System.out.println("Доступны/сделаны следующие задачи:");
            for (TaskHolder task : availableTasks.values()) {
                System.out.printf("Задача №%d: %s%n", task.getId(), task.getDescriptor());
            }

            System.out.print("Введите номер задачи для его выполнения: ");
            int selectedTaskNumber = inputScanner.nextInt();

            TaskHolder selectedTask = availableTasks.get(selectedTaskNumber);
            if (selectedTask != null) {
                TaskExecutor.executeTask(selectedTask.getTaskClass());
            } else {
                System.out.println("Задача с таким номером не найдена.");
            }

        } catch (IOException | URISyntaxException e) {
            System.out.println("Ошибка при поиске задач: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
