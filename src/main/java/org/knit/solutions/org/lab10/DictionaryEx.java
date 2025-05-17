//22
package org.knit.solutions.org.lab10;

import java.util.ArrayList;
import java.util.List;

class Dictionary<K, V> {
    // Вложенный класс для хранения пар ключ-значениеprivate static class Entry<K, V> {


    private List<Pair<K, V>> entries;

    public Dictionary() {
        entries = new ArrayList<>();
    }

    // Метод для добавления или обновления пары ключ-значение
    public void put(K key, V value) {
        for (Pair<K, V> entry : entries) {
            if (entry.getFirst().equals(key)) {
                entry.setSecond(value); // Обновляем значение, если ключ уже существует
                return;
            }
        }
        entries.add(new Pair<>(key, value)); // Добавляем новую пару
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        for (Pair<K, V> entry : entries) {
            if (entry.getFirst().equals(key)) {
                return entry.getSecond();
            }
        }
        return null;
    }

    // Метод для удаления пары по ключу
    public void remove(K key) {
        entries.removeIf(entry -> entry.getFirst().equals(key));
    }

    // Метод для проверки наличия ключа
    public boolean containsKey(K key) {
        for (Pair<K, V> entry : entries) {
            if (entry.getFirst().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Метод для получения всех ключей
    public List<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (Pair<K, V> entry : entries) {
            keys.add(entry.getFirst());
        }
        return keys;
    }

    // Метод для получения всех значений
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Pair<K, V> entry : entries) {
            values.add(entry.getSecond());
        }
        return values;
    }
}

public class DictionaryEx {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("Вика", 25);
        dictionary.put("Максим", 30);
        dictionary.put("Костя", 35);

        System.out.println("Возраст Вики: " + dictionary.get("Вика"));
        System.out.println("Возраст Максима: " + dictionary.get("Максим"));

        dictionary.remove("Костя");
        System.out.println("Есть ли Костя: " + dictionary.containsKey("Костя"));

        System.out.println("Все ключи (имена): " + dictionary.keySet());
        System.out.println("Все значения (возраста): " + dictionary.values());
    }
}