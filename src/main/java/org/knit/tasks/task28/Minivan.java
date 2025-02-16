package org.knit.tasks.task28;

public class Minivan implements Transport {
    @Override
    public String getName() {
        return "Семейный минивэн";
    }

    @Override
    public String getComfort() {
        return Comfort.MEDIUM.getLevel();
    }

    @Override
    public String getSpeed() {
        return Speed.LOW.getValue();
    }

    @Override
    public String getCapacity() {
        return Capacity.SIX.getValue();
    }
}
