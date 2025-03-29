package org.knit.solutions.labor2.lab1.chainOfResponsibility;

public class CallCenter extends Approver {
    @Override
    protected boolean canSolve(Problem amount) {
        return amount.getDifficulty() <= 20;
    }

    @Override
    protected void solve(Problem amount) {
        System.out.println("Колл центр решил проблему");
    }
}
