package org.knit.lab9;

public class Task16 {
    Col col = new Col();
    public void print() {
        for (Col.Rank r : Col.Rank.values()) {
            for (Col.Suit s : Col.Suit.values()) {
                System.out.println(r.getRank() + " " + s.getSuit());
            }
        }
    }
}
