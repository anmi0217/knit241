package org.knit.solutions.org2.lab15;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(
        taskNumber = 15,
        taskDescription = "Реализация паттерна Прокси (Proxy) для ленивой загрузки изображений"
)
public class Task15 implements Solution {

    @Override
    public void execute() {
        // Создаем прокси для изображений
        Image image1 = new ImageProxy("nature.jpg");
        Image image2 = new ImageProxy("city.jpg");
        Image image3 = new ImageProxy("nature.jpg"); // Повторный запрос того же изображения

        // Первое отображение - будет загрузка
        System.out.println("\nПервое отображение nature.jpg:");
        image1.display();

        // Первое отображение другого изображения - будет загрузка
        System.out.println("\nПервое отображение city.jpg:");
        image2.display();

        // Повторное отображение - возьмется из кэша
        System.out.println("\nПовторное отображение nature.jpg:");
        image3.display();
    }
}