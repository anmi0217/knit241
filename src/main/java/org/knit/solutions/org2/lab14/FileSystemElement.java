package org.knit.solutions.org2.lab14;

interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
