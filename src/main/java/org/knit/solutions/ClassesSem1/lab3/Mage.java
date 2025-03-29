package org.knit.solutions.ClassesSem1.lab3;

public class Mage extends Player {
    public Mage(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 55;  // Уменьшили здоровье для баланса
        this.maxHealth = 70;
        this.isALife = true;
        this.damage = 20;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 0;
        this.energy = 30;
        this.maxEnergy = 100;
    }

    public void castSpell(Player player) {
        int r = Math.abs(axis_X - player.axis_X) + Math.abs(axis_Y - player.axis_Y);
        if (r > 15) {
            System.out.println("Цель слишком далеко!");
        } else {
            if (energy < 40) {  // Увеличили стоимость заклинания
                System.out.println("Недостаточно энергии");
            } else {
                System.out.println(this.name + " Накладывает заклинание на " + player.name);
                this.energy -= 40;  // Увеличили стоимость заклинания
                player.decreaseHealth(50);  // Оставили мощное заклинание
            }
        }
    }
}
