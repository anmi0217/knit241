package org.knit.tasks.task5;

public class File implements Component {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void print(int indent) {
        System.out.println(" ".repeat(indent) + name + " (" + size + " bytes)");
    }
}
