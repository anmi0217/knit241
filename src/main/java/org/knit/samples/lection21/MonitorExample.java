package org.knit.samples.lection21;


import org.apache.commons.lang3.exception.ExceptionUtils;

class SharedResource {
    public  void printMessage(String message) {
        System.out.print("[");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message + "]");
    }
}

public class MonitorExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        System.out.println("🔧 Сборщик: Заготовка обработана");

       Thread t1 = new Thread(() -> resource.printMessage("Привет"));
        Thread t2 = new Thread(() -> resource.printMessage("Мир"));
        Thread t3 = new Thread(() -> resource.printMessage("Java"));

        t1.start();
        t2.start();
        t3.start();



        t1.join();
       t2.join();
       t3.join();
        System.out.println("End");

    }
}