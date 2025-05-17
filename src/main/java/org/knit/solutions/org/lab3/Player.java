package org.knit.solutions.org.lab3;

public abstract class Player implements Attack {
    private String name;
    private int currentHealth;
    private int maxHealth;
    private boolean isAlive;
    private int x;
    private int y;
    private int damage;
    private int defence;

    // Конструктор, который принимает параметры для всех свойств
    public Player(String name, int maxHealth, int damage, int defence) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.isAlive = true;
        this.damage = damage;
        this.defence = defence;
        this.x = 0;
        this.y = 0;
    }

    // Остальные методы и свойства класса
    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int health) {
        this.currentHealth = health;
        if (this.currentHealth <= 0) {
            this.isAlive = false;
            System.out.println(name + " мертв.");
        } else {
            this.isAlive = true;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        System.out.println(name + " перемещен на позицию (" + x + ", " + y + ").");
    }

    protected abstract void increaseHealth(int value);
    protected abstract void decreaseHealth(int value);

    @Override
    public String toString() {
        return name + " [HP: " + currentHealth + "/" + maxHealth + ", Статус: " + (isAlive ? "жив" : "мертв") + "]";
    }
}