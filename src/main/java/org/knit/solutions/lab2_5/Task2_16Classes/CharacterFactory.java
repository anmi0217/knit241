package org.knit.solutions.lab2_5.Task2_16Classes;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<Integer, Character> charMap = new HashMap<>();

    public FlyWeight getChar(int id) {
        Character charr = charMap.get(id);

        if (charr == null) {
            charr = new Character(id);
            charMap.put(id, charr);

        }
        return charr;
    }
}
