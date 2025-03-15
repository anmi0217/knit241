package org.knit.solutions.task22;

public class Task22 {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        dictionary.put("Joe", 40);
        System.out.println(dictionary);

        System.out.println(dictionary.get("Alice"));
        dictionary.remove("Bob");
        System.out.println(dictionary);
    }
}
