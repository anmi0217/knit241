package org.knit.solutions.Task1;

public class Legal_department extends Approver {
    @Override
    protected boolean canApprove(Problem amount) {
        return amount.getIndex() <= 500;
    }

    @Override
    protected void approve(Problem amount) {
        System.out.println("Юридический отдел может решить ваш вопрос: '" + amount.getText() + "', ожидайте.");
    }
}
