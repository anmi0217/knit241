//18
package org.knit.solutions.org.lab10;

// Универсальный класс Pair
class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Пара{" + "первый=" + first + ", второй=" + second + '}';
    }
}

public class PairExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Возраст", 30);

        System.out.println("Изначальная пара: " + pair);

        System.out.println("Первый: " + pair.getFirst());
        System.out.println("Второй: " + pair.getSecond());

        pair.setSecond(35);

        System.out.println("Пара после изменения: " + pair);
    }
}