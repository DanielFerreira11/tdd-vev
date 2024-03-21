import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import TaskManager.Priority;
import TaskManager.*;

import java.util.*;

class TaskTest {
	TaskManager manager = new TaskManager();
	Task task;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
		String title = "Limpar a casa";
		String description = "Limpeza semanal da sala e cozinha";
		Date expirationDate = new Date(124, 2, 10);
		Priority priority = Priority.LOW;
		task = new Task(title, description, expirationDate, priority);
		manager.addTask(task);
    }

	@SuppressWarnings("deprecation")
	@Test
	void testAddTask() {
		assertEquals(1, manager.getTasks().size());
		assertEquals(task, manager.getTasks().get(0));
		assertEquals("Limpar a casa", task.getTitle());
		assertEquals("Limpeza semanal da sala e cozinha", task.getDescription());
		assertEquals(new Date(124, 2, 10), task.getExpirationDate());
		assertEquals(Priority.LOW, task.getPriority());
	}
	
	@Test
	void testUpdateTitleTask() {
		task.setTitle("Limpar a cozinha");
		assertEquals("Limpar a cozinha", task.getTitle());
	}
	
	@Test
	void testUpdateDescriptionTask() {
		task.setDescription("Limpar a cozinha");
		assertEquals("Limpar a cozinha", task.getDescription());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testUpdateExpirationDateTask() {
		Date newDate = new Date(125, 2, 10);
		task.setExpirationDate(newDate);
		assertEquals(newDate, task.getExpirationDate());
	}
	
	@Test
	void testUpdatePriorityTask() {
		task.setPriority(Priority.HIGH);
		assertEquals(Priority.HIGH, task.getPriority());
	}
	
	@Test
	void testRemoveTask() {
		manager.removeTask(0);
		assertEquals(0, manager.getTasks().size());
	}
}