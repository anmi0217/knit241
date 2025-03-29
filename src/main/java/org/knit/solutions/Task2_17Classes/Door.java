package org.knit.solutions.Task2_17Classes;

public class Door {
    private boolean hasPrize;

    public boolean open() {
        return hasPrize;
    }

    public Door(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }
}
