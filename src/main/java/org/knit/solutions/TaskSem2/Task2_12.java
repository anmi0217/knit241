package org.knit.solutions.TaskSem2;


import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem2.lab4.task2.Caretaker;
import org.knit.solutions.ClassesSem2.lab4.task2.TextEditor;

import org.knit.TaskDescription;

/**
 * Задача 12: Реализация системы отмены изменений в текстовом редакторе
 * <p>
 * Описание:
 * - Класс TextEditor содержит текущий текст документа.
 * - Класс Memento хранит снимок состояния текста для возможности отката изменений.
 * - Класс Caretaker управляет историей изменений (стек сохранённых состояний).
 * - Методы saveState() и undo() сохраняют и откатывают изменения.
 * - Возможность нескольких уровней отката изменений.
 */

@TaskDescription(taskNumber = 12,
        taskDescription = "Реализация системы отмены изменений в текстовом редакторе",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_12 implements Solution {
    public void execute() {
        Caretaker saver = new Caretaker();

        TextEditor note1 = new TextEditor("Hello world!");

        saver.saveState(note1);
        saver.gatTempText();


        TextEditor note2 = new TextEditor("How are you?");
        saver.saveState(note2);
        saver.gatTempText();

        TextEditor note3 = new TextEditor("Всё хорошо!");
        saver.saveState(note3);
        saver.gatTempText();

        System.out.println("\nОткат к предыдущим состояниям:\n");

        saver.undo();
        saver.gatTempText();

        saver.undo();
        saver.gatTempText();

        saver.undo();

        saver.undo();
        saver.gatTempText();
    }
}

