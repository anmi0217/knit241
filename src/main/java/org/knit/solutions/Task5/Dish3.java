package org.knit.solutions.Task5;

public class Dish3 extends Thread{
    private final Waiter waiter;
    private final String name = "Стейк";

    public Dish3(Waiter waiter) {
        this.waiter = waiter;
    }


    @Override
    public void run() {
        try {
            System.out.println(name + " добавлено в очередь на готовку....");
            waiter.acquireDish(name);
            Thread.sleep(5000);
            waiter.releaseDish(name);
            System.out.println(name + " передано официанту.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
