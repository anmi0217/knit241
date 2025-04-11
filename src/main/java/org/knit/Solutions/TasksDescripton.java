package org.knit.Solutions;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface TasksDescripton {
    int number();
    String name();
}