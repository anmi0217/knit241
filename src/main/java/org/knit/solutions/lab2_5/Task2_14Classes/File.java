package org.knit.solutions.lab2_5.Task2_14Classes;

public class File implements FileSystemElement{
    private String name;
    private String textContent;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getByteSize() {

        return name.length() * 2 + textContent.length() * 2;
    }

    public File(String name, String textContent) {
        this.name = name;
        this.textContent = textContent;
    }

    public File(String name) {
        this.name = name;
        this.textContent = "";
    }

    public String getName() {
        return name;
    }

    public String getTextContent() {
        return textContent;
    }
}
