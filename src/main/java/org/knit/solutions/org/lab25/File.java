package org.knit.solutions.org.lab25;

public class File implements FileSystemComponent {
    private String name; // Имя файла
    private long size; // Размер файла в байтах

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name; // Возвращает имя файла
    }

    @Override
    public long getSize() {
        return size; // Возвращает размер файла
    }

    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("File cannot contain other components."); // Файл не может содержать другие элементы
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("File cannot contain other components."); // Файл не может содержать другие элементы
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + getName() + " (" + getSize() + " bytes)"); // Выводит имя файла и его размер
    }
}