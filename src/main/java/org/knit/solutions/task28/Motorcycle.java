package org.knit.solutions.task28;

public class Motorcycle implements Transport {
    @Override
    public String getName() {
        return "Мотоцикл для доставки";
    }

    @Override
    public String getComfort() {
        return Comfort.LOW.getLevel();
    }

    @Override
    public String getSpeed() {
        return Speed.HIGH.getValue();
    }

    @Override
    public String getCapacity() {
        return Capacity.ONE.getValue();
    }
}
