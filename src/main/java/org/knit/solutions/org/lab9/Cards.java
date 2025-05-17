//16
package org.knit.solutions.org.lab9;

enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return suitName;
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

    private final String rankName;

    Rank(String rankName) {
        this.rankName = rankName;
    }

    public String getRankName() {
        return rankName;
    }
}

class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank.getRankName() + " " + suit.getSuitName();
    }
}

public class Cards {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        int index = 0;

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck[index++] = new Card(suit, rank);
            }
        }

        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
