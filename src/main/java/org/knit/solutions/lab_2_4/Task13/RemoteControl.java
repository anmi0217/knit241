package org.knit.solutions.lab_2_4.Task13;

public class RemoteControl {
    private Command lightOnCommand;
    private Command lightOffCommand;
    private Command tvOnCommand;
    private Command tvOffCommand;

    private Command lastCommand;

    private boolean isLightOn = false;
    private boolean isTVOn = false;

    public RemoteControl() {
        this.lightOnCommand = new LightOnCommand();
        this.lightOffCommand = new LightOffCommand();
        this.tvOnCommand = new TVOnCommand();
        this.tvOffCommand = new TVOffCommand();
    }

    public void turnOnTV() {
        if (!isTVOn) {
            tvOnCommand.execute();
            this.lastCommand = tvOnCommand;
            isTVOn = true;
        } else {
            System.out.println("Телевизор и так включен");
        }
    }

    public void turnOffTV() {
        if (isTVOn) {
            tvOffCommand.execute();
            this.lastCommand = tvOffCommand;
            isTVOn = false;
        } else {
            System.out.println("Телевизор и так выключен");
        }
    }

    public void turnOnLight() {
        if (!isLightOn) {
            lightOnCommand.execute();
            this.lastCommand = lightOnCommand;
            isLightOn = true;
        } else {
            System.out.println("Свет и так включен");
        }
    }

    public void turnOffLight() {
        if (isLightOn) {
            lightOffCommand.execute();
            this.lastCommand = lightOffCommand;
            isLightOn = false;
        } else {
            System.out.println("Свет и так выключен");
        }
    }

    public void undo() {
        if (lastCommand.equals(lightOnCommand)) {
            turnOffLight();
        } else if (lastCommand.equals(lightOffCommand)) {
            turnOnLight();
        } else if (lastCommand.equals(tvOnCommand)) {
            turnOffTV();
        } else if (lastCommand.equals(tvOffCommand)) {
            turnOffLight();
        }
    }

    public void goodnight() {
        if (isTVOn) {
            turnOffTV();
        }
        if (isLightOn) {
            turnOffLight();
        }
    }
}
