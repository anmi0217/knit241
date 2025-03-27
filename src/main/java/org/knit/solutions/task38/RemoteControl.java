package org.knit.solutions.task38;

import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoCommand() {
        if (history.isEmpty()) {
            System.out.println("История команд пуста.");
        } else {
            Command command = history.pop();
            command.undo();
        }
    }
}
