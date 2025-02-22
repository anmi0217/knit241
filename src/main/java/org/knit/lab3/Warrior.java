package org.knit.lab3;

public class Warrior extends Player {

    public Warrior(String name) {
        super(name, 500, 200, 200);
    }

    public void attack(Player target) {
        if (isAlive) {
            System.out.println(name + " \uD83D\uDDE1атакует " + target.name + "а");
            target.decreaseHealth(damage);
        }
    }
}
