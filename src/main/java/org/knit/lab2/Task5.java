package org.knit.lab2;

/*

Необходимо смоделировать простую файловую систему, в которой могут быть как отдельные файлы, так и папки, содержащие другие файлы и папки. Паттерн "Компоновщик" позволит работать с объектами файлов и папок единообразно.

Условие:
Создайте абстрактный класс или интерфейс FileSystemComponent, который будет представлять общий элемент файловой системы (файл или папку). В нем должны быть следующие методы:

getName(): возвращает имя элемента.
getSize(): возвращает размер элемента в байтах.
add(FileSystemComponent component): добавляет элемент в папку (опционально).
remove(FileSystemComponent component): удаляет элемент из папки (опционально).
display(String indent): выводит структуру файловой системы в удобном формате.
Создайте класс File, который наследует или реализует FileSystemComponent. Файл будет иметь имя и размер. Реализуйте методы getName() и getSize(), метод add() для файлов не должен быть реализован (файл не может содержать другие элементы).

Создайте класс Folder, который также наследует или реализует FileSystemComponent. Папка может содержать другие папки и файлы, и её размер равен сумме размеров всех файлов и папок внутри неё. Реализуйте методы getName(), getSize(), add(), remove() и display().

Реализуйте метод display(String indent) таким образом, чтобы он отображал структуру файлов и папок с соответствующими отступами для вложенных элементов.

*/

public class Task5 {
    public void execute() {

        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 300);

        FileSystemComponent folder1 = new Folder("Folder1");
        FileSystemComponent folder2 = new Folder("Folder2");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1);

        folder2.remove(file2);
        folder2.add(folder1);

        folder1.remove(file2);

        folder2.display("");

        System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");
    }
}
