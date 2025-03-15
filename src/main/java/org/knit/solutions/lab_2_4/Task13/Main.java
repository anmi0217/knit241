package org.knit.solutions.lab_2_4.Task13;

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.turnOnTV();
        remoteControl.turnOnTV();
        remoteControl.turnOffTV();
        remoteControl.turnOnLight();

        remoteControl.undo();

        remoteControl.turnOnTV();
        remoteControl.turnOnLight();
        remoteControl.goodnight();
    }
}
