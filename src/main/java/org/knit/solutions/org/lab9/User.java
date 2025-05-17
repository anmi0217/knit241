package org.knit.solutions.org.lab9;

public class User {
    @NotNull
    private String name;

    @MaxLength(10)
    private String username;

    @Min(18)
    private int age;

    // Конструкторы, геттеры и сеттеры
    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
