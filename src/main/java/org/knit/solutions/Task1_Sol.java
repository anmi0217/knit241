package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task1.*;

/*
Задача 2.1 Chain of Responsibility (Цепочка обязанностей)
Описание:
Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его.
Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.

Задача:
Реализуйте систему обработки жалоб клиентов в банке.
Жалоба сначала поступает в колл-центр.
Если проблема сложная, запрос передается менеджеру.
Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
Каждый уровень обработки либо решает проблему, либо передает ее дальше.
 */

@TaskDescription(taskNumber = 1, taskDescription = "Chain of Responsibility (Цепочка обязанностей)", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task1_Sol implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 1 запущена");

        Approver call_center = new Сall_center();
        Approver manager = new Manager();
        Approver legal_department = new Legal_department();
        Approver director = new Director();

        call_center.setNextApprover(manager);
        manager.setNextApprover(legal_department);
        legal_department.setNextApprover(director);


        Problem problem1 = new Problem("Хочу кредит", 46);
        Problem problem2 = new Problem("Хочу кредит больше", 129);
        Problem problem3 = new Problem("Хочу кредит ещё больше", 358);
        Problem problem4 = new Problem("Хочу кредит ещё ещё больше", 707);
        Problem problem5 = new Problem("Хочу кредит ещё ещё ещё больше", 10000);

        call_center.processRequest(problem1);
        call_center.processRequest(problem2);
        call_center.processRequest(problem3);
        call_center.processRequest(problem4);
        call_center.processRequest(problem5);
    }
}
