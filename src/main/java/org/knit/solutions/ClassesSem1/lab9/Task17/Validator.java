package org.knit.solutions.ClassesSem1.lab9.Task17;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Доступ к private полям
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Ошибка: Поле " + field.getName() + " не должно быть null.");
            }

            // Проверка @MaxLength
            if (field.isAnnotationPresent(MaxLength.class) && value instanceof String) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (((String) value).length() > maxLength) {
                    System.out.println("Ошибка: Поле " + field.getName() + " превышает максимальную длину " + maxLength + ".");
                }
            }

            // Проверка @Min
            if (field.isAnnotationPresent(Min.class) && value instanceof Integer) {
                int minValue = field.getAnnotation(Min.class).value();
                if ((Integer) value < minValue) {
                    System.out.println("Ошибка: Поле " + field.getName() + " меньше минимального значения " + minValue + ".");
                }
            }
        }
    }
}
