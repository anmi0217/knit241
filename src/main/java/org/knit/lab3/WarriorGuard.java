package org.knit.lab3;

// У щитовика характеристики война +100 доп. ед. защиты и он умеет ставить щит классам

public class WarriorGuard extends Warrior {
    public WarriorGuard(String name) {
        super(name);
        this.def += 100;
        this.damage -= 100;
    }

    public void deployShield(Player target) {
        if (isAlive) {
            System.out.println(name + " ставит щит " + target.name);
            target.increaseShield(100);
        }
    }
}
