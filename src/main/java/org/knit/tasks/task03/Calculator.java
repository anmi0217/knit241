package org.knit.tasks.task03;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public String add(double a, double b) {
        BigDecimal x = BigDecimal.valueOf(a);
        BigDecimal y = BigDecimal.valueOf(b);
        return x.add(y).stripTrailingZeros().toPlainString();
    }

    public String subtract(double a, double b) {
        BigDecimal x = BigDecimal.valueOf(a);
        BigDecimal y = BigDecimal.valueOf(b);
        return x.subtract(y).stripTrailingZeros().toPlainString();
    }

    public String multiply(double a, double b) {
        BigDecimal x = BigDecimal.valueOf(a);
        BigDecimal y = BigDecimal.valueOf(b);
        return x.multiply(y).stripTrailingZeros().toPlainString();
    }

    public String divide(double a, double b) {
        BigDecimal x = BigDecimal.valueOf(a);
        BigDecimal y = BigDecimal.valueOf(b);
        return x.divide(y, 64, RoundingMode.HALF_UP).toPlainString();
    }
}
