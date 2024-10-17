package org.knit.tasks.task8;

import java.util.Comparator;

public class ProductMassComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p1.getMass(), p2.getMass());
    }
}
