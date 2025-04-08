package org.knit.solutions.Task1;

public class Сall_center extends Approver {
    @Override
    protected boolean canApprove(Problem amount) {
        return amount.getIndex() <= 100;
    }

    @Override
    protected void approve(Problem amount) {
        System.out.println("Колл-центр может решить ваш вопрос: '" + amount.getText() + "', ожидайте.");
    }
}
