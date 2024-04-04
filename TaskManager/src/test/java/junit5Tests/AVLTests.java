package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;
import TaskManager.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para o TaskManager")
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
    @DisplayName("Teste: Remover tarefa quando o tamanho da lista é 5")
    void testRemoveTaskAtListSize() {
        Task removedTask = manager.getTasks().get(5); // Obtenha a tarefa na posição antes de remover
        manager.removeTask(5);
        assertEquals(5, manager.getTasks().size());
        assertTrue(manager.getTasks().contains(removedTask)); // Verifique se a tarefa removida não está mais na lista
    }

    @Test
    @DisplayName("Teste: Remover tarefa quando o tamanho da lista é 4")
    void testRemoveTaskAtListSizeMinusOne() {
        Task removedTask = manager.getTasks().get(4);
        manager.removeTask(4);
        assertEquals(4, manager.getTasks().size());
        assertFalse(manager.getTasks().contains(removedTask));
    }

    @Test
    @DisplayName("Teste: Remover tarefa dentro da faixa da lista")
    void testRemoveTaskWithinListRange() {
        Task removedTask = manager.getTasks().get(2);
        manager.removeTask(2);
        assertEquals(4, manager.getTasks().size());
        assertFalse(manager.getTasks().contains(removedTask));
    }

    @Test
    @DisplayName("Teste: Remover tarefa na posição um com mais de duas tarefas")
    void testRemoveTaskAtPositionOneWithMoreThanTwoTasks() {
        Task removedTask = manager.getTasks().get(1);
        manager.removeTask(1);
        assertEquals(4, manager.getTasks().size());
        assertFalse(manager.getTasks().contains(removedTask));
    }

    @Test
    @DisplayName("Teste: Remover tarefa zero com pelo menos uma tarefa")
    void testRemoveTaskZeroWithAtLeastOneTask() {
        Task removedTask = manager.getTasks().get(0);
        manager.removeTask(0);
        assertEquals(4, manager.getTasks().size());
        assertFalse(manager.getTasks().contains(removedTask));
    }

    @Test
    @DisplayName("Teste: Remover tarefa em posição negativa")
    void testRemoveTaskAtNegativePosition() {
        assertThrows(IndexOutOfBoundsException.class, () -> manager.removeTask(-1));
    }

    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste: Cobertura completa")
    void testToFullCoverage() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        assertEquals(tarefa.getTitle(), "Tarefa 1");
        assertEquals(tarefa.getDescription(), "Descrição da Tarefa 1");
        assertEquals(tarefa.getExpirationDate(), new Date(2024, 3, 25));
        assertEquals(tarefa.getPriority(), Priority.HIGH);
    }

    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste: Atualizar tarefa")
    void updateTask() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        manager.addTask(tarefa);

        tarefa.setDescription("Lavar o carro");
        tarefa.setTitle("Tarefa 2");
        tarefa.setExpirationDate(new Date(2025, 4, 3));
        tarefa.setPriority(Priority.LOW);
        manager.updateTask(5, tarefa);

        assertEquals(tarefa, manager.getTasks().get(5));
    }

    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Teste: Falha na atualização da tarefa")
    void updateTaskFail() {
        Task tarefa = new Task("Tarefa 1", "Descrição da Tarefa 1", new Date(2024, 3, 25), Priority.HIGH);
        manager.updateTask(5, tarefa);

        assertFalse(manager.getTasks().contains(tarefa));
    }
}