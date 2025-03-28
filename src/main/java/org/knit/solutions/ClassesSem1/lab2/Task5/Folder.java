package org.knit.solutions.ClassesSem1.lab2.Task5;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    public void display(String indent) {
        System.out.println(indent + getName());
        for (FileSystemComponent component : components) {
            component.display(indent + "\t");
        }
    }
}
