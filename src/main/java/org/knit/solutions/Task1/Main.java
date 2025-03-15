package org.labs.Tasks2.Task1;

import org.labs.TasksDescripton;

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

@TasksDescripton(number = 1, name = "Chain of Responsibility (Цепочка обязанностей)")
public class Main {
    public static void main(String[] args) {
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
