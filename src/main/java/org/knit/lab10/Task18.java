package org.knit.lab10;

public class Task18 {
    public void execute() {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair.getFirst() + " / " + pair.getSecond());
        pair.setSecond(35);
        System.out.println(pair);
    }
}
