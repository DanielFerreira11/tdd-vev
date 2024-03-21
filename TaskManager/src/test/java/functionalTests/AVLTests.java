package functionalTests;

import static org.junit.jupiter.api.Assertions.*;
import TaskManager.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AVLTests {
	TaskManager manager = new TaskManager();
	Task task;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
		manager.addTask(new Task("Limpar a casa", "Limpeza semanal da sala e cozinha", new Date(2024, 3, 25), Priority.MEDIUM));
		manager.addTask(new Task("Estudar para o exame", "Revisar o material e resolver exercícios", new Date(2024, 3, 30), Priority.HIGH));
		manager.addTask(new Task("Preparar relatório mensal", "Coletar dados e elaborar relatório para apresentação", new Date(2024, 4, 10), Priority.HIGH));
		manager.addTask(new Task("Correr no parque", "Fazer exercício aeróbico por 30 minutos", new Date(2024, 3, 28), Priority.MEDIUM));
		manager.addTask(new Task("Fazer compras no mercado", "Comprar mantimentos para a semana", new Date(2024, 3, 27), Priority.LOW));
    }

	@Test
	void testRemoveTaskAtListSize() {
	    Task removedTask = manager.getTasks().get(5); // Obtenha a tarefa na posição antes de remover
	    manager.removeTask(5);
	    assertEquals(5, manager.getTasks().size());
	    assertTrue(manager.getTasks().contains(removedTask)); // Verifique se a tarefa removida não está mais na lista
	}

	@Test
	void testRemoveTaskAtListSizeMinusOne() {
	    Task removedTask = manager.getTasks().get(4);
	    manager.removeTask(4);
	    assertEquals(4, manager.getTasks().size());
	    assertFalse(manager.getTasks().contains(removedTask));
	}

	@Test
	void testRemoveTaskWithinListRange() {
	    Task removedTask = manager.getTasks().get(2);
	    manager.removeTask(2);
	    assertEquals(4, manager.getTasks().size());
	    assertFalse(manager.getTasks().contains(removedTask));
	}

	@Test
	void testRemoveTaskAtPositionOneWithMoreThanTwoTasks() {
	    Task removedTask = manager.getTasks().get(1);
	    manager.removeTask(1);
	    assertEquals(4, manager.getTasks().size());
	    assertFalse(manager.getTasks().contains(removedTask));
	}

	@Test
	void testRemoveTaskZeroWithAtLeastOneTask() {
	    Task removedTask = manager.getTasks().get(0);
	    manager.removeTask(0);
	    assertEquals(4, manager.getTasks().size());
	    assertFalse(manager.getTasks().contains(removedTask));
	}

	@Test
	void testRemoveTaskAtNegativePosition() {
	    assertThrows(IndexOutOfBoundsException.class, () -> manager.removeTask(-1));
	}

}
