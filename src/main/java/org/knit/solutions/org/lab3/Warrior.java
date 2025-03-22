package org.knit.solutions.org.lab3;

// Класс Warrior (воин)
public class Warrior extends Player {
    Warrior(String name) {
        super(name, 100, 15, 5); // Здоровье 100, урон 15, защита 5
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
        return 100;
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

    }

    public void attack(Player player) {
        System.out.println(getName() + " атакует " + player.getName() + " с уроном " + getDamage());
        player.decreaseHealth(getDamage());
    }
}


// Класс для сильного врага
class StrongEnemy extends Player {
    StrongEnemy(String name) {
        super(name, 150, 30, 2); // Сильный враг с увеличенным уроном (30) и здоровьем (150)
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
        return 150;
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
    }

    public void attack(Player player) {
        System.out.println(getName() + " атакует " + player.getName() + " с огромным уроном " + getDamage());
        player.decreaseHealth(getDamage());
    }
}
