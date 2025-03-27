package org.knit.solutions.lab2_5.Task2_14Classes;

public interface FileSystemElement {

    void accept(Visitor visitor);
    int getByteSize();
}
