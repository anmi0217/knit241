package org.knit.solutions.lab10;

import java.util.ArrayList;
import java.util.Objects;

public class Dictionary<K, V> {
    private final ArrayList<Pair<K, V>> entries;

    public Dictionary() {
        this.entries = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (Pair<K, V> pair : entries) {
            if (Objects.equals(pair.getFirst(), key)) {
                pair.setSecond(value);
                return;
            }
        }
        entries.add(new Pair<>(key, value));
    }

    public V get(K key) {
        for (Pair<K, V> pair : entries) {
            if (Objects.equals(pair.getFirst(), key)) {
                return pair.getSecond();
            }
        }
        throw new IllegalArgumentException("Ключ \"" + key + "\" не найден в словаре.");
    }

    public void remove(K key) {
        for (int i = 0; i < entries.size(); i++) {
            if (Objects.equals(entries.get(i).getFirst(), key)) {
                entries.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Ключ \"" + key + "\" не найден для удаления.");
    }

    public boolean containsKey(K key) {
        for (Pair<K, V> pair : entries) {
            if (Objects.equals(pair.getFirst(), key)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<K> keys() {
        ArrayList<K> keys = new ArrayList<>();
        for (Pair<K, V> pair : entries) {
            keys.add(pair.getFirst());
        }
        return keys;
    }

    public ArrayList<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Pair<K, V> pair : entries) {
            values.add(pair.getSecond());
        }
        return values;
    }

}