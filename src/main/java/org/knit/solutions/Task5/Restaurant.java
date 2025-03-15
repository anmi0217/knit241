package org.labs.Tasks2.Task5;

public class Restaurant {
    private int dishCount = 0;

    public synchronized void cookDish(String chefName) throws InterruptedException {
        int MAX_DISHES = 3;
        while (dishCount == MAX_DISHES) {
            System.out.println(chefName + " ждёт, так как поднос полон.");
            wait();
        }
        dishCount++;
        System.out.println(chefName + " приготовил блюдо. На подносе сейчас: " + dishCount);

        notify();
    }

    public synchronized void serveDish(String waiterName) throws InterruptedException {
        while (dishCount == 0) {
            System.out.println(waiterName + " ждёт, так как на подносе нет блюд.");
            wait();
        }
        dishCount--;
        System.out.println(waiterName + " забрал блюдо. На подносе осталось: " + dishCount);

        notify();
    }
}
