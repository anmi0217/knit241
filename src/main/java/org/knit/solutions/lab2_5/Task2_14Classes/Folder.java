package org.knit.solutions.lab2_5.Task2_14Classes;

import java.util.ArrayList;


public class Folder implements FileSystemElement{
    private ArrayList<FileSystemElement> content;
    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getByteSize() {
        int size = 0;
        for (FileSystemElement el : content) {
            size += el.getByteSize();
        }
        return size;
    }

    public ArrayList<FileSystemElement> getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public Folder(String name) {
        this.name = name;
        this.content = new ArrayList<FileSystemElement>();
    }

    public void add(FileSystemElement el) {
        content.add(el);
    }
}
