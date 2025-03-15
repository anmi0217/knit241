package org.knit.solutions.lab2;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent {
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void add(FileSystemComponent component) {
        if (components.contains(component)) {
            System.out.println("⛔Уже есть компонент с таким названием в папке!");
        } else {
            components.add(component);
        }
    }

    @Override
    public void remove(FileSystemComponent component) {
        if (components.contains(component)) {
            components.remove(component);
        } else {
            System.out.println("⛔Такого компонента нет в данной папке!");
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "\uD83D\uDCC2" + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "--");
        }
    }
}
