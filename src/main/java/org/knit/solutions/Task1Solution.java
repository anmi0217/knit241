package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task1.CallCenterHandler;
import org.knit.solutions.Task1.Complaint;
import org.knit.solutions.Task1.ComplaintHandler;

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

@TaskDescription(taskNumber = 1, taskDescription = "Chain of Responsibility (Цепочка обязанностей)", href = "org.knit.solutions.Task1")
public class Task1Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 1 запущена");

        ComplaintHandler chain = new CallCenterHandler();

        Complaint complaint1 = new Complaint("Неправильное списание средств", 2);
        Complaint complaint2 = new Complaint("Проблемы с оформлением кредита", 5);
        Complaint complaint3 = new Complaint("Ошибка в работе банковской системы", 8);
        Complaint complaint4 = new Complaint("Масштабное мошенничество", 10);

        chain.handleComplaint(complaint1);
        chain.handleComplaint(complaint2);
        chain.handleComplaint(complaint3);
        chain.handleComplaint(complaint4);
    }
}

