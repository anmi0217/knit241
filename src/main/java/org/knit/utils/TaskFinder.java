package org.knit.utils;

import lombok.extern.slf4j.Slf4j;
import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.lang.Class.forName;


@Slf4j
public class TaskFinder {

    @Deprecated
    @SuppressWarnings("unchecked")
    public static TreeMap<Integer, TaskHolder> findTasks(String path) throws IOException, URISyntaxException {
        log.info("метод запущен");
        String nPath = path.replace(".", "/");
        TreeMap<Integer, TaskHolder> classes = new TreeMap<>();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources =
                contextClassLoader.getResources(nPath);
        while (resources.hasMoreElements()) {
            File file = new File(resources.nextElement().toURI());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files == null) {
                    return classes;
                }
                for (File aClassFile : files) {
                    if (aClassFile.isFile() && aClassFile.getName().endsWith(".class")) {
                        String clazzPath = path + "." + aClassFile.getName().substring(0, aClassFile.getName().lastIndexOf("."));
                        try {
                            Class<?> aClass = forName(clazzPath);
                            if (aClass.isAnnotationPresent(TaskDescription.class)) {
                                TaskDescription annotation = aClass.getAnnotation(TaskDescription.class);
                                Class<?>[] interfaces = aClass.getInterfaces();
                                if (interfaces.length == 0) {
                                    System.err.println("Warn: class not loaded " + clazzPath + " RootCause is: not implement any interface");
                                }
                                for (Class<?> anInterface : interfaces) {
                                    if (anInterface.equals(Solution.class)) {
                                        if (classes.containsKey(annotation.taskNumber())) {
                                            System.err.println("Warn: class not loaded " + clazzPath + " RootCause is: task with same id [" + annotation.taskNumber() + "] already added");
                                            continue;
                                        }
                                        classes.put(annotation.taskNumber(), new TaskHolder((Class<? extends Solution>) aClass, annotation.taskNumber(), annotation.taskDescription()));
                                    } else {
                                        System.err.println("Warn: class not loaded " + clazzPath + " RootCause is: not implement Solution");
                                    }
                                }
                            }
                        } catch (ClassNotFoundException e) {
                            System.err.println("Warn: class not loaded " + clazzPath);
                        }
                    }
                }
            }
        }
        return classes;
    }

    public static TreeMap<Integer, TaskHolder> findTasksByReflectionApi(String path) {
        TreeMap<Integer, TaskHolder> taskHolderTreeMap = new TreeMap<>();
        Reflections reflections = new Reflections(path);

        Set<Class<?>> annotations = reflections.get(Scanners.TypesAnnotated.with(TaskDescription.class).asClass());
        Set<Class<? extends Solution>> interfaces = reflections.getSubTypesOf(Solution.class);


        Set<Class<? extends Solution>> collect = interfaces.stream()
                .filter(annotations::contains).collect(Collectors.toSet());


        for (Class<? extends Solution> aClass : collect) {
            TaskDescription annotation = aClass.getAnnotation(TaskDescription.class);
            TaskHolder taskHolder = TaskHolder.builder()
                    .taskClass(aClass)
                    .id(annotation.taskNumber())
                    .descriptor(annotation.taskDescription())
                    .build();

            taskHolderTreeMap.put(annotation.taskNumber(), taskHolder);
        }
        return taskHolderTreeMap;
    }
}
