package org.knit.solutions.Task5;

public class Dish2 extends Thread{
    private final Waiter waiter;
    private final String name = "Крабовый салат";

    public Dish2(Waiter waiter) {
        this.waiter = waiter;
    }


    @Override
    public void run() {
        try {
            System.out.println(name + " добавлено в очередь на готовку....");
            waiter.acquireDish(name);
            Thread.sleep(2500);
            waiter.releaseDish(name);
            System.out.println(name + " передано официанту.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
