package org.knit.lab2_1.task2_1_2;

public class Task2_1_2 {
    public static void Run() {
        Coffee coffee1 = new Americano();
        Coffee coffee2 = new Raff();
        Coffee coffee3 = new Cappuccino();

        printCoffee(coffee1);
        printCoffee(coffee2);
        printCoffee(coffee3);

        coffee1 = new Milk(coffee1);
        printCoffee(coffee1);

        coffee2 = new Chocolate(coffee2);
        printCoffee(coffee2);

        coffee3 = new Caramel(coffee3);
        printCoffee(coffee3);
    }

    public static void printCoffee(Coffee coffee) {
        System.out.println(coffee.getDescription() + " \nЦена: " + coffee.getCost() + "₽");
    }
}
