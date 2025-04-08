package org.knit.solutions.Task4;

public class GasStation {
    private int availablePumps = 2;

    public synchronized void acquirePump(String name) throws InterruptedException {
        while (availablePumps == 0) {
            System.out.println("Все колонки заняты, " + name + " ждёт");
            wait();
        }
        availablePumps--;
        System.out.println(name + " заняла колонку, заправляемся");
    }

    public synchronized void releasePump(String name) {
        availablePumps++;
        System.out.println(name + " освободила колонку");
        notify();
    }
}
