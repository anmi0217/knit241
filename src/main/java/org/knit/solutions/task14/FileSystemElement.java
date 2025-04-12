package org.knit.solutions.task14;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}