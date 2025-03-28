package org.knit.solutions.lab2_5.Task2_16Classes;

import java.util.NoSuchElementException;

public class Character implements FlyWeight{
    private int id; // код символа

    @Override
    public void render(int x, int y, String style) {
        System.out.println("Char(" + x + ", " + y + "); style: " + style);
    }

    public Character(int id) {
        this.id = id;
        System.out.println("Создан символ с кодом " + id);
    }
}
