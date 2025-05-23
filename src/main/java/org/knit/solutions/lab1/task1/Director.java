package org.knit.solutions.lab1.task1;

public class Director extends Approver {
    @Override
    protected boolean isEligible(int amount) {
        return amount <= 50000;
    }

    @Override
    protected void approveRequest(int amount, String description) {
        System.out.println("Директор одобрил заявку: \"" + description + "\" на сумму $" + amount);
    }
}
