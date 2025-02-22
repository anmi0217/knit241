package org.knit.lab9;

public class Col {
    enum Suit {
        SPADES ("пики"),
        HEARTS("черви"),
        DIAMONDS("бубны"),
        CLUBS("трефы");

        private final String suit;

        Suit(String s) {
            suit = s;
        }

        String getSuit() {
            return suit;
        }
    }

    enum Rank {
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("Валет"),
        QUEEN("Дама"),
        KING("Король"),
        ACE("Туз");

        private final String rank;

        Rank(String r) {
            rank = r;
        }

        String getRank() {
            return rank;
        }
    }
}
