package org.knit.tasks.task09;

import java.util.Random;

public class Dictionary {
    private final String[] dictionary;

    public Dictionary(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public String getRandomWord() {
        return dictionary[new Random().nextInt(dictionary.length)];
    }
}
