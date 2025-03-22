package org.knit.solutions.lab2_4.Task2_12Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class TextEditor {
    private final Path path;
    private String text;
    private final String name;

    public TextEditor(String name) {

        this.path = Path.of("src/main/java/org/knit/jnbovfavhk/sem2/lab2_4/" + name);
//        для сгу
//        this.path = Path.of("C:\\Users\\belonozhkoin\\IdeaProjects\\javatasks\\src\\main\\java\\org\\knit\\jnbovfavhk\\sem2\\lab2_4\\" + name);
        this.text = "";
        this.name = name;
    }


    public void editText(String newText) {
        this.text = newText;
        saveToFile();
    }


    public Memento returnState() {
        return new Memento(name, text);
    }


    public String getName() {
        return name;
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
        saveToFile();
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))) {

            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getText() {
        return text;
    }
}
