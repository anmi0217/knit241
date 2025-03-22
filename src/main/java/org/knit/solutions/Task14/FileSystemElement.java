package org.knit.solutions.Task14;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
