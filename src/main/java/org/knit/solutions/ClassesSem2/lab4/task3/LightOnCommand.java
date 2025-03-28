package org.knit.solutions.ClassesSem2.lab4.task3;

public class LightOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Свет включен!");
    }

    @Override
    public void undo() {
        System.out.println("Свет выключен!");
    }
}
