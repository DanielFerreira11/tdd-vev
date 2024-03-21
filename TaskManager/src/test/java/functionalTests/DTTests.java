package functionalTests;

import static org.junit.jupiter.api.Assertions.*;
import TaskManager.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class DTTests {
    TaskManager manager = new TaskManager();

    @SuppressWarnings("deprecation")
    @Test
    void testCreateTask() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
    	assertFalse(manager.getTasks().contains(tarefa));
    	
    	manager.addTask(tarefa);
    	
    	assertEquals(1, manager.getTasks().size());
    	assertEquals(tarefa, manager.getTasks().get(0));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    void testTaskWithInvalidPriority() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), "");
    	assertFalse(manager.getTasks().contains(tarefa));
    	
    	manager.addTask(tarefa);
    	
    	assertEquals(0, manager.getTasks().size());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    void testTaskWithInvalidDueDate() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", "", Priority.HIGH);
    	assertFalse(manager.getTasks().contains(tarefa));
    	
    	manager.addTask(tarefa);
    	
    	assertEquals(0, manager.getTasks().size());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    void testTaskWithInvalidIndex() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
    	assertFalse(manager.getTasks().contains(tarefa));
    	
    	manager.addTask(tarefa);
    	
    	manager.removeTask(2);
    	assertEquals(tarefa, manager.getTasks().get(0));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    void testRemoveTask() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
    	assertFalse(manager.getTasks().contains(tarefa));
    	
    	manager.addTask(tarefa);
    	
    	manager.removeTask(0);
    	assertEquals(0, manager.getTasks().size());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    void testUpdateTask() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
    	assertFalse(manager.getTasks().contains(tarefa));
    	
    	manager.addTask(tarefa);
    	tarefa.setDescription("Lavar o carro");
    	manager.updateTask(0, tarefa);
    	
    	assertEquals(tarefa, manager.getTasks().get(0));
    }
}