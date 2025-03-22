package org.knit.solutions.org.lab3;

public class Mage extends Player {
    public Mage(String name) {
        super(name, 70, 25, 2); // Например, здоровье 70, урон 20, защита 2
    }

    @Override
    protected void increaseHealth(int value) {
        int hp = getCurrentHealth();
        hp += value;

        if (hp > getMaxHealth()) {
            hp = getMaxHealth();
        }

        setCurrentHealth(hp);
        System.out.println(getName() + " увеличил здоровье на " + value + ". Текущее здоровье: " + hp);
    }

    private int getMaxHealth() {
        return 60;
    }

    @Override
    protected void decreaseHealth(int value) {
        int hp = getCurrentHealth();

        int actualDamage = value - getDefence();
        if (actualDamage < 1) {
            actualDamage = 1;
        }

        hp -= actualDamage;

        if (hp < 0) {
            hp = 0;
        }

        setCurrentHealth(hp);

        if (hp == 0) {
            setAlive(false);
            System.out.println(getName() + " был побежден.");
        } else {
            System.out.println(getName() + " получил урон на " + actualDamage + ". Текущее здоровье: " + hp);
        }
    }

    private void setAlive(boolean b) {
        // Установка статуса жизни
    }

    public void attack(Player player) {
        System.out.println(getName() + " колдует и атакует " + player.getName() + " с уроном " + getDamage());
        player.decreaseHealth(getDamage());
    }
}