package org.knit.solutions.org.lab3;

public class Priest extends Player implements Heal {

    public Priest(String name) {
        super(name, 80, 10, 3); // Например, здоровье 80, урон 5, защита 3
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
        return 80;
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
        System.out.println(getName() + " атакует " + player.getName() + " с уроном " + getDamage());
        player.decreaseHealth(getDamage());
    }

@Override
    // Метод для лечения союзника
    public void heal(Player player) {
        if (player.getCurrentHealth() > 0) {
            int healAmount = 20; // Количество здоровья, которое врач может восстановить
            player.increaseHealth(healAmount);
            System.out.println(getName() + " лечит " + player.getName() + " на " + healAmount + ".");
        } else {
            System.out.println(player.getName() + " уже побежден.");
        }
    }
}