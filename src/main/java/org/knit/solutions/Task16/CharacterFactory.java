package org.knit.solutions.Task16;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private Map<Character, FlyweightCharacter> cache = new HashMap<>();

    public FlyweightCharacter getCharacter(char symbol) {
        FlyweightCharacter flyweight = cache.get(symbol);
        if (flyweight == null) {
            flyweight = new ConcreteCharacter(symbol);
            cache.put(symbol, flyweight);
        }
        return flyweight;
    }
}
