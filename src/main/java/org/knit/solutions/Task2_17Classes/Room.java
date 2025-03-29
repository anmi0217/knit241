package org.knit.solutions.Task2_17Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Room {
    private final ArrayList<Door> doorList = new ArrayList<>(3);
    private short openedDoorCount;

    public Room() {
        doorList.add(new Door(true));
        doorList.add(new Door(false));
        doorList.add(new Door(false));
        openedDoorCount = 0;
        Collections.shuffle(doorList);
    }

    public boolean openDoor(short i) {
        openedDoorCount++;
        return doorList.get(i).open();
    }

    public short getOpenedDoorCount() {
        return openedDoorCount;
    }
}
