package org.knit.solutions.lab2_2.Task2_9Classes;

import static java.lang.Thread.sleep;

public class Stamper extends Worker implements Runnable {

    public Stamper(Factory factory) {

        super(factory);

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(random.nextInt(1500) + 1000);
                if (factory.getMaterial() > 0) {
                    factory.stampBlank();
                    System.out.println("Заготовка " + i + " создана");
                }
                else {
                    System.out.println("материал кончился");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }


        }
    }
}
