package org.knit;

import org.knit.utils.TaskExecutor;
import org.knit.utils.TaskFinder;
import org.knit.utils.TaskHolder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер семестра (1, 2)");
        String PACKAGE = "org.knit.solutions.TaskSem" + scanner.nextInt();

        TreeMap<Integer, TaskHolder> tasks = TaskFinder.findTasks(PACKAGE);
        for (TaskHolder task : tasks.values()) {
            System.out.println("Номер задачи: " + task.getId() + ": " + task.getDescriptor());
        }

        try {
            System.out.println("Введите номер задачи для запуска");
            TaskHolder taskHolder = tasks.get(scanner.nextInt());
            if (taskHolder != null) {
                TaskExecutor.executeTask(taskHolder.getTaskClass());
            } else {
                System.out.println("Task not found");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}