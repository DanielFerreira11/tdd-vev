package functionalTests;

import static org.junit.jupiter.api.Assertions.*;
import TaskManager.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class DTTests {
    TaskManager manager = new TaskManager();

    @SuppressWarnings("deprecation")
    @Test
    void testHighAndMediumPriorityTasksWithSameDueDate() {
    	Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
    	manager.addTask(tarefa);
        
    	assertFalse(manager.getTasks().contains(tarefa));
    	assertEquals(1, manager.getTasks().size());
    	assertEquals(tarefa, manager.getTasks().get(0));
    }
}