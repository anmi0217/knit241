package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task15.Image;
import org.knit.solutions.task15.ImageProxy;

/*
Задача:
Создайте удаленную библиотеку изображений.

При запросе изображения оно загружается с сервера (имитация через задержку в коде).
Картинка хранится как объект класса RealImage.
Прокси-объект ImageProxy должен лениво загружать изображение и кэшировать его для повторного использования.
📌 Подсказка:
ImageProxy должен проверять, создан ли объект RealImage. Если нет — создавать его.
 */

@TaskDescription(taskNumber = 15, taskDescription = "15. Задача 15 на паттерн Прокси (Proxy)")
public class Task15 implements Solution{
    @Override
    public void execute() {
        Image image1 = new ImageProxy("image1.png");
        Image image2 = new ImageProxy("image2.jpg");

        image1.display();
        System.out.println();
        image2.display();

        System.out.println();
        image1.display();
        image2.display();
    }
}
