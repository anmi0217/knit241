package org.knit.tasks.task8;

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        Random random = new Random();
        String[] names = {"сыр", "колбаса", "молоко", "оливки", "масло"};
        int[] prices = {100, 150, 200, 250, 300, 350, 400, 450, 500};
        int[] masses = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            products.add(new Product(
                    names[random.nextInt(names.length)],
                    prices[random.nextInt(prices.length)],
                    masses[random.nextInt(masses.length)]
            ));
        }
        products.sort(Comparator.comparing(Product::getName)
                .thenComparing(Product::getPrice)
                .thenComparing(Product::getMass));
        Map<Product, Integer> productFrequency = new HashMap<>();
        for (Product product : products) {
            if (productFrequency.containsKey(product)) {
                productFrequency.put(product, productFrequency.get(product) + 1);
            } else {
                productFrequency.put(product, 1);
            }
            System.out.println(product);
        }
        int k = 0;
        for (int i : productFrequency.values()) {
            if (i > 1) {
                k += i;
            }
        }
        System.out.println("Количество одинаковых продуктов: " + k);
    }
}
