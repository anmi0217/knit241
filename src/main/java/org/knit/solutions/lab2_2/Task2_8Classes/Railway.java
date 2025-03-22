package org.knit.solutions.lab2_2.Task2_8Classes;


import static java.lang.Thread.sleep;

public class Railway {
    private TrafficLight trafficLight;

    public Railway() {
        this.trafficLight = TrafficLight.RED;
    }

    public synchronized void setNextLight() {
        trafficLight = trafficLight.getNext();
        System.out.println("Свет светофора: " + trafficLight);
        notifyAll();
    }

    public TrafficLight getCurrentLight() {
        return trafficLight;
    }

    public synchronized void goThroughRailway(Car car) throws InterruptedException {
        if (getCurrentLight().equals(TrafficLight.GREEN)) {
            sleep(1000);
            System.out.println(car.getName() + " проехал(а) по шоссе");
        }
        else {
            wait();
        }
    }
}
