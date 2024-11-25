package org.knit.tasks.task17;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object o) throws IllegalAccessException {
        Class<?> c = o.getClass();
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object v = field.get(o);

            if (field.isAnnotationPresent(NotNull.class) && v == null) {
                System.out.printf("Поле %s не может быть null.\n", field.getName());
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                assert v != null;
                int length = ((String) v).length();
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (length > maxLength) {
                    System.out.printf("Длина строки в поле %s не может быть больше %d.\n", field.getName(), maxLength);
                }
            }

            if (field.isAnnotationPresent(MinValue.class)) {
                assert v != null;
                int value = (int) v;
                int minValue = field.getAnnotation(MinValue.class).value();
                if (value < minValue) {
                    System.out.printf("Значение поля %s не может быть меньше %d.\n", field.getName(), minValue);
                }
            }
        }
    }
}
