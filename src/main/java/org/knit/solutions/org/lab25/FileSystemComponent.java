package org.knit.solutions.org.lab25;

public abstract interface FileSystemComponent {
    String getName(); // Возвращает имя элемента
    long getSize(); // Возвращает размер элемента в байтах
    void add(FileSystemComponent component); // Добавляет элемент в папку (опционально)
    void remove(FileSystemComponent component); // Удаляет элемент из папки (опционально)
    void display(String indent); // Выводит структуру файловой системы в удобном формате

}
