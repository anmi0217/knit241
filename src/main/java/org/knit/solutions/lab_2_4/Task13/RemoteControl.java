package org.knit.solutions.lab_2_4.Task13;

import java.util.Stack;

public class RemoteControl {
    private Stack<Command> commandHistory;

    public RemoteControl() {
        this.commandHistory = new Stack<>();
    }

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

    public void goodnight(TV tv, Lights lights) {
        executeCommand(new TVOffCommand(tv));
        executeCommand(new LightOffCommand(lights));
    }
}
