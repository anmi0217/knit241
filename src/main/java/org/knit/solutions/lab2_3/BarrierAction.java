package org.knit.solutions.lab2_3;

public class BarrierAction implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        count++;

        if (count == 1) {
            System.out.println("На старт! Внимание! Марш!");
        } else {
            System.out.println("Все прибежали на финиш, поздравляем победителей");
        }
    }
}
