package org.knit.solutions.ClassesSem1.lab3;

public abstract class Player {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected boolean isALife;
    protected int damage;
    protected int axis_X;
    protected int axis_Y;
    protected int protection;
    protected int energy;
    protected int maxEnergy;

    public void displayInfo() {
        System.out.print(name + ":");
        System.out.print(" Живой: " + (isALife ? "Да" : "Нет"));
        System.out.print("; Текущее здоровье: " + currentHealth + "/" + maxHealth);
        System.out.print("; Урон: " + damage);
        System.out.print("; Защита: " + protection);
        System.out.print("; Энергия: " + energy + "/100");
        System.out.println("; Координаты: X = " + axis_X + ", Y = " + axis_Y);
    }

    protected void attack(Player player) {
        int r = Math.abs(axis_X - player.axis_X) + Math.abs(axis_Y - player.axis_Y);
        if (r > 5) {
            System.out.println("Цель слишком далеко!");
        } else {
            if (energy < 30) {
                System.out.println("Недостаточно энергии");
            } else {
                System.out.println(this.name + " атакует " + player.name);
                energy -= 30;
                player.decreaseHealth(this.damage);
            }
        }
    }

    protected void addHealth(int healPower) {
        currentHealth = Math.min(this.maxHealth, currentHealth + healPower);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
    }

    protected void decreaseHealth(int value) {
        this.currentHealth -= Math.max(value - protection, 0);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
        if (currentHealth < 0) {
            isALife = false;
            System.out.println(this.name + " мёртв");
        }
    }

    protected void move(int x, int y) {
        // Проверяем, находятся ли новые координаты в пределах допустимого диапазона
        if (x < -40 || x > 40 || y < -40 || y > 40) {
            System.out.println("Невозможно переместить " + name + ". Координаты (" + x + ", " + y + ") выходят за границы карты.");
            return; // Прекращаем выполнение метода, если координаты невалидны
        }

        // Рассчитываем расстояние для перемещения
        int r = Math.abs(axis_X - x) + Math.abs(axis_Y - y);

        // Проверяем, достаточно ли энергии для перемещения
        if (r > energy) {
            System.out.println("Недостаточно энергии!");
        } else {
            // Если энергии достаточно и координаты допустимы, перемещаем персонажа
            axis_X = x;
            axis_Y = y;
            energy -= r; // Вычитаем затраченную энергию
            System.out.println(name + " передвигается на: X = " + axis_X + ", Y = " + axis_Y);
        }
    }


    protected void addEnergy() {
        energy = Math.min(maxEnergy, energy + 20);
    }
}