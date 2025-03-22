package org.knit.solutions.lab2_4.Task2_13Classes;

import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command){
        command.execute();
        commandHistory.push(command);
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Прошлых команд нет");
        }
    }
}
