package org.knit.solutions.task13;

import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> commandHistory = new Stack<>();

    public void execute(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }

    public void goodNight(Light light, TV tv){
        execute(new LightOffCommand(light));
        execute(new TVOffCommand(tv));
    }

    public void goodMorning(Light light, TV tv){
        execute(new LightOnCommand(light));
        execute(new TVOnCommand(tv));
    }
}
