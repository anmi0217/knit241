package org.knit.solutions.ClassesSem1.lab3;

public class Warrior extends Player {
    public Warrior(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 75;
        this.maxHealth = 100;
        this.isALife = true;
        this.damage = 30;  // Уменьшили урон для баланса
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 10;
        this.energy = 30;
        this.maxEnergy = 100;
    }
}
