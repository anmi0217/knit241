// Specialist.java
package org.knit.solutions.org2.lab1;


public class Specialist extends Approver {
    public Specialist(String name) {
        super(name);
    }

    @Override
    protected boolean canApprove(int amount) {
        return amount <= 8;
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Специалист " + getName() + " обрабатывает запрос: " + problem.getDescription());
    }
}
