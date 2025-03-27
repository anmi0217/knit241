package org.knit.solutions.task41;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, Character> characters = new HashMap<>();

    public Character getCharacter(String characterCode) {
        if (!characters.containsKey(characterCode)) {
            characters.put(characterCode, new ConcreteCharacter(characterCode));
        }
        return characters.get(characterCode);
    }
}
