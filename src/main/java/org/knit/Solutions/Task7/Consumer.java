package org.knit.Solutions.Task7;

public class Consumer extends Thread{
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse){
        this.warehouse = warehouse;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            warehouse.issuance();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
