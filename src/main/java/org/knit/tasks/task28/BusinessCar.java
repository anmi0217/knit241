package org.knit.tasks.task28;

public class BusinessCar implements Transport {
    @Override
    public String getName() {
        return "Бизнес-автомобиль";
    }

    @Override
    public String getComfort() {
        return Comfort.HIGH.getLevel();
    }

    @Override
    public String getSpeed() {
        return Speed.MEDIUM.getValue();
    }

    @Override
    public String getCapacity() {
        return Capacity.FOUR.getValue();
    }
}
