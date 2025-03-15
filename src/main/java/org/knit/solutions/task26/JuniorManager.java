package org.knit.solutions.task26;

public class JuniorManager extends Handler {
    @Override
    protected boolean isCanHandleProblem(Problem problem) {
        return problem.getDifficulty() <= 10;
    }

    @Override
    protected void handle(Problem problem) {
        System.out.println("Младший менеджер решил проблему. " + problem);
    }
}
