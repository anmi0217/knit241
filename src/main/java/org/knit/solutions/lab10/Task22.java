package org.knit.solutions.lab10;

public class Task22 {
    public void execute() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        dictionary.put("John", 10);
        dictionary.put("Vanessa", 40);
        System.out.println(dictionary.get("Alice"));
        System.out.println(dictionary.values());
        System.out.println(dictionary.keys());
        System.out.println(dictionary.containsKey("Bob"));
        dictionary.remove("John");

    }
}
