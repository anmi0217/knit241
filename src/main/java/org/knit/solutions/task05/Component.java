package org.knit.solutions.task05;

public interface Component {
    default void add(Component component) {
        System.out.println("По умолчанию добавление элементов недоступно.");
    }

    default void remove(Component component) {
        System.out.println("По умолчанию удаление элементов недоступно.");
    }

    String getName();

    int getSize();

    void print(int indent);
}
