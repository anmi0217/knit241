package org.knit.solutions.Task16;

public class ConcreteCharacter implements FlyweightCharacter {
    private final char symbol;

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.println("Отрисовка символа '" + symbol + "' в позиции ("
                + x + ", " + y + ") со стилем: " + style);
    }
}
