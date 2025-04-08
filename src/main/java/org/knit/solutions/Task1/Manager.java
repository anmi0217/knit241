package org.knit.solutions.Task1;

public class Manager extends Approver {
    @Override
    protected boolean canApprove(Problem amount) {
        return amount.getIndex() <= 200;
    }

    @Override
    protected void approve(Problem amount) {
        System.out.println("Менеджер может решить ваш вопрос: '" + amount.getText() + "', ожидайте.");
    }
}