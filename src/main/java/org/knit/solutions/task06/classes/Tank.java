package org.knit.solutions.task06.classes;

import org.knit.solutions.task06.abilities.Melee;

public class Tank extends Player implements Melee {
    public Tank(String name, int posX, int posY) {
        super(name, posX, posY);
        System.out.println("Славный меч " + name + " готов к бою");
    }

    @Override
    public void melee(Player p) {
        if (!isAlive) {
            System.out.println(name + " мёртв");
        } else if (name.equals(p.getName())) {
            System.out.println(name + " не может атаковать самого себя");
        } else if (Math.abs(posX - p.getPosX()) > 2 &&
                Math.abs(posY - p.getPosY()) > 2) {
            System.out.println("Меч " + name + " не такой длинный");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " бьёт мечом " + p.getName());
            p.decreaseHP(3, this);
        }
    }

    @Override
    protected void decreaseHP(int damage, Player p) {
        super.decreaseHP(damage - 2, p);
    }

    @Override
    public String toString() {
        return "Воин по имени " + name + "\n" +
                "Убил персонажей: " + killCount + "\n" +
                "В данный момент: " + (isAlive ? "жив" : "мёртв") + "\n";
    }
}
