package org.knit.solutions.task16;

public class CharacterFlyweight implements Flyweight{
    private final char symbol;

    public CharacterFlyweight(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.println("Символ: " + symbol + " на координатах ( " + x + ", " + y + " )");
    }
}
