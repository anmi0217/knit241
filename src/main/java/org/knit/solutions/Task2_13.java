package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_4.Task2_13Classes.*;

@TaskDescription(taskNumber = 13, taskDescription = "Паттерн Command (Команда)." +
        "Задача 13: Реализация системы команд для управления умным домом.", href = "org/knit/solutions/lab2_4/Task2_13Classes")
public class Task2_13 implements Solution{
    public void execute() {
        SmartHouse house = new SmartHouse();
        RemoteControl remoteControl = new RemoteControl();

        LightOffCommand lightOff = new LightOffCommand(house);
        LightOnCommand lightOn = new LightOnCommand(house);
        TVOffCommand tvOff = new TVOffCommand(house);
        TVOnCommand tvOn = new TVOnCommand(house);


        remoteControl.executeCommand(lightOn);
        remoteControl.executeCommand(tvOn);
        remoteControl.executeCommand(lightOff);

        System.out.println("========");
        remoteControl.undoLastCommand();
        remoteControl.undoLastCommand();
        remoteControl.undoLastCommand();
        remoteControl.undoLastCommand();
    }
}
