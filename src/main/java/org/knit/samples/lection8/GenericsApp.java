package org.knit.samples.lection8;

import java.util.function.BiFunction;

public class GenericsApp {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Double> function = new BiFunction<>() {
            @Override
            public Double apply(Integer integer, Integer integer2) {
                System.out.println(integer + " " + integer2);
                return 0.0;
            }
        };
        function.andThen((x) -> x + "1").apply(1,1);
    }
}
