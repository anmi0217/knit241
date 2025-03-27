package org.knit.solutions;

import org.knit.TaskDescription;

@TaskDescription(taskNumber = 2, taskDescription = "Краткое описание задачи 2")
public class TaskExample2 implements Solution{

    public void execute() {
        System.out.println("Задача 2 запущена");
    }
}
