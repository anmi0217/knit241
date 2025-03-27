package org.knit.solutions;

import org.knit.TaskDescription;

/**
 * Полное описание задачи
 */
@TaskDescription(taskNumber = 1, taskDescription = "Краткое описание задачи 1", href = "org/knit/solutions/taskExampleClasses/README.md")
public class TaskExample implements Solution {
    @Override
    public void execute() {
            System.out.println("Задача 1 запущена");
    }
}
