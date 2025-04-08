package org.knit.solutions.Task1;

public class Director extends Approver {
    @Override
    protected boolean canApprove(Problem amount) {
        return amount.getIndex() <= 1000; // Директор одобряет до 50,000
    }

    @Override
    protected void approve(Problem amount) {
        System.out.println("Директор может решить ваш вопрос: '" + amount.getText() + "', ожидайте.");
    }
}
