import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class CreateTask {

	@Test
	void test() {
		String title = "Limpar a casa";
		String description = "Limpeza semanal da sala e cozinha";
		Date expirationDate = new Date(124, 2, 10);
		Integer priority = 3;
		
		Task task = new Task(title, description, expirationDate, priority);
		
		assertNotNull(task);
		assertEquals("Limpar a casa", task.getTitle());
		assertEquals("Limpeza semanal da sala e cozinha", task.getDescription());
		assertEquals(expirationDate, task.getExpirationDate());
		assertEquals(Integer.valueOf(3), task.getPriority());
	}

}
