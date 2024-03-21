package functionalTests;

import static org.junit.jupiter.api.Assertions.*;
import TaskManager.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PPETests {
    TaskManager manager = new TaskManager();

    @SuppressWarnings("deprecation")
	@Test
    void testHighAndMediumPriorityTasksWithSameDueDate() {
    	Task tarefa1 = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
    	Task tarefa2 = new Task("Tarefa 2", "Descrição da Tarefa 2", new Date(2024, 3, 25), Priority.MEDIUM);
    	manager.addTask(tarefa1);
        manager.addTask(tarefa2);
        
    	assertEquals(tarefa1, manager.getTasks().get(0));
    	assertEquals(tarefa2, manager.getTasks().get(1));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    void testSamePriorityTasksWithDifferentDueDates() {
        Task tarefa3 = new Task("Tarefa 3", "Descrição da Tarefa 3", new Date(2024, 3, 28), Priority.LOW);
        Task tarefa4 = new Task("Tarefa 4", "Descrição da Tarefa 4", new Date(2024, 3, 30), Priority.LOW);
        manager.addTask(tarefa3);
        manager.addTask(tarefa4);
        
        assertEquals(tarefa3, manager.getTasks().get(0));
        assertEquals(tarefa4, manager.getTasks().get(1));
    }

    @SuppressWarnings("deprecation")
    @Test
    void testLowPriorityTaskCloserDueToHighPriorityTask() {
        Task tarefa5 = new Task("Tarefa 5", "Descrição da Tarefa 5", new Date(2024, 3, 26), Priority.LOW);
        Task tarefa6 = new Task("Tarefa 6", "Descrição da Tarefa 6", new Date(2024, 3, 30), Priority.HIGH);
        manager.addTask(tarefa5);
        manager.addTask(tarefa6);
        
        assertEquals(tarefa5, manager.getTasks().get(0));
        assertEquals(tarefa6, manager.getTasks().get(1));
    }

    @SuppressWarnings("deprecation")
    @Test
    void testLowAndHighPriorityTasksWithSameDueDate() {
        Task tarefa7 = new Task("Tarefa 7", "Descrição da Tarefa 7", new Date(2024, 3, 28), Priority.LOW);
        Task tarefa8 = new Task("Tarefa 8", "Descrição da Tarefa 8", new Date(2024, 3, 28), Priority.HIGH);
        manager.addTask(tarefa7);
        manager.addTask(tarefa8);
        
        assertEquals(tarefa8, manager.getTasks().get(0));
        assertEquals(tarefa7, manager.getTasks().get(1));
    }

    @SuppressWarnings("deprecation")
    @Test
    void testLowAndMediumPriorityTasksWithSameDueDate() {
        Task tarefa9 = new Task("Tarefa 9", "Descrição da Tarefa 9", new Date(2024, 3, 29), Priority.LOW);
        Task tarefa10 = new Task("Tarefa 10", "Descrição da Tarefa 10", new Date(2024, 3, 29), Priority.MEDIUM);
        manager.addTask(tarefa9);
        manager.addTask(tarefa10);
        
        assertEquals(tarefa10, manager.getTasks().get(0));
        assertEquals(tarefa9, manager.getTasks().get(1));
    }
}