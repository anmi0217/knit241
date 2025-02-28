package org.knit.lab3;

public abstract class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected boolean isAlive;
    protected int posX;
    protected int posY;
    protected int damage;
    protected int def;

    public Player(String name, int maxHealth, int damage, int def) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.isAlive = true;
        this.posX = 0;
        this.posY = 0;
        this.damage = damage;
        this.def = def;
    }

    public void increaseHealth(int value) {
        if (isAlive) {
            this.health += value;
            if (this.health > maxHealth) {
                this.health = maxHealth;
            }
            System.out.println(name + " увеличил ХП до " + value);
        } else {
            ExCatcher("Нельзя вылечить игрока, так как он мертв!");
        }
    }

    public void decreaseHealth(int value) {
        if (health < 0) {
            System.out.println("Этот класс уже умер!");
        } else {
            if (def > 0) {
                def -= value;
                if (def < 0) {
                    health += def;
                    def = 0;
                }
            } else {
                health -= value;
            }
            if (health < 0) {
                isAlive = false;
                System.out.println(name + " помер");
            } else {
                System.out.println(name + " атакован на " + value + " ед.");
            }
        }
    }

    public void increaseShield(int value) {
        if (isAlive) {
            this.def += value;
            System.out.println(name + " получил " + value + " ед. защиты");
        } else {
            ExCatcher("Нельзя поставить щит игроку, так как он мертв!");
        }
    }

    public void move(int x, int y) {
        this.posX = x;
        this.posY = y;
        System.out.printf("\n" + name + " переместился на позицию (%d, %d)", x, y);
    }

    public void ExCatcher(String ex) {
        System.out.println(ex);
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\nХП: " + health + "/" + maxHealth + "\nЗащита: " + def + "\nПозиция: (" + posX + ", " + posY +
                ")\nСтатус: " + (isAlive ? "Жив" : "Мертв");
    }
}
