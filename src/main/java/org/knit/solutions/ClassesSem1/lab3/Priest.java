package org.knit.solutions.ClassesSem1.lab3;

public class Priest extends Player {
    public Priest(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 60;
        this.maxHealth = 60;
        this.isALife = true;
        this.damage = 10;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 0;
        this.energy = 100;
        this.maxEnergy = 100;
    }

    public void heal(Player player) {
        int r = Math.abs(axis_X - player.axis_X) + Math.abs(axis_Y - player.axis_Y); // Вычисляем расстояние
        if (r > 20) {  // Проверяем, не слишком ли далеко цель
            System.out.println("Цель слишком далеко для исцеления!");
        } else {
            if (this.energy < 40) {  // Проверяем, достаточно ли энергии для лечения
                System.out.println("Недостаточно энергии для лечения");
            } else {
                System.out.println(this.name + " Лечит " + player.name);
                this.energy -= 40;  // Уменьшаем энергию
                player.addHealth(20);  // Увеличиваем здоровье игрока
            }
        }
    }
}
