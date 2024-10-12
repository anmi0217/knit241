package org.knit.tasks.task6;

import org.knit.tasks.task6.classes.Archer;
import org.knit.tasks.task6.classes.Mage;
import org.knit.tasks.task6.classes.Priest;
import org.knit.tasks.task6.classes.Tank;

public class Task6 {
    public static void main(String[] args) {
        Archer archer = new Archer("Андерсдоттер", 0, 0);
        Mage mage = new Mage("Барбелот", 1, 1);
        Priest priest = new Priest("Рейндоттир", 6, 6);
        Tank tank = new Tank("Николь", 5, 5);
        System.out.println();

        archer.goUp();
        mage.teleportRight();
        priest.goLeft();
        tank.goDown();
        archer.range(tank);
        mage.range(priest);
        priest.goDown();
        tank.goLeft();
        archer.range(tank);
        mage.teleportRight();
        priest.heal(tank);
        tank.goLeft();
        archer.range(tank);
        mage.melee(priest);
        tank.melee(mage);
        archer.range(tank);
        tank.goRight();
        archer.range(tank);

        System.out.println();
        System.out.println(archer);
        System.out.println(mage);
        System.out.println(priest);
        System.out.println(tank);
    }
}
