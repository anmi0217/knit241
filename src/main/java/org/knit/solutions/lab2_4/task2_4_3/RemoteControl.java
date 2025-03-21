package org.knit.solutions.lab2_4.task2_4_3;

import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }
}
