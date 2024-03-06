import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
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
		Integer priority = 3;
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
		assertEquals(Integer.valueOf(3), task.getPriority());
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
		task.setPriority(2);
		assertEquals(2, task.getPriority());
	}
}