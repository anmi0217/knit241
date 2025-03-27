package org.knit.solutions.task39;

public class File implements FileSystemElement {
    private final String name;
    private final int size;
    private final boolean isHasVirus;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
        this.isHasVirus = Math.random() < 0.5;
        System.out.printf("Создан файл %s размером %d.\n", name, size);
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
    public boolean isHasVirus() {
        return isHasVirus;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
