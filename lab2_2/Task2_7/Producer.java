package org.dina.lab2_2.Task2_7;

class Producer implements Runnable {
    Store store;
    Producer(Store store) {
        this.store = store;
    }
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                store.produce();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

