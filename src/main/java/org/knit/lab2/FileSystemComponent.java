package org.knit.lab2;

public abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("⛔Не удалось добавить компонент!");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("⛔Не удалось удалить компонент!");
    }

    public abstract void display(String indent);
}
