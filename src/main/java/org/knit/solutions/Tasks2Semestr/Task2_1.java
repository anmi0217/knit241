package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.lab1.task1.*;

/**
 * Задача 2.1: Chain of Responsibility (Цепочка обязанностей)
 *
 * Описание:
 * Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его.
 * Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.
 *
 * Пример из жизни:
 * Рассмотрим систему поддержки пользователей. Запрос от клиента сначала поступает к оператору первого уровня (обычный оператор),
 * затем, если он не может решить проблему, передается специалисту второго уровня (инженеру), а если и он не справляется – ведущему инженеру.
 *
 * Задача:
 * Реализуйте систему обработки жалоб клиентов в банке.
 * Жалоба сначала поступает в колл-центр.
 * Если проблема сложная, запрос передается менеджеру.
 * Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
 * Каждый уровень обработки либо решает проблему, либо передает её дальше (не менее 4-х уровней поддержки).
 *
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
        junior.setNext(senior);
        senior.setNext(director);

        // Создаем жалобы с разной сложностью
        Problem p1 = new Problem("Кредит", 100);
        Problem p2 = new Problem("Кредит", 9000);
        Problem p3 = new Problem("Кредит", 49000);
        Problem p4 = new Problem("Кредит", 99000);

        // Запускаем обработку жалоб
        junior.handle(p1);  // Младший менеджер одобряет
        junior.handle(p2);  // Старший менеджер одобряет
        junior.handle(p3);  // Директор одобряет
        junior.handle(p4);  // Превышает лимит – запрос отклонён
    }
}
