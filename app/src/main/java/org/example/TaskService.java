package org.example;

public class TaskService {
     public Task addTask(Task task) {
         if (task.getName() == null || task.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        return task;
}
}