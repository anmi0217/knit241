package org.knit.solutions.Task10;

public class StartRace implements Runnable {
    @Override
    public void run() {
        try {System.out.println("Начало гонки через 3...");
            Thread.sleep(2000);
            System.out.println("2...");
            Thread.sleep(2000);
            System.out.println("1...");
            Thread.sleep(2000);
            System.out.println("Гонка началась!");
        } catch (InterruptedException e) {
        }
    }
}
