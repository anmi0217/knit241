package org.knit.solutions;

import org.knit.TaskDescription;

@TaskDescription(taskNumber = 14, taskDescription = "Краткое описание задачи 1", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task14 implements Solution{

    @Override
    public void execute() {
        System.out.println("Задача 14");
    }
}
