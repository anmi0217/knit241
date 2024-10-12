package org.knit.tasks.task6.classes;

import org.knit.tasks.task6.abilities.Melee;
import org.knit.tasks.task6.abilities.Range;

public class Archer extends Player implements Melee, Range {
    public Archer(String name, int posX, int posY) {
        super(name, posX, posY);
        System.out.println("Легендарный лук " + name + " готов к бою");
    }

    @Override
    public void melee(Player p) {
        if (!isAlive) {
            System.out.println(name + " мёртв");
        } else if (name.equals(p.getName())) {
            System.out.println(name + " не может атаковать самого себя");
        } else if (Math.abs(posX - p.getPosX()) > 1 &&
                Math.abs(posY - p.getPosY()) > 1) {
            System.out.println("Клинок " + name + " не такой длинный");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " бьёт клинком " + p.getName());
            p.decreaseHP(2, this);
        }
    }

    @Override
    public void range(Player p) {
        if (!isAlive) {
            System.out.println(name + " мёртв");
        } else if (name.equals(p.getName())) {
            System.out.println(name + " не может атаковать самого себя");
        } else if (Math.abs(posX - p.getPosX()) < 2 &&
                Math.abs(posY - p.getPosY()) < 2) {
            System.out.println("Лук " + name + " бесполезен вблизи");
        } else if (Math.abs(posX - p.getPosX()) > 4 &&
                Math.abs(posY - p.getPosY()) > 4) {
            System.out.println("Лук " + name + " не достанет так далеко");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " пронзает стрелой " + p.getName());
            p.decreaseHP(4, this);
        }
    }

    @Override
    public String toString() {
        return "Лучник по имени " + name + "\n" +
                "Убил персонажей: " + killCount + "\n" +
                "В данный момент: " + (isAlive ? "жив" : "мёртв") + "\n";
    }
}
