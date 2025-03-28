package org.knit.solutions.ClassesSem1.lab10.Task22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private List<Tuple<K, V>> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (Tuple<K, V> tuple : dictionary) {
            if (tuple.getKey().equals(key)) {
                tuple.setValue(value);
                return;
            }
        }
        dictionary.add(new Tuple<>(key, value));
    }

    public V get(K key) {
        for (Tuple<K, V> tuple : dictionary) {
            if (tuple.getKey().equals(key)) {
                return tuple.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        for (Tuple<K, V> tuple : dictionary) {
            if (tuple.getKey().equals(key)) {
                dictionary.remove(tuple);
            }
        }
    }
}
