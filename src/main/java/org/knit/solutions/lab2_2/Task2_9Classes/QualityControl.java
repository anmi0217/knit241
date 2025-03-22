package org.knit.solutions.lab2_2.Task2_9Classes;

import static java.lang.Thread.sleep;

public class QualityControl extends Worker implements Runnable {


    public QualityControl(Factory factory) {
        super(factory);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(1000);
                factory.checkDetail();
                System.out.println("Деталь " + i + " проверена и отправлена на склад");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
