package org.knit.solutions.task16;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    public final Map<Character, CharacterFlyweight> characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char symbol) {
        characters.putIfAbsent(symbol, new CharacterFlyweight(symbol));
        return characters.get(symbol);
    }
}
