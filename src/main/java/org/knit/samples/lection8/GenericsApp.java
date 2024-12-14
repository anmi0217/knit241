package org.knit.samples.lection8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GenericsApp {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "3", "b1");

        Stream<String> stream = strings.stream();
        List<Integer> collect = stream
                .map(Integer::valueOf).collect(Collectors.toList());

        for (Integer i : collect) {
            System.out.println(i);
        }


    }
}
