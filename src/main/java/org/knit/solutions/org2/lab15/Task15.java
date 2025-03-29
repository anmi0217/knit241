package org.knit.solutions.org2.lab15;

import org.knit.solutions.annotations.Discription;

@Discription(value = 15, name = "Прокси (Proxy)")
public class Task15 {
    public static void main(String[] args) {
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
