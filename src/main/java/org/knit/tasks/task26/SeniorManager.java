package org.knit.tasks.task26;

public class SeniorManager extends Handler {
    @Override
    protected boolean isCanHandleProblem(Problem problem) {
        return problem.getDifficulty() <= 30;
    }

    @Override
    protected void handle(Problem problem) {
        System.out.println("Старший менеджер решил проблему. " + problem);
    }
}
