package org.knit.tasks.task27;

public class Americano implements Coffee {
    @Override
    public int getCost() {
        return 165;
    }

    @Override
    public int getVolume() {
        return 180;
    }

    @Override
    public String getDescription() {
        return "Американо";
    }
}
