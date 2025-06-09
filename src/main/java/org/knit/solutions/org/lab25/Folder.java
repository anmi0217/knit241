package org.knit.solutions.org.lab25;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private String name; // Имя папки
    private List<FileSystemComponent> components; // Список файлов и папок

    public Folder(String name) {
        this.name = name;
        this.components = new ArrayList<>(); // Инициализируем список компонентов
    }

    @Override
    public String getName() {
        return name; // Возвращает имя папки
    }

    @Override
    public long getSize() {
        long totalSize = 0; // Общий размер папки
        for (FileSystemComponent component : components) {
            totalSize += component.getSize(); // Суммируем размеры всех компонентов
        }
        return totalSize; // Возвращает общий размер папки
    }

    @Override
    public void add(FileSystemComponent component) {
        components.add(component); // Добавляет компонент в папку
    }

    @Override
    public void remove(FileSystemComponent component) {
        components.remove(component); // Удаляет компонент из папки
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + getName()); // Выводит имя папки
        for (FileSystemComponent component : components) {
            component.display(indent + "  "); // Рекурсивно выводит содержимое папки с отступами
        }
    }
}