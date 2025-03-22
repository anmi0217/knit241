package org.knit.solutions.lab2_1.Task2_3Classes;

public class Motorbike implements Transport {
    @Override
    public String getSpecifications() {
        return "Спортивный мотоцикл Honda CBR1000RR-R Fireblade\n" +
                "Двигатель: 999 см³, 4-цилиндровый, рядный,\n" +
                "Мощность: около 214 л.с. (160 кВт) при 14,500 об/мин,\n" +
                "Крутящий момент: 113 Нм при 12,500 об/мин,\n" +
                "Система впуска: Throttle By Wire,\n" +
                "Трансмиссия: 6-ступенчатая,";
    }
}
