package org.knit.solutions.ClassesSem1.lab2.Task5;

public abstract class FileSystemComponent {
    public abstract String getName();

    public abstract double getSize();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Нельзя добавить компонент к файлу!");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Нельзя удалить компонент из файла!");
    }

    public void display(String indent) {
        System.out.println(indent + getName());
    }
}
