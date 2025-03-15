package org.knit.solutions.lab_2_4.Task13;

public class LightOffCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Свет выключили");
    }
}
