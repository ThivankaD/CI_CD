package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskServiceTest {
     @Test
    void shouldAddValidTask() {
        TaskService service = new TaskService();
        Task task = new Task("Write report");

        Task result = service.addTask(task);

        //assertNotNull(result);
        System.out.println("Test is running");
        assertEquals("Write report", result.getName());
    }

    @Test
    void shouldRejectEmptyTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task);
        });

        assertEquals("Task name cannot be empty", exception.getMessage());
}
}
