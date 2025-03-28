package org.knit.solutions.TaskSem2;

import org.knit.solutions.ClassesSem2.lab1.task1.*;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 2.1: Chain of Responsibility (Цепочка обязанностей)
 * <p>
 * Описание:
 * Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его.
 * Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.
 * <p>
 * Пример из жизни:
 * Рассмотрим систему поддержки пользователей. Запрос от клиента сначала поступает к оператору первого уровня (обычный оператор),
 * затем, если он не может решить проблему, передается специалисту второго уровня (инженеру), а если и он не справляется – ведущему инженеру.
 * <p>
 * Задача:
 * Реализуйте систему обработки жалоб клиентов в банке.
 * Жалоба сначала поступает в колл-центр.
 * Если проблема сложная, запрос передается менеджеру.
 * Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
 * Каждый уровень обработки либо решает проблему, либо передает её дальше (не менее 4-х уровней поддержки).
 * <p>
 * Описание объекта жалобы:
 * Жалоба будет содержать описание проблемы и уровень сложности.
 * Каждый обработчик в цепочке проверяет сложность проблемы и решает, передать ли её дальше или решить самостоятельно.
 */

@TaskDescription(taskNumber = 1,
        taskDescription = "Chain of Responsibility (Цепочка обязанностей)",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_1 implements Solution {
    public void execute() {
        // Создаем обработчиков
        Approver junior = new JuniorManager();
        Approver senior = new SeniorManager();
        Approver director = new Director();

        // Устанавливаем цепочку: junior -> senior -> director
        junior.setNextApprover(senior);
        senior.setNextApprover(director);

        Problem problem1 = new Problem("Кредит", 100);
        Problem problem2 = new Problem("Кредит", 9000);
        Problem problem3 = new Problem("Кредит", 49000);
        Problem problem4 = new Problem("Кредит", 99000);

        // Запросы на одобрение разных сумм
        junior.processRequest(problem1);   // Младший менеджер одобряет
        junior.processRequest(problem2);  // Старший менеджер одобряет
        junior.processRequest(problem3); // Директор одобряет
        junior.processRequest(problem4); // Превышает лимит – запрос отклонен
    }
}

