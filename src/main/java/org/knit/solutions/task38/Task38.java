package org.knit.solutions.task38;

public class Task38 {
    public static void main(String[] args) {
        Light light = new Light();
        Conditioner conditioner = new Conditioner();
        RemoteControl remoteControl = new RemoteControl();

        Command turnOnLight = new TurnOnLight(light);
        Command turnOffLight = new TurnOffLight(light);
        Command turnOnConditioner = new TurnOnConditioner(conditioner);
        Command turnOffConditioner = new TurnOffConditioner(conditioner);

        remoteControl.undoCommand();
        remoteControl.executeCommand(turnOnLight);
        remoteControl.executeCommand(turnOnConditioner);
        remoteControl.executeCommand(turnOnConditioner);
        remoteControl.undoCommand();
        remoteControl.executeCommand(turnOffConditioner);
        remoteControl.executeCommand(turnOffLight);
    }
}
