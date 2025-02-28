package org.knit.lab3;

public class Mage extends Player {

    public Mage(String name) {
        super(name, 300, 100, 150);
    }

    public void castSpell(Player target) {
        if (isAlive) {
            System.out.println(name + " \uD83D\uDD2Eбросает заклинание в " + target.name + "а");
            target.decreaseHealth(damage);
        }
    }
}
