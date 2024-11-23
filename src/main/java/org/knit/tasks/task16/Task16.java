package org.knit.tasks.task16;

import java.util.ArrayList;
import java.util.List;

public class Task16 {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck.add(new Card(suit, value));
            }
        }
        deck.forEach(System.out::println);
    }
}
