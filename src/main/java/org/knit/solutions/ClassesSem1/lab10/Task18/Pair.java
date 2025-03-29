package org.knit.solutions.ClassesSem1.lab10.Task18;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getFirst() {
        return key;
    }

    public V getSecond() {
        return value;
    }

    public void setFirst(K newKey) {
        this.key = newKey;
    }

    public void setSecond(V newValue) {
        this.value = newValue;
    }


}
