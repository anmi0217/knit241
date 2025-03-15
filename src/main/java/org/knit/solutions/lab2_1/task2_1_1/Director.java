package org.knit.solutions.lab2_1.task2_1_1;

public class Director extends Manager {
    @Override
    protected boolean canApprove(Problem problem) {
        return 51 <= problem.getDifficult() && problem.getDifficult() <= 100;
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Директор одобрил запрос на сложность: " + problem.getDifficult() + "\n описание запроса: " + problem.getDescription());
    }
}