package org.knit.lab2_1.task2_1_1;

public class Task2_1_1 {
    public static void Run() {
        Problem problem1 = new Problem(100, "Украли деньги с безопасного счета");
        Problem problem2 = new Problem(10, "Не могу найти комнату №101");
        Problem problem3 = new Problem(50, "Несоответствие фамилии в документе");

        Manager junior = new JuniorManager();
        Manager senior = new SeniorManager();
        Manager director = new Director();

        junior.setNextManager(senior);
        senior.setNextManager(director);

        junior.processRequest(problem1);
        junior.processRequest(problem2);
        junior.processRequest(problem3);
    }
}
