package org.knit.tasks.task6;

public abstract class Player {
    private String name;
    private boolean isAlive;
    private int currentHP;
    private int basicHP;
    private int maxHP;
    private int currentDEF;
    private int basicDEF;
    // todo private int posX;
    // todo private int posY;

    protected abstract void increaseHP(int hp);

    protected abstract void decreaseHP(int hp);

    protected abstract void increaseDEF(int def);

    protected abstract void decreaseDEF(int def);

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getBasicHP() {
        return basicHP;
    }

    public void setBasicHP(int basicHP) {
        this.basicHP = basicHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentDEF() {
        return currentDEF;
    }

    public void setCurrentDEF(int currentDEF) {
        this.currentDEF = currentDEF;
    }

    public int getBasicDEF() {
        return basicDEF;
    }

    public void setBasicDEF(int basicDEF) {
        this.basicDEF = basicDEF;
    }
}
