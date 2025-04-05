package org.knit.solutions.labor2.lab1.chainOfResponsibility;

public class LegalDepartment extends Approver {
    @Override
    protected boolean canSolve(Problem amount) {
        return amount.getDifficulty() <= 80; // Директор одобряет до 50,000
    }

    @Override
    protected void solve(Problem amount) {
        System.out.println("Юридический отдел решил проблему");
    }
}
