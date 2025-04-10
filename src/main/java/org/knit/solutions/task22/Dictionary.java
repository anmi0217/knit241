package org.knit.solutions.task22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private final List<Pair<K, V>> dictionary = new ArrayList<>();

    public void put(K key, V value) {
        dictionary.add(new Pair<>(key, value));
    }

    public V get(K key) {
        for (Pair<K, V> pair : dictionary) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        System.out.println("Элемент с ключом " + key + " не найден");
        return null;
    }

    public void remove(K key) {
        for (Pair<K, V> pair : dictionary) {
            if (pair.getKey().equals(key)) {
                dictionary.remove(pair);
                return;
            }
        }
        System.out.println("Элемент с ключом " + key + " не найден");
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }
}
