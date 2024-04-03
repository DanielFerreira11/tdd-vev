package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;
import TaskManager.*;

import java.util.Date;

import org.junit.jupiter.api.*;

class DTTests {
    TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
    }

    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste de criação de tarefa")
    void testCreateTask() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        assertFalse(manager.getTasks().contains(tarefa));

        manager.addTask(tarefa);

        assertEquals(1, manager.getTasks().size());
        assertEquals(tarefa, manager.getTasks().get(0));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste de remoção de tarefa com índice inválido")
    void testTaskWithInvalidIndex() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        assertFalse(manager.getTasks().contains(tarefa));
        
        manager.addTask(tarefa);
        
        manager.removeTask(2);
        assertEquals(tarefa, manager.getTasks().get(0));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste de remoção de tarefa")
    void testRemoveTask() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        assertFalse(manager.getTasks().contains(tarefa));
        
        manager.addTask(tarefa);
        
        manager.removeTask(0);
        assertEquals(0, manager.getTasks().size());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste de atualização de tarefa")
    void testUpdateTask() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        assertFalse(manager.getTasks().contains(tarefa));
        
        manager.addTask(tarefa);
        tarefa.setDescription("Lavar o carro");
        manager.updateTask(0, tarefa);
        
        assertEquals(tarefa, manager.getTasks().get(0));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste de falha na atualização de tarefa")
    void testFailedUpdateTask() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        assertFalse(manager.getTasks().contains(tarefa));
        
        manager.addTask(tarefa);
        tarefa.setDescription("Lavar o carro");
        tarefa.setTitle("Tarefa 2");
        tarefa.setExpirationDate(new Date(2025, 4, 3));
        tarefa.setPriority(Priority.LOW);
        manager.updateTask(1, tarefa);
        
        assertEquals(tarefa, manager.getTasks().get(0));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste para cobertura completa da tarefa")
    void testToFullCoverage() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);        
        assertEquals(tarefa.getTitle(), "Tarefa 1");
        assertEquals(tarefa.getDescription(), "Descrição da Tarefa 1");
        assertEquals(tarefa.getExpirationDate(), new Date(2024, 3, 25));
        assertEquals(tarefa.getPriority(), Priority.HIGH);
    }
}
