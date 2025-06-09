package org.knit.solutions.org.lab3;

public class WarriorGuard extends Warrior {
    private int additionalDefence = 0;

    public WarriorGuard(String name) {
        super(name);
    }

    @Override
    protected void decreaseHealth(int value) {
        int hp = getCurrentHealth();
        hp = hp + getDefence() + additionalDefence - value;
        setCurrentHealth(hp);
        System.out.println(getName() + " получил урон на " + value + ". Текущее здоровье: " + hp);
    }
}