package org.knit.solutions.task39;

public interface FileSystemElement {
    String getName();

    int getSize();

    boolean isHasVirus();

    void accept(Visitor visitor);
}
