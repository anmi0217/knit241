package org.knit.solutions.lab2_4.Task2_12Classes;

public class Memento {
    private String path;
    private String text;
    private String name;

    public Memento(String name, String text) {
        this.path = "C:\\Users\\belonozhkoin\\IdeaProjects\\javatasks\\src\\main\\java\\org\\knit\\jnbovfavhk\\sem2\\lab2_4\\" + name;
        this.text = text;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }
}
