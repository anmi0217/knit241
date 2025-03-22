package org.knit.utils;

import org.knit.solutions.Solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TaskExecutor {
    public static void executeTask(Class<? extends Solution> aClass) {
        try {
            Constructor<? extends Solution> constructor = aClass.getConstructor();
            Solution solution = constructor.newInstance();
            solution.execute();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}