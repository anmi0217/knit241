package org.knit.lab2_1.task2_1_1;

public class JuniorManager extends Manager {
    @Override
    protected boolean canApprove(Problem problem) {
        return problem.getDifficult() <= 10;
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Младший менеджер одобрил запрос на сложность: " + problem.getDifficult() + "\n описание запроса: " + problem.getDescription());
    }
}