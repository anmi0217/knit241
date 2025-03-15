package org.knit.solutions.task26;

public class Director extends Handler {
    @Override
    protected boolean isCanHandleProblem(Problem problem) {
        return problem.getDifficulty() <= 50;
    }

    @Override
    protected void handle(Problem problem) {
        System.out.println("Директор решил проблему. " + problem);
    }
}
