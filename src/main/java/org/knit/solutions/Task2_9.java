package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_9Classes.Collector;
import org.knit.solutions.lab2_2.Task2_9Classes.Factory;
import org.knit.solutions.lab2_2.Task2_9Classes.QualityControl;
import org.knit.solutions.lab2_2.Task2_9Classes.Stamper;

@TaskDescription(taskNumber = 9, taskDescription = "На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:\n" +
        "Штамповщик – вырезает заготовку (создает объект детали). " +
        "Сборщик – собирает из заготовки готовую деталь. " +
        "Оператор контроля качества – проверяет деталь и отправляет на склад. ", href = "org/knit/solutions/lab2_2/Task2_9Classes")

public class Task2_9 implements Solution{
    public void execute() {
        Factory factory = new Factory();
        QualityControl qualityControl = new QualityControl(factory);
        Collector collector = new Collector(factory);
        Stamper stamper = new Stamper(factory);

        Thread thread1 = new Thread(stamper);
        Thread thread2 = new Thread(collector);
        Thread thread3 = new Thread(qualityControl);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
