package org.knit.solutions.TaskSem2;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem2.lab4.task3.*;

import org.knit.TaskDescription;

/**
 * Задача 13: Реализация системы команд для управления умным домом
 * <p>
 * Описание:
 * - Интерфейс Command определяет метод execute(), который выполняет команду.
 * - Классы команд:
 * - LightOnCommand – включает свет.
 * - LightOffCommand – выключает свет.
 * - TVOnCommand – включает телевизор.
 * - TVOffCommand – выключает телевизор.
 * - Класс RemoteControl хранит команду и позволяет её выполнить.
 * - Реализован механизм отмены последней команды (undo).
 */

@TaskDescription(taskNumber = 13,
        taskDescription = "Реализация системы команд для управления умным домом",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_13 implements Solution {
    public void execute() {
        RemoteControl controller = new RemoteControl();

        Command lightOn = new LightOnCommand();
        Command lightOff = new LightOffCommand();

        Command tvOn = new TVOnCommand();
        Command tvOff = new TVOffCommand();

        System.out.println("Управление Домом: ");

        controller.executeCommand(lightOn);
        controller.executeCommand(lightOff);
        controller.executeCommand(tvOn);
        controller.executeCommand(tvOff);

        System.out.println("\nОтмена команд:");
        controller.undoLastCommand();
        controller.undoLastCommand();
        controller.undoLastCommand();
        controller.undoLastCommand();
        controller.undoLastCommand();
    }
}

