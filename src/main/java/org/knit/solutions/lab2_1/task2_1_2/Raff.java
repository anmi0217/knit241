package org.knit.solutions.lab2_1.task2_1_2;

public class Raff implements Coffee {

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Раф — это кофейный напиток, в котором сочетаются порция эспрессо, сливки и ванильный сахар.\n" +
                "От классических латте и капучино он отличается консистенцией (более густой) и вкусом (сладким, чем-то напоминающим подтаявший пломбир).";
    }
}
