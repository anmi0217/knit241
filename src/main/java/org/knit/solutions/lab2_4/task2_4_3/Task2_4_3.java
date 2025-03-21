package org.knit.solutions.lab2_4.task2_4_3;

public class Task2_4_3 {
    public static void Run() {
        SmartHome smartHome = new SmartHome();
        RemoteControl controller = new RemoteControl();

        Command SwitchOnLight = new SwitchOnLight(smartHome);
        Command SwitchOffLight = new SwitchOffLight(smartHome);
        Command SwitchOnTV = new SwitchOnTV(smartHome);
        Command SwitchOffTV = new SwitchOffTV(smartHome);

        System.out.println("\nУмный дом получил команды:");
        controller.executeCommand(SwitchOnLight);
        controller.executeCommand(SwitchOnLight);
        controller.executeCommand(SwitchOffLight);
        controller.executeCommand(SwitchOnTV);
        controller.executeCommand(SwitchOnTV);
        controller.executeCommand(SwitchOffTV);
        controller.executeCommand(SwitchOffTV);

        System.out.println("\nОтменяем 2 последние команды:");
        controller.undoLastCommand();
        controller.undoLastCommand();
    }
}
