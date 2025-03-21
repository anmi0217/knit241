package org.knit.Solutions.Task1;

/*
Задача 2.1 Chain of Responsibility (Цепочка обязанностей)
Описание:
Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его. Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.

Пример из жизни:
Рассмотрим систему поддержки пользователей. Запрос от клиента сначала поступает к оператору первого уровня (обычный оператор), затем, если он не может решить проблему, передается специалисту второго уровня (инженеру), а если и он не справляется – ведущему инженеру.

Задача:
Реализуйте систему обработки жалоб клиентов в банке.

Жалоба сначала поступает в колл-центр.
Если проблема сложная, запрос передается менеджеру.
Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
Каждый уровень обработки либо решает проблему, либо передает ее дальше. (не менее 4х уровней поддержки)
Представить проблему в виде объекта, с описанием, уровнем сложности.
 */

import org.knit.Solutions.TasksDescripton;

@TasksDescripton(number = 1, name = "Задача 2.1 Chain of Responsibility (Цепочка обязанностей)\n")

public class Main {
    public static void main(String[] args) {
        ComplaintHandler callCenter = new CallCenterHandler();
        ComplaintHandler manager = new ManagerHandler();
        ComplaintHandler legalDepartment = new LegalDepartmentHandler();
        ComplaintHandler executive = new ExecutiveHandler();

        callCenter.setNextHandler(manager);
        manager.setNextHandler(legalDepartment);
        legalDepartment.setNextHandler(executive);

        Complaint simpleComplaint = new Complaint("Не работает карта", 1);
        Complaint mediumComplaint = new Complaint("Ошибка в переводе", 2);
        Complaint complexComplaint = new Complaint("Юридический спор", 3);
        Complaint criticalComplaintSystem = new Complaint("Критическая ошибка в системе", 4);
        Complaint criticalComplaint = new Complaint("Критическая ошибка", 5);

        callCenter.handleComplaint(simpleComplaint);
        callCenter.handleComplaint(mediumComplaint);
        callCenter.handleComplaint(complexComplaint);
        callCenter.handleComplaint(criticalComplaintSystem);
        callCenter.handleComplaint(criticalComplaint);
    }
}