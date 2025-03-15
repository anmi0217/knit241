package org.knit.solutions.task06.classes;

public abstract class Player {
    protected final String name;
    protected int killCount = 0;
    protected boolean isAlive = true;
    protected int currentHP = 6;
    protected int posX;
    protected int posY;

    public Player(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    public void goDown() {
        posY -= 1;
        System.out.println(name + " идёт вниз.");
    }

    public void goLeft() {
        posX -= 1;
        System.out.println(name + " идёт влево.");
    }

    public void goRight() {
        posX += 1;
        System.out.println(name + " идёт вправо.");
    }

    public void goUp() {
        posY += 1;
        System.out.println(name + " идёт вверх.");
    }

    protected String getName() {
        return name;
    }

    protected void increaseKillCount() {
        killCount++;
    }

    protected boolean isNotAlive() {
        return !isAlive;
    }

    protected void increaseHP() {
        currentHP = Math.min(currentHP + 3, 10);
    }

    protected void decreaseHP(int damage, Player p) {
        currentHP = Math.max(currentHP - damage, 0);
        if (currentHP == 0) {
            isAlive = false;
            p.increaseKillCount();
            System.out.println(name + " повержен " + p.getName());
        }
    }

    protected int getPosX() {
        return posX;
    }

    protected int getPosY() {
        return posY;
    }
}
