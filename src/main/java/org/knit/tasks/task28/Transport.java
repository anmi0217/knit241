package org.knit.tasks.task28;

public interface Transport {
    String getName();

    String getComfort();

    String getSpeed();

    String getCapacity();

    default String getFeatures() {
        return String.format(
                "%s. Характеристики: уровень комфорта - %s, скорость - %s, вместимость - %s.",
                getName(), getComfort(), getSpeed(), getCapacity()
        );
    }
}
