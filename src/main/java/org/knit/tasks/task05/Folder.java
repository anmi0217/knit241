package org.knit.tasks.task05;

import java.util.ArrayList;

public class Folder implements Component {
    private final String name;
    private final ArrayList<Component> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Component component : components) {
            size += component.getSize();
        }
        return size;
    }

    @Override
    public void print(int indent) {
        System.out.println(" ".repeat(indent) + name);
        for (Component component : components) {
            component.print(indent + 4);
        }
    }
}
