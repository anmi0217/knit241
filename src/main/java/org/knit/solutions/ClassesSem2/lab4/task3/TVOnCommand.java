package org.knit.solutions.ClassesSem2.lab4.task3;

public class TVOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Телевизор включен!");
    }

    @Override
    public void undo() {
        System.out.println("Телевизор выключен!");
    }
}
