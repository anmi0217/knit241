package org.knit.samples.lection25;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }
}
