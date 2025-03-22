package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task15.Image;
import org.knit.solutions.Task15.ImageProxy;

/*
Задача:
Создайте удаленную библиотеку изображений.

При запросе изображения оно загружается с сервера (имитация через задержку в коде).
Картинка хранится как объект класса RealImage.
Прокси-объект ImageProxy должен лениво загружать изображение и кэшировать его для повторного использования.
📌 Подсказка:
ImageProxy должен проверять, создан ли объект RealImage. Если нет — создавать его.
 */

@TaskDescription(taskNumber = 15, taskDescription = "Паттерн Прокси (Proxy)")
public class Task15Solution implements Solution {
    @Override
    public void execute() {
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image1.jpg");

        image1.display();
        System.out.println();

        image2.display();
    }
}
