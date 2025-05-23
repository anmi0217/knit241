package org.knit.solutions.lab1.task1;

// Базовый абстрактный класс для обработчиков заявок
public abstract class Approver {
    protected Approver next; // Ссылка на следующего в цепочке

    public void setNext(Approver approver) {
        this.next = approver;
    }

    public void handle(Problem request) {
        int level = request.getAmount();
        String note = request.getDescription();

        if (isEligible(level)) {
            approveRequest(level, note);
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Заявка \"" + note + "\" на сумму $" + level +
                    " отклонена: превышает допустимый предел.");
        }
    }

    protected abstract boolean isEligible(int amount); // Критерий обработки

    protected abstract void approveRequest(int amount, String description); // Детали одобрения
}
