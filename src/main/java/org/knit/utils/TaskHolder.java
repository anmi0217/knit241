package org.knit.utils;

import org.knit.solutions.Solution;

public class TaskHolder implements Comparable<TaskHolder> {
    private final Class<? extends Solution> taskClass;
    private int id;
    private String descriptor;

    public TaskHolder(Class<? extends Solution> taskClass, int id, String descriptor) {
        this.taskClass = taskClass;
        this.id = id;
        this.descriptor = descriptor;
    }

    public Class<? extends Solution> getTaskClass() {
        return taskClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public int compareTo(TaskHolder taskHolder) {
        return Integer.compare(id, taskHolder.id);
    }

    @Override
    public String toString() {
        return "TaskHolder{" +
                "taskClass=" + taskClass +
                ", id=" + id +
                ", descriptor='" + descriptor + '\'' +
                '}';
    }
}