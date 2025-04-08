package org.knit.solutions.Task10;

import static org.knit.solutions.Task10.Race.registerFinish;

public class FinishRace implements Runnable {
    @Override
    public void run() {
        try {System.out.println("Все бегуны финишировали!");
            Thread.sleep(2000);
            registerFinish();
        } catch (InterruptedException e) {
        }
    }
}
