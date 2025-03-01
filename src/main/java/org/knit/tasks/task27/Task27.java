package org.knit.tasks.task27;

public class Task27 {
    public static void main(String[] args) {
        Coffee latte = new Latte();
        System.out.println(coffeeToString(latte));

        latte = new SugarAdditive(latte);
        System.out.println(coffeeToString(latte));

        latte = new CinnamonAdditive(latte);
        System.out.println(coffeeToString(latte));

        Coffee cappuccino = new Cappuccino();
        System.out.println(coffeeToString(cappuccino));

        cappuccino = new MilkAdditive(cappuccino);
        System.out.println(coffeeToString(cappuccino));

        cappuccino = new SugarAdditive(cappuccino);
        System.out.println(coffeeToString(cappuccino));
    }

    private static String coffeeToString(Coffee coffee) {
        return String.format(
                "%s. Цена: %d руб. Объём: %d мл",
                coffee.getDescription(), coffee.getCost(), coffee.getVolume()
        );
    }
}
