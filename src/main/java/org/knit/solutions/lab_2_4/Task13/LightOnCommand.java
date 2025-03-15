package org.knit.solutions.lab_2_4.Task13;

public class LightOnCommand implements Command {
    private final Lights lights;

    public LightOnCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        if (!lights.isOn()) {
            lights.setOn(true);
        } else {
            System.out.println("Свет и так включен");
        }
    }

    @Override
    public void undo() {
        if (lights.isOn()) {
            lights.setOn(false);
        } else {
            System.out.println("Свет и так выключен");
        }
    }
}
