package org.knit.solutions.task41;

public class ConcreteCharacter implements Character {
    private final String characterCode;

    public ConcreteCharacter(String characterCode) {
        this.characterCode = characterCode;
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.printf("Код символа: %s, положение: (%d, %d), стиль: %s.\n", characterCode, x, y, style);
    }
}
