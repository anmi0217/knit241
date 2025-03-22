package org.knit.solutions.lab2_2.Task2_4Classes;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class GasStation {
    private final Semaphore semaphore = new Semaphore(2);


    public void fillUp(Car car) throws InterruptedException {
        semaphore.acquire();

        System.out.println(car.getName() + " заправляется... Свободных станций: " + semaphore.availablePermits());

        car.increaseFuel();
        sleep(3000);


        semaphore.release();

    }


}
