package org.knit.lab2_1.task2_1_2;

public class Americano implements Coffee {
    @Override
    public int getCost() {
        return 120;
    }

    @Override
    public String getDescription() {
        return "Американо — это напиток на основе эспрессо с добавлением горячей воды.\n" +
                "Пропорции могут варьироваться, но обычно используется соотношение 1:2 или 1:3 эспрессо к воде, в зависимости от желаемой крепости напитка.";
    }
}
