package org.knit.solutions.task40;

public class Task40 {
    public static void main(String[] args) {
        Image image = new ImageProxy();
        image.request();
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        image.request();
    }
}
