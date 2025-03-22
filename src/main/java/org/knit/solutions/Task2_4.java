package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_4Classes.Car;
import org.knit.solutions.lab2_2.Task2_4Classes.GasStation;

@TaskDescription(taskNumber = 4, taskDescription = "Многопоточность. " +
        "На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди. " +
        "Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.", href = "org/knit/solutions/lab2_2/Task2_4Classes")
public class Task2_4 implements Solution {
    public void execute() {
        GasStation gasStation = new GasStation();

        for (int i = 0; i < 6; i++) {
            Car car = new Car(gasStation);
            car.start();
        }
    }
}


