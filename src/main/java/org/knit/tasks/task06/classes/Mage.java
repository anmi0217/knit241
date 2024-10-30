package org.knit.tasks.task06.classes;

import org.knit.tasks.task06.abilities.Melee;
import org.knit.tasks.task06.abilities.Range;
import org.knit.tasks.task06.abilities.Teleport;

public class Mage extends Player implements Melee, Range, Teleport {
    public Mage(String name, int posX, int posY) {
        super(name, posX, posY);
        System.out.println("Великий посох " + name + " готов к бою");
    }

    @Override
    public void melee(Player p) {
        if (!isAlive) {
            System.out.println(name + " мёртв");
        } else if (name.equals(p.getName())) {
            System.out.println(name + " не может атаковать самого себя");
        } else if (Math.abs(posX - p.getPosX()) > 1 &&
                Math.abs(posY - p.getPosY()) > 1) {
            System.out.println("Взрыв " + name + " не такой большой");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " взрывает себя и " + p.getName());
            p.decreaseHP(5, this);
            decreaseHP(3, this);
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
            System.out.println("Заклинание " + name + " слишком опасно");
        } else if (Math.abs(posX - p.getPosX()) > 4 &&
                Math.abs(posY - p.getPosY()) > 4) {
            System.out.println("Заклинание " + name + " не такое сильное");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " призывает заклинание на " + p.getName());
            p.decreaseHP(3, this);
        }
    }

    @Override
    public void teleportDown() {
        posY -= 2;
        System.out.println(name + " перемещается вниз.");
    }

    @Override
    public void teleportLeft() {
        posX -= 2;
        System.out.println(name + " перемещается влево.");
    }

    @Override
    public void teleportRight() {
        posX += 2;
        System.out.println(name + " перемещается вправо.");
    }

    @Override
    public void teleportUp() {
        posY += 2;
        System.out.println(name + " перемещается вверх.");
    }

    @Override
    public String toString() {
        return "Маг по имени " + name + "\n" +
                "Убил персонажей: " + killCount + "\n" +
                "В данный момент: " + (isAlive ? "жив" : "мёртв") + "\n";
    }
}
