package org.knit.solutions.lab3;

// Класс Хиллер имеет 800 ХП и 100 ед. защиты по умолчанию. Лечит на 100 ед.

public class Healer extends Player {

    public Healer(String name) {
        super(name, 800, 0, 100);
    }

    public void heal(Player target) {
        if (isAlive) {
            System.out.println(name + " \uD83D\uDC8Aлечит " + target.name + "а");
            target.increaseHealth(100);
        }
    }
}
