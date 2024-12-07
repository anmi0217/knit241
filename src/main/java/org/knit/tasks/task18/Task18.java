package org.knit.tasks.task18;

public class Task18 {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair);
        pair.setSecondValue(35);
        System.out.println(pair);
    }
}
