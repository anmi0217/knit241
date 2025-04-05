package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab7.PathManager;

/***
 * Задача 12: Обход файлов
 1. Обойти все файлы в указанной директории и ее подкаталогах.
 2. Если файл имеет расширение .txt, подсчитать количество слов в нем.
 3. Вывести общее количество слов во всех текстовых файлах
 */
@TaskDescription(taskNumber = 12,
        taskDescription = "Обход файлов",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task12 implements Solution {
    public void execute() {
        PathManager.run();
    }
}