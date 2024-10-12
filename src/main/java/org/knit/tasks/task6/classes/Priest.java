package org.knit.tasks.task6.classes;

import org.knit.tasks.task6.abilities.Heal;
import org.knit.tasks.task6.abilities.Melee;

public class Priest extends Player implements Melee, Heal {
    public Priest(String name, int posX, int posY) {
        super(name, posX, posY);
        System.out.println("Прославленный жезл " + name + " готов к бою");
    }

    @Override
    public void melee(Player p) {
        if (!isAlive) {
            System.out.println(name + " мёртв");
        } else if (name.equals(p.getName())) {
            System.out.println(name + " не может атаковать самого себя");
        } else if (Math.abs(posX - p.getPosX()) > 1 &&
                Math.abs(posY - p.getPosY()) > 1) {
            System.out.println("Жезл " + name + " не такой длинный");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " бьёт жезлом " + p.getName());
            p.decreaseHP(2, this);
        }
    }

    @Override
    public void heal(Player p) {
        if (!isAlive) {
            System.out.println(name + " мёртв");
        } else if (name.equals(p.getName())) {
            System.out.println(name + " не может исцелять самого себя");
        } else if (Math.abs(posX - p.getPosX()) > 3 &&
                Math.abs(posY - p.getPosY()) > 3) {
            System.out.println("Сила жезла " + name + " не безгранична");
        } else if (p.isNotAlive()) {
            System.out.println(p.getName() + " уже мёртв");
        } else {
            System.out.println(name + " исцеляет " + p.getName());
            p.increaseHP();
        }
    }

    @Override
    public String toString() {
        return "Священник по имени " + name + "\n" +
                "Убил персонажей: " + killCount + "\n" +
                "В данный момент: " + (isAlive ? "жив" : "мёртв") + "\n";
    }
}
