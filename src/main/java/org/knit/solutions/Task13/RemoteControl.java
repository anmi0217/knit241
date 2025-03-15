package org.knit.solutions.Task13;

public class RemoteControl {
    private Command command;
    private Command lastCommand;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        if (command != null) {
            command.execute();
            lastCommand = command;
        }
    }
    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}
