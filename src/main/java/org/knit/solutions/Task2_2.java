package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_1.Task2_2Classes.*;

@TaskDescription(taskNumber = 2, taskDescription = "Decorator. " +
        "Реализуйте систему онлайн-заказов кофе с помощью декоратора.", href = "org/knit/solutions/lab2_1/Task2_2Classes")
public class Task2_2 implements Solution{
    public void execute() {
        Coffee coffee1 = new Latte();
        Coffee coffee2 = new Cappuccino();

        System.out.printf("Напиток(%s) стоит $%s\n", coffee1.getDescription(), coffee1.getCost());
        System.out.printf("Напиток(%s) стоит $%s\n", coffee2.getDescription(), coffee2.getCost());

        coffee1 = new AlmondMilk(coffee1);
        coffee2 = new CoconutMilk(coffee2);
        coffee2 = new Sugar(coffee2);

        System.out.printf("Напиток(%s) стоит $%s\n", coffee1.getDescription(), coffee1.getCost());
        System.out.printf("Напиток(%s) стоит $%s\n", coffee2.getDescription(), coffee2.getCost());
    }
}
